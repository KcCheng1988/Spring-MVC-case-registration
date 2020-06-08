package com.system.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.system.model.Case;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
	
	@Value("#{officerOptions}")
	private Map<String, String> officerOptions;
	
	@RequestMapping("/form")
	public String showForm(Model theModel) {
		
		Case theCase = new Case();
		
		theModel.addAttribute("newCase", theCase);
		
		// add the officer options to the model
		theModel.addAttribute("theOfficerOptions", officerOptions);
		
		return "registration-form";
	}
	
	@RequestMapping("/confirm")
	public String confirmRegistration(@Valid @ModelAttribute("newCase") Case theCase, 
			BindingResult theBindingResult, Model theModel) {
		
		if (theBindingResult.hasErrors()) {
			return "registration-form";
		}
		else {
			// set the registration date as the current time
			Calendar c1 = Calendar.getInstance();
			theCase.setRegistrationDate(c1);
			
			// compute and set the TAT date
			Calendar c2 = (Calendar) c1.clone();
			c2.add(Calendar.DATE, Integer.parseInt(theCase.getTat()));
			theCase.setTatDate(c2);
			
			// set the date output format
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			
			// set the output string for registration and TAT date
			String regDateOutput = sdf.format(theCase.getRegistrationDate().getTime());
			String tatDateOutput = sdf.format(theCase.getTatDate().getTime());

			// adding the output string to the model
			theModel.addAttribute("regDate", regDateOutput);
			theModel.addAttribute("tatDate", tatDateOutput);
			
			return "confirmation-page";
		}
		
	}
	
	// InitBinder: pre-process all web requests coming into our controller
	// The entire method pre-processes every String form data,
	// remove leading and trailing white space
	// If String only has white space, trim it to null
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		// Editor available in Spring API to remove leading and trailing whitespace
		// true passed as argument: means trim to null if only whitespace is passed in
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
}
