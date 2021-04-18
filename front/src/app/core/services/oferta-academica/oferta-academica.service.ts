import { Injectable } from '@angular/core';
import { HttpService } from '@core-service/http.service';
import { environment } from 'src/environments/environment';
import { OfertaAcademica } from '../../modelo/oferta-academica';


@Injectable({
  providedIn: 'root'
})
export class OfertaAcademicaService {

  constructor(protected http: HttpService) { }

  public consultar() {
    return this.http.doGet<OfertaAcademica[]>(`${environment.endpoint}/ofertas-academicas`, 
    this.http.optsName('consultar ofertas academicas'));
  }

  public guardar(ofertaAcademica: OfertaAcademica) {
    return this.http.doPost<OfertaAcademica, any>(`${environment.endpoint}/ofertas-academicas`, ofertaAcademica,
                                                this.http.optsName('Crear Oferta Academica'));
  }
}
