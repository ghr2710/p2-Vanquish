import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';

@Component({
  selector: 'app-posts',
  templateUrl: './posts.component.html',
  styleUrls: ['./posts.component.css']
})
export class PostsComponent implements OnInit {



showComment = true; 
showLabel = "read comments🔻";
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
  let s = "read comments🔻";
  let z = "hide comments🔺";
  if (this.showComment == true){
     this.showComment=false;
     this.showLabel=z;
  } else if (this.showComment == false) {
    this.showComment=true;
      this.showLabel=s;
  }

}

}