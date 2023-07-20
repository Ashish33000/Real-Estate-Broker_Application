import { HttpClient,HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../user';


@Injectable({
  providedIn: 'root'
})
export class ApiserviceService {

  constructor(private http:HttpClient) { }

  apiurl='http://localhost:8080'
  // signup
  signup(data:any):Observable<any>{
    //console.log(data,"data##");
    return this.http.post(`${this.apiurl}/auth/register`,data);

  }
  //calling server to generate server
  doLogin(user:any){
    return this.http.post(`${this.apiurl}/signIn`,user);
  }
 loginUser(token: string){
  localStorage.setItem("token",token);
  return true;
 }
//to check person is loggedin
 isLoggedIn(){
  let token=localStorage.getItem("token");
  if(token==undefined ||token===''||token==null){
     return true;
  }else{
    return true;
  }
 }
 //logout the user
 logout(){
  localStorage.removeItem("token");
  return true;
 }

 //for getting the token
  getToken(){
    return localStorage.getItem("token");
  }

}
