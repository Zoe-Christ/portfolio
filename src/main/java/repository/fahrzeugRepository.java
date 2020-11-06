package repository;

import model.Fahrzeug;

public class fahrzeugRepository extends GenericRepository<Fahrzeug, Long> {

    public fahrzeugRepository() {
        super(Fahrzeug.class);
    }
}

