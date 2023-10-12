package com.talentstream.entity;
import javax.persistence.Embeddable;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Embeddable
@Getter
@Setter
public class GraduationDetails {
	private String gcollegeName;  
	 private String gboard;        
	 private String gprogram;      
	 private String gpercentage;   
	 private String gyearOfPassing;
	 private String gCity;        
	 private String gState;

}
