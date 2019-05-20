import {Component} from '@angular/core';
import {Field} from '../../../models/field.interface';
import {FieldConfig} from '../../../models/field-config.interface';
import {FormGroup} from '@angular/forms';

@Component({
  selector: 'app-form-radio',
  templateUrl: './form-radio.component.html',
  styleUrls: ['./form-radio.component.scss'],
})
export class FormRadioComponent implements Field {

  config: FieldConfig;
  group: FormGroup;

}
