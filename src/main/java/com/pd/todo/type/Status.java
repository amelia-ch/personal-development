package com.pd.todo.type;

public enum Status {
	
	FINISH("FINISH"),
	UNFINISH("UNFINISH");
	
	private String name;

	private Status(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
