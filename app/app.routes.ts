import { Routes } from '@angular/router';
import { BooksRead } from './book/books-read/books-read';
import { BookRead } from './book/book-read/book-read';
import { BookCreate } from './book/book-create/book-create';
import { BookUpdate } from './book/book-update/book-update';
import { UsersRead } from './user/users-read/users-read';
import { UserRead } from './user/user-read/user-read';
import { UserCreate } from './user/user-create/user-create';
import { UserUpdate } from './user/user-update/user-update';
import { RolesRead } from './role/roles-read/roles-read';
import { RoleRead } from './role/role-read/role-read';
import { RoleCreate } from './role/role-create/role-create';
import { RoleUpdate } from './role/role-update/role-update';
import { HomePage } from './public/home-page/home-page';
import { AboutusPage } from './public/aboutus-page/aboutus-page';
import { ContactusPage } from './public/contactus-page/contactus-page';
import { LoginPage } from './public/login-page/login-page';
import { RegisterPage } from './public/register-page/register-page';
import { adminGuard, managerGuard, userGuard } from './users-guard';

export const routes: Routes = [
    {path: 'books-read',component:BooksRead, canActivate:[userGuard]},
    {path: 'book-read',component:BookRead, canActivate:[userGuard]},
    {path: 'book-create',component:BookCreate, canActivate:[managerGuard]},
    {path: 'book-update',component:BookUpdate, canActivate:[managerGuard]},

    {path: 'users-read',component:UsersRead, canActivate:[adminGuard]},
    {path: 'user-read',component:UserRead, canActivate:[adminGuard]},
    {path: 'user-create',component:UserCreate, canActivate:[adminGuard]},
    {path: 'user-update',component:UserUpdate, canActivate:[adminGuard]},

    {path: 'roles-read',component:RolesRead, canActivate:[adminGuard]},
    {path: 'role-read',component:RoleRead, canActivate:[adminGuard]},
    {path: 'role-create',component:RoleCreate, canActivate:[adminGuard]},
    {path: 'role-update',component:RoleUpdate, canActivate:[adminGuard]},

    {path: 'home-page',component:HomePage},
    {path: 'aboutus-page',component:AboutusPage},
    {path: 'contactus-page',component:ContactusPage},
    {path: 'login-page',component:LoginPage},
    {path: 'register-page',component:RegisterPage},
    {path: '', redirectTo: 'home-page', pathMatch: 'full'}
];
