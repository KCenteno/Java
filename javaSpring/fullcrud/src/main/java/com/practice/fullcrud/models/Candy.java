package com.practice.fullcrud.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="candys")
public class Candy {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

	@NotNull
    @Size(min = 3, max = 30, message= "Name must be atleast 3 characters long")
	private String name;
	
	@NotNull
    @Size(min = 3, max = 15, message= "Brand must be atleast 3 characters long")
	private String brand;
	
	@NotNull
	@Max(value= 10, message= "no more the 10!")
	@Min(value = 0, message= "At least one right?")
	private Integer rating;
	
	@NotNull()
	@Max(value= 10, message= "no more the 10!")
	@Min(value = 0, message= "At least one right?")
	private Double price;
	
	// This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
	
    
    // Creating the many to one relationship[ with the owner class
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="owner_id")
    private Owner owner;
    
    @PrePersist
	protected void onCreate(){
		this.createdAt = new Date();
	}
	
	@PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

	public Candy() {
		super();
	}
	
	
	public Candy(@NotNull @Size(min = 3, max = 30, message = "Name must be atleast 3 characters long") String name,
			@NotNull @Size(min = 3, max = 15, message = "Brand must be atleast 3 characters long") String brand,
			@NotNull @Max(value = 10, message = "no more the 10!") @Min(value = 0, message = "At least one right?") Integer rating,
			@NotNull @Max(value = 10, message = "no more the 10!") @Min(value = 0, message = "At least one right?") Double price,
			Owner owner) {
		super();
		this.name = name;
		this.brand = brand;
		this.rating = rating;
		this.price = price;
		this.owner = owner;
	}

	public Candy(@NotNull @Size(min = 3, max = 30, message = "Expense must not be blank") String name,
			@NotNull @Size(min = 3, max = 15, message = "Expense must not be blank") String brand,
			@NotNull(message = "Amount must be at least 1 cent") @Max(10) @Min(0) Integer rating,
			@NotNull(message = "Amount must be at least 1 cent") @Max(10) @Min(0) Double price) {
		super();
		this.name = name;
		this.brand = brand;
		this.rating = rating;
		this.price = price;
	}
	
	
	public Candy(Long id, @NotNull @Size(min = 3, max = 30, message = "Expense must not be blank") String name,
			@NotNull @Size(min = 3, max = 15, message = "Expense must not be blank") String brand,
			@NotNull(message = "Amount must be at least 1 cent") @Max(10) @Min(0) Integer rating,
			@NotNull(message = "Amount must be at least 1 cent") @Max(10) @Min(0) Double price, Date createdAt,
			Date updatedAt) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.rating = rating;
		this.price = price;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
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
    
}
