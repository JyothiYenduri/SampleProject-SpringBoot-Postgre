package com.talentstream.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Eligibility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
    private List<String> typeOfDegreeList = new ArrayList<>();

    @ElementCollection
    private Set<String> specializationSet = new HashSet<>(); // Use Set to avoid duplicates
    @ElementCollection
    private Set<Integer> yearOfPassedOutSet = new HashSet<>(); // Use Set to avoid duplicates

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<String> getTypeOfDegreeList() {
		return typeOfDegreeList;
	}

	public void setTypeOfDegreeList(List<String> typeOfDegreeList) {
		this.typeOfDegreeList = typeOfDegreeList;
	}

	public Set<String> getSpecializationSet() {
		return specializationSet;
	}

	public void setSpecializationSet(Set<String> specializationSet) {
		this.specializationSet = specializationSet;
	}

	public Set<Integer> getYearOfPassedOutSet() {
		return yearOfPassedOutSet;
	}

	public void setYearOfPassedOutSet(Set<Integer> yearOfPassedOutSet) {
		this.yearOfPassedOutSet = yearOfPassedOutSet;
	}

	public Eligibility(Long id, List<String> typeOfDegreeList, Set<String> specializationSet,
			Set<Integer> yearOfPassedOutSet) {
		super();
		this.id = id;
		this.typeOfDegreeList = typeOfDegreeList;
		this.specializationSet = specializationSet;
		this.yearOfPassedOutSet = yearOfPassedOutSet;
	}

	public Eligibility() {
		super();
	}

    // Constructors, getters, setters, etc.
    
}
