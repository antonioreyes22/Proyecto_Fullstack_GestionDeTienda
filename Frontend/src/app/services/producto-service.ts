import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Producto } from '../models/producto.model';

@Injectable({
  providedIn: 'root',
})
export class ProductoService {
  
  private apiUrl: string = 'http://localhost:8080/api/productos';

  constructor(private http: HttpClient, private router: Router) {}

  crearProducto(producto: Producto): Observable<Producto> {
    return this.http.post<Producto>(this.apiUrl + "/guardar", producto);
  }

  getProductList(): Observable<Producto[]> {
    return this.http.get<Producto[]>(this.apiUrl);
  }

  getProductoById(id: number): Observable<Producto>{
    return this.http.get<Producto>(this.apiUrl + "/" + id);
  }

  getProductoByNombre(nombre: string): Observable<Producto>{
    return this.http.get<Producto>(this.apiUrl + "/nombre/" + nombre);
  }

  deleteById(id: number): Observable<Producto>{
    return this.http.post<Producto>(this.apiUrl + "/eliminar/" + id, id);
  }

  findAllChaquetas(): Observable<Producto[]>{
    return this.http.get<Producto[]>(this.apiUrl + "/tipo/chaquetas");
  }

  findAllCamisetas(): Observable<Producto[]>{
    return this.http.get<Producto[]>(this.apiUrl + "/tipo/camisetas");
  }
}
