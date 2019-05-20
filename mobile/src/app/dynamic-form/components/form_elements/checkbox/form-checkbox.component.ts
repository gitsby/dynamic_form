import {Component} from '@angular/core';
import {Field} from '../../../models/field.interface';
import {FieldConfig} from '../../../models/field-config.interface';
import {FormGroup} from '@angular/forms';

@Component({
  selector: 'app-form-checkbox',
  templateUrl: './form-checkbox.component.html',
  styleUrls: ['./form-checkbox.component.scss'],
})
export class FormCheckboxComponent implements Field {

  config: FieldConfig;
  group: FormGroup;

  constructor() {
  }

}
