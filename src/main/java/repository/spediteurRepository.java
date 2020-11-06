package repository;

import model.Spediteur;

public class spediteurRepository extends GenericRepository<Spediteur, Long> {

    public spediteurRepository() {
        super(Spediteur.class);
    }
}
