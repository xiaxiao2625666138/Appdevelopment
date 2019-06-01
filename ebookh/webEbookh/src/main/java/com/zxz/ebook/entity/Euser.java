package com.zxz.ebook.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="euser", schema="ebookh", catalog="")
@JsonIgnoreProperties(value={"handler", "hibernateLazyInitializer", "fieldHandler"})
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "name"
)
public class Euser {

    private String name;
    private String password;
    private String phone;
    private String address;
    private String email;
    private char disabled;
    private List<Eorder> orders;

    public Euser(){}

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="user_name", length=40)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name="user_password", length=30)
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name="phone")
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name="address")
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name="email")
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name="disabled")
    public char getDisabled() {
        return disabled;
    }
    public void setDisabled(char disabled) {
        this.disabled = disabled;
    }

    @OneToMany(cascade={CascadeType.REMOVE},fetch=FetchType.EAGER,
            targetEntity = Eorder.class,mappedBy = "username")
    @OrderBy("time DESC ")
    public List<Eorder> getOrders() {
        return orders;
    }
    public void setOrders(List<Eorder> orders) {
        this.orders = orders;
    }

}
