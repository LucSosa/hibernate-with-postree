package br.com.sosa;

import br.com.sosa.dao.GenericDao;
import br.com.sosa.model.PersonUser;
import br.com.sosa.model.PhoneUser;
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
    public void testQueryList() {
        GenericDao<PersonUser> dao = new GenericDao<PersonUser>();
        List<PersonUser> list = dao.getEntityManager().createQuery("FROM PersonUser WHERE firstName = 'Lucas'").getResultList();

        for (PersonUser personUser : list) {
            System.out.println(personUser);
        }
    }

    @Test
    public void testQueryListMaxResult() {
        GenericDao<PersonUser> dao = new GenericDao<PersonUser>();
        List<PersonUser> list = dao.getEntityManager()
                .createQuery("FROM PersonUser ORDER BY firstName")
                .setMaxResults(4)
                .getResultList();

        for (PersonUser personUser : list) {
            System.out.println(personUser);
        }
    }

    @Test
    public void testQueryListParameter() {
        GenericDao<PersonUser> dao = new GenericDao<PersonUser>();
        List<PersonUser> list = dao.getEntityManager()
                .createQuery("FROM PersonUser WHERE firstName = :name")
                .setParameter("name", "Lucas")
                .getResultList();

        for (PersonUser personUser : list) {
            System.out.println(personUser);
        }
    }

    @Test
    public void testSumAge(){
        GenericDao<PersonUser> dao = new GenericDao<PersonUser>();

        Long sumAge = (Long) dao.getEntityManager()
                .createQuery("SELECT SUM(u.age) FROM PersonUser u")
                .getSingleResult();

        System.out.println("Soma de todas as idades é " + sumAge);
    }

    @Test
    public void testNamedQuery(){
        GenericDao<PersonUser> dao = new GenericDao<PersonUser>();
        List<PersonUser> list = dao.getEntityManager().createNamedQuery("PersonUser.queryAll").getResultList();

        for (PersonUser personUser : list) {
            System.out.println(personUser);
            System.out.println("------------");
        }
    }

    @Test
    public void testNamedQueryByName(){
        GenericDao<PersonUser> dao = new GenericDao<PersonUser>();
        List<PersonUser> list = dao.getEntityManager().createNamedQuery("PersonUser.FindByName")
                .setParameter("name", "Lucas").getResultList();

        for (PersonUser personUser : list) {
            System.out.println(personUser);
            System.out.println("------------");
        }
    }

    @Test
    public void testInsertPhone(){
        GenericDao dao = new GenericDao();
        PersonUser user = new PersonUser();

        user.setId(4L);

        PhoneUser phone = new PhoneUser();
        phone.setTipo("Celular");
        phone.setNumero("665544332");
        phone.setPersonUser(user);

        dao.save(phone);
    }

    @Test
    public void testFindPhones(){
        GenericDao dao = new GenericDao();
        PersonUser user = new PersonUser();

        user.setId(4L);

        for (PhoneUser fone : user.getPhoneUsers()){
            System.out.println(fone.getNumero());
            System.out.println(fone.getTipo());
            System.out.println(fone.getPersonUser().getFirstName());
            System.out.println("-----------------------");
        }
    }
}