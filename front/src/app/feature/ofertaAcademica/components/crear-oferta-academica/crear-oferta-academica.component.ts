import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { OfertaAcademicaService } from '../../../../core/services/oferta-academica/oferta-academica.service';

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
    console.log(this.ofertaAcademicaForm.value);
    this.ofertaAcademicaService.guardar(this.ofertaAcademicaForm.value).subscribe( 
      () => alert('Se creó la oferta academica correctamente'),
      error => alert('Ocurrió un error la oferta academica:'+ error.error.mensaje)
      
      );
  }

  private construirFormularioOfertaAcademica() {
    this.ofertaAcademicaForm = new FormGroup({
      nivelAcademico: new FormControl('', [Validators.required]),
      fechaLimitePago: new FormControl('', [Validators.required]),
      valor: new FormControl('', [Validators.required])
    });
  }

}
