import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NavbarOuterComponent } from './navbar-outer.component';

describe('NavbarOuterComponent', () => {
  let component: NavbarOuterComponent;
  let fixture: ComponentFixture<NavbarOuterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NavbarOuterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NavbarOuterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should render the logo', () => {
    //const fixture = TestBed.createComponent(AppComponent);
    //fixture.detectChanges();
    const compiled = fixture.debugElement.nativeElement;
    expect(compiled.querySelector('nav>img').src).toContain("assets/Revature-Logo.png");
  });
});
