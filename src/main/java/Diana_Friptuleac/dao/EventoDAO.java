package Diana_Friptuleac.dao;

import Diana_Friptuleac.classi.Evento;
import Diana_Friptuleac.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EventoDAO {
    private final EntityManager entityManager;

    //l'oggetto
    public EventoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //Metodo save
    public void save(Evento newEvento) {
        EntityTransaction transaction = entityManager.getTransaction();  //nuova transizione
        transaction.begin();  //faccio partire la transition
        entityManager.persist(newEvento);  //agg. nuovo evento ma non e ancora nel DB.
        transaction.commit();  //chiudo transizione e mando l'elevto al DB
        System.out.println("L'evento " + newEvento.getTitolo() + " è stato aggiunto con successo!");

    }

    //Metodo getById
    public Evento getById(long eventoId) {
        Evento foundEvento = entityManager.find(Evento.class, eventoId);
        if (foundEvento == null) throw new NotFoundException(eventoId);
        return foundEvento;
    }

    //Metodo delete
    public void delete(long eventoId) {
        Evento foundEvent = this.getById(eventoId);
        EntityTransaction transaction = entityManager.getTransaction();  //nuova transazione creata da Entity Manager
        transaction.begin();
        entityManager.remove(foundEvent);
        transaction.commit();
        System.out.println("L'evento " + foundEvent.getTitolo() + " è stato rimosso con successo!");
    }
}
