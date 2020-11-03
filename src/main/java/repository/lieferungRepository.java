package repository;

import model.lieferung;

public class lieferungRepository extends GenericRepository<lieferung, Long> {

    public lieferungRepository() {
        super(lieferung.class );
    }

}
