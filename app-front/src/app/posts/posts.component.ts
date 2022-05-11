import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';

@Component({
  selector: 'app-posts',
  templateUrl: './posts.component.html',
  styleUrls: ['./posts.component.css']
})
export class PostsComponent implements OnInit {


  headers = {'Content-type':'application/json'};


showComment = false; 
showLabel = "read comments🔻";
viewComment = "none";
 comments: any;
 posts: any;
 countVote = 0;
 countVote2= 0;
  postID='10';
 

  constructor() { }

  ngOnInit(): void {
   
    this.getPosts();
  
  }

  async getPosts() {
    let resp = await fetch('http://localhost:8080/post'); //posts end point
    if (resp.status===200) {
      this.posts = await resp.json();

      this.posts = this.posts.sort((a, b) => new Date(a.start_date).getTime() - new Date(b.start_date).getTime());
     
    }
  }

  async getComments(id: string) {
    
    let resp = await fetch('http://localhost:8080/comment/post/' + id);
    if (resp.status===200) {
      this.comments = await resp.json();
    }
  }



displayComment(){
 let m = document.getElementById("postID").textContent;
 this.postID =m; 

 this.getComments(m);


} 

/*
EXAMPLE JSON
{
    "username": "test",
    "commentBody": "test",
    "relatedPost" : 2
}
*/

async createComment(id: string){
  let username = sessionStorage.getItem('Auth-Token');
  let credentials = {
    username: username,
    commentBody: (<HTMLInputElement>document.getElementById('commentBody')).value,
    relatedPost:id
  };
  let credentialJSON = JSON.stringify(credentials);

  let resp = await fetch('http://localhost:8080/comment',
    {method:'POST', body:credentialJSON, headers:this.headers});
    if (resp.status===200) {
      let comment = await resp.json();
    }
    location.replace('http://localhost:4200');
}


 
//this is for the green
    voteCount(){
   this.countVote +=1;

  }
  //this is for the yellow
   voteCount2(){
    this.countVote2 +=1;
 
   }
  
toggleView(){
  let m = "none";
  let z = "read comments🔻";
  let s = "hide comments🔺";
  if (this.showComment == true){
     this.showComment=false;
     this.showLabel=z;
    
  } else if (this.showComment == false) {
    this.showComment=true;
      this.showLabel=s;
   
  }

}

}