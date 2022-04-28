import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-posts',
  templateUrl: './posts.component.html',
  styleUrls: ['./posts.component.css']
})
export class PostsComponent implements OnInit {
 posts: any;
  constructor() { }

  ngOnInit(): void {
  }

  
  async getPosts() {
    let resp = await fetch('https://mocki.io/v1/72f60eb3-e51d-4164-9248-c3e80891ffcc');
    if (resp.status===200) {
      this.posts = await resp.json();
    }
  }
}
