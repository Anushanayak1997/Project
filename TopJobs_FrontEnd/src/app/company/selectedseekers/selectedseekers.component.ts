import { Component, OnInit } from '@angular/core';
import { environment } from 'src/environments/environment';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-selectedseekers',
  templateUrl: './selectedseekers.component.html',
  styleUrls: ['./selectedseekers.component.css']
})
export class SelectedseekersComponent implements OnInit {
  selctedseekerurl=environment.apiBaseUrl+"getselectedusers";
  id:any;
  seekerssel: any;
  constructor( private router: ActivatedRoute,private http:HttpClient) { }

  ngOnInit() {
    this.router.paramMap.subscribe((params: ParamMap) => {
      let Index = parseInt(params.get('Index'));
      console.log(Index)
      this.id = Index

    })
    this.http.get(this.selctedseekerurl+'/'+this.id).subscribe((Response)=>
      {
        this.seekerssel=Response;
        console.log(this.seekerssel);
      })
       

    
    }
}
  