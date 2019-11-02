import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  userType: string;
  url: any;
  loggedIn: any;

  constructor(private route: Router) { }


  ngOnInit() {
    this.loggedIn = sessionStorage.getItem('user_id');
    this.userType = sessionStorage.getItem('user_type');

    if (this.userType == 'JobSeeker') {

    } else {

    }
  }

  gologin() {
    this.route.navigate(['login'])
  }

  goRegister() {
    this.route.navigate(['register'])
  }

  goLogOut() {
    console.log("logut called")
    sessionStorage.clear();
    this.route.navigate(['login'])
  }

}
