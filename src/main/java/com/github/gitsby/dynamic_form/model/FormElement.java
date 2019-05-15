package com.github.gitsby.dynamic_form.model;

import java.util.HashMap;
import java.util.Map;

public abstract class FormElement {

  public final Map<String, String> cssStyles = new HashMap<>();
  public boolean editable;
  public ControlType controlType;
  public String controlName;
  public String label;

}
