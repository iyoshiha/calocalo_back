package jp.co.calocalo.form;

import java.io.Serializable;

public class DeleteEmpForm implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int empId;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}
	
	
	
}
