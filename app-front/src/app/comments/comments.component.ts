import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-comments',
  templateUrl: './comments.component.html',
  styleUrls: ['./comments.component.css']
})
export class CommentsComponent implements OnInit {
 
  posts: any;
  comments: any;
  commentsForPost: boolean;  //this var is used to render comments for each post
   constructor() { }
 
   ngOnInit(): void {
    
   
     this.getComments();
   }

   
   async getComments(){
    let resp = await fetch('https://mocki.io/v1/64c9598f-c131-41ba-a127-5134f3979ff6'); //comments end point
    if (resp.status===200) {
      this.comments = await resp.json();
    }

   }

   // a method that renders the posts matching the post id with the comment 


  }
