package com.example.demo.Model;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.demo.Validate.GameValidar;

public class TsscConsulta {

	@NotNull(message = "Ingresa una fecha",  groups=GameValidar.class)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate scheduledDate;
}
