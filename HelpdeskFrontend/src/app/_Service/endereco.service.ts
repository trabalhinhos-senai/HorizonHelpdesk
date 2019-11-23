import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { retry, catchError, share } from 'rxjs/operators';
import { Estados } from '../_DTO/estados';
import { Cidades } from '../_DTO/cidades';

@Injectable({
  providedIn: 'root'
})
export class EnderecoService {

   // Define API
   apiURL = 'https://servicodados.ibge.gov.br/api';

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
   getAllEstados(): Observable<Estados[]> {
     return this.http.get<Estados[]>(this.apiURL + '/v1/localidades/estados')
       .pipe(
         retry(1),
         catchError(this.handleError)
       )
   }
 
   // HttpClient API get() method => Fetch product
   getEstado(id): Observable<Estados> {
     return this.http.get<Estados>(this.apiURL + '/v1/localidades/estados/' + id)
       .pipe(
         retry(1),
         catchError(this.handleError)
       )
   }

   getCidadePorUF(id): Observable<Cidades[]> {
    return this.http.get<Cidades[]>(this.apiURL + '/v1/localidades/estados/' + id + '/municipios')
      .pipe(
        retry(1),
        catchError(this.handleError)
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
