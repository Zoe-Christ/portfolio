package repository;

import model.Lieferung;

public class lieferungRepository extends GenericRepository<Lieferung, Long> {

    public lieferungRepository() {
        super(Lieferung.class);
    }

}
