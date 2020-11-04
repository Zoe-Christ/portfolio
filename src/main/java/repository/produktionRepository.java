package repository;

import model.Produktion;

public class produktionRepository extends GenericRepository<Produktion, Long> {

    public produktionRepository() {
        super( Produktion.class );
    }

}