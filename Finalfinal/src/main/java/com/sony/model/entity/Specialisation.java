package com.sony.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "specialisation")
public class Specialisation {
	
		
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO, generator = "specialisation_sequence")
	    @SequenceGenerator(name = "specialisation_sequence", sequenceName = "SPECIALISATION_ID_SEQ")
		@Column(name = "specialisation_id") 
		private int specialisationId;
		
		@Column(name = "specialisation_name")
		private String specialisationName;

		public int getSpecialisationId() {
			return specialisationId;
		}

		public void setSpecialisationId(int specialisationId) {
			this.specialisationId = specialisationId;
		}

		public String getSpecialisationName() {
			return specialisationName;
		}

		public void setSpecialisationName(String specialisationName) {
			this.specialisationName = specialisationName;
		}

		

	}


