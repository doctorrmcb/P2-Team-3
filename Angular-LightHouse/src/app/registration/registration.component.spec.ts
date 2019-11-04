import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistrationComponent } from './registration.component';
import { FormsModule } from '@angular/forms';
import { RouterTestingModule} from '@angular/router/testing';
import { HttpClientModule, HttpClient } from '@angular/common/http';

describe('RegistrationComponent', () => {
  let component: RegistrationComponent;
  let fixture: ComponentFixture<RegistrationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [
        FormsModule,
        RouterTestingModule,
        HttpClientModule
        ],
      declarations: [ RegistrationComponent ],
      providers: [HttpClient]
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
    expect(compiled.querySelector('#fullName').name).toContain("fullName");
  });

  it('should contain email name input', () => {
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
