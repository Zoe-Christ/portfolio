package repository;

import model.Vertrag;

public class vertragRepository extends GenericRepository<Vertrag, Long> {

    public vertragRepository() {
        super(Vertrag.class);
    }
}
