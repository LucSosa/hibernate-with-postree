package br.com.sosa;

import static org.junit.Assert.assertTrue;

import br.com.sosa.dao.GenericDao;
import br.com.sosa.model.PersonUser;
import org.junit.Test;

import java.util.List;

/**
 * Unit test for simple App.
 */
public class testeHibernateUtil {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void insertUser() {
        GenericDao<PersonUser> dao = new GenericDao<PersonUser>();
        PersonUser user = new PersonUser();

        user.setFirstName("Miyamoto ");
        user.setLastName("Musashi ");
        user.setEmail("miyamoto.musashi@musachi.com.br");
        user.setPassword("123");
        user.setLogin("musashi");
        user.setAge(26);

        dao.save(user);
    }

    @Test
    public void testSearch() {
        GenericDao<PersonUser> dao = new GenericDao<PersonUser>();
        PersonUser user = new PersonUser();

        user.setId(2L);
        user = dao.search(user);
        System.out.println(user);
    }

    @Test
    public void testUpdate() {
        GenericDao<PersonUser> dao = new GenericDao<PersonUser>();
        PersonUser user = new PersonUser();

        user.setId(2L);
        user = dao.search(user);

        user.setAge(99);
        user.setFirstName("Gutts");

        dao.updateMerge(user);
    }

    @Test
    public void testDelete() {
        GenericDao<PersonUser> dao = new GenericDao<PersonUser>();
        PersonUser user = new PersonUser();

        user.setId(2L);
        user = dao.search(user);

        dao.deleteById(user);
    }

    @Test
    public void testSearchAllUsers() {
        GenericDao<PersonUser> dao = new GenericDao<PersonUser>();
        List<PersonUser> list = dao.searchAllUsers(PersonUser.class);

        for (PersonUser peopleList : list) {
            System.out.println(peopleList);
            System.out.println("-----------");
        }

    }

    @Test
    public void testQueryList(){
        GenericDao<PersonUser> dao = new GenericDao<PersonUser>();
        List<PersonUser> list = dao.getEntityManager().createQuery("FROM PersonUser WHERE firstName = 'Lucas'").getResultList();

        for (PersonUser personUser : list) {
            System.out.println(personUser);
        }


    }
}
