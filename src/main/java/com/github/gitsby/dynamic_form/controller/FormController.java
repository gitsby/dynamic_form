package com.github.gitsby.dynamic_form.controller;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Vector;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FormController {

  @GetMapping(value = "/form", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public Object getFormConfig(HttpServletRequest request) {

    Enumeration<String> enParameters = request.getParameterNames();
    HashMap<String, Object> hmParameters = new HashMap<>();
    String parameterName = "";
    String requestID = "";
    String requestor = "";
    HashMap<String, Object> hmData;
    Vector<Object> vData = new Vector<>();
    Vector<Object> vReturn = new Vector<>();
    HashMap<String, String> hmOptions;

    String json = null;

    while (enParameters.hasMoreElements()) {
      parameterName = enParameters.nextElement();
      hmParameters.put(parameterName, request.getParameter(parameterName));
    }

    if (hmParameters.containsKey("RequestID")) {
      requestID = (String) hmParameters.get("RequestID");
    }

    if (hmParameters.containsKey("Requestor")) {

      requestor = (String) hmParameters.get("Requestor");
    }

    if (requestID.equalsIgnoreCase("AccountData_AccountInformation")) {
      hmData = new HashMap<String, Object>();
      hmData.put("controlName", "AccountID");
      hmData.put("label", "Account ID");
      hmData.put("editable", false);
      hmData.put("width", "50");
      hmData.put("controlType", "Label");
      hmData.put("options", null);
      vData.addElement(hmData);

      hmData = new HashMap<String, Object>();
      hmData.put("controlName", "AccountName");
      hmData.put("label", "Account Name");
      hmData.put("width", "200");
      hmData.put("controlType", "Text");
      hmData.put("editable", true);
      hmData.put("options", null);
      vData.addElement(hmData);

      hmData = new HashMap<String, Object>();
      hmData.put("controlName", "AccountType");
      hmData.put("label", "Account Type");
      hmData.put("width", "200");
      hmData.put("controlType", "Select");
      hmData.put("editable", true);
      hmOptions = new HashMap<String, String>();
      hmOptions.put("001", "Basic Checking");
      hmOptions.put("002", "Premium Checking");
      hmOptions.put("003", "Standard Checking");
      hmOptions.put("004", "Certificate Of Deposit");
      hmData.put("options", hmOptions);
      vData.addElement(hmData);


      hmData = new HashMap<String, Object>();
      hmData.put("controlName", "ResidencyType");
      hmData.put("label", "Residency Type");
      hmData.put("width", "200");
      hmData.put("controlType", "Radio");
      hmData.put("editable", true);
      hmOptions = new HashMap<String, String>();
      hmOptions.put("001", "Full Time");
      hmOptions.put("002", "Partial Year");
      hmOptions.put("003", "Non Resident");
      hmData.put("options", hmOptions);
      vData.addElement(hmData);

      
      hmData = new HashMap<String, Object>();
      hmData.put("controlName", "Submit");
      hmData.put("label", "Submit");
      hmData.put("width", "200");
      hmData.put("controlType", "Xref");
      hmData.put("editable", false);
      HashMap<String, String> requestParamsMap = new HashMap<>();
      requestParamsMap.put("RequestParm1", "PersonalInformation1");
      requestParamsMap.put("RequestParm2", "PersonalInformation2");
      hmData.put("requestParam", requestParamsMap);
      hmData.put("options", null);
      vData.addElement(hmData);

      vReturn.addElement(vData);
    } else if (requestID.equalsIgnoreCase("AccountData_PersonalInformation")) {
      hmData = new HashMap<String, Object>();
      hmData.put("controlName", "FirstName");
      hmData.put("label", "First Name");
      hmData.put("width", "200");
      hmData.put("controlType", "Text");
      hmData.put("editable", true);
      hmData.put("options", null);
      vData.addElement(hmData);

      hmData = new HashMap<String, Object>();
      hmData.put("controlName", "LastName");
      hmData.put("label", "Last Name");
      hmData.put("width", "200");
      hmData.put("controlType", "Text");
      hmData.put("editable", true);
      hmData.put("options", null);
      vData.addElement(hmData);

      hmData = new HashMap<String, Object>();
      hmData.put("controlName", "Citizenship");
      hmData.put("label", "Citizen Ship");
      hmData.put("width", "200");
      hmData.put("controlType", "Select");
      hmData.put("editable", true);
      hmOptions = new HashMap<String, String>();
      hmOptions.put("001", "United States");
      hmOptions.put("002", "United Kingdom");
      hmOptions.put("003", "United Arab Emirates");
      hmOptions.put("004", "Republic Of Congo");
      hmData.put("options", hmOptions);
      vData.addElement(hmData);

      hmData = new HashMap<String, Object>();
      hmData.put("controlName", "ResidencyType");
      hmData.put("label", "Residency Type");
      hmData.put("width", "200");
      hmData.put("controlType", "Radio");
      hmData.put("editable", true);
      hmOptions = new HashMap<String, String>();
      hmOptions.put("001", "Full Time");
      hmOptions.put("002", "Partial Year");
      hmOptions.put("003", "Non Resident");
      hmData.put("options", hmOptions);
      vData.addElement(hmData);

      hmData = new HashMap<String, Object>();
      hmData.put("controlName", "Resident");
      hmData.put("label", "Resident Of The Country");
      hmData.put("width", "200");
      hmData.put("controlType", "CheckBox");
      hmData.put("editable", true);
      hmOptions = new HashMap<String, String>();
      hmOptions.put("001", "Yes");
      hmData.put("options", hmOptions);
      vData.addElement(hmData);

      hmData = new HashMap<String, Object>();
      hmData.put("controlName", "Submit");
      hmData.put("label", "Submit");
      hmData.put("width", "200");
      hmData.put("controlType", "Xref");
      hmData.put("editable", false);

      HashMap<String, String> requestParamsMap = new HashMap<>();
      requestParamsMap.put("RequestParm1", "PersonalInformation1");
      requestParamsMap.put("RequestParm2", "PersonalInformation2");
      hmData.put("requestParam", requestParamsMap);
      hmData.put("options", null);
      vData.addElement(hmData);

      vReturn.addElement(vData);
    }

    return vReturn;
    
//    Enumeration<String> enParameters = request.getParameterNames();
//    HashMap<String, Object> hmParameters = new HashMap<>();
//    String parameterName = "";
//    String requestID = "";
//    String requestor = "";
//    HashMap<String, Object> hmData;
//    Vector<Object> vData = new Vector<>();
//    Vector<Object> vReturn = new Vector<>();
//    HashMap<String, String> hmOptions;
//
//    String json = null;
//
//    while (enParameters.hasMoreElements()) {
//      parameterName = enParameters.nextElement();
//      hmParameters.put(parameterName, request.getParameter(parameterName));
//    }
//
//    if (hmParameters.containsKey("RequestID")) {
//      requestID = (String) hmParameters.get("RequestID");
//    }
//
//    if (hmParameters.containsKey("Requestor")) {
//
//      requestor = (String) hmParameters.get("Requestor");
//    }
//
//    if (requestID.equalsIgnoreCase("AccountData_AccountInformation")) {
//      hmData = new HashMap<String, Object>();
//      hmData.put("controlName", "AccountID");
//      hmData.put("label", "Account ID");
//      hmData.put("editable", false);
//      hmData.put("width", "50");
//      hmData.put("controlType", "Label");
//      hmData.put("options", null);
//      vData.addElement(hmData);
//
//      hmData = new HashMap<String, Object>();
//      hmData.put("controlName", "AccountName");
//      hmData.put("label", "Account Name");
//      hmData.put("width", "200");
//      hmData.put("controlType", "Text");
//      hmData.put("editable", true);
//      hmData.put("options", null);
//      vData.addElement(hmData);
//
//      hmData = new HashMap<String, Object>();
//      hmData.put("controlName", "AccountType");
//      hmData.put("label", "Account Type");
//      hmData.put("width", "200");
//      hmData.put("controlType", "Select");
//      hmData.put("editable", true);
//      hmOptions = new HashMap<String, String>();
//      hmOptions.put("001", "Basic Checking");
//      hmOptions.put("002", "Premium Checking");
//      hmOptions.put("003", "Standard Checking");
//      hmOptions.put("004", "Certificate Of Deposit");
//      hmData.put("options", hmOptions);
//      vData.addElement(hmData);
//
//      hmData = new HashMap<String, Object>();
//      hmData.put("controlName", "Submit");
//      hmData.put("label", "Submit");
//      hmData.put("width", "200");
//      hmData.put("controlType", "Xref");
//      hmData.put("editable", false);
//      HashMap<String, String> requestParamsMap = new HashMap<>();
//      requestParamsMap.put("RequestParm1", "PersonalInformation1");
//      requestParamsMap.put("RequestParm2", "PersonalInformation2");
//      hmData.put("requestParam", requestParamsMap);
//      hmData.put("options", null);
//      vData.addElement(hmData);
//
//      vReturn.addElement(vData);
//    } else if (requestID.equalsIgnoreCase("AccountData_PersonalInformation")) {
//      hmData = new HashMap<String, Object>();
//      hmData.put("controlName", "FirstName");
//      hmData.put("label", "First Name");
//      hmData.put("width", "200");
//      hmData.put("controlType", "Text");
//      hmData.put("editable", true);
//      hmData.put("options", null);
//      vData.addElement(hmData);
//
//      hmData = new HashMap<String, Object>();
//      hmData.put("controlName", "LastName");
//      hmData.put("label", "Last Name");
//      hmData.put("width", "200");
//      hmData.put("controlType", "Text");
//      hmData.put("editable", true);
//      hmData.put("options", null);
//      vData.addElement(hmData);
//
//      hmData = new HashMap<String, Object>();
//      hmData.put("controlName", "Citizenship");
//      hmData.put("label", "Citizen Ship");
//      hmData.put("width", "200");
//      hmData.put("controlType", "Select");
//      hmData.put("editable", true);
//      hmOptions = new HashMap<String, String>();
//      hmOptions.put("001", "United States");
//      hmOptions.put("002", "United Kingdom");
//      hmOptions.put("003", "United Arab Emirates");
//      hmOptions.put("004", "Republic Of Congo");
//      hmData.put("options", hmOptions);
//      vData.addElement(hmData);
//
//      hmData = new HashMap<String, Object>();
//      hmData.put("controlName", "ResidencyType");
//      hmData.put("label", "Residency Type");
//      hmData.put("width", "200");
//      hmData.put("controlType", "Radio");
//      hmData.put("editable", true);
//      hmOptions = new HashMap<String, String>();
//      hmOptions.put("001", "Full Time");
//      hmOptions.put("002", "Partial Year");
//      hmOptions.put("003", "Non Resident");
//      hmData.put("options", hmOptions);
//      vData.addElement(hmData);
//
//      hmData = new HashMap<String, Object>();
//      hmData.put("controlName", "Resident");
//      hmData.put("label", "Resident Of The Country");
//      hmData.put("width", "200");
//      hmData.put("controlType", "CheckBox");
//      hmData.put("editable", true);
//      hmOptions = new HashMap<String, String>();
//      hmOptions.put("001", "Yes");
//      hmData.put("options", hmOptions);
//      vData.addElement(hmData);
//
//      hmData = new HashMap<String, Object>();
//      hmData.put("controlName", "Submit");
//      hmData.put("label", "Submit");
//      hmData.put("width", "200");
//      hmData.put("controlType", "Xref");
//      hmData.put("editable", false);
//
//      HashMap<String, String> requestParamsMap = new HashMap<>();
//      requestParamsMap.put("RequestParm1", "PersonalInformation1");
//      requestParamsMap.put("RequestParm2", "PersonalInformation2");
//      hmData.put("requestParam", requestParamsMap);
//      hmData.put("options", null);
//      vData.addElement(hmData);
//
//      vReturn.addElement(vData);
//    }
//
//    return vReturn;
  }

}
