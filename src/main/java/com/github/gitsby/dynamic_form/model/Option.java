package com.github.gitsby.dynamic_form.model;

public class Option {

  public String id;
  public String value;

  private Option() {

  }

  public static Option of(String id, String value) {
    Option option = new Option();
    option.id = id;
    option.value = value;
    return option;
  }

}
