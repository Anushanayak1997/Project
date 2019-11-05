import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Response } from 'selenium-webdriver/http';
import { RouteConfigLoadEnd, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-find-candidates',
  templateUrl: './find-candidates.component.html',
  styleUrls: ['./find-candidates.component.css']
})
export class FindCandidatesComponent implements OnInit {

  url: string = environment.apiBaseUrl + "getallusers";
  user_type: any;
  seekers:any;
  seekerlist=[];
  users: string;
  constructor(private http: HttpClient,private router:Router,private Toaster:ToastrService) { }

  ngOnInit() {
    this.getAllUsers();
  }


  getAllUsers(){
    this.http.get(this.url).subscribe(
      (Response) => {
       
        
        console.log("users")
        console.log(Response);
        this.user_type = Response;

        for (let seeker of this.user_type) {
          if (seeker.userType == "JobSeeker") {
            this.seekers = seeker;
            this.seekerlist.push(this.seekers)
            
       
             console.log(this.seekerlist)
           
          }
        }
      })
  }


  viewProfile(id:any){

    console.log(id)
    this.users=sessionStorage.getItem('user_type');

    console.log(this.users);
  
    if(this.users == ('JobSeeker' || 'Employer' ) ){
      this.router.navigate(['seeker/' + id])
    }else{
      setTimeout(() => 
      {
        
        this.router.navigate(['/login'])
      },
      2000);
      this.Toaster.warning('You have not Logged in', 'login to view');

    

    }
  }


}
