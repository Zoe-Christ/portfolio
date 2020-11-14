package repository;

import model.Abteilung;

public class abteilungRepository extends GenericRepository<Abteilung, Long> {

    public abteilungRepository() {
        super(Abteilung.class);
    }

}
