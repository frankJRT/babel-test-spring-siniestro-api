package com.test.babel.siniestro.exceptions;

public class ResourceNotFoundException  extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3213751455127147011L;

	public ResourceNotFoundException() {
		super("Recurso no encontrado");
	}
	
	public ResourceNotFoundException(String message) {
		super(message);
	}
}
