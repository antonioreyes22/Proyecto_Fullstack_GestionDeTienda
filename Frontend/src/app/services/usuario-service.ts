import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Usuario } from '../models/usuario.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class UsuarioService {

  private apiUrl: string = 'http://localhost:8080/api/usuarios';

  constructor(private http: HttpClient) {}

  crearUsuario(usuario: Usuario):Observable<Usuario> {
    return this.http.post<Usuario>(this.apiUrl + "/registrar", usuario);
  }

  getUserList():Observable<Usuario []>{
    return this.http.get<Usuario[]>(this.apiUrl);
  }

  getUserByName(nombre: String): Observable<Usuario>{
    return this.http.get<Usuario>(this.apiUrl + "/nombre/" + nombre)
  }

  getUserByEmail(correo: String): Observable<Usuario>{
    return this.http.get<Usuario>(this.apiUrl + "/email/" + correo);
  }

  deleteUserByName(nombre: String): Observable<Usuario>{
    return this.http.post<Usuario>(this.apiUrl + "/eliminar/nombre/" + nombre, nombre);
  }
}
