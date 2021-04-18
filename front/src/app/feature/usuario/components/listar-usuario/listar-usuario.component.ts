import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Usuario } from '../../shared/model/usuario';
import { UsuarioService } from '../../shared/service/usuario.service';

@Component({
  selector: 'app-listar-usuario',
  templateUrl: './listar-usuario.component.html',
  styleUrls: ['./listar-usuario.component.sass']
})
export class ListarUsuarioComponent implements OnInit {

  public usuarios : Observable<Usuario[]>;

  constructor(protected usuarioService: UsuarioService) { }

  ngOnInit(): void {
    this.usuarios = this.usuarioService.consultar();
  }

}
