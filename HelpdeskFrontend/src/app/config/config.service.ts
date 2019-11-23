import { Injectable } from '@angular/core';
import { Config } from '../_DTO/config';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { retry, catchError, share } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ConfigService {

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
    getAllConfig(): Observable<Config[]> {
      return this.http.get<Config[]>(this.apiURL + '/config/list')
      .pipe(
        retry(1),
        catchError(this.handleError)
      )
    }
  
    // HttpClient API get() method => Fetch product
    getConfig(id): Observable<Config> {
      return this.http.get<Config>(this.apiURL + '/config/get/' + id)
      .pipe(
        retry(1),
        catchError(this.handleError)
      )
    }
  
    // HttpClient API post() method => Create product
    createConfig(config): Observable<Number> {
      return this.http.post<Number>(this.apiURL + '/config', JSON.stringify(config), this.httpOptions)
      .pipe(
        retry(1),
        catchError(this.handleError)
      )
    }
  
    // HttpClient API put() method => Update product
    updateConfig(id, config): Observable<Config> {
      return this.http.put<Config>(this.apiURL + '/config/' + id, JSON.stringify(config), this.httpOptions)
      .pipe(
        retry(1),
        catchError(this.handleError)
      )
    }
  
    // HttpClient API delete() method => Delete product
    deleteConfig(id): Observable<Config>{
      return this.http.delete<Config>(this.apiURL + '/config/' + id, this.httpOptions)
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
