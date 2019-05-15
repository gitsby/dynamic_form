import {Component, OnInit} from '@angular/core';
import {Field} from "../../../models/field.interface";
import {FormGroup} from "@angular/forms";
import {FieldConfig} from "../../../models/field-config.interface";

@Component({
  selector: 'app-xref',
  templateUrl: './form-xref.component.html',
  styleUrls: ['./form-xref.component.scss'],
})
export class FormXrefComponent implements Field {
  
  config: FieldConfig;
  group: FormGroup;

}
