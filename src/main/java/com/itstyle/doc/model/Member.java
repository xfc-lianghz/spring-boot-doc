package com.itstyle.doc.model;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data                
@NoArgsConstructor     
@AllArgsConstructor
@Entity
@Table(name = "md_members" )
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "member_id", nullable = false)
	private Integer memberId;
	@Column(nullable = false)
    private String account;
	@Column(nullable = false)
    private String password;
	@Column(nullable = false)
    private String authMethod;
	@Column(nullable = true)
    private String description;
	
	@Column(nullable = false)
    private String email;
	@Column(nullable = false)
    private String phone;
	@Column(nullable = true)
    private String avatar;
	@Column(nullable = false)
    private Integer role;
	
	@Column(nullable = false)
    private Integer status;
	@Column(nullable = false)
    private Timestamp createTime;
	@Column(nullable = false)
    private Integer create_at;
	@Column(nullable = true)
    private Timestamp lastLoginTime;
}
