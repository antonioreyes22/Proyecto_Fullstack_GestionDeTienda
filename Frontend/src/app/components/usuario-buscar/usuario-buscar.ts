import { Component } from '@angular/core';
import { OnInit } from '@angular/core';
import { Usuario } from '../../models/usuario.model';
import { UsuarioService } from '../../services/usuario-service';
import { Observable } from 'rxjs';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-usuario-buscar',
  imports: [CommonModule, FormsModule],
  templateUrl: './usuario-buscar.html',
  styleUrl: './usuario-buscar.css',
})
export class UsuarioBuscar implements OnInit{

  usuario?: Usuario;
  nombre: string = '';
  buscado: boolean = false;

  constructor(private usuarioService: UsuarioService){}
  
  ngOnInit(): void {
    //this.listUsers();
  }

  getUser(name: string): void{
    this.buscado = true;

    this.usuarioService.getUserByName(name).subscribe
    (
      {
        next: (usuario) => 
          { this.usuario = usuario; },
        error: () => 
          { this.usuario = undefined; }
      }
    )
  };
}
