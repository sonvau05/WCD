package com.aptech.entity;
import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name="contact")
public class Contact {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
 private int id;
 private String firstName;
 private String lastName;
 private String phoneNumber;
 @ManyToOne
 @JoinColumn(name="group_id")
 private Group group;
 public int getId(){return id;}
 public String getFirstName(){return firstName;}
 public void setFirstName(String s){this.firstName=s;}
 public String getLastName(){return lastName;}
 public void setLastName(String s){this.lastName=s;}
 public String getPhoneNumber(){return phoneNumber;}
 public void setPhoneNumber(String s){this.phoneNumber=s;}
 public Group getGroup(){return group;}
 public void setGroup(Group g){this.group=g;}
}
