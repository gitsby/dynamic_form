import {AfterViewInit, Component, ViewChild} from '@angular/core';
import {FieldConfig} from "../dynamic-form/models/field-config.interface";
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
      controlType: ControlType.Text,
      label: 'Full name',
      controlName: 'name',
      placeholder: 'Enter your name',
      editable: true
    },
    {
      controlType: ControlType.Select,
      editable: true,
      controlName: "AccountType",
      options: [
        {
          id: "001",
          value: "Basic Checking"
        },
        {
          id: "002",
          value: "Premium Checking"
        },
        {
          id: "003",
          value: "Certificate Of Deposit"
        },
        {
          id: "004",
          value: "Standard Checking"
        }
      ],
    }
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
  }

  submit(value: { [name: string]: any }) {
    console.log(value);
  }
}
