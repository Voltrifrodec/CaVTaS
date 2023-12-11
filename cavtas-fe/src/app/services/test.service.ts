import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { TestingItem } from '../interfaces/testing-item.model';

@Injectable({
  providedIn: 'root'
})
export class TestService {

  private url = `http://localhost:8080/api/test`;

  constructor(private http: HttpClient) {
  }

  public getValue(id: number): Observable<TestingItem> {
    return this.http.get<TestingItem>(`${this.url}/${id}`);
  }

  public getAllValues(): Observable<TestingItem[]> {
    return this.http.get<TestingItem[]>(`${this.url}`);
  }

}
