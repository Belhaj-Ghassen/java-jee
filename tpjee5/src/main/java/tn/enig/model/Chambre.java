package tn.enig.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
	public class Chambre {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
	    private String title;
	    private int numberOfBeds;

	    @ManyToOne
	    @JoinColumn(name = "hotel_id")
	    private hotel hotel;

		public Chambre(int id, String title, int numberOfBeds, hotel hotel) {
			super();
			this.id = id;
			this.title = title;
			this.numberOfBeds = numberOfBeds;
			this.hotel = hotel;
		}
		
		
		public Chambre() {
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
		public int getNumberOfBeds() {
			return numberOfBeds;
		}
		public void setNumberOfBeds(int numberOfBeds) {
			this.numberOfBeds = numberOfBeds;
		}
		public hotel getHotel() {
			return hotel;
		}
		public void setHotel(hotel hotel) {
			this.hotel = hotel;
		}
		@Override
		public String toString() {
			return "Chambre [id=" + id + ", title=" + title + ", numberOfBeds=" + numberOfBeds + "]";
		}
	    


}
