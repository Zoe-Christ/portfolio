package repository;

import model.Filiale;

public class filialeRepository extends GenericRepository<Filiale, Long> {

    public filialeRepository() {
        super(Filiale.class);
    }
}
