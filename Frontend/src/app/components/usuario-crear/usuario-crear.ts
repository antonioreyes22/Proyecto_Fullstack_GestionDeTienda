import { Component, OnInit } from '@angular/core';
import { UsuarioService } from '../../services/usuario-service';
import { Usuario } from '../../models/usuario.model';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-usuario-crear',
  imports: [CommonModule, FormsModule],
  templateUrl: './usuario-crear.html',
  styleUrl: './usuario-crear.css',
})
export class UsuarioCrear implements OnInit{

    nombre : string = '';
    email : string = '';
    exist: boolean = false;
    creado: boolean = false;
    errorMsg: string = '';

    constructor(private usuarioService: UsuarioService){}

  ngOnInit(): void{
    
  }
 
  addUser(){
    let usuario = new Usuario(this.nombre, this.email);
    console.log(usuario);
    this.usuarioService.crearUsuario(usuario).subscribe(
      res => console.log(res)
    );
  }

  addUser2()
  {
    this.creado = false;
    this.exist = false;

    this.usuarioService.getUserByName(this.nombre).subscribe(usuario => {
    if (usuario) {
      this.creado = true;
      this.exist = true;
    } else {
      const nuevoUsuario = new Usuario(this.nombre, this.email);
      this.usuarioService.crearUsuario(nuevoUsuario).subscribe(() => {
        this.creado = true;
      });
    }
  });
  }

  addUser3()
  {
    this.creado = false;
    this.exist = false;

    this.usuarioService.getUserByName(this.nombre).subscribe(usuario => 
      {
        if(usuario)
          {
            this.creado = true;
            this.exist = true;
            this.errorMsg = "Nombre de usuario existente";
          }
          else
            {
              this.usuarioService.getUserByEmail(this.email).subscribe(usuario => 
                {
                  if(usuario)
                    {
                      this.creado = true;
                      this.exist = true;
                      this.errorMsg = "Correo existente";
                    }
                    else
                      {
                        const nuevoUsuario = new Usuario(this.nombre, this.email);
                        this.usuarioService.crearUsuario(nuevoUsuario).subscribe(() => {
                        this.creado = true;
                        });
                      }
                })
            }        
      })
  }
}

