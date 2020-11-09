import connection.ConnectionHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;


@DisplayName("Database connection tests")
public class ConnectionHelperTest {

    @Test
    @DisplayName("Test successfully establishing connection to DB")
    void testConnectionToDB() {
        EntityManager em = (EntityManager) ConnectionHelper.getConnection("portfolio");
        Assertions.assertNotNull(em);
        em.close();
    }
}
