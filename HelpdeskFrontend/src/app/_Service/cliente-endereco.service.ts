import { Injectable } from '@angular/core';
import { ClienteEndereco } from '../cliente-pack/clientesDTO';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { retry, catchError, share } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ClienteEnderecoService {

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
  getAllClientesEndereco(): Observable<ClienteEndereco[]> {
    return this.http.get<ClienteEndereco[]>(this.apiURL + '/clienteEndereco/list')
      .pipe(
        retry(1),
        catchError(this.handleError)
      )
  }

  // HttpClient API get() method => Fetch product
  getClienteEndereco(id): Observable<ClienteEndereco> {
    return this.http.get<ClienteEndereco>(this.apiURL + '/clienteEndereco/get/' + id)
      .pipe(
        retry(1),
        catchError(this.handleError)
      )
  }

  // HttpClient API post() method => Create product
  createClienteEndereco(clienteEndereco): Observable<Number> {
    return this.http.post<Number>(this.apiURL + '/clienteEndereco', JSON.stringify(clienteEndereco), this.httpOptions)
      .pipe(
        retry(1),
        catchError(this.handleError)
      )
  }

  // HttpClient API put() method => Update product
  updateClienteEndereco(id, clienteEndereco): Observable<ClienteEndereco> {
    return this.http.put<ClienteEndereco>(this.apiURL + '/clienteEndereco/' + id, JSON.stringify(clienteEndereco), this.httpOptions)
      .pipe(
        retry(1),
        catchError(this.handleError)
      )
  }

  // HttpClient API delete() method => Delete product
  deleteClienteEndereco(id): Observable<ClienteEndereco> {
    return this.http.delete<ClienteEndereco>(this.apiURL + '/clienteEndereco/' + id, this.httpOptions)
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
