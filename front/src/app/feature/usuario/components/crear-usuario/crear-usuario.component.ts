import { Component, OnInit } from '@angular/core';

import { FormGroup, FormControl, Validators } from '@angular/forms';
import { UsuarioService } from '../../shared/service/usuario.service';

@Component({
  selector: 'app-crear-usuario',
  templateUrl: './crear-usuario.component.html',
  styleUrls: ['./crear-usuario.component.sass']
})
export class CrearUsuarioComponent implements OnInit {

  usuarioForm : FormGroup;
  constructor(protected usuarioService: UsuarioService) { }

  ngOnInit(): void {
    this.construirFormularioUsuario();
  }

  crear() {
    console.log('clic en el boton de crear');
    console.log(this.usuarioForm.value);
    this.usuarioService.guardar(this.usuarioForm.value).subscribe( id => {
      alert('Se creó el usuario con el id:'+ id);
    });
  }

  private construirFormularioUsuario() {
    this.usuarioForm = new FormGroup({
      id: new FormControl('', [Validators.required]),
      nombre: new FormControl('', [Validators.required])
    });
  }
}
