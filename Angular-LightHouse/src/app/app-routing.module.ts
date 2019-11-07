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
import { TakeQuizComponent } from './take-quiz/take-quiz.component';
import { LeaderboardComponent } from './leaderboard/leaderboard.component';
import { DeleteQuestionComponent } from './delete-question/delete-question.component';
import { ResourcesPageComponent } from './resources-page/resources-page.component';
import { QuizManagementComponent } from './quiz-management/quiz-management.component';
import { ManageQuestionComponent } from './manage-question/manage-question.component';
import { CreateQuestionComponent } from './create-question/create-question.component';

const appRoutes: Routes = [
  {path: '', component: LoginComponent},
  {path: 'registration', component: RegistrationComponent},
  {path: 'home', component: HomeComponent},
  {path: 'general-forum', component: GeneralForumComponent},
  {path: 'general-forum-inner', component: GeneralForumInnerComponent},
  {path: 'post', component: PostComponent},
  {path: 'sub-forum/:id/:title', component: ThreadComponent},
  {path: 'quiz-management', component: QuizManagementComponent},
  {path: 'sub-forum/:id', component: SubForumComponent},
  {path: 'sub-forum/:id/:title', component: ThreadComponent},
  {path: 'leaderboard', component: LeaderboardComponent},
  {path: 'take-quiz', component: TakeQuizComponent},
  {path: 'resources-page', component: ResourcesPageComponent},
  {path: 'delete-question', component: DeleteQuestionComponent},
  {path: 'create-question', component: CreateQuestionComponent}
]


@NgModule({
  declarations: [],
  imports: [
    CommonModule
  ]
})
export class AppRoutingModule { }
export const routing = RouterModule.forRoot(appRoutes);
