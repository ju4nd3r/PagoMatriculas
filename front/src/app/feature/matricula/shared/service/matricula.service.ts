import { Injectable } from '@angular/core';
import { HttpService } from '@core-service/http.service';
import { environment } from 'src/environments/environment';
import { Matricula } from '../model/matricula';

@Injectable({
  providedIn: 'root'
})
export class MatriculaService {

  constructor(protected http: HttpService) { }

  public guardar(matricula: Matricula) {
    return this.http.doPost<Matricula, boolean>(`${environment.endpoint}/matriculas`, matricula,
                                                this.http.optsName('Crear Matricula'));
  }
}
