package repository;

import model.PLZ;

public class PLZRepository extends GenericRepository<PLZ, Long> {

    public PLZRepository() {
        super( PLZ.class );
    }

}
