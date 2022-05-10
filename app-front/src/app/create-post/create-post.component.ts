import { Component, OnInit } from '@angular/core';

let loggedInUser;

@Component({
  selector: 'app-create-post',
  templateUrl: './create-post.component.html',
  styleUrls: ['./create-post.component.css']
})
export class CreatePostComponent implements OnInit {

  headers = {'Content-type':'application/json'};
  post: any;

  constructor() { }

  ngOnInit(): void {
  }
  /*
  JSON EXAMPLE
  {
    "username": "test",
    "postBody": "test",
    "option1" : "opt 1",
    "option2" : "opt 2"
}
  */

  async createPost() {
    let username = "test";//sessionStorage.getItem('Auth-Token');
    let credentials = {
      username:username,
      postBody:(<HTMLInputElement>document.getElementById('postbody')).value,
      option1:(<HTMLInputElement>document.getElementById('option1name')).value,
      option2:(<HTMLInputElement>document.getElementById('option2name')).value
    };
    let credentialJSON = JSON.stringify(credentials);

    let resp = await fetch('http://localhost:8080/post',
    {method:'POST', body:credentialJSON, headers:this.headers});
    if (resp.status===200) {
      this.post = await resp.json();
    }
  }

}
