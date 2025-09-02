import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Login } from './login';

@Injectable({
  providedIn: 'root'
})
export class BookService {
  private baseURLAuth = "http://localhost:8080/book/auth/api/";
  public loginStatus = false;
  setLoginStatus(status:boolean){
    this.loginStatus = status;
  }
  constructor(private httpClient:HttpClient) { }

  login(login:Login): Observable<any> {
    return this.httpClient.post(this.baseURLAuth + "login", login);
  }
  isUser(): boolean {
    if(typeof localStorage !== 'undefined'){
      if(localStorage.getItem('userRoles')){
        console.log ((JSON.parse(localStorage.getItem('userRoles') || '{}')).some((e: { name: string; }) => e.name === 'ROLE_USER'));
        return ((JSON.parse(localStorage.getItem('userRoles') || '{}')).some((e: { name: string; }) => e.name === 'ROLE_USER'));
      }
    }
    return false;
  }
  isManager(): boolean {
    if(typeof localStorage !== 'undefined'){
      if(localStorage.getItem('userRoles')){
        return ((JSON.parse(localStorage.getItem('userRoles') || '{}')).some((e: { roleName: string; }) => e.roleName === 'ROLE_MANAGER'));
      }
    }
    return false;
  }
  isAdmin(): boolean {
    if(typeof localStorage !== 'undefined'){
      if(localStorage.getItem('userRoles')){
        return ((JSON.parse(localStorage.getItem('userRoles') || '{}')).some((e: { roleName: string; }) => e.roleName === 'ROLE_ADMIN'));
      }
    }
    return false;
  }
}
