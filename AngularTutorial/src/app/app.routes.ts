import { Routes } from '@angular/router';
import { HomePage } from './home-page/home-page';
import { AboutusPage } from './aboutus-page/aboutus-page';
import { ReadBooks } from './read-books/read-books';
import { CreateBook } from './create-book/create-book';
import { UpdateBook } from './update-book/update-book';
import { ReadBook } from './read-book/read-book';

export const routes: Routes = [
    {path:"home-page", component:HomePage},
    {path:"aboutus-page", component:AboutusPage},
    {path:"read-books",component:ReadBooks},
    {path:"create-book",component:CreateBook},
    {path:"update-book",component:UpdateBook},
    {path:"read-book",component:ReadBook},
    {path: "", redirectTo: 'home-page', pathMatch: 'full'}
];
