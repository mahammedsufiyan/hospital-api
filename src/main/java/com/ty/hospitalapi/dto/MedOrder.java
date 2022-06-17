package com.ty.hospitalapi.dto;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;

@Entity
public class MedOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private double totalAmt;
	private LocalDateTime order_Date_Time;
	@OneToMany(mappedBy = "medOrder")
	
	private List<Item> items;
	@ManyToOne
	@JoinColumn
	private Encounter encounters;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getTotalAmt() {
		return totalAmt;
	}
	public void setTotalAmt(double totalAmt) {
		this.totalAmt = totalAmt;
	}
	public LocalDateTime getOrder_Date_Time() {
		return order_Date_Time;
	}
	public void setOrder_Date_Time(LocalDateTime order_Date_Time) {
		this.order_Date_Time = order_Date_Time;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	public Encounter getEncounter() {
		return encounters;
	}
	public void setEncounter(Encounter encounter) {
		this.encounters = encounter;
	}
	
	
}
