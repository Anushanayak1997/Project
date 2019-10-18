import { Component, OnInit } from '@angular/core';
import {  Router } from '@angular/router';


@Component({
  selector: 'app-job-posts',
  templateUrl: './job-posts.component.html',
  styleUrls: ['./job-posts.component.css']
})
export class JobPostsComponent implements OnInit {

  constructor( private route:Router) { }

  ngOnInit() {
  }

  toCreatePost(){
    this.route.navigate(['company/create-post'])
  }


}
