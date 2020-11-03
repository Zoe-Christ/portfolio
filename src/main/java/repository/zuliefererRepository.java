package repository;

import model.Zulieferer;

public class zuliefererRepository extends GenericRepository<Zulieferer, Long> {

    public zuliefererRepository() {
        super(Zulieferer.class);
    }

}