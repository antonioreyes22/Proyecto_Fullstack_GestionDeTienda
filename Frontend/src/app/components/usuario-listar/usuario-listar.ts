import { Component, NgModule, OnInit } from '@angular/core';
import { Usuario } from '../../models/usuario.model';
import { UsuarioService } from '../../services/usuario-service';
import { CommonModule } from '@angular/common';
import { FormGroup, FormsModule, ReactiveFormsModule } from '@angular/forms';

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

  constructor(private usuarioService: UsuarioService){}
  
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
  }

  saveUser(id: number, username: string, email: string, index: number)
  {
    
    this.usuarioService.getUserByName(username).subscribe
    (
      (existingUser) => 
        {
          if (existingUser && existingUser.id !== id) 
            {
              username = ""; // no cambiamos el nombre
            }

            this.usuarioService.getUserByEmail(email).subscribe
            (
            (existingUser) => 
              { 
                if (existingUser && existingUser.id !== id) 
                  {
                    email = ""; // no cambiamos el email
                  }

              this.usuarioService.updateUser(id, username, email).subscribe();
              window.location.reload();
              }
            )
      }         
    )
  }
}
