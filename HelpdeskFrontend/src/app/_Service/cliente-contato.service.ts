import { Injectable } from '@angular/core';
import { ClienteContato } from '../cliente-pack/clientesDTO';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { retry, catchError, share } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ClienteContatoService {

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
    getAllClientesContato(): Observable<ClienteContato[]> {
      return this.http.get<ClienteContato[]>(this.apiURL + '/clienteContato/list')
        .pipe(
          retry(1),
          catchError(this.handleError)
        )
    }
  
    // HttpClient API get() method => Fetch product
    getClienteContato(id): Observable<ClienteContato> {
      return this.http.get<ClienteContato>(this.apiURL + '/clienteContato/get/' + id)
        .pipe(
          retry(1),
          catchError(this.handleError)
        )
    }
  
    // HttpClient API post() method => Create product
    createClienteContato(clienteContato): Observable<Number> {
      return this.http.post<Number>(this.apiURL + '/clienteContato', JSON.stringify(clienteContato), this.httpOptions)
        .pipe(
          retry(1),
          catchError(this.handleError)
        )
    }
  
    // HttpClient API put() method => Update product
    updateClienteContato(id, clienteContato): Observable<ClienteContato> {
      return this.http.put<ClienteContato>(this.apiURL + '/clienteContato/' + id, JSON.stringify(clienteContato), this.httpOptions)
        .pipe(
          retry(1),
          catchError(this.handleError)
        )
    }
  
    // HttpClient API delete() method => Delete product
    deleteClienteContato(id): Observable<ClienteContato> {
      return this.http.delete<ClienteContato>(this.apiURL + '/clienteContato/' + id, this.httpOptions)
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
