import { Component } from '@angular/core';
import { UsuarioService } from '../../services/usuario-service';
import { Usuario } from '../../models/usuario.model';
import { OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-usuario-eliminar',
  imports: [FormsModule],
  templateUrl: './usuario-eliminar.html',
  styleUrl: './usuario-eliminar.css',
})
export class UsuarioEliminar implements OnInit{

  nombre: string = '';

  constructor(private usuarioService: UsuarioService) {}

  ngOnInit(): void{}

  deleteUser(name: string): void{
    this.usuarioService.deleteUserByName(name).subscribe({
    next: res => console.log('Usuario eliminado', res),
    error: err => console.error('Error:', err)
  });
  
  }
}
