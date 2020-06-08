package com.system.model;

import java.util.Calendar;
import java.util.LinkedHashMap;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Case {
	
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String firstName;
	
	private String lastName;
	/* private LinkedHashMap<String, String> officerOptions; */
	private String officer;
	private Calendar registrationDate;
	private Calendar tatDate;
//	private String briefFacts;
	private String emailAddress;
	private LinkedHashMap<String, String> TATOptions;
	private String tat;
	private String investigationType;
	private LinkedHashMap<String, String> investigationTypeOptions;
	private String[] exhibit;
	
	@Min(value=1, message = "must be at least 1 person")
	@Max(value=4, message = "must be at most 4 person")
	private int manpower;
	
	public Case() {
		// set up the list for TAT options
		TATOptions =  new LinkedHashMap<String, String>();
		
		TATOptions.put("30", "30");
		TATOptions.put("60", "60");
		TATOptions.put("90", "90");
		TATOptions.put("120", "120");
		
		// set up the list for investigation type options
		investigationTypeOptions = new LinkedHashMap<String, String>();
		
		investigationTypeOptions.put("Traffic Accident Reconstruction",
				"Traffic Accident Reconstruction");
		investigationTypeOptions.put("Crime Scene Reconstruction",
				"Crime Scene Reconstruction");
		investigationTypeOptions.put("Urine Analysis", "Urine Analysis");
		investigationTypeOptions.put("Paint Transfer Analysis", "{Paint Transfer Analysis");
		investigationTypeOptions.put("Chemical Analysis", "Chemical Analysis");
		investigationTypeOptions.put("Physical Fit Analysis", "Physical Fit Analysis");
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/*
	 * public LinkedHashMap<String, String> getOfficerOptions() { return
	 * officerOptions; }
	 * 
	 * public void setOfficerOptions(LinkedHashMap<String, String> officerOptions) {
	 * this.officerOptions = officerOptions; }
	 */

	public String getOfficer() {
		return officer;
	}

	public void setOfficer(String officer) {
		this.officer = officer;
	}

	public void setTATOptions(LinkedHashMap<String, String> tATOptions) {
		TATOptions = tATOptions;
	}

	public Calendar getRegistrationDate() {
		return registrationDate;
	}
	
	public void setRegistrationDate(Calendar registrationDate) {
		this.registrationDate = registrationDate;
	}
	
	/*
	 * public String getBriefFacts() { return briefFacts; }
	 * 
	 * public void setBriefFacts(String briefFacts) { this.briefFacts = briefFacts};
	 */
	
	
	public Calendar getTatDate() {
		return tatDate;
	}

	public void setTatDate(Calendar tatDate) {
		this.tatDate = tatDate;
	}

	public String getEmailAddress() {
		return emailAddress;
	}
	
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	public LinkedHashMap<String, String> getTATOptions() {
		return TATOptions;
	}

	public String getTat() {
		return tat;
	}
	
	public void setTat(String tat) {
		this.tat = tat;
	}

	public String getInvestigationType() {
		return investigationType;
	}

	public void setInvestigationType(String investigationType) {
		this.investigationType = investigationType;
	}

	public LinkedHashMap<String, String> getInvestigationTypeOptions() {
		return investigationTypeOptions;
	}

	public String[] getExhibit() {
		return exhibit;
	}

	public void setExhibit(String[] exhibit) {
		this.exhibit = exhibit;
	}

	public int getManpower() {
		return manpower;
	}

	public void setManpower(int manpower) {
		this.manpower = manpower;
	}
	
	
}
