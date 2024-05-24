package edu.cjc.springbootrestapicrudapp.app.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class APIError {

	private int statuscode;
	private String message;
	private Date date;
	private String path;
	private HttpStatus httpMessage;
	
}
