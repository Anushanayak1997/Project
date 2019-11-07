import { Component, OnInit } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-manageaccount',
  templateUrl: './manageaccount.component.html',
  styleUrls: ['./manageaccount.component.css']
})
export class ManageaccountComponent implements OnInit {

  getuserurl=environment.apiBaseUrl+"getuserbyid";
  User:any;
  constructor(private http:HttpClient) { }

  ngOnInit() {

    this.getUser();
  }

  getUser(){
    this.http.get(this.getuserurl).subscribe((Response)=>{
      this.User=Response;
    })
  }
}
