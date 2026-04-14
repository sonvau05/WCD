package com.aptech.util;
import javax.persistence.*;
public class JPAUtil {
 private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ContactPU");
 public static EntityManager getEM(){return emf.createEntityManager();}
}
