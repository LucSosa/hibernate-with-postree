package br.com.sosa;

import static org.junit.Assert.assertTrue;

import br.com.sosa.dao.GenericDao;
import br.com.sosa.model.PersonUser;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class testeHibernateUtil
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        GenericDao<PersonUser> dao = new GenericDao<PersonUser>();
        PersonUser user = new PersonUser();

        user.setFirstName("Lucas");
        user.setLastName("Sosa Machado");
        user.setEmail("lucas.sosa@sosa.com.br");
        user.setPassword("123");
        user.setLogin("lucassosa");
        user.setAge(26);

        dao.salvar(user);
    }
}
