import { Component, OnInit } from '@angular/core';
import { Usuario } from '../../shared/model/usuario';
import { UsuarioService } from '../../shared/service/usuario.service';

@Component({
  selector: 'app-listar-usuario',
  templateUrl: './listar-usuario.component.html',
  styleUrls: ['./listar-usuario.component.sass']
})
export class ListarUsuarioComponent implements OnInit {

  usuarios: Usuario[] = [];
  constructor(protected usuarioService: UsuarioService) { }

  ngOnInit(): void {
    this.getUsuarios();
  }

  getUsuarios(){
    this.usuarioService.consultar().subscribe(usuarios => {
      this.usuarios = usuarios;
    });

  }

}
