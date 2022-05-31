package com.techgeeknext.entities.people;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "people")
@Data
public class People {

  @Id
  public String cid;
  public String title;
  public String firstname;
  public String lastname;
  public String middle_name;
  public String mobile;
  public String gender;
  public String birth_date;
  public String is_deleted;
  public String created_by;
  public String created_date;
  public String update_date;
  public String update_by;

}
