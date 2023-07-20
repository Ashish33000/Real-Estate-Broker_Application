import { Component,OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { ApiserviceService } from '../apiservice.service';

import { Router } from '@angular/router';
import { HttpHeaders, HttpResponse } from '@angular/common/http';
import { User } from 'src/app/user';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user:User=new User();
  constructor(private service: ApiserviceService, private router: Router){}

  ngOnInit(): void {

    }
    userlogin(){
      if(this.user.username!='' && this.user.password!=''){
        console.log("submit username and password");
        console.log(this.user.username,":",this.user.password)

        this.service.doLogin(this.user).subscribe((res:any)=>{
          console.log(res.token);

        });

      }else{
        console.log("field are empty");

      }

    }




}
