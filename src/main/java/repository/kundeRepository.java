package repository;

import model.Kunde;


public class kundeRepository extends GenericRepository<Kunde, Long> {

    public kundeRepository() {
        super(Kunde.class);
    }
}
