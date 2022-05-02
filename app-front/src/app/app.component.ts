import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'vote-app';
}

// function passValidator() {
//   // Get the value of the input field with id
//   let x = document.getElementById("password1").value;
//   let y = document.getElementById("password2").value;
//   let z = document.getElementById("username1").value;

  // evaluate if the passwords are matching then return the texts 
//   var text;

//   if (x != y) {
//     text = "Invalid input/Passwords don't match";
//   } else if  (x==y) {
//     text = "Registered successfully!";
//   } else if ( z= undefined) {
//     text = "Username can't be blank";
//   }
  
//   document.getElementById("validate-pass").innerHTML = text;

// }

//needs a fix
// function reveal(){
//   let x: any = document.getElementById("password1") as HTMLInputElement;
//   let y: any = document.getElementById("password2")as HTMLInputElement;
//   if (x.type === "password" || y.type === "password" ) {
//     x.type = "text";
//     y.type = "text";
//   } else {
//     x.type = "password";
//     y.type = "password";
//   }
// }


