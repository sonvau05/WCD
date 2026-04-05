
package model;
public class Product {
    private String id,name,description,categoryId;
    private double price;
    public Product(){}
    public Product(String id,String name,double price,String description,String categoryId){
        this.id=id;this.name=name;this.price=price;
        this.description=description;this.categoryId=categoryId;
    }
    public String getId(){return id;}
    public String getName(){return name;}
    public double getPrice(){return price;}
    public String getDescription(){return description;}
}
