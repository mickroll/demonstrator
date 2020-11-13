package org.example;

import java.time.LocalDate;

public class ExampleTarget {

  private LocalDate birthday;

  private ExampleMember member;

  public LocalDate getBirthday() {
    return birthday;
  }

  public void setBirthday(LocalDate birthday) {
    this.birthday = birthday;
  }

  public ExampleMember getMember() {
    return member;
  }

  public void setMember(ExampleMember member) {
    this.member = member;
  }
}
