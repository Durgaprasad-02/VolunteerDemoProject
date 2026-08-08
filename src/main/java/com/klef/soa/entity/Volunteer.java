package com.klef.soa.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="volunteer_table")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Volunteer {
	@Id
	@Column(name="vid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long volunteerid;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String type;
	@Column(nullable = false)
    private Boolean status;
	@Column(nullable = false)
    private String location;
	@CreationTimestamp
    private LocalDateTime createdAt;
	@UpdateTimestamp
    private LocalDateTime updatedAt;

    
	

}
