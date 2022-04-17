package com.practice.safetravels.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="travelplans")
public class TravelPlan {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
	
	
    @NotNull
    @Size(min = 1, max = 200, message= "Expense must not be blank")
    private String expense;
    
    
    @NotNull
    @Size(min = 1, max = 40, message= "Vendor must not be blank")
    private String vendor;
    
    
    @NotNull(message= "Amount must be at least 1 cent")
    @Min(value= (long) 0.01)
    private Double amount;
    
    
    @NotNull
    @Size(min = 1, max = 200, message= "Description must not be blank")
    private String description;
    
    
    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    public TravelPlan() {}

	public TravelPlan(@NotNull @Size(min = 1, max = 200, message = "Expense must not be blank") String expense,
			@NotNull @Size(min = 1, max = 40, message = "Vendor must not be blank") String vendor,
			@NotNull(message = "Amount must be at least 1 cent") @Min(0) Double amount,
			@NotNull @Size(min = 1, max = 200, message = "Description must not be blank") String description) {
		super();
		this.expense = expense;
		this.vendor = vendor;
		this.amount = amount;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getExpense() {
		return expense;
	}

	public void setExpense(String expense) {
		this.expense = expense;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
    
	@PrePersist
	protected void onCreate(){
		this.createdAt = new Date();
	}
	
	@PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    
}
