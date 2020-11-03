package repository;

import model.Zahlung;

public class zahlungRepository extends GenericRepository<Zahlung, Long> {

    public zahlungRepository() {
        super(Zahlung.class);
    }

}
