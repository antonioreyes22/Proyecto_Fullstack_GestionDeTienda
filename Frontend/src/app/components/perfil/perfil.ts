import { Component, OnInit } from '@angular/core';
import { UsuarioService } from '../../services/usuario-service';
import { Usuario } from '../../models/usuario.model';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { nombreExisteValidator } from '../../validators/usuario-exists.validator';
import { emailExisteValidator } from '../../validators/usuario-exists.validator';
import { inject } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { FormGroup } from '@angular/forms';
import { emailExisteValidatorID } from '../../validators/usuario-exists.validator';
import { nombreExisteValidatorID } from '../../validators/usuario-exists.validator';

@Component({
  selector: 'app-perfil',
  imports: [CommonModule, FormsModule, ReactiveFormsModule],
  templateUrl: './perfil.html',
  styleUrl: './perfil.css',
})
export class Perfil {

  usuario!: Usuario;
  modificando: boolean = false;
  fb = inject(FormBuilder);
  form!: FormGroup;

  constructor(private usuarioService: UsuarioService){}

  ngOnInit(): void 
  {
    this.usuarioService.getUser().subscribe
    (
      {
        next: data => this.usuario = data,
        error: err => console.log(err)   
      }
    );
  }

  modifyingUser()
  {
    this.modificando = !this.modificando;

    this.form = this.fb.group(
        {
          nombre: [this.usuario.nombre, [Validators.minLength(2)], nombreExisteValidatorID(this.usuarioService, this.usuario.id!)],
          email: [this.usuario.email, [Validators.email], emailExisteValidatorID(this.usuarioService, this.usuario.id!)]
        })  
  }

  saveUser(id: number) 
    {
    if (this.form.invalid) return;

    let { nombre, email } = this.form.value;

    if(nombre === "") nombre = this.usuario.nombre;

    if(email === "") email = this.usuario.email;

    this.usuarioService.updateUser(id, nombre, email)
      .subscribe(() => {
        this.modificando = false;

        this.usuario.nombre = nombre;
        this.usuario.email = email;

        localStorage.setItem('nombre', nombre);
      });
  }
}
