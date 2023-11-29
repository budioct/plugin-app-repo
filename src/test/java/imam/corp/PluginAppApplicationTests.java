package imam.corp;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.random.RandomGenerator;

@SpringBootTest
class PluginAppApplicationTests {

    @Autowired
    EntityManagerFactory entityManagerFactory;

    @Test
    void testConnectJDBC() {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            transaction.commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            transaction.rollback();
        }

        entityManager.close();
        entityManagerFactory.close();

    }

    @Test
    void testbro(){

        System.out.println(RandomGenerator.getDefault().nextLong());

    }

}
