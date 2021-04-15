import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import {CrearOfertaAcademicaComponent} from './components/crear-oferta-academica/crear-oferta-academica.component';
import {ListarOfertaAcademicaComponent} from './components/listar-oferta-academica/listar-oferta-academica.component';
import {OfertaAcademicaComponent} from './components/oferta-academica/oferta-academica.component';

const routes: Routes = [
  {
    path: '',
    component: OfertaAcademicaComponent,
    children: [
      {
        path: 'crear',
        component: CrearOfertaAcademicaComponent
      },
      {
        path: 'listar',
        component: ListarOfertaAcademicaComponent
      }
    
    ]
  }
];
@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
    
    })
export class OfertaAcademicaRoutingModule {}