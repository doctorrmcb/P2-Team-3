import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GeneralForumInnerComponent } from './general-forum-inner.component';

describe('SubForumComponent', () => {
  let component: GeneralForumInnerComponent;
  let fixture: ComponentFixture<GeneralForumInnerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GeneralForumInnerComponent ]
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
