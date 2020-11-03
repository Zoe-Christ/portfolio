package repository;

import model.Einkauf;

public class einkaufRepository extends GenericRepository<Einkauf, Long> {

    public einkaufRepository() {
        super(Einkauf.class);
    }
}