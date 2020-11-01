package repository;

import model.zulieferer;

public class zuliefererRepository extends GenericRepository<zulieferer, Long> {

    public zuliefererRepository() {
        super( zulieferer.class );
    }

}