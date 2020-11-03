package repository;

import model.Mitarbeiter;

public class mitarbeiterRepository extends GenericRepository<Mitarbeiter, Long> {

    public mitarbeiterRepository() {
        super(Mitarbeiter.class);
    }

}
