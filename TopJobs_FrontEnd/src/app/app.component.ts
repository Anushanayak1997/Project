import { Component, OnInit } from '@angular/core';
import {ToastrService} from 'ngx-toastr'

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent  implements OnInit{
  title = 'TopJobs';
  constructor(
    private toast: ToastrService,
  ) { }


  ngOnInit() {
    //this.toast.success("I'm a toast!", "Success!");
  }
  test() {
   
  }
}
