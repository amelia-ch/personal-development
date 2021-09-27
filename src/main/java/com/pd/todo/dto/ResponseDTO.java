package com.pd.todo.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class ResponseDTO<T> implements Serializable {

    private String status;
    private String code;
    private String message;
    private List<T> data;

    public ResponseDTO() {
    }

    public ResponseDTO(String status, String code, String message, List<T> data) {
		super();
		this.status = status;
		this.code = code;
		this.message = message;
		this.data = data;
	}



	public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }


    public ResponseDTO defaultResponse() {
        ResponseDTO response = new ResponseDTO();
        response.setStatus("Success");
        response.setCode("201");
        response.setMessage("Process Successed");
        return response;
    }
    
    public ResponseDTO defaultResponse(Long version) {
        ResponseDTO response = new ResponseDTO();
        response.setStatus("Success");
        response.setCode("201");
        response.setMessage("Process Successed");
        return response;
    }

    public ResponseDTO noDataFoundResponse() {
        ResponseDTO response = new ResponseDTO();
        response.setStatus("Success");
        response.setCode("204");
        response.setMessage("No data Found");
        return response;
    }

    public ResponseDTO failedResponse(String code, String message) {
        ResponseDTO response = new ResponseDTO();
        response.setStatus("Failed");
        response.setCode(code);
        response.setMessage(message);

        return response;
    }
}

