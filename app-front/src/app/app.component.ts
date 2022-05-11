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
  passMessage = ""; //password match validation message 
  reveal = "password";
  post: any;
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


  PassValidation() {
  let  pass1=(<HTMLInputElement>document.getElementById('password1')).value;
  let pass2=(<HTMLInputElement>document.getElementById('password2')).value;

   if (pass1!= pass2){
    this.passMessage = "the passwords don't match"
   } else if (pass1== pass2)
   this.passMessage = "registered successfully! please login above"
   this.Register();
  }

  async Register() {
    //let username = sessionStorage.getItem('Auth-Token');
    let credentials = {
     
      username:(<HTMLInputElement>document.getElementById('username1')).value,
      password:(<HTMLInputElement>document.getElementById('password1')).value
    
    };
    let credentialJSON = JSON.stringify(credentials);

    let resp = await fetch('http://localhost:8080/users',
    {method:'POST', body:credentialJSON, headers:this.headers});
    if (resp.status===200) {
      this.post = await resp.json();
    } else if (resp.status===409){
      this.passMessage = "username already exists please choose another"
    }
    location.reload;
  }


showPass(){

  if( this.reveal != "text"){
    this.reveal = "text";
  } else if( this.reveal == "text"){
    this.reveal ="password"
  }
}



}





