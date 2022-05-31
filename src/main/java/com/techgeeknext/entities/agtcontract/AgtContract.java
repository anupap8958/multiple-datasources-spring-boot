package com.techgeeknext.entities.agtcontract;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "AGT_CONTRACT")
@Data
public class AgtContract {

  @Id
  public int contractId;
  public String contractNo;
  public Date contractDate;
  public int bookingCode;
  public int agentId;
  public int areaId;
  public int servicePointId;
  public int applicationId;
  public String applicationNo;
  public String contractStatus;
  public String activeFlag;
  public String createdBy;
  public Date createdDate;
  public String updatedBy;
  public Date updatedDate;
  public String docStatus;
  public String packStatus;
  public int editNo;

}
