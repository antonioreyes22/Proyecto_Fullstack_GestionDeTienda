import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UsuarioEliminar } from './usuario-eliminar';

describe('UsuarioEliminar', () => {
  let component: UsuarioEliminar;
  let fixture: ComponentFixture<UsuarioEliminar>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [UsuarioEliminar]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UsuarioEliminar);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
