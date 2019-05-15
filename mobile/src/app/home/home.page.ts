import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import {FieldConfig} from "../dynamic-form/models/field-config.interface";
import {DynamicFormComponent} from "../dynamic-form/containers/dynamic-form/dynamic-form.component";
import {ControlType} from "../dynamic-form/models/ControlType";

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage implements OnInit, AfterViewInit {

  @ViewChild(DynamicFormComponent) form: DynamicFormComponent;

  config: FieldConfig[];


  ngOnInit(): void {

    let cssStylesText = new Map();
    cssStylesText.set("width", "50px");
    cssStylesText.set("color", "red");


    let cssStylesSelect = new Map();
    cssStylesSelect.set("width", "100px");
    this.config = [
      {
        cssStyles: cssStylesText,
        editable: true,
        controlType: ControlType.Text,
        controlName: "AccountID",
        label: null
      },
      {
        cssStyles: cssStylesSelect,
        editable: true,
        controlType: ControlType.Select,
        controlName: "AccountType",
        label: "Account Type",
        options: [
          {id: "001", value: "Basic Checking"},
          {id: "002", value: "Premium Checking"},
          {id: "003", value: "Standard Checking"},
          {id: "004", value: "Certificate Of Deposit"}
        ]
      },
      {
        editable: false,
        controlType: ControlType.Radio,
        controlName: "ResidencyType",
        label: "Residency Type",
        options: [
          {id: "001", value: "Full Time"},
          {id: "001", value: "Partial Year"},
          {id: "001", value: "Non Resident"},
        ]
      }
    ];
    // let reqParams = new Map<string, string>();
    //
    //    reqParams.set("RequestParm1", "PersonalInformation2PersonalInformation1");
    //    reqParams.set("RequestParm2", "PersonalInformation2PersonalInformation2");
    //    this.config = [
    //      {
    //        controlType: ControlType.Radio,
    //        editable: true,
    //        controlName: "ResidencyType",
    //        label: "Residency Type",
    //        options: [
    //          {id: "001", value: "Full Time"},
    //          {id: "002", value: "Partial Year"},
    //          {id: "003", value: "Non Resident"},
    //        ],
    //      },
    //      {
    //        controlType: ControlType.Select,
    //        editable: true,
    //        controlName: "AccountType",
    //        label: "Account Type",
    //        options: [
    //          {id: "001", value: "Basic Checking"},
    //          {id: "002", value: "Premium Checking"},
    //          {id: "003", value: "Standard Checking"},
    //          {id: "004", value: "Certificate Of Deposit"}
    //        ],
    //      },
    //      {
    //        controlType: ControlType.Text,
    //        label: 'Full name',
    //        controlName: 'name',
    //        placeholder: 'Enter your name',
    //        editable: true
    //      },
    //    ];


    // {
    //   controlType: ControlType.Xref,
    //   editable: false,
    //   controlName: "Submit",
    //   options: null,
    //   requestParam: reqParams,
    //   label: "Submit"
    // }
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

  submit(value
             :
             {
               [name
                   :
                   string
                   ]:
                   any
             }
  ) {
    console.log(value);
  }
}
