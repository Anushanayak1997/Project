import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { loginUser } from '../H_user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  topicHasError = true;
  submitted = false;
  errorMsg = '';


  constructor(private router: Router) { }

  ngOnInit() {
  }

  topics = ["JobSeeker","Employer","Admin"]
  userModel = new loginUser('Rob', 'rob@test.com');

  goRegister(){
    this.router.navigate(['register']);
  }

  validateTopic(value) {
    if (value === 'default') {
      this.topicHasError = true;
    } else {
      this.topicHasError = false;
    }
  }

  onSubmit(){
   
     console.log("logged in")
    
  }

}
