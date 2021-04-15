import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CrearMatriculaComponent } from './components/crear-matricula/crear-matricula.component';
import { MatriculaComponent } from './components/matricula/matricula.component';


const routes: Routes = [
    {
      path: '',
      component: MatriculaComponent,
      children: [
        {
          path: 'crear',
          component: CrearMatriculaComponent
        }
      ]
    }
  ];


@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
    
    })
export class MatriculaRoutingModule {}