package com.taketicket.documentos.models.entities;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "permission")
public class Permission {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private UUID code;
	
	@Column(name = "type")
	private String type;
	
	/*
	@OneToMany(mappedBy = "permission", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<UserXPermission>userxpermissions;
    */
	public Permission( String type) {
		super();
		this.type = type;
	}
	
}
