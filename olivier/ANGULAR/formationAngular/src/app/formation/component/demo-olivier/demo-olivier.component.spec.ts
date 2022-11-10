import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DemoOlivierComponent } from './demo-olivier.component';

describe('DemoOlivierComponent', () => {
  let component: DemoOlivierComponent;
  let fixture: ComponentFixture<DemoOlivierComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DemoOlivierComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DemoOlivierComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
