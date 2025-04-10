import { Component } from '@angular/core';
import { Book } from '../models/book';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { FileHandle } from '../models/filehandle';
import { BookService } from '../services/book.service';
import { DomSanitizer } from '@angular/platform-browser';
import { Router } from '@angular/router';

@Component({
  selector: 'app-mngbooks',
  imports: [FormsModule,CommonModule],
  templateUrl: './mngbooks.component.html',
  styleUrl: './mngbooks.component.css'
})
export class MngbooksComponent {
  b:Book=new Book()
  

  constructor(private bs:BookService,private router:Router,private sanitizer:DomSanitizer)
  {

  }
submitdata()
{

  const formData=this.prepareFormData(this.b);
  this.bs.createBook(formData).subscribe(data => {
    if(data!=null)
      alert("Book added successfully")
    console.log(data)
    
 
  }, 
  error =>{ console.log(error);
  
   
  })
}
prepareFormData(book:Book):FormData{
  const formData=new FormData()
  formData.append(
    'book',
    new Blob([JSON.stringify(book)],{type:"application/json"})
  );
  for(var i=0;i<book.bookImages.length;i++)
  {
    formData.append(
      'imageFile',
      book.bookImages[i].file,
      book.bookImages[i].file.name
    );
  }
  return formData;
}
removeImage(i:number)
{
  this.b.bookImages.splice(i,1)
}
onFileSelected(event:any){
  if(event.target.files)
  {
const file=event.target.files[0];
const fileHandle:FileHandle={
file:file,
url:this.sanitizer.bypassSecurityTrustUrl(window.URL.createObjectURL(file)),
name:file.name


}
this.b.bookImages.push(fileHandle)
  }
}
}
