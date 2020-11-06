package repository;

import model.Rolle;

public class rolleRepository extends GenericRepository<Rolle, Long> {

    public rolleRepository() {
        super(Rolle.class);
    }
}
