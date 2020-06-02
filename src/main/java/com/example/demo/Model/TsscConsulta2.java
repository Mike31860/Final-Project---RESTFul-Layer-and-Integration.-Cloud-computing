package com.example.demo.Model;

import java.util.List;

import javax.validation.constraints.NotBlank;

public class TsscConsulta2 {

	@NotBlank
	private String scheduledDate;
	private long total;
	private TsscTopic temaEncontrado;

	public TsscConsulta2() {
		super();
	}
	public TsscConsulta2(String scheduledDate, long total, TsscTopic temaEncontrado) {
	
		this.scheduledDate = scheduledDate;
		this.total = total;
		this.temaEncontrado = temaEncontrado;
	}
	public TsscConsulta2(long total, TsscTopic temaEncontrado) {
		this.total = total;
		this.temaEncontrado = temaEncontrado;
	}
	public String getScheduledDate() {
		return scheduledDate;
	}
	public void setScheduledDate(String scheduledDate) {
		this.scheduledDate = scheduledDate;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public TsscTopic getTemas() {
		return temaEncontrado;
	}
	public void setTemas(TsscTopic temaEncontrado) {
		this.temaEncontrado = temaEncontrado;
	}
	
	
	
	
}
