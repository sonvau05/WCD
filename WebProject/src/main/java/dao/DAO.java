
package dao;
import java.sql.*;
import java.util.*;
import model.*;

public class DAO {
    String url="jdbc:sqlserver://localhost:1433;databaseName=ProductDB;encrypt=false";
    String user="sa";
    String pass="123456";

    Connection getConnection() throws Exception{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url,user,pass);
    }

    public List<Category> getAllCategories(){
        List<Category> list=new ArrayList<>();
        try(Connection c=getConnection()){
            ResultSet rs=c.createStatement().executeQuery("select * from Category");
            while(rs.next()){
                list.add(new Category(rs.getString(1),rs.getString(2),rs.getString(3)));
            }
        }catch(Exception e){}
        return list;
    }

    public List<Product> getProductsByCatId(String id){
        List<Product> list=new ArrayList<>();
        try(Connection c=getConnection()){
            PreparedStatement ps=c.prepareStatement("select * from Product where category_id=?");
            ps.setString(1,id);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                list.add(new Product(rs.getString(1),rs.getString(2),rs.getDouble(3),rs.getString(4),rs.getString(5)));
            }
        }catch(Exception e){}
        return list;
    }

    public void updateProductCategory(String pid,String cid){
        try(Connection c=getConnection()){
            PreparedStatement ps=c.prepareStatement("update Product set category_id=? where id=?");
            ps.setString(1,cid);
            ps.setString(2,pid);
            ps.executeUpdate();
        }catch(Exception e){}
    }
}
