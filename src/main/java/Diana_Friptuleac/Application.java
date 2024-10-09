package Diana_Friptuleac;

import Diana_Friptuleac.classi.Evento;
import Diana_Friptuleac.classi.EventoType;
import Diana_Friptuleac.classi.Location;
import Diana_Friptuleac.dao.EventoDAO;
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

        //-------------------------------Save-------------------------------------------------------
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

        em.close();
        emf.close();
    }
}
