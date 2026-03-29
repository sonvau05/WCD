
package util;
import jakarta.persistence.*;
public class JPAUtil {
private static final EntityManagerFactory emf =
Persistence.createEntityManagerFactory("myPU");
public static EntityManagerFactory get(){return emf;}
}
