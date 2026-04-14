package com.aptech.entity;
import javax.persistence.*;
@Entity
@Table(name="friend_group")
public class Group {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
 private int id;
 private String name;
 private String description;
 public int getId(){return id;}
 public String getName(){return name;}
 public void setName(String name){this.name=name;}
 public String getDescription(){return description;}
 public void setDescription(String d){this.description=d;}
}
