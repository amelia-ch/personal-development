package com.pd.todo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.pd.todo.type.Status;

import lombok.Data;

@Data
@Entity
@Table(name= "trx_todo")
public class TodoEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name = "created_at")
	private Date createdAt;
	
	@Column(name = "finish_at")
	private Date finishAt;
	
	@Column(name = "user_id")
	private Long userId;
	
	@Column(name = "task")
	private String task;
	
	@Column(name = "percentage")
	private Double percentage;
	
	@Column(name = "status")
	private Status status;
	
}
