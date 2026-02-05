import { Component, OnInit } from '@angular/core';
import { UsuarioService } from '../../services/usuario-service';
import { Usuario } from '../../models/usuario.model';
import { CommonModule } from '@angular/common';
import { AbstractControl, FormBuilder, FormControl, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { inject } from '@angular/core';
import { Validators } from '@angular/forms';
import { emailExisteValidator, nombreExisteValidator } from '../../validators/usuario-exists.validator';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'app-usuario-crear',
  imports: [CommonModule, FormsModule, ReactiveFormsModule],
  templateUrl: './usuario-crear.html',
  styleUrl: './usuario-crear.css',
})
export class UsuarioCrear implements OnInit{

  fb = inject(FormBuilder);
  form!: FormGroup;
  creado: boolean = false;
  nuevoNombre?: string;
  nuevoEmail?: string;

  constructor(private usuarioService: UsuarioService){}

  ngOnInit(): void
  {
    this.form = this.fb.group(
    {
      nombre: ['', [Validators.required, Validators.minLength(2)], nombreExisteValidator(this.usuarioService)],
      email: ['', [Validators.required, Validators.email], emailExisteValidator(this.usuarioService)]
    })  
  }

  addUser()
  {
    this.creado = false

    if (this.form.invalid || this.form.pending) 
    {
      this.form.markAllAsTouched();
      return;
    }

    const { nombre, email } = this.form.value;

    const usuario = new Usuario(nombre!, email!);

    this.usuarioService.crearUsuario(usuario).subscribe(res => {
      console.log(res);
      this.nuevoNombre = usuario.nombre;
      this.nuevoEmail = usuario.email;
      this.creado = true;
      this.form.reset();
    });
  }
}

