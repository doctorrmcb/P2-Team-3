import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SubForumComponent } from './sub-forum.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { RouterTestingModule } from '@angular/router/testing';
import { HttpClient, HttpClientModule } from '@angular/common/http';

describe('SubForumComponent', () => {
  let component: SubForumComponent;
  let fixture: ComponentFixture<SubForumComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [NgbModule, RouterTestingModule, HttpClientModule],
      declarations: [ SubForumComponent ],
      providers: [ HttpClient ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SubForumComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
