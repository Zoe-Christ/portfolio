package repository;


import model.Produkt;

public class produktRepository extends GenericRepository<Produkt, Long> {

    public produktRepository() {
        super(Produkt.class);
    }

}
