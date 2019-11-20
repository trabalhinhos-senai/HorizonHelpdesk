import { Injectable } from '@angular/core';
import { Usuario } from '../usuarios';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { retry, catchError, share } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  /*Usuarios = Usuarios;

  constructor() { }

  getUsuarios() {
    return this.Usuarios;
  }

  getUsuarioById(id: string) {
    
    for (let i = 0; i < this.Usuarios.length; i++) {
      const usuario = this.Usuarios[i];

      if (usuario.id === id) {
        return usuario;
      }   
    }    
  }*/

  // Define API
  apiURL = '/api';

  constructor(private http: HttpClient) { }

  /*========================================
    CRUD Methods for consuming RESTful API
  =========================================*/

  // Http Options
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }

  // HttpClient API get() method => Fetch Products list
  getAllUsers(): Observable<Usuario[]> {
    return this.http.get<Usuario[]>(this.apiURL + '/usuario/list')
    .pipe(
      retry(1),
      catchError(this.handleError)
    )
  }

  // HttpClient API get() method => Fetch product
  getUser(id): Observable<Usuario> {
    return this.http.get<Usuario>(this.apiURL + '/usuario/get/' + id)
    .pipe(
      retry(1),
      catchError(this.handleError)
    )
  }

  // HttpClient API post() method => Create product
  createUser(usuario): Observable<Number> {
    return this.http.post<Number>(this.apiURL + '/usuario', JSON.stringify(usuario), this.httpOptions)
    .pipe(
      retry(1),
      catchError(this.handleError)
    )
  }

  // HttpClient API put() method => Update product
  updateUser(id, usuario): Observable<Usuario> {
    console.log(JSON.stringify(usuario));
    return this.http.put<Usuario>(this.apiURL + '/usuario/' + id, JSON.stringify(usuario), this.httpOptions)
    .pipe(
      retry(1),
      catchError(this.handleError)
    )
  }

  // HttpClient API delete() method => Delete product
  deleteUser(id): Observable<Usuario>{
    return this.http.delete<Usuario>(this.apiURL + '/usuario/' + id, this.httpOptions)
    .pipe(
      retry(1),
      catchError(this.handleError), 
      share()
    )
  }

  // Error handling
  handleError(error) {
     let errorMessage = '';
     if(error.error instanceof ErrorEvent) {
       // Get client-side error
       errorMessage = error.error.message;
     } else {
       // Get server-side error
       errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
     }
     window.alert(errorMessage);
     return throwError(errorMessage);
  }

}
