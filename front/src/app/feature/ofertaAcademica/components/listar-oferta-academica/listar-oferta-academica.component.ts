import { Component, OnInit } from '@angular/core';
import { OfertaAcademicaService } from '../../../../core/services/oferta-academica/oferta-academica.service';
import { OfertaAcademica } from '../../../../core/modelo/oferta-academica';

@Component({
  selector: 'app-listar-oferta-academica',
  templateUrl: './listar-oferta-academica.component.html',
  styleUrls: ['./listar-oferta-academica.component.sass']
})
export class ListarOfertaAcademicaComponent implements OnInit {

  ofertasAcademicas: OfertaAcademica[] = [];
  constructor(protected ofertaAcademicaService: OfertaAcademicaService) { }

  ngOnInit(): void {
    this.getOfertasAcademicas();
  }

  getOfertasAcademicas(){
    this.ofertaAcademicaService.consultar().subscribe(ofertasAcademicas => {
      this.ofertasAcademicas = ofertasAcademicas;
    });

  }

}
