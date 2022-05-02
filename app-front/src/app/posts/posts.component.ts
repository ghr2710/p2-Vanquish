import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-posts',
  templateUrl: './posts.component.html',
  styleUrls: ['./posts.component.css']
})
export class PostsComponent implements OnInit {
 posts: any;
 countVote = 0;
 countVote2= 0;
  constructor() { }

  ngOnInit(): void {
  }
  

  
  async getPosts() {
    let resp = await fetch('https://mocki.io/v1/72f60eb3-e51d-4164-9248-c3e80891ffcc');
    if (resp.status===200) {
      this.posts = await resp.json();
    }
    
    function votecount() {
      let  votecount: 0;
      
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


