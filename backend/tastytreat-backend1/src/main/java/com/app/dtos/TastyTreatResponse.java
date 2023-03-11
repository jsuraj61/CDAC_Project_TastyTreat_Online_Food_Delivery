package com.app.dtos;

import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
public class TastyTreatResponse {
	public static enum Status {
		SUCCESS, FAIL, ERROR
	}
	
	private Status status;
	private Object data;
	private String message;
	
	// success ctor
	public TastyTreatResponse(Status status, Object data) {
		this.status = status;
		this.data = data;
	}
	
	// error ctor
	public TastyTreatResponse(Status status, String message) {
		this.status = status;
		this.message = message;
	}
	
	// full ctor
	public TastyTreatResponse(Status status, Object data, String message) {
		this.status = status;
		this.data = data;
		this.message = message;
	}

	// getters and setters
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public static ResponseEntity<TastyTreatResponse> success() {
		return ResponseEntity.ok(new TastyTreatResponse(Status.SUCCESS, null));
	}
	
	public static ResponseEntity<TastyTreatResponse> success(Object data) {
		return ResponseEntity.ok(new TastyTreatResponse(Status.SUCCESS, data));
	}
	
	public static ResponseEntity<TastyTreatResponse> success(String message, Object data) {
		return ResponseEntity.ok(new TastyTreatResponse(Status.SUCCESS, data, message));
	}
	
	public static ResponseEntity<TastyTreatResponse> fail(Object data) {
		return ResponseEntity.ok(new TastyTreatResponse(Status.FAIL, data));
	}

	public static ResponseEntity<TastyTreatResponse> fail(String message, Object data) {
		return ResponseEntity.ok(new TastyTreatResponse(Status.FAIL, data, message));
	}
	
	public static ResponseEntity<TastyTreatResponse> error(String message) {
		return ResponseEntity.ok(new TastyTreatResponse(Status.ERROR, message));
	}

	public static ResponseEntity<TastyTreatResponse> error(String message, Object data) {
		return ResponseEntity.ok(new TastyTreatResponse(Status.ERROR, data, message));
	}
	
}
