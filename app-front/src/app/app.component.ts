import { Component } from '@angular/core';

let loggedInUser;

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'vote-app';

  loginStatus= Boolean(sessionStorage.getItem('In-Use'));  //show or hide posts by setting this var true/false

  headers = {'Content-type':'application/json'};

  /*
  JSON EXAMPLE
  {
    "username": "test",
    "password": "test"
  }
*/

  async login() {
    let credentials = {
      username:(<HTMLInputElement>document.getElementById('username')).value,
      password:(<HTMLInputElement>document.getElementById('password')).value
    };
    let credentialJSON = JSON.stringify(credentials);
  
    let resp = await fetch('http://localhost:8080/auth',
    {method:'POST', body:credentialJSON, headers:this.headers});
    if (resp.status===200) {
      loggedInUser = await resp.json();
      sessionStorage.setItem('Auth-Token', loggedInUser.username);
      this.loginStatus= true;  //show or hide posts by setting this var true/false 
      sessionStorage.setItem('In-Use', String(this.loginStatus));
    }
    else{
      alert("Username or Password is incorrect")
    }
  }

  logout(){
    sessionStorage.removeItem('Auth-Token');
    this.loginStatus= false;  //show or hide posts by setting this var true/false 
    sessionStorage.setItem('In-Use', String(this.loginStatus));
  }
}





