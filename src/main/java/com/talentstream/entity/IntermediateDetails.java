package com.talentstream.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Embeddable
@Getter
@Setter
public class IntermediateDetails {
	 private String icollegeName;
	    private String iboard;
	    private String iprogram;
	    private String ipercentage;
	    private String iyearOfPassing;
	    private String iCity;
	    private String iState;
}
