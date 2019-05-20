import {
  ComponentFactoryResolver,
  ComponentRef,
  Directive,
  Input,
  OnChanges,
  OnInit,
  Type,
  ViewContainerRef
} from '@angular/core';
import {FormGroup} from '@angular/forms';

import {FormInputComponent} from '../form_elements/input/form-input.component';
import {FormSelectComponent} from '../form_elements/select/form-select.component';

import {Field} from '../../models/field.interface';
import {FieldConfig} from '../../models/field-config.interface';
import {FormRadioComponent} from '../form_elements/radio/form-radio.component';

const components: {[type: string]: Type<Field>} = {
  Text: FormInputComponent,
  Select: FormSelectComponent,
  Radio: FormRadioComponent
};

@Directive({
  selector: '[dynamicField]'
})
export class DynamicFieldDirective implements Field, OnChanges, OnInit {
  @Input()
  config: FieldConfig;

  @Input()
  group: FormGroup;

  component: ComponentRef<Field>;

  constructor(
    private resolver: ComponentFactoryResolver,
    private container: ViewContainerRef
  ) {}

  ngOnChanges() {
    if (this.component) {
      this.component.instance.config = this.config;
      this.component.instance.group = this.group;
    }
  }

  ngOnInit() {
    if (!components[this.config.controlType]) {
      const supportedTypes = Object.keys(components).join(', ');
      throw new Error(
          `Trying to use an unsupported type (${this.config.controlType}).
        Supported types: ${supportedTypes}`
      );
    }
    const component = this.resolver.resolveComponentFactory<Field>(components[this.config.controlType]);
    this.component = this.container.createComponent(component);
    this.component.instance.config = this.config;
    this.component.instance.group = this.group;
  }
}
