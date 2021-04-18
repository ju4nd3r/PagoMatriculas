import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { OfertaAcademicaService } from '../../../../core/services/oferta-academica/oferta-academica.service';
import { OfertaAcademica } from '../../../../core/modelo/oferta-academica';

@Component({
  selector: 'app-listar-oferta-academica',
  templateUrl: './listar-oferta-academica.component.html',
  styleUrls: ['./listar-oferta-academica.component.sass']
})
export class ListarOfertaAcademicaComponent implements OnInit {

  ofertasAcademicas: Observable<OfertaAcademica[]>;
  constructor(protected ofertaAcademicaService: OfertaAcademicaService) { }

  ngOnInit(): void {
    this.ofertasAcademicas = this.ofertaAcademicaService.consultar();
  }

}
