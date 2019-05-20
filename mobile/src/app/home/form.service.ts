import {Injectable} from '@angular/core';
import {HttpService} from '../http.service';
import {FieldConfig} from '../dynamic-form/models/field-config.interface';

@Injectable({
  providedIn: 'root'
})
export class FormService {

  private httpService: HttpService;

  constructor(httpService: HttpService) {
    this.httpService = httpService.setControllerPrefix('/form');
  }


  getFormConfig(param: string): Promise<FieldConfig[]> {
    return this.httpService.get('/v2', {RequestID: param})
    .toPromise()
    .then(response => response.body as FieldConfig[]);
  }
}
