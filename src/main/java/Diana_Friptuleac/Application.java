package Diana_Friptuleac;

import Diana_Friptuleac.classi.*;
import Diana_Friptuleac.dao.EventoDAO;
import Diana_Friptuleac.dao.LocationDAO;
import Diana_Friptuleac.dao.PartecipazioneDAO;
import Diana_Friptuleac.dao.PersonaDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4w3d3");

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();


        System.out.println("----------------Java Relationships ----------------------------");

        EventoDAO eventDB = new EventoDAO(em);


        // Creiamo un oggetto Location fittizio (o da database)
        Location location1 = new Location("Parco Nazionale", "Italia");
        Location location2 = new Location("Foresta Amazzonica", "Brasile");

        //-------------------------------Save evento-------------------------------------------------------
        Evento evento1 = new Evento("Panda", LocalDate.of(2024, 12, 10),
                "Salviamo i Panda!", EventoType.PUBBLICO, 200, location1);

        Evento evento2 = new Evento("Foreste", LocalDate.of(2024, 11, 15),
                "Proteggiamo le foreste", EventoType.PUBBLICO, 300, location2);

        Evento evento3 = new Evento("Mare", LocalDate.of(2025, 1, 20),
                "Ripuliamo il mare", EventoType.PUBBLICO, 150, location1);

        Evento evento4 = new Evento("Animali", LocalDate.of(2024, 10, 25),
                "Difendiamo gli animali selvatici", EventoType.PRIVATO, 100, location2);

        Evento evento5 = new Evento("Città", LocalDate.of(2024, 9, 30),
                "Verde in città", EventoType.PUBBLICO, 250, location1);

        Evento evento6 = new Evento("Montagna", LocalDate.of(2024, 12, 5),
                "Salviamo la montagna", EventoType.PRIVATO, 80, location2);

      /*  eventDB.save(evento1);
        eventDB.save(evento2);
        eventDB.save(evento3);
        eventDB.save(evento4);
        eventDB.save(evento5);
        eventDB.save(evento6); */

        //-------------------------------Save persona-------------------------------------------------------
        PersonaDAO personaDB = new PersonaDAO(em);
        
        Persona pers1 = new Persona("Mario", "Rossi", "mario.rossi@gmail.com", LocalDate.of(1990, 5, 10), SessoPersona.M);
        Persona pers2 = new Persona("Anna", "Verdi", "anna.verdi@gmail.com", LocalDate.of(1985, 7, 23), SessoPersona.F);
        Persona pers3 = new Persona("Luca", "Bianchi", "luca.bianchi@gmail.com", LocalDate.of(1995, 12, 5), SessoPersona.M);


       /* personaDB.save(pers1);
        personaDB.save(pers2);
        personaDB.save(pers3); */

        //-------------------------------Save location-------------------------------------------------------

        LocationDAO locationDAO = new LocationDAO(em);
        Location l1 = new Location("Parco Nazionale", "Roma");
        Location l2 = new Location("Parco del fiume", "Roma");
        Location l3 = new Location("Alpi Struttura", "Torino");

      /*  locationDAO.save(l1);
        locationDAO.save(l2);
        locationDAO.save(l3); */

        //-------------------------------Save parrtecipazione-------------------------------------------------------
        PartecipazioneDAO partecipazioneDAO = new PartecipazioneDAO(em);

        Partecipazioni p1 = new Partecipazioni(StatoPartecipazione.CONFERMATA, pers1, evento1);
        Partecipazioni p2 = new Partecipazioni(StatoPartecipazione.DA_CONFERMARE, pers2, evento2);
        Partecipazioni p3 = new Partecipazioni(StatoPartecipazione.CONFERMATA, pers3, evento3);

        partecipazioneDAO.save(p1);
        partecipazioneDAO.save(p2);
        partecipazioneDAO.save(p3);
        em.close();
        emf.close();
    }
}
