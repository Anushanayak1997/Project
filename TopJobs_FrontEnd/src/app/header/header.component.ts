import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private route:Router) { }
  url:any;
  loggedIn:any;
  
  ngOnInit() {
    this.loggedIn = sessionStorage.getItem('user_id');
    console.log("in header" +this.loggedIn);
   this.url =console.log(window.location.href)
  }

  gologin(){
   this.route.navigate(['login'])
  }

  goRegister(){
    this.route.navigate(['register'])
  }

goLogOut(){
  console.log("logut called")
  sessionStorage.clear();
  this.route.navigate(['login'])
}


}
