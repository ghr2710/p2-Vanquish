import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';

@Component({
  selector: 'app-posts',
  templateUrl: './posts.component.html',
  styleUrls: ['./posts.component.css']
})
export class PostsComponent implements OnInit {

// @ViewChild('postID') postID: ElementRef;
// @ViewChild('postIDcomment') postIDcomment: ElementRef;


 comments: any;
 posts: any;
 countVote = 0;
 countVote2= 0;
  constructor() { }

  ngOnInit(): void {
   
    this.getPosts();
   
  }

  async getPosts() {
    let resp = await fetch('https://mocki.io/v1/87493bff-3f23-4395-9cfb-8873f5465d80'); //posts end point
    if (resp.status===200) {
      this.posts = await resp.json();
    }
  }

 
//this is for the green
    voteCount(){
   this.countVote +=1;

  }
  //this is for the yellow
   voteCount2(){
    this.countVote2 +=1;
 
   }
  

}