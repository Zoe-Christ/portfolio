package repository;

import model.Qualitaetsmanagement;

public class qmRepository extends GenericRepository<Qualitaetsmanagement, Long> {

    public qmRepository() {
        super(Qualitaetsmanagement.class);
    }
}
