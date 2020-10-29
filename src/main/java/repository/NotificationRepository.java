package repository;

import dhbw.datenbanken.ormexample.data.model.Notification;


public class NotificationRepository extends GenericRepository<Notification, Long> {

    public NotificationRepository() {
        super( Notification.class );
    }

}
