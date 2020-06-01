package com.example.demo.Model;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.demo.Validate.GameValidar;

public class TsscConsulta {

	
	@NotBlank
	private String scheduledDate;
	
	public TsscConsulta() {
		
	}


	public TsscConsulta(String scheduledDate) {
		super();
		this.scheduledDate = scheduledDate;
	}

	public String getScheduledDate() {
		return scheduledDate;
	}

	public void setScheduledDate(String scheduledDate) {
		this.scheduledDate = scheduledDate;
	}
	
	
	
	
	
}
