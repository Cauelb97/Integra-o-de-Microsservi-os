package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity //para dizer que vai ser monitorada pelo JPA
@Table(name = "tb_worker")
public class Worker implements Serializable{

	static final long serialVersionUID = 1L;
	
	@Id //diz que esse Id é a chave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY)  //Para que o id seja gerado auto pelo banco de dados
	private Long id;
	private String name;
	private Double dailyIncome;
	
	public Worker() {
	}
	
	public Worker(Long id, String name, Double dailyIncome) {
		super();
		this.id = id;
		this.name = name;
		this.dailyIncome = dailyIncome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getDailyIncome() {
		return dailyIncome;
	}

	public void setDailyIncome(Double dailyIncome) {
		this.dailyIncome = dailyIncome;
	}

}
