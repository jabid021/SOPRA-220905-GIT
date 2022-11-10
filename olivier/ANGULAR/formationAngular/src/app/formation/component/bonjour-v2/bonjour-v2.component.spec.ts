import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BonjourV2Component } from './bonjour-v2.component';

describe('BonjourV2Component', () => {
  let component: BonjourV2Component;
  let fixture: ComponentFixture<BonjourV2Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BonjourV2Component ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BonjourV2Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
