package Diana_Friptuleac.dao;

import Diana_Friptuleac.classi.Location;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class LocationDAO {
    private final EntityManager em;


    public LocationDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Location location) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(location);
        transaction.commit();
        System.out.println("La location " + location.getNome_location() + " è statta salvata con successo!");
    }
}
