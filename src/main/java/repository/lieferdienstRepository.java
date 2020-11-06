package repository;

import model.Lieferdienst;

public class lieferdienstRepository extends GenericRepository<Lieferdienst, Long> {

    public lieferdienstRepository() {
        super(Lieferdienst.class);
    }
}
