
package model;
import jakarta.persistence.*;
@Entity
public class Attendee{
@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;
private String name;
private String email;
@ManyToOne
private Event event;
public int getId(){return id;}
public String getName(){return name;}
public String getEmail(){return email;}
public void setName(String n){name=n;}
public void setEmail(String e){email=e;}
public void setEvent(Event e){event=e;}
}
