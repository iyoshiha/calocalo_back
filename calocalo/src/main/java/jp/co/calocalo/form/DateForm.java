package jp.co.calocalo.form;

import java.io.Serializable;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class DateForm implements Serializable{
	
	private static final long serialVersionUID = 1L;
		
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date date;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
