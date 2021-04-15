import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ActualizarUsuarioComponent } from './components/actualizar-usuario/actualizar-usuario.component';
import { CrearUsuarioComponent } from './components/crear-usuario/crear-usuario.component';
import { EliminarUsuarioComponent } from './components/eliminar-usuario/eliminar-usuario.component';
import { ListarUsuarioComponent } from './components/listar-usuario/listar-usuario.component';
import { UsuarioComponent } from './components/usuario/usuario.component';


const routes: Routes = [
    {
      path: '',
      component: UsuarioComponent,
      children: [
        {
          path: 'crear',
          component: CrearUsuarioComponent
        },
        {
          path: 'listar',
          component: ListarUsuarioComponent
        },
        {
          path: 'eliminar',
          component: EliminarUsuarioComponent
        },
        {
            path: 'actualizar',
            component: ActualizarUsuarioComponent
        }
      ]
    }
  ];


@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
    
    })
export class UsuarioRoutingModule {}