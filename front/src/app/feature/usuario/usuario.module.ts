import { NgModule } from '@angular/core';

import { UsuarioRoutingModule } from './usuario-routing.module';
import { ActualizarUsuarioComponent } from './components/actualizar-usuario/actualizar-usuario.component';
import { CrearUsuarioComponent } from './components/crear-usuario/crear-usuario.component';
import { EliminarUsuarioComponent } from './components/eliminar-usuario/eliminar-usuario.component';
import { ListarUsuarioComponent } from './components/listar-usuario/listar-usuario.component';
import { UsuarioComponent } from './components/usuario/usuario.component';
import { SharedModule } from '@shared/shared.module';

import { UsuarioService } from './shared/service/usuario.service';



@NgModule({
    declarations: [
    ActualizarUsuarioComponent,
    CrearUsuarioComponent,
    EliminarUsuarioComponent,
    ListarUsuarioComponent,
    UsuarioComponent
    ],
    imports : [
        UsuarioRoutingModule,
        SharedModule
    ],
    providers: [UsuarioService]

})
export class UsuarioModule {}