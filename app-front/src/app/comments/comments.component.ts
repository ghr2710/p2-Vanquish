import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-comments',
  templateUrl: './comments.component.html',
  styleUrls: ['./comments.component.css']
})
export class CommentsComponent implements OnInit {
 
  posts: any;
  comments: any;
 // commentsForPost: boolean;  //this var is used to render comments for each post
  postID =8;

   constructor() { }
 
   ngOnInit(): void {
    
    
     this.getComments();
   }

   
   async getComments() {
    
    let resp = await fetch('http://localhost:8080/comment/post/' + this.postID);
    if (resp.status===200) {
      this.comments = await resp.json();
    }
  }
  
  


   // a method that renders the posts matching the post id with the comment 

  loadComments() {
    let m = document.getElementById("postID").textContent;
    this.getComments();
  }

}
