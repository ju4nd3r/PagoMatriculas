import { Component, OnInit } from '@angular/core';
import { OfertaAcademica } from '@core/modelo/oferta-academica';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { OfertaAcademicaService } from '@core/services/oferta-academica/oferta-academica.service';
import { MatriculaService } from '../../shared/service/matricula.service';

@Component({
  selector: 'app-crear-matricula',
  templateUrl: './crear-matricula.component.html',
  styleUrls: ['./crear-matricula.component.sass']
})
export class CrearMatriculaComponent implements OnInit {
  ofertasAcademicas: OfertaAcademica[] = [];
  matriculaForm: FormGroup;
  
  constructor(protected ofertaAcademicaService: OfertaAcademicaService,
    protected matriculaService: MatriculaService) {
      this.construirFormularioMatricula();
  }

  ngOnInit(): void {
    this.getOfertasAcademicas();
  }

  crear() {
    console.log(this.matriculaForm.value);
    this.matriculaService.guardar(this.matriculaForm.value).subscribe( 
      () => alert('Se creó la matricula correctamente'),
      error => alert('Ocurrió un error creando la matrícula: '+ error.error.mensaje))
  }

  getOfertasAcademicas(){
    this.ofertaAcademicaService.consultar().subscribe(ofertasAcademicas => {
      this.ofertasAcademicas = ofertasAcademicas;
    });

  }

  private construirFormularioMatricula() {
    this.matriculaForm = new FormGroup({
      ofertaAcademicaId: new FormControl('', [Validators.required]),
      usuarioId: new FormControl('', [Validators.required])
    });

  }

}
