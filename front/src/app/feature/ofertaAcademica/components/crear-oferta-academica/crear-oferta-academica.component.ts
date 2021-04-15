import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { OfertaAcademicaService } from '../../shared/service/oferta-academica.service';

@Component({
  selector: 'app-crear-oferta-academica',
  templateUrl: './crear-oferta-academica.component.html',
  styleUrls: ['./crear-oferta-academica.component.sass']
})
export class CrearOfertaAcademicaComponent implements OnInit {

  ofertaAcademicaForm: FormGroup;

  constructor(protected ofertaAcademicaService: OfertaAcademicaService) { 
    this.construirFormularioOfertaAcademica();
  }

  

  ngOnInit(): void {
  }

  crear() {
    
    this.ofertaAcademicaService.guardar(this.ofertaAcademicaForm.value);
  }

  private construirFormularioOfertaAcademica() {
    this.ofertaAcademicaForm = new FormGroup({
      nivelAcademico: new FormControl('', [Validators.required]),
      fechaLimitePago: new FormControl('', [Validators.required]),
      valor: new FormControl('', [Validators.required])
    });
  }

}
