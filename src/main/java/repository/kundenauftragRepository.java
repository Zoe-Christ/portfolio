package repository;

import model.Kundenauftrag;

public class kundenauftragRepository extends GenericRepository<Kundenauftrag, Long> {

    public kundenauftragRepository() {
        super(Kundenauftrag.class);
    }

}