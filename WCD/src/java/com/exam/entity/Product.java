
package com.exam.entity;
import javax.persistence.*;

@Entity
@Table(name="products")
public class Product {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
 private int id;
 private String name;
 private String description;
 private double price;
 private int quantity;

 public Product(){}
 public Product(String n,String d,double p,int q){name=n;description=d;price=p;quantity=q;}

 public int getId(){return id;}
 public String getName(){return name;}
 public void setName(String n){name=n;}
 public String getDescription(){return description;}
 public void setDescription(String d){description=d;}
 public double getPrice(){return price;}
 public void setPrice(double p){price=p;}
 public int getQuantity(){return quantity;}
 public void setQuantity(int q){quantity=q;}
}
