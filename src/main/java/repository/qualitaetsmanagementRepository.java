package repository;

import model.Qualitaetsmanagement;

public class qualitaetsmanagementRepository extends GenericRepository<Qualitaetsmanagement, Long> {

    public qualitaetsmanagementRepository() {
        super(Qualitaetsmanagement.class);
    }
}
