package repository;

import model.mitarbeiter;

public class mitarbeiterRepository extends GenericRepository<mitarbeiter, Long> {

    public mitarbeiterRepository() {
        super(mitarbeiter.class );
    }

}
