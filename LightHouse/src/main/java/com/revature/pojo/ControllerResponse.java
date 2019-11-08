package com.revature.pojo;

/**
 * This class contains one field, a string used to dictate the response in Angular
 * @author Robert Li
 *
 */
public class ControllerResponse {

	/**
	 * The message that will be passed on to angular
	 */
	private String response;

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((response == null) ? 0 : response.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ControllerResponse other = (ControllerResponse) obj;
		if (response == null) {
			if (other.response != null)
				return false;
		} else if (!response.equals(other.response))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Response [response=" + response + "]";
	}

	public ControllerResponse(String response) {
		super();
		this.response = response;
	}

	public ControllerResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
