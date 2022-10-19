package br.com.menotti.springweight.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "tbl_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name", nullable = false, length = 45, unique = true)
    private String name;
    @Column(name= "date_birth", nullable = true)
    private Date dateBirth;
    @Column(name = "weight_obj",nullable = true)
    private double weightObj;

    public User(String name, String dateBirth, double weightObj) {
        this.name = name.toUpperCase();
        this.dateBirth = Date.valueOf(dateBirth);
        this.weightObj = weightObj;
    }

    public User() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name.toUpperCase();
    }

    public void setName(String name) {
        this.name = name.toUpperCase();
    }

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(String dateBirth) {
        this.dateBirth = Date.valueOf(dateBirth);
    }

    public double getWeightObj() {
        return weightObj;
    }

    public void setWeightObj(double weightObj) {
        this.weightObj = weightObj;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateBirth=" + dateBirth +
                ", weightObj=" + weightObj +
                '}';
    }
}