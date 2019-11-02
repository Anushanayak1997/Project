import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-application-status',
  templateUrl: './application-status.component.html',
  styleUrls: ['./application-status.component.css']
})
export class ApplicationStatusComponent implements OnInit {
  userType: string;

  constructor(private router:Router) { }

  ngOnInit() {
    this.userType=sessionStorage.getItem('user_type');
    if(this.userType == 'JobSeeker'){
      console.log("correct user");
    }else{
      this.router.navigate(['home']);
    }
  }

}
