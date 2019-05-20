import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import {FieldConfig} from '../dynamic-form/models/field-config.interface';
import {DynamicFormComponent} from '../dynamic-form/containers/dynamic-form/dynamic-form.component';
import {FormService} from './form.service';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage implements OnInit, AfterViewInit {

  @ViewChild(DynamicFormComponent) form: DynamicFormComponent;

  config: FieldConfig[] = [];

  selectedParam: string;

  constructor(private formService: FormService) {

  }

  ngOnInit(): void {

  }


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

  async selectParam(value) {
    this.config = await this.formService.getFormConfig(value);
  }

  test() {
    console.log(this.selectedParam);
  }
}
