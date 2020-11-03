package repository;


import model.Bestellung;

public class bestellungRepository extends GenericRepository<Bestellung, Long> {

    public bestellungRepository() {
        super(Bestellung.class);
    }

}
