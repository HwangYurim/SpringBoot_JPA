package com.jpa.sample.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Entity(name="users")
@Getter @Setter
public class User {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "���� ID", dataType = "long", position=0)
	private Long id;
	
	@ApiModelProperty(value = "������", dataType = "String", position=10)
	private String name;
	
	@ApiModelProperty(value = "�ּ�", dataType = "String", position=20)
	private String addr;
	
}
