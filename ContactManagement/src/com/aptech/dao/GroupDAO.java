package com.aptech.dao;
import com.aptech.entity.*;
import com.aptech.util.JPAUtil;
import javax.persistence.*;
import java.util.*;
public class GroupDAO {
 public List<Group> getAll(){
  EntityManager em=JPAUtil.getEM();
  return em.createQuery("select g from Group g",Group.class).getResultList();
 }
 public void add(Group g){
  EntityManager em=JPAUtil.getEM();
  em.getTransaction().begin();
  em.persist(g);
  em.getTransaction().commit();
 }
}
