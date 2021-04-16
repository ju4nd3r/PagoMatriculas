import { NgModule } from '@angular/core';

import { MatriculaRoutingModule } from './matricula-routing.module';
import { CrearMatriculaComponent } from './components/crear-matricula/crear-matricula.component';
import { MatriculaComponent } from './components/matricula/matricula.component';

import { SharedModule } from '@shared/shared.module';



@NgModule({
    declarations: [
        CrearMatriculaComponent,
        MatriculaComponent,
    ],
    imports : [
        MatriculaRoutingModule,
        SharedModule

    ],
    providers: []

})
export class MatriculaModule {}