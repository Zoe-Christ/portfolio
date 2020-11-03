package repository;

import model.Lager;

public class lagerRepository extends GenericRepository<Lager, Long> {

    public lagerRepository() {
        super(Lager.class);
    }

}
