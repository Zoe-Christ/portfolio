package repository;

import model.zahlung;

public class zahlungRepository extends GenericRepository<zahlung, Long> {

    public zahlungRepository() {
        super( zahlung.class );
    }

}
