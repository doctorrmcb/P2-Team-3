import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GeneralForumComponent } from './general-forum.component';
import { GeneralForumInnerComponent } from '../general-forum-inner/general-forum-inner.component';
import { Forum } from '../types/Forum'
import { Input } from '@angular/core';

describe('GeneralForumComponent', () => {
  let component: GeneralForumComponent;
  let fixture: ComponentFixture<GeneralForumComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [
        ],
      declarations: [ GeneralForumComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GeneralForumComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
   
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should contain container class', () =>{
    //component.setInput('test');
    const compiled = fixture.debugElement.nativeElement.querySelector('.container');
    expect(compiled).toBeTruthy();
  })

  it('should contain SubForums class in dl tag', () =>{
    const compiled = fixture.debugElement.nativeElement.querySelector('dl');
    expect(compiled.getAttribute("class")).toContain("SubForums");
  })
});
