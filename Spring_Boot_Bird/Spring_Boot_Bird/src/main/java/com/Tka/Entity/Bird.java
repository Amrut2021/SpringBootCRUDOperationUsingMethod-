package com.Tka.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Bird {
	@Id
	private int id;
	private String name;
	private String color;
	private int weight;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public Bird(int id, String name, String color, int weight) {
		super();
		this.id = id;
		this.name = name;
		this.color = color;
		this.weight = weight;
	}
	public Bird() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Bird [id=" + id + ", name=" + name + ", color=" + color + ", weight=" + weight + "]";
	}
	
	

}
