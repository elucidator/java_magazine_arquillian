package nl.elucidator.java_magazine.arquillian.sample.model;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Class JpaRespository.
 */
@Stateless
public class JpaRepository {

    @PersistenceContext
    private EntityManager entityManager;


    public boolean create(final User user) {
        entityManager.persist(user);
        return user.getId() != null;
    }
}
