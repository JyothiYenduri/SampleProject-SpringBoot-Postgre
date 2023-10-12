package com.talentstream.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

//@Entity
@Getter
@Setter
@Embeddable

public class XClassDetails {
	  private String xschoolName;
	    private String xboard;
	    private String xpercentage;
	    private String xyearOfPassing;
	    private String xCity;
	    private String xState;
	    private String xPincode;
	    

}
