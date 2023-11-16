package com.cgpm.api.base;

import org.springframework.stereotype.Component;

/**
 * @author michel.pech
 */

@Component
public abstract class BaseDTO<ID> {
	
	private ID id;		

	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
	}			
	
}
