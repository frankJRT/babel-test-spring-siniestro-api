package com.test.babel.siniestro.dto;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse {

	private String message;
	private Boolean success;
	private HttpStatus status;

	/*
	 * public ApiResponse() {
	 * 
	 * }
	 * 
	 * public String getMessage() { return message; }
	 * 
	 * public void setMessage(String message) { this.message = message; }
	 * 
	 * public Boolean getSuccess() { return success; }
	 * 
	 * public void setSuccess(Boolean success) { this.success = success; }
	 * 
	 * public HttpStatus getStatus() { return status; }
	 * 
	 * public void setStatus(HttpStatus status) { this.status = status; }
	 * 
	 * public static class Builder {
	 * 
	 * private ApiResponse apiResponse;
	 * 
	 * public Builder() { apiResponse = new ApiResponse(); }
	 * 
	 * public Builder message(String msg) { apiResponse.message = msg; return this;
	 * }
	 * 
	 * public Builder success(Boolean scc) { apiResponse.success = scc; return this;
	 * }
	 * 
	 * public Builder status(HttpStatus stts) { apiResponse.status = stts; return
	 * this; }
	 * 
	 * public ApiResponse build() { return apiResponse; }
	 * 
	 * }
	 * 
	 * public Object builder() { // TODO Auto-generated method stub return null; }
	 */
}
