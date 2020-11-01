package repository;

import model.online_haendler;

public class online_haendlerRepository extends GenericRepository<online_haendler, Long> {

    public online_haendlerRepository() {
        super( online_haendler.class );
    }

}