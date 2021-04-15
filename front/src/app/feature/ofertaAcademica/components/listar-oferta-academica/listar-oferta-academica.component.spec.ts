import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarOfertaAcademicaComponent } from './listar-oferta-academica.component';

describe('ListarOfertaAcademicaComponent', () => {
  let component: ListarOfertaAcademicaComponent;
  let fixture: ComponentFixture<ListarOfertaAcademicaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListarOfertaAcademicaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListarOfertaAcademicaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
