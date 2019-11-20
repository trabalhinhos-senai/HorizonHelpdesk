import { Injectable } from '@angular/core';
import { Cliente } from '../clientes';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { retry, catchError, share } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ClientesService {

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
  getAllClientes(): Observable<Cliente[]> {
    return this.http.get<Cliente[]>(this.apiURL + '/cliente/list')
      .pipe(
        retry(1),
        catchError(this.handleError)
      )
  }

  // HttpClient API get() method => Fetch product
  getCliente(id): Observable<Cliente> {
    return this.http.get<Cliente>(this.apiURL + '/cliente/get/' + id)
      .pipe(
        retry(1),
        catchError(this.handleError)
      )
  }

  // HttpClient API post() method => Create product
  createCliente(cliente): Observable<Number> {
    return this.http.post<Number>(this.apiURL + '/cliente', JSON.stringify(cliente), this.httpOptions)
      .pipe(
        retry(1),
        catchError(this.handleError)
      )
  }

  // HttpClient API put() method => Update product
  updateCliente(id, cliente): Observable<Cliente> {
    console.log(JSON.stringify(cliente));
    return this.http.put<Cliente>(this.apiURL + '/cliente/' + id, JSON.stringify(cliente), this.httpOptions)
      .pipe(
        retry(1),
        catchError(this.handleError)
      )
  }

  // HttpClient API delete() method => Delete product
  deleteCliente(id): Observable<Cliente> {
    return this.http.delete<Cliente>(this.apiURL + '/cliente/' + id, this.httpOptions)
      .pipe(
        retry(1),
        catchError(this.handleError),
        share()
      )
  }

  // Error handling
  handleError(error) {
    let errorMessage = '';
    if (error.error instanceof ErrorEvent) {
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
