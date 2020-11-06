package repository;


import model.Adresse;

public class adresseRepository extends GenericRepository<Adresse, Long> {

    public adresseRepository() {
        super(Adresse.class);
    }

}
