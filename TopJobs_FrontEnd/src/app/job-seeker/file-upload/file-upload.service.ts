import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class FileUploadService {

  constructor(private http:HttpClient) { }
  postFile(fileToUpload: File) {
    console.log("in service");
    const endpoint =environment.apiBaseUrl+"";
    const formData: FormData = new FormData();
    formData.append('fileKey', fileToUpload, fileToUpload.name);
     this.http
      .post(endpoint, formData).subscribe((Response)=>{console.log(Response)})
      
}
  
}
