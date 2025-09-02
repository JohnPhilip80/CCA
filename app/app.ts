import { Component, OnInit, signal } from '@angular/core';
import { Router, RouterLink, RouterOutlet } from '@angular/router';
import { BookService } from './book-service';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet,RouterLink],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App implements OnInit {
  ngOnInit(): void {
    
  }
  constructor(public bookService: BookService,private router: Router) { }
  logoutUser(): void{
    window.localStorage.removeItem('JWT');
    this.bookService.setLoginStatus(false);
    this.router.navigate(['login-page'])
  }
}
