package edu.bnu.hmss.entity;
// Generated Oct 3, 2014 4:33:30 AM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Floor generated by hbm2java
 */
@Entity
@Table(name = "floor", catalog = "hoteldb")
public class Floor implements java.io.Serializable {

	private Integer floorId;
	private Hotel hotel;
	private Integer floorNumber;
	private Set<Room> rooms = new HashSet<Room>(0);

	public Floor() {
	}

	public Floor(Hotel hotel) {
		this.hotel = hotel;
	}

	public Floor(Hotel hotel, Integer floorNumber, Set<Room> rooms) {
		this.hotel = hotel;
		this.floorNumber = floorNumber;
		this.rooms = rooms;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "FloorId", unique = true, nullable = false)
	public Integer getFloorId() {
		return this.floorId;
	}

	public void setFloorId(Integer floorId) {
		this.floorId = floorId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Hotel_HotelId", nullable = false)
	public Hotel getHotel() {
		return this.hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	@Column(name = "FloorNumber")
	public Integer getFloorNumber() {
		return this.floorNumber;
	}

	public void setFloorNumber(Integer floorNumber) {
		this.floorNumber = floorNumber;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "floor")
	public Set<Room> getRooms() {
		return this.rooms;
	}

	public void setRooms(Set<Room> rooms) {
		this.rooms = rooms;
	}

}
