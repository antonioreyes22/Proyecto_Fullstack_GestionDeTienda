import { AbstractControl, AsyncValidatorFn, ValidationErrors } from '@angular/forms';
import { UsuarioService } from '../services/usuario-service';
import { map, catchError, of } from 'rxjs';

export function nombreExisteValidator(
  usuarioService: UsuarioService
): AsyncValidatorFn {
  return (control: AbstractControl) => {
    if (!control.value) return of(null);

    return usuarioService.getUserByName(control.value).pipe(
      map(usuario => (usuario ? { nombreExiste: true } : null)),
      catchError(() => of(null))
    );
  };
}

export function emailExisteValidator(
  usuarioService: UsuarioService
): AsyncValidatorFn {
  return (control: AbstractControl) => {
    if (!control.value) return of(null);

    return usuarioService.getUserByEmail(control.value).pipe(
      map(usuario => (usuario ? { emailExiste: true } : null)),
      catchError(() => of(null))
    );
  };
}