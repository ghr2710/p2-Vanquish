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

      this.posts = this.posts.sort((a, b) => new Date(b.datePosted).getTime() - new Date(a.datePosted).getTime());
     
    }
  }

  async getComments(id: string) {
    
    let resp = await fetch('http://localhost:8080/comment/post/' + id);
    if (resp.status===200) {
      this.comments = await resp.json();
      
   //   this.comments = this.comments.sort((a, b) => new Date(b.datePosted).getTime() - new Date(a.datePosted).getTime());
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


/*
EXAMPLE JSON
{
    "postId" : 25,
    "username": "test",
    "postBody": "test",
    "option1" : "opt 1",
    "option2" : "opt 2",
    "numberOfVotesOption1": 10,
    "numberOfVotesOption2": 20,
    "totalVotes": 30,
    "datePosted": "day"
}

EXAMPLE JSON 2
{
    "username": "test",
    "postId": 23
}
*/
//this is for the green
  async voteCount(element: any){
    let num = element.numberOfVotesOption1;
    num = num+1;
    
    let tot = element.numberOfVotesOption2;
    tot = tot + num;

    let username = sessionStorage.getItem('Auth-Token');
    
    let credentials = {
      postId: element.postId,
      username: element.username,
      postBody: element.postBody,
      option1: element.option1,
      option2: element.option2,
      numberOfVotesOption1: num,
      numberOfVotesOption2: element.numberOfVotesOption2,
      totalVotes: tot,
      datePosted: element.datePosted
    };
    let credentialJSON = JSON.stringify(credentials);

    let credentials2 = {
      username: username,
      postId: element.postId
    };
    let credentialJSON2 = JSON.stringify(credentials2);

    let resp = await fetch('http://localhost:8080/vote',
    {method:'POST', body:credentialJSON2, headers:this.headers});
    if (resp.status===200) {
      let vote = await resp.json();
      let resp2 = await fetch('http://localhost:8080/post',
      {method:'POST', body:credentialJSON, headers:this.headers});
      if (resp2.status===200){
        let post = await resp2.json();
      }
    }
    else{
      alert("You have already voted on this post");
    }
    location.replace('http://localhost:4200');
  }
  //this is for the yellow
  async voteCount2(element: any){
    let num = element.numberOfVotesOption2;
    num = num+1;
    
    let tot = element.numberOfVotesOption1;
    tot = tot + num;

    let username = sessionStorage.getItem('Auth-Token');
    
    let credentials = {
      postId: element.postId,
      username: element.username,
      postBody: element.postBody,
      option1: element.option1,
      option2: element.option2,
      numberOfVotesOption1: element.numberOfVotesOption1,
      numberOfVotesOption2: num,
      totalVotes: tot,
      datePosted: element.datePosted
    };
    let credentialJSON = JSON.stringify(credentials);

    let credentials2 = {
      username: username,
      postId: element.postId
    };
    let credentialJSON2 = JSON.stringify(credentials2);

    let resp = await fetch('http://localhost:8080/vote',
    {method:'POST', body:credentialJSON2, headers:this.headers});
    if (resp.status===200) {
      let vote = await resp.json();
      let resp2 = await fetch('http://localhost:8080/post',
      {method:'POST', body:credentialJSON, headers:this.headers});
      if (resp2.status===200){
        let post = await resp2.json();
      }
    }
    else{
      alert("You have already voted on this post");
    }
    location.replace('http://localhost:4200');
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