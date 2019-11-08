import { BrowserModule } from '@angular/platform-browser';	
import { NgModule } from '@angular/core';	
import { FormsModule } from '@angular/forms';	
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';	
import { RouterModule, Routes, Router } from '@angular/router';	

import { AppComponent } from './app.component';	
import { RegistrationComponent } from './registration/registration.component';	

import { QuizManagementComponent } from './quiz-management/quiz-management.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';	
import { NavbarOuterComponent } from './navbar-outer/navbar-outer.component';	
import { LoginComponent } from './login/login.component';	
import { AppRoutingModule, routing } from './app-routing.module';	
import { HomeComponent } from './home/home.component';	
import { GeneralForumComponent } from './general-forum/general-forum.component';	
import { GeneralForumInnerComponent } from './general-forum-inner/general-forum-inner.component';	
import { ThreadComponent } from './thread/thread.component';	
import { PostComponent } from './post/post.component';	
import { SubForumComponent } from './sub-forum/sub-forum.component';	
import { HttpRequestInterceptor } from './types/HttpRequestInterceptor';	
import { ResourcesPageComponent } from './resources-page/resources-page.component';	
import { QuizComponent } from './quiz/quiz.component';	
import { LeaderboardComponent } from './leaderboard/leaderboard.component';
import { CategoryComponent } from './category/category.component';
import { TakeQuizComponent } from './take-quiz/take-quiz.component';
import { DeleteQuestionComponent } from './delete-question/delete-question.component';
import { ManageQuestionComponent } from './manage-question/manage-question.component';
import { CreateQuestionComponent } from './create-question/create-question.component';
import { UpdateQuestionComponent } from './update-question/update-question.component';
import { ViewQuestionComponent } from './view-question/view-question.component';

@NgModule({	
  declarations: [	

    AppComponent,	
    RegistrationComponent,	
    NavbarOuterComponent,	
    LoginComponent,	
    HomeComponent,	
    GeneralForumComponent,	
    GeneralForumInnerComponent,	
    ThreadComponent,	
    PostComponent,	
    SubForumComponent,	
    ResourcesPageComponent,	
    QuizComponent,	
    LeaderboardComponent, 
    CategoryComponent,
    TakeQuizComponent,
    QuizManagementComponent,	
    DeleteQuestionComponent,
    ManageQuestionComponent,
    CreateQuestionComponent,
    UpdateQuestionComponent,
    ViewQuestionComponent,
  ],	
  imports: [	
    routing,	
    RouterModule,	
    BrowserModule,	
    FormsModule,	
    NgbModule,	
    HttpClientModule,	
    AppRoutingModule	
  ],	
  exports: [	
  ],	
  providers: [[	
    { provide: HTTP_INTERCEPTORS, useClass: HttpRequestInterceptor, multi: true }	
  ],],	
  bootstrap: [AppComponent]	
})	
    
export class AppModule { }