import {AfterViewInit, Component, ViewChild} from '@angular/core';
import {FieldConfig} from "../dynamic-form/models/field-config.interface";
import {Validators} from "@angular/forms";
import {DynamicFormComponent} from "../dynamic-form/containers/dynamic-form/dynamic-form.component";
import {ControlType} from "../dynamic-form/models/ControlType";

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage implements AfterViewInit {

  @ViewChild(DynamicFormComponent) form: DynamicFormComponent;

  config: FieldConfig[] = [
    {
      type: ControlType.Text,
      label: 'Full name',
      name: 'name',
      placeholder: 'Enter your name',
      editable: false
    },
    // {
    //   type: 'select',
    //   label: 'Favourite Food',
    //   name: 'food',
    //   options: ['Pizza', 'Hot Dogs', 'Knakworstje', 'Coffee'],
    //   placeholder: 'Select an option',
    //   validation: [Validators.required]
    // },
    // {
    //   label: 'Submit',
    //   name: 'submit',
    //   type: 'button'
    // }
  ];

  ngAfterViewInit() {
    let previousValid = this.form.valid;
    this.form.changes.subscribe(() => {
      if (this.form.valid !== previousValid) {
        previousValid = this.form.valid;
        setTimeout(() =>
            this.form.setDisabled('submit', !previousValid), 0);
      }
    });
    setTimeout(() => this.form.setDisabled('submit', true), 0)
    setTimeout(() => this.form.setValue('name', 'Todd Motto'), 0)
  }

  submit(value: { [name: string]: any }) {
    console.log(value);
  }
}
