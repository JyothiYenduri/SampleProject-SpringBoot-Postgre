package com.talentstream.entity;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;
@Embeddable
//@Entity
@Getter
@Setter
public class ExperienceDetails {
	 private String company;
	    private String position;
	    private String startDate;
	    private String endDate;
}
