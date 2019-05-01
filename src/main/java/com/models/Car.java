package com.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.NotFound;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table
public class Car {
	
	@Id
	@GeneratedValue
	private int id;
	
	@NotEmpty
	@NotNull
	@Column(name="licence_plate_number")
	private String licencePlateNumber;
	
	@Column(name="model_name")
	private String modelName;
	
	@Column(name="device_id")
	private String deviceId;
	
	@Column(name="group_name")
	private String groupName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLicencePlateNumber() {
		return licencePlateNumber;
	}

	public void setLicencePlateNumber(String licencePlateNumber) {
		this.licencePlateNumber = licencePlateNumber;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public Car(String licencePlateNumber, String modelName, String deviceId, String groupName) {
		super();
		this.licencePlateNumber = licencePlateNumber;
		this.modelName = modelName;
		this.deviceId = deviceId;
		this.groupName = groupName;
	}
	
	public Car() {}
}
