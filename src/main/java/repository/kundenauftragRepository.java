package repository;

import model.kundenauftrag;

public class kundenauftragRepository extends GenericRepository<kundenauftrag, Long> {

    public kundenauftragRepository() {
        super( kundenauftrag.class );
    }

}