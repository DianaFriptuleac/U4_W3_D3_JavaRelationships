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

        try {
            System.out.println("----------------Java Relationships ----------------------------");

            // Creazione dei DAO
            EventoDAO eventDB = new EventoDAO(em);
            LocationDAO locationDAO = new LocationDAO(em);
            PersonaDAO personaDB = new PersonaDAO(em);
            PartecipazioneDAO partecipazioneDAO = new PartecipazioneDAO(em);

            // Salvo le location
            Location l1 = new Location("Parco Nazionale", "Roma");
            Location l2 = new Location("Parco del fiume", "Roma");
            Location l3 = new Location("Alpi Struttura", "Torino");

         /*  locationDAO.save(l1);
            locationDAO.save(l2);
            locationDAO.save(l3);*/

            // Salvo gli eventi
            Evento evento1 = new Evento("Panda", LocalDate.of(2024, 12, 10), "Salviamo i Panda!", EventoType.PUBBLICO, 200, l1);
            Evento evento2 = new Evento("Foreste", LocalDate.of(2024, 11, 15), "Proteggiamo le foreste", EventoType.PUBBLICO, 300, l2);
            Evento evento3 = new Evento("Mare", LocalDate.of(2025, 1, 20), "Ripuliamo il mare", EventoType.PUBBLICO, 150, l1);
            Evento evento4 = new Evento("Animali", LocalDate.of(2024, 10, 25), "Difendiamo gli animali selvatici", EventoType.PRIVATO, 100, l3);
            Evento evento5 = new Evento("Città", LocalDate.of(2024, 9, 30), "Verde in città", EventoType.PUBBLICO, 250, l1);
            Evento evento6 = new Evento("Montagna", LocalDate.of(2024, 12, 5), "Salviamo la montagna", EventoType.PRIVATO, 80, l3);

         /*   eventDB.save(evento1);
            eventDB.save(evento2);
            eventDB.save(evento3);
            eventDB.save(evento4);
            eventDB.save(evento5);
            eventDB.save(evento6);*/

            // Salvo le persone
            Persona pers1 = new Persona("Mario", "Rossi", "mario.rossi@gmail.com", LocalDate.of(1990, 5, 10), SessoPersona.M);
            Persona pers2 = new Persona("Anna", "Verdi", "anna.verdi@gmail.com", LocalDate.of(1985, 7, 23), SessoPersona.F);
            Persona pers3 = new Persona("Luca", "Bianchi", "luca.bianchi@gmail.com", LocalDate.of(1995, 12, 5), SessoPersona.M);

            personaDB.save(pers1);
            personaDB.save(pers2);
            personaDB.save(pers3);

            // Salvo le partecipazioni
            Partecipazioni p1 = new Partecipazioni(StatoPartecipazione.CONFERMATA, pers1, evento1);
            Partecipazioni p2 = new Partecipazioni(StatoPartecipazione.DA_CONFERMARE, pers2, evento2);
            Partecipazioni p3 = new Partecipazioni(StatoPartecipazione.CONFERMATA, pers3, evento3);

            partecipazioneDAO.save(p1);
            partecipazioneDAO.save(p2);
            partecipazioneDAO.save(p3);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}
