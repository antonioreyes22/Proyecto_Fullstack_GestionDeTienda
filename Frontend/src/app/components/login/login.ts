import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-login',
  imports: [CommonModule, FormsModule],
  templateUrl: './login.html',
  styleUrl: './login.css',
})
export class Login {

  username: string = '';
  password: string = '';
  logged?: boolean;
  failed?: boolean;

  constructor(private http: HttpClient) {}

  loginUser() {

    const body = {
      username: this.username,
      password: this.password
    };

    this.http.post('http://localhost:8080/auth/login', body, {
      responseType: 'text' // Porque el backend devuelve el token como String
    }).subscribe({
      next: (token) => {
        console.log('TOKEN RECIBIDO:', token);

        localStorage.setItem('token', token);
        localStorage.setItem('nombre', this.username);

        this.failed = false;
        this.logged = true;

        //alert('Login correcto');
      },
      error: (err) => {
        console.error('Error login:', err);
        this.logged = false;
        this.failed = true;
        //alert('Credenciales incorrectas');
      }
    });
  }
}
