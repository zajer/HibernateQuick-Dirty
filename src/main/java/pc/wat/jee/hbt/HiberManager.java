
package pc.wat.jee.hbt;

import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class HiberManager {
    final private String PU = "pc.wat.jee_HBT_war_1.0-SNAPSHOTPU";
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory(PU);
    //private EntityManager em = Persistence.createEntityManagerFactory(PU).createEntityManager();
    
    public List<DataEntity> getAllWorkers(){
        List<DataEntity> result = new ArrayList<>();
        CriteriaBuilder cb = emf.getCriteriaBuilder();
        CriteriaQuery<DataEntity> cq = cb.createQuery(DataEntity.class);
        Root<DataEntity> rootOfQuery = cq.from(DataEntity.class);
        
        cq.select(rootOfQuery);
        EntityManager em = emf.createEntityManager();
        //em.create ("SELECT w FROM WORKERS").getResultList();
        result.addAll( em.createQuery(cq).getResultList());
        em.close();
        return result;
    }
    
    public void saveEntity(DataEntity toSave){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(toSave);
        em.getTransaction().commit();
        em.close();
    }
}
