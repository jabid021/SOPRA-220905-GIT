import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListProduitSecComponent } from './list-produit-sec.component';

describe('ListProduitSecComponent', () => {
  let component: ListProduitSecComponent;
  let fixture: ComponentFixture<ListProduitSecComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListProduitSecComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListProduitSecComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
