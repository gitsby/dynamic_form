import {ValidatorFn} from '@angular/forms';
import {ControlType} from "./ControlType";
import {Option} from "./Option";

export interface FieldConfig {
  editable?: boolean
  label?: string,
  controlName: string,
  options?: Option[],
  placeholder?: string,
  controlType: ControlType,
  validation?: ValidatorFn[],
  value?: any
  requestParam?: Map<string, string>;
  cssStyles?: Map<string, string>;
}
