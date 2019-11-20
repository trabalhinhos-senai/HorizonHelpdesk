import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { retry, catchError, share } from 'rxjs/operators';
import { Chamado } from '../chamados';

@Injectable({
  providedIn: 'root'
})
export class ChamadosService {

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
  getAllChamados(): Observable<Chamado[]> {
    return this.http.get<Chamado[]>(this.apiURL + '/chamado/list')
    .pipe(
      retry(1),
      catchError(this.handleError)
    )
  }

  // HttpClient API get() method => Fetch product
  getChamado(id): Observable<Chamado> {
    return this.http.get<Chamado>(this.apiURL + '/chamado/get/' + id)
    .pipe(
      retry(1),
      catchError(this.handleError)
    )
  }

  // HttpClient API post() method => Create product
  createChamado(chamado): Observable<Number> {
    return this.http.post<Number>(this.apiURL + '/chamado', JSON.stringify(chamado), this.httpOptions)
    .pipe(
      retry(1),
      catchError(this.handleError)
    )
  }

  // HttpClient API put() method => Update product
  updateChamado(id, chamado): Observable<Chamado> {
    console.log(JSON.stringify(chamado));
    return this.http.put<Chamado>(this.apiURL + '/chamado/' + id, JSON.stringify(chamado), this.httpOptions)
    .pipe(
      retry(1),
      catchError(this.handleError)
    )
  }

  // HttpClient API delete() method => Delete product
  deleteChamado(id): Observable<Chamado>{
    return this.http.delete<Chamado>(this.apiURL + '/chamado/' + id, this.httpOptions)
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
