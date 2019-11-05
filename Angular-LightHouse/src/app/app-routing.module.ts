
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { HomeComponent } from './home/home.component';
import { GeneralForumComponent } from './general-forum/general-forum.component';
import { GeneralForumInnerComponent } from './general-forum-inner/general-forum-inner.component';
import { ThreadComponent } from './thread/thread.component';
import { PostComponent } from './post/post.component';
import { SubForumComponent } from './sub-forum/sub-forum.component';
import { CategoryComponent } from './category/category.component';

const appRoutes: Routes = [
  {path: '', component: LoginComponent},
  {path: 'registration', component: RegistrationComponent},
  {path: 'home', component: HomeComponent},
  {path: 'general-forum', component: GeneralForumComponent},
  {path: 'general-forum-inner', component: GeneralForumInnerComponent},
  {path: 'thread', component: ThreadComponent},
  {path: 'post', component: PostComponent},
  {path: 'sub-forum/:id', component: SubForumComponent},
  {path: 'category', component: CategoryComponent}
]


@NgModule({
  declarations: [],
  imports: [
    CommonModule
  ]
})
export class AppRoutingModule { }
export const routing = RouterModule.forRoot(appRoutes);
