import { Injectable } from '@angular/core';
import { TipoAtividade } from '../_DTO/tipoAtividade';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { retry, catchError, share } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class TipoAtividadeService {

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
  getAllTipoAtividade(): Observable<TipoAtividade[]> {
    return this.http.get<TipoAtividade[]>(this.apiURL + '/tipoatividade/list')
      .pipe(
        retry(1),
        catchError(this.handleError)
      )
  }

  // HttpClient API get() method => Fetch product
  getTipoAtividade(id): Observable<TipoAtividade> {
    return this.http.get<TipoAtividade>(this.apiURL + '/tipoatividade/get/' + id)
      .pipe(
        retry(1),
        catchError(this.handleError)
      )
  }

  // HttpClient API post() method => Create product
  createTipoAtividade(tipoatividade): Observable<Number> {
    return this.http.post<Number>(this.apiURL + '/tipoatividade', JSON.stringify(tipoatividade), this.httpOptions)
      .pipe(
        retry(1),
        catchError(this.handleError)
      )
  }

  // HttpClient API put() method => Update product
  updateTipoAtividade(id, tipoatividade): Observable<TipoAtividade> {
    return this.http.put<TipoAtividade>(this.apiURL + '/tipoatividade/' + id, JSON.stringify(tipoatividade), this.httpOptions)
      .pipe(
        retry(1),
        catchError(this.handleError)
      )
  }

  // HttpClient API delete() method => Delete product
  deleteTipoAtividade(id): Observable<TipoAtividade> {
    return this.http.delete<TipoAtividade>(this.apiURL + '/tipoatividade/' + id, this.httpOptions)
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
