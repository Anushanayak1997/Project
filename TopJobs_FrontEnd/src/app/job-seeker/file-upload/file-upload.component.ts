import { Component, OnInit } from '@angular/core';
import{FileUploadService } from './file-upload.service' 

@Component({
  selector: 'app-file-upload',
  templateUrl: './file-upload.component.html',
  styleUrls: ['./file-upload.component.css']
})
export class FileUploadComponent implements OnInit {
  fileToUpload: File = null;
  constructor(private fileUploadService:FileUploadService) { }

  ngOnInit() {

  }
  handleFileInput(files: FileList) {
    console.log("hi");
    this.fileToUpload = files.item(0);
    

}



uploadFileToActivity() {
  console.log("hi in ts");
  this.fileUploadService.postFile(this.fileToUpload)
}
}
