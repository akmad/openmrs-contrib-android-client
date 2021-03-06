/*
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */

package org.openmrs.mobile.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ForeignKey;
import com.raizlabs.android.dbflow.annotation.Table;

import org.openmrs.mobile.data.db.AppDatabase;

@Table(database = AppDatabase.class)
public class PatientIdentifier extends BaseOpenmrsEntity {
	@SerializedName("identifierType")
	@Expose
	@ForeignKey
	private PatientIdentifierType identifierType;

	@SerializedName("identifier")
	@Expose
	@Column
	private String identifier;

	@SerializedName("location")
	@Expose
	@ForeignKey(stubbedRelationship = true)
	private Location location;

	@ForeignKey(stubbedRelationship = true)
	private Patient patient;

	/**
	 * @return The identifierType
	 */
	public PatientIdentifierType getIdentifierType() {
		return identifierType;
	}

	/**
	 * @param identifierType The identifierType
	 */
	public void setIdentifierType(PatientIdentifierType identifierType) {
		this.identifierType = identifierType;
	}

	/**
	 * @return The identifier
	 */
	public String getIdentifier() {
		return identifier;
	}

	/**
	 * @param identifier The identifier
	 */
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	/**
	 * @return The location
	 */
	public Location getLocation() {
		return location;
	}

	/**
	 * @param location The location
	 */
	public void setLocation(Location location) {
		this.location = location;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
}
