import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-seeker-profile',
  templateUrl: './seeker-profile.component.html',
  styleUrls: ['./seeker-profile.component.css']
})
export class SeekerProfileComponent implements OnInit {
skills:any;
  constructor() { }

  ngOnInit() {

    this.skills=[{id:1,name:"xyz"},{id:2,name:"abc"},{id:3,name:"fjkd"}];
    console.log(this.skills);
  }

}
