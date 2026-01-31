import { Component, NgModule, OnInit } from '@angular/core';
import { Usuario } from '../../models/usuario.model';
import { UsuarioService } from '../../services/usuario-service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-usuario-listar',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './usuario-listar.html',
  styleUrls: ['./usuario-listar.css'],
})
export class UsuarioListar implements OnInit{
  
  usuarios: Usuario [] = [];

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
}
