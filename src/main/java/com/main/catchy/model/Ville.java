package com.main.catchy.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Table(name="Ville")@Inheritance(strategy=InheritanceType.JOINED)@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class,property="@villeID")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ville implements Serializable {
	private static final long serialVersionUID = -6123703288245602356L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "villeID")
	private long villeID;

	@Column(name = "name")
	private String name;

	@ManyToOne
	@JoinColumn(name = "regionID")
	private Region villeRegion;

	@OneToMany(mappedBy = "villeContact")
	private List<Contact> contact;

}
