package tn.enig.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String location;
    
	public hotel(int id, String title, String location) {
		super();
		this.id = id;
		this.title = title;
		this.location = location;
	}
	
	
	public hotel() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "hotel [id=" + id + ", title=" + title + ", location=" + location + "]";
	}

}
