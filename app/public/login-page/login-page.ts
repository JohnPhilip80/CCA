import { Component, OnInit } from '@angular/core';
import { Login } from '../../login';
import { BookService } from '../../book-service';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login-page',
  imports: [FormsModule],
  templateUrl: './login-page.html',
  styleUrl: './login-page.css'
})
export class LoginPage implements OnInit {
  login:Login = new Login();
  constructor(private service:BookService,private router:Router){}
  ngOnInit(): void {
    
  }
  onSubmit():void{
    this.service.login(this.login).subscribe((response) =>{
      console.log(response);
      if (response.token) {
        const jwtToken = response.token;
        localStorage.setItem('userName',response.userName);
        localStorage.setItem('JWT', jwtToken);
        localStorage.setItem('userRoles',JSON.stringify(response.userRoles));
        this.service.setLoginStatus(true);
        this.router.navigateByUrl('/home-page');
      }
    })
  }
}
