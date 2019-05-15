import {Component} from '@angular/core';
import {FormGroup} from '@angular/forms';

import {Field} from '../../../models/field.interface';
import {FieldConfig} from '../../../models/field-config.interface';

@Component({
  selector: 'form-input',
  styleUrls: ['form-input.component.scss'],
  template: `
    <div [formGroup]="group">
      <label>{{ config.label }}</label>
      <br>
      <input [readOnly]="!config.editable"
             type="text"
             [attr.placeholder]="config.placeholder"
             [formControlName]="config.controlName">
    </div>
  `
})
export class FormInputComponent implements Field {
  config: FieldConfig;
  group: FormGroup;
}
