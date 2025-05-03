package com.soft.DTO;

import java.time.LocalDateTime;

public class ErrorResponse {

	private int status;
	private String message;
	private LocalDateTime timestmp;
	public ErrorResponse(int status, String message, LocalDateTime timestmp) {
		super();
		this.status = status;
		this.message = message;
		this.timestmp = timestmp;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDateTime getTimestmp() {
		return timestmp;
	}
	public void setTimestmp(LocalDateTime timestmp) {
		this.timestmp = timestmp;
	}
	
	
	
	
	
}
