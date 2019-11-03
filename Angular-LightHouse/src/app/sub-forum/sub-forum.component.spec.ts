import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SubForumComponent } from './sub-forum.component';

describe('SubForumComponent', () => {
  let component: SubForumComponent;
  let fixture: ComponentFixture<SubForumComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SubForumComponent ]
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
