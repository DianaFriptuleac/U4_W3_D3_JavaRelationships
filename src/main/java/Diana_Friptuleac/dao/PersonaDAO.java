package Diana_Friptuleac.dao;

import Diana_Friptuleac.classi.Persona;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class PersonaDAO {
    private final EntityManager entityManager;

    //l'oggetto
    public PersonaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //Metodo save
    public void save(Persona newPersona) {
        EntityTransaction transaction = entityManager.getTransaction();  //nuova transizione
        transaction.begin();  //faccio partire la transition
        entityManager.persist(newPersona);  //agg. nuovo evento ma non e ancora nel DB.
        transaction.commit();  //chiudo transizione e mando l'elevto al DB
        System.out.println("La persona " + newPersona.getName() + " " + newPersona.getCognome() + " è stata salvata con successo!");
    }
}
