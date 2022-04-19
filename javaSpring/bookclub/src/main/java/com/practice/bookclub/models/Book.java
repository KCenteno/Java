package com.practice.bookclub.models;

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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="books")
public class Book {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	@Size(min=2, message="Title must be more then 2 characters!")
	private String title;
	
	@NotEmpty
	@Size(min=2, message="Author must be more then 2 characters!")
	private String author;
	
	@NotEmpty
	@Size(min=10, message="Thoughts about the book must be at least 10 characters!")
	private String thoughts;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    @PrePersist
	protected void onCreate(){
		this.createdAt = new Date();
	}
	
	@PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

	public Book() {
		super();
	}

	public Book(@NotEmpty @Size(min = 2, message = "Title must be more then 2 characters!") String title,
			@NotEmpty @Size(min = 2, message = "Author must be more then 2 characters!") String author,
			@NotEmpty @Size(min = 10, message = "Thoughts about the book must be at least 10 characters!") String thoughts,
			User user) {
		super();
		this.title = title;
		this.author = author;
		this.thoughts = thoughts;
		this.user = user;
	}

	public Book(Long id, @NotEmpty @Size(min = 2, message = "Title must be more then 2 characters!") String title,
			@NotEmpty @Size(min = 2, message = "Author must be more then 2 characters!") String author,
			@NotEmpty @Size(min = 10, message = "Thoughts about the book must be at least 10 characters!") String thoughts,
			User user, Date createdAt, Date updatedAt) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.thoughts = thoughts;
		this.user = user;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getThoughts() {
		return thoughts;
	}

	public void setThoughts(String thoughts) {
		this.thoughts = thoughts;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
