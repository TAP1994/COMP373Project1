package com.fms.model.facility;
import java.util.ArrayList;
import com.fms.model.maintenance.*;
import com.fms.model.users.*;

public class Building {
	
	private String BuildingID;
	private Address address;
	private ArrayList<Issues> issues;
	private ArrayList<Room> rooms = new ArrayList<Room>();
	//every building is a box
	public Building(String BID, int floors, int rooms, Address a){
		BuildingID = BID;
		address = a;
		for (int i = 1; i <=floors; i++){
			for (int x = 0; x<rooms; x++){
				Room temp = new Room();
				int roomno = (i*100) + x;
				temp.setRoomNo(roomno);
				temp.setRoomID(BID + roomno);
				this.rooms.add(temp);
			}
		}
	}
	public Building(){}
	
	public String getBuildingID() {
		return BuildingID;
	}
	public void setBuildingID(String id) {
		BuildingID = id;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public int getIssueCount() {
		return issues.size();
	}
	public ArrayList<Issues> getIssues(){
		return issues;
	}
	public void addIssue(Issues i) {
		issues.add(i);
	}
	public ArrayList<Room> getRooms(){
		return rooms;
	}
	public String toString(){
		String s = ("Building " + BuildingID + " at " + address.toString()); 
		s = s + ("\nRooms:");
		for (Room r: rooms){
			s = s + (r.toString());
		}
		return s;
	}
	public void setRooms(String BID,int floors, int rooms){
		for (int i = 1; i <=floors; i++){
			for (int x = 0; x<rooms; x++){
				Room temp = new Room();
				int roomno = (i*100) + x;
				temp.setRoomNo(roomno);
				temp.setRoomID(BID + roomno);
				this.rooms.add(temp);
			}
		}
	}
	public Room getRoom(int i) {
		for(Room r: rooms){
			if (r.getRoomNo() == i)
				return r;
		} System.out.println("NO MATCH");
		return rooms.get(0);
	}
	public void addTenantToRoom(Tenants t, int roomNo){
		for (Room r: rooms){
			if (r.getRoomNo() == roomNo){
				r.addTenant(t);
			}
		}
	}
}
