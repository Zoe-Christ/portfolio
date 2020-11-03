package repository;

import model.qm;

public class qmRepository extends GenericRepository<qm, Long> {

    public qmRepository() {
        super(qm.class);
    }
}
