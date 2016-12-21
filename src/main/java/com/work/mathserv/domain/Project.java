package com.work.mathserv.domain;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "APP_PROJECT")
public class Project implements Serializable {

	private static final long serialVersionUID = 96285180113476324L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Basic(optional = false)
	@Column(name = "id", nullable = false)
	protected Long id;

	@NotNull(message = "{error.application.name.null}")
	@NotEmpty(message = "{error.application.name.empty}")
	@Size(max = 100, message = "{error.application.name.max}")
	@Column(name = "NAME", length = 100)
	private String name;

	@Size(max = 250, message = "{error.application.desc.max}")
	@Column(name = "DESCRIPTION", length = 250)
	private String description;

	@NotNull(message = "{error.application.status.null}")
	@NotEmpty(message = "{error.application.status.empty}")
	@Size(max = 20, message = "{error.application.status.max}")
	@Column(name = "STATUS", length = 20)
	private String status;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

}
