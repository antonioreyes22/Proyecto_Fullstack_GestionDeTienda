import { Component, NgModule, OnInit } from '@angular/core';
import { Usuario } from '../../models/usuario.model';
import { UsuarioService } from '../../services/usuario-service';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { inject } from '@angular/core';
import { Validators } from '@angular/forms';
import { emailExisteValidatorID, nombreExisteValidatorID } from '../../validators/usuario-exists.validator';


@Component({
  selector: 'app-usuario-listar',
  standalone: true,
  imports: [CommonModule, FormsModule, ReactiveFormsModule],
  templateUrl: './usuario-listar.html',
  styleUrls: ['./usuario-listar.css'],
})
export class UsuarioListar implements OnInit{
  
  usuarios: Usuario [] = [];
  modificando: boolean [] = [];
  fb = inject(FormBuilder);
  form!: FormGroup;
  ocultar: boolean = false;

  constructor(public usuarioService: UsuarioService){}
  
  ngOnInit(): void {
    this.listUsers();
  }

  listUsers(){
    this.usuarioService.getUserList().subscribe(
      data => {
        this.usuarios = data;
        console.log(this.usuarios);
      }
    );
  }

  deleteUser(username: string){
    this.usuarioService.deleteUserByName(username).subscribe();
    window.location.reload();
  }

  modifyingUser(index: number){
    this.modificando[index] = true;
    this.ocultar = true;
    const usuario = this.usuarios[index];

    this.form = this.fb.group(
    {
      nombre: [usuario.nombre, [Validators.minLength(2)], nombreExisteValidatorID(this.usuarioService, usuario.id!)],
      email: [usuario.email, [Validators.email], emailExisteValidatorID(this.usuarioService, usuario.id!)]
    })  
  }

  saveUser(id: number, index: number) {
    if (this.form.invalid) return;

    let { nombre, email } = this.form.value;

    if(nombre === "")
      nombre = this.usuarios[index].nombre;

    if(email === "")
      email = this.usuarios[index].email;

    this.usuarioService.updateUser(id, nombre, email)
      .subscribe(() => {
        this.modificando[index] = false;
        this.ocultar = false;
        const updateName = this.usuarioService.getUserByName(nombre);
        localStorage.setItem('nombre', );
        this.listUsers(); // refresca la lista sin recargar la página
      });
}
}
