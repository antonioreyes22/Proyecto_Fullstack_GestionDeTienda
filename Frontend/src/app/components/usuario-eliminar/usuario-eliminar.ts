import { Component } from '@angular/core';
import { UsuarioService } from '../../services/usuario-service';
import { Usuario } from '../../models/usuario.model';
import { OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-usuario-eliminar',
  imports: [FormsModule, CommonModule],
  templateUrl: './usuario-eliminar.html',
  styleUrl: './usuario-eliminar.css',
})
export class UsuarioEliminar implements OnInit{

  nombre: string = '';
  eliminado?: boolean;
  error?: boolean;

  constructor(private usuarioService: UsuarioService) {}

  ngOnInit(): void{}

  deleteUser(name: string): void{
    this.eliminado = false;
    this.error = false;

    this.usuarioService.deleteUserByName(name).subscribe({
    next:  () => this.eliminado = true,
    error: () => {console.log("USUARIO NO ELIMINADO");  this.error = true}
  });
  
  }
}
