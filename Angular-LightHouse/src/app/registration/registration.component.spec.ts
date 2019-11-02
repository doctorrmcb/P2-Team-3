import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistrationComponent } from './registration.component';

describe('RegistrationComponent', () => {
  let component: RegistrationComponent;
  let fixture: ComponentFixture<RegistrationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RegistrationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RegistrationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should contain username input', () => {
    //const fixture = TestBed.createComponent(AppComponent);
    //fixture.detectChanges();
    const compiled = fixture.debugElement.nativeElement;
    expect(compiled.querySelector('#username').name).toContain("username");
  });

  it('should contain password input', () => {
    //const fixture = TestBed.createComponent(AppComponent);
    //fixture.detectChanges();
    const compiled = fixture.debugElement.nativeElement;
    expect(compiled.querySelector('#password').name).toContain("password");
  });

  it('should contain full name input', () => {
    const compiled = fixture.debugElement.nativeElement;
    expect(compiled.querySelector('#fullName').name).toContain("full name");
  });

  it('should contain full name input', () => {
    const compiled = fixture.debugElement.nativeElement;
    expect(compiled.querySelector('#email').name).toContain("email");
  });

  it('should call onRegister method', ()=>{
    const compiled = fixture.debugElement.nativeElement.querySelector('#register');
    spyOn(component, "onRegister");
    compiled.click();
    expect(component.onRegister).toHaveBeenCalled();
  });

});
