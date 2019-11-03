import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GeneralForumInnerComponent } from './general-forum-inner.component';
import { Forum } from '../types/Forum'
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { RouterTestingModule } from '@angular/router/testing';
import { GeneralForumComponent } from '../general-forum/general-forum.component'

describe('GeneralForumInnerComponent', () => {
  let component: GeneralForumInnerComponent;
  let fixture: ComponentFixture<GeneralForumInnerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [NgbModule, RouterTestingModule],
      declarations: [ GeneralForumInnerComponent, GeneralForumComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GeneralForumInnerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
