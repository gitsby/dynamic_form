package com.github.gitsby.dynamic_form.controller;

import com.github.gitsby.dynamic_form.model.ControlType;
import com.github.gitsby.dynamic_form.model.FormElement;
import com.github.gitsby.dynamic_form.model.Option;
import com.github.gitsby.dynamic_form.model.form_element.FormCheckBox;
import com.github.gitsby.dynamic_form.model.form_element.FormRadio;
import com.github.gitsby.dynamic_form.model.form_element.FormSelect;
import com.github.gitsby.dynamic_form.model.form_element.FormText;
import com.github.gitsby.dynamic_form.model.form_element.FormXref;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/form")
public class FormController {

  @GetMapping("/v2")
  @CrossOrigin(origins = "*")
  public ResponseEntity<Object> formVersion2(@RequestParam("RequestID") String requestId) {
    List<FormElement> formElements = new ArrayList<>();

    if ("AccountData_AccountInformation".equals(requestId)) {
      FormText text = new FormText();
      text.controlType = ControlType.Text;
      text.controlName = "AccountName";
      text.label = "Account Name";
      text.editable = true;
      text.cssStyles.put("width", "200");
      formElements.add(text);

      FormSelect select = new FormSelect();
      select.controlType = ControlType.Select;
      select.controlName = "AccountType";
      select.label = "Account Type";
      select.editable = true;
      select.options.add(Option.of("001", "Basic Checking"));
      select.options.add(Option.of("002", "Premium Checking"));
      select.options.add(Option.of("003", "Standard Checking"));
      select.options.add(Option.of("004", "Certificate Of Deposit"));
      select.cssStyles.put("width", "200");
      formElements.add(select);

      FormRadio radio = new FormRadio();
      radio.controlType = ControlType.Radio;
      radio.controlName = "ResidencyType";
      radio.label = "Residency Type";
      radio.editable = true;
      radio.options.add(Option.of("001", "Full Time"));
      radio.options.add(Option.of("002", "Partial Year"));
      radio.options.add(Option.of("003", "Non Resident"));
      radio.cssStyles.put("width", "200");
      formElements.add(radio);

      FormXref formXref = new FormXref();
      formXref.controlType = ControlType.Xref;
      formXref.baseHref = "http://localhost:8080/test";
      formXref.params.put("param1", "asd");
      formXref.params.put("param2", "bkb");
      formXref.label = "Submit";
      formXref.controlName = "Submit";
      formXref.cssStyles.put("width", "200");

    } else if ("AccountData_PersonalInformation".equals(requestId)) {
      FormText firstName = new FormText();
      firstName.controlType = ControlType.Text;
      firstName.controlName = "FirstName";
      firstName.label = "First Name";
      firstName.editable = true;
      firstName.cssStyles.put("width", "200");
      formElements.add(firstName);

      FormText lastName = new FormText();
      lastName.controlType = ControlType.Text;
      lastName.controlName = "LastName";
      lastName.label = "Last Name";
      lastName.editable = true;
      lastName.cssStyles.put("width", "200");
      formElements.add(lastName);

      FormSelect select = new FormSelect();
      select.controlType = ControlType.Select;
      select.controlName = "Citizenship";
      select.label = "Citizen Ship";
      select.editable = true;
      select.options.add(Option.of("001", "United States"));
      select.options.add(Option.of("002", "United Kingdom"));
      select.options.add(Option.of("003", "United Arab Emirates"));
      select.options.add(Option.of("004", "Republic Of Congo"));
      select.cssStyles.put("width", "200");
      formElements.add(select);

      FormRadio radio = new FormRadio();
      radio.controlType = ControlType.Radio;
      radio.controlName = "ResidencyType";
      radio.label = "Residency Type";
      radio.editable = true;
      radio.options.add(Option.of("001", "Full Time"));
      radio.options.add(Option.of("002", "Partial Year"));
      radio.options.add(Option.of("003", "Non Resident"));
      radio.cssStyles.put("width", "200");
      formElements.add(radio);

      FormCheckBox checkBox = new FormCheckBox();
      checkBox.controlType = ControlType.Checkbox;
      checkBox.controlName = "Resident";
      checkBox.label = "Resident Of The Country";
      checkBox.editable = true;
      checkBox.options.add(Option.of("001", "Yes"));
      checkBox.cssStyles.put("width", "200");
      formElements.add(checkBox);

      FormXref formXref = new FormXref();
      formXref.controlType = ControlType.Xref;
      formXref.baseHref = "http://localhost:8080/test";
      formXref.params.put("param1", "qwe");
      formXref.params.put("param2", "zxc");
      formXref.label = "Submit";
      formXref.controlName = "Submit";
      formXref.cssStyles.put("width", "200");
    }

    return ResponseEntity.ok(formElements);
  }



  @GetMapping("/test")
  public ResponseEntity<?> test(@RequestParam("param1") String param1, @RequestParam("param2") String param2) {
    return ResponseEntity.ok("Message from controller with param1:" + param1 + ", param2:" + param2);

  }


}
