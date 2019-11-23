import { Injectable } from '@angular/core';
import { GrupoAcesso } from '../_DTO/gruposDeAcesso';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { retry, catchError, share } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class GrupoAcessoService {

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
  getAllGrupoAcesso(): Observable<GrupoAcesso[]> {
    return this.http.get<GrupoAcesso[]>(this.apiURL + '/grupoacesso/list')
      .pipe(
        retry(1),
        catchError(this.handleError)
      )
  }

  // HttpClient API get() method => Fetch product
  getGrupoAcesso(id): Observable<GrupoAcesso> {
    return this.http.get<GrupoAcesso>(this.apiURL + '/grupoacesso/get/' + id)
      .pipe(
        retry(1),
        catchError(this.handleError)
      )
  }

  // HttpClient API post() method => Create product
  createGrupoAcesso(grupoacesso): Observable<Number> {
    return this.http.post<Number>(this.apiURL + '/grupoacesso', JSON.stringify(grupoacesso), this.httpOptions)
      .pipe(
        retry(1),
        catchError(this.handleError)
      )
  }

  // HttpClient API put() method => Update product
  updateGrupoAcesso(id, grupoacesso): Observable<GrupoAcesso> {
    console.log(JSON.stringify(grupoacesso));
    return this.http.put<GrupoAcesso>(this.apiURL + '/grupoacesso/' + id, JSON.stringify(grupoacesso), this.httpOptions)
      .pipe(
        retry(1),
        catchError(this.handleError)
      )
  }

  // HttpClient API delete() method => Delete product
  deleteGrupoAcesso(id): Observable<GrupoAcesso> {
    return this.http.delete<GrupoAcesso>(this.apiURL + '/grupoacesso/' + id, this.httpOptions)
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
