package repository;

import model.Plz;

public class PlzRepository extends GenericRepository<Plz, Long> {
    public PlzRepository() {
        super(Plz.class);
    }

}
