package repository;

import model.produktion;

public class produktionRepository extends GenericRepository<produktion, Long> {

    public produktionRepository() {
        super( produktion.class );
    }

}