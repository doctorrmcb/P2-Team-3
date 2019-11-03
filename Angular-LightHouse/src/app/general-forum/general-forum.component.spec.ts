import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GeneralForumComponent } from './general-forum.component';

describe('GeneralForumComponent', () => {
  let component: GeneralForumComponent;
  let fixture: ComponentFixture<GeneralForumComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
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
});
