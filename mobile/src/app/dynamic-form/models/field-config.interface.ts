import {ValidatorFn} from '@angular/forms';
import {ControlType} from "./ControlType";
import {Option} from "./Option";

export interface FieldConfig {
  editable?: boolean
  label?: string,
  name: string,
  options?: Option[],
  placeholder?: string,
  type: ControlType,
  validation?: ValidatorFn[],
  value?: any
}
