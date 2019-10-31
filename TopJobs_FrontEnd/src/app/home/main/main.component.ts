import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CookieService } from 'ngx-cookie-service';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {
  cookieValue: string;

  constructor(private router: Router,private cookieService: CookieService) { }

  ngOnInit() {
    this.cookieValue = this.cookieService.get('email');
    console.log(this.cookieValue)
  }
  gologin(){
//    this.router.navigate(['login']);
this.cookieValue = this.cookieService.get('email');
  }

  goRegister(){
    this.router.navigate(['register']);
  }
}
