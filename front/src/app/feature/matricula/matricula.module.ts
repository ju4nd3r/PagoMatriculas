import { NgModule } from '@angular/core';

import { MatriculaRoutingModule } from './matricula-routing.module';
import { CrearMatriculaComponent } from './components/crear-matricula/crear-matricula.component';
import { MatriculaComponent } from './components/matricula/matricula.component';



@NgModule({
    declarations: [
        CrearMatriculaComponent,
        MatriculaComponent,
    ],
    imports : [
        MatriculaRoutingModule,

    ],
    providers: []

})
export class MatriculaModule {}