package br.com.sosa.model;

import javax.persistence.*;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "PersonUser.queryAll",
                    query = "SELECT u FROM PersonUser u"),
        @NamedQuery(name = "PersonUser.FindByName",
                    query = "SELECT u FROM PersonUser u WHERE u.firstName = :name")
})
public class PersonUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String login;
    private String password;
    private int age;
    @OneToMany(mappedBy = "personUser", fetch = FetchType.EAGER)
    private List<PhoneUser> phoneUsers;
    public int getAge() {
        return age;
    }

    public List<PhoneUser> getPhoneUsers() {
        return phoneUsers;
    }

    public void setPhoneUsers(List<PhoneUser> phoneUsers) {
        this.phoneUsers = phoneUsers;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "PersonUser{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
    }
}
