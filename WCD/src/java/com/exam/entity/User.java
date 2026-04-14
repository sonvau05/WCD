
package com.exam.entity;
import javax.persistence.*;

@Entity
@Table(name="users")
public class User {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
 private int id;
 private String username;
 private String email;
 private String password;

 public User(){}
 public User(String u,String e,String p){username=u;email=e;password=p;}

 public int getId(){return id;}
 public String getUsername(){return username;}
 public void setUsername(String u){username=u;}
 public String getEmail(){return email;}
 public void setEmail(String e){email=e;}
 public String getPassword(){return password;}
 public void setPassword(String p){password=p;}
}
