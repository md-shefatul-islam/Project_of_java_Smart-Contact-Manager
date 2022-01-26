package com.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "contact")
public class Contact {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    @NotNull(message = "Can not be empty")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "only alphabets allowed")
    private String name;

    @Column(name = "nickname")
    @NotNull(message = "Can not be empty")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "only alphabets allowed")
    private String nickname;

    @Column(name="phone")
    @NotNull(message = "Can not be empty")
    private  String phone;

    @Column(name="num_type")
    @NotNull(message = "Can not be empty")
    private  String num_type;

    @Column(name="date")
    @NotNull(message = "Can not be empty")
    private String date;

    @Column(name="u_id")
    private String u_id;


    public Contact(){}

    public Contact(String name, String nickname, String phone, String num_type, String date, String  u_id) {
        this.name = name;
        this.nickname = nickname;
        this.phone = phone;
        this.num_type = num_type;
        this.date = date;
        this.u_id = u_id;
    }

    public Contact(Integer id, String name, String nickname, String phone, String num_type, String date, String  u_id) {
        this.id = id;
        this.name = name;
        this.nickname = nickname;
        this.phone = phone;
        this.num_type = num_type;
        this.date = date;
        this.u_id = u_id;
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhone() {
        return phone;
    }

    public String getNum_type() {
        return num_type;
    }

    public void setNum_type(String num_type) {
        this.num_type = num_type;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }
}
