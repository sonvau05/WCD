package com.aptech.dao;
import com.aptech.entity.*;
import com.aptech.util.JPAUtil;
import javax.persistence.*;
import java.util.*;
public class ContactDAO {
 public void add(Contact c){
  EntityManager em=JPAUtil.getEM();
  em.getTransaction().begin();
  em.persist(c);
  em.getTransaction().commit();
  em.close();
 }
 public List<Contact> getAll(){
  EntityManager em=JPAUtil.getEM();
  return em.createQuery("select c from Contact c",Contact.class).getResultList();
 }
 public void delete(int id){
  EntityManager em=JPAUtil.getEM();
  em.getTransaction().begin();
  Contact c=em.find(Contact.class,id);
  if(c!=null) em.remove(c);
  em.getTransaction().commit();
 }
}
