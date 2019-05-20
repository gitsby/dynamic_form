import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ReactiveFormsModule} from '@angular/forms';

import {DynamicFieldDirective} from './components/dynamic-field/dynamic-field.directive';
import {DynamicFormComponent} from './containers/dynamic-form/dynamic-form.component';
import {FormInputComponent} from './components/form_elements/input/form-input.component';
import {FormSelectComponent} from './components/form_elements/select/form-select.component';
import {FormXrefComponent} from './components/form_elements/xref/form-xref.component';
import {FormRadioComponent} from './components/form_elements/radio/form-radio.component';

@NgModule({
  imports: [
    CommonModule,
    ReactiveFormsModule
  ],
  declarations: [
    DynamicFieldDirective,
    DynamicFormComponent,
    FormInputComponent,
    FormSelectComponent,
    FormXrefComponent,
    FormRadioComponent
  ],
  exports: [
    DynamicFormComponent
  ],
  entryComponents: [
    FormInputComponent,
    FormSelectComponent,
    FormXrefComponent,
    FormRadioComponent
  ]
})
export class DynamicFormModule {
}
