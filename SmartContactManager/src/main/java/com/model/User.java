package com.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    @NotNull(message = "Can not be empty")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "only alphabets allowed")
    private String name;

    @Column(name = "email")
    @NotNull(message="Can not be empty")
    @Email(message = "Should be in email format")
    private String email;

    @Column(name="phone")
    @NotNull(message = "Can not be empty")
    private  String phone;

    @Column(name="gender")
    @NotNull(message = "Can not be empty")
    private String gender;

    @NotNull(message = "Provide your password")
    private String password;

    @Column(name="dob")
    @NotNull(message = "Can not be empty")
    private String dob;

    @Column(name="type")
    @NotNull(message = "Can not be empty")
    private String type;


//    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "user")
//    private Login login;

    public User(){}

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User(String name, String email, String phone, String gender, String password, String dob, String type) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.password = password;
        this.dob = dob;
        this.type = type;
    }
    public User(Integer id, String name, String email, String phone, String gender, String password, String dob, String type) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.password = password;
        this.dob = dob;
        this.type = type;
    }
    public User(Integer id, String name, String email, String phone, String gender, String password, String dob) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.password = password;
        this.dob = dob;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

//    public Login getLogin() {
//        return login;
//    }
//
//    public void setLogin(Login login) {
//        this.login = login;
//    }
}
