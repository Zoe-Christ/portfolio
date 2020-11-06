package repository;

import model.Maschine;

public class maschineRepository extends GenericRepository<Maschine, Long> {

    public maschineRepository() {  super (Maschine.class);    }

}
