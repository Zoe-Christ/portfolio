package repository;

import model.lager;

public class lagerRepository extends GenericRepository<lager, Long> {

    public lagerRepository() {
        super( lager.class );
    }

}
