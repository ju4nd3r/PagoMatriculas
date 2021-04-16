import { NgModule } from '@angular/core';

import {CrearOfertaAcademicaComponent} from './components/crear-oferta-academica/crear-oferta-academica.component';
import {ListarOfertaAcademicaComponent} from './components/listar-oferta-academica/listar-oferta-academica.component';
import {OfertaAcademicaComponent} from './components/oferta-academica/oferta-academica.component';
import {OfertaAcademicaRoutingModule} from './oferta-academica-routing.module';
import { OfertaAcademicaService } from '../../core/services/oferta-academica/oferta-academica.service';

import { SharedModule } from '@shared/shared.module';




@NgModule({
    declarations: [
        CrearOfertaAcademicaComponent,
        ListarOfertaAcademicaComponent,
        OfertaAcademicaComponent
    ],
    imports : [
      OfertaAcademicaRoutingModule,
      SharedModule
    ],
    providers: [OfertaAcademicaService]

})
export class OfertaAcademicaModule {}