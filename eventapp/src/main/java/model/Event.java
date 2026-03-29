
package model;
import jakarta.persistence.*;
@Entity
public class Event{
@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;
private String name;
private java.sql.Date date;
private String venue;
private int seats_available;
public int getId(){return id;}
public String getName(){return name;}
public void setName(String n){name=n;}
public java.sql.Date getDate(){return date;}
public void setDate(java.sql.Date d){date=d;}
public String getVenue(){return venue;}
public void setVenue(String v){venue=v;}
public int getSeats_available(){return seats_available;}
public void setSeats_available(int s){seats_available=s;}
}
