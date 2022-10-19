package br.com.menotti.springweight.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "tbl_weight")
public class Weight {
    @Column(name = "weight",nullable = false,length = 5)
    private double weight;
    @Column(name = "fk_id",nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer fkId;
    @Column(name = "date_now", nullable = true)
    private LocalDate dateNow;

    public Weight(double weight, Integer fkId) {
        this.weight = weight;
        this.fkId = fkId;
        this.dateNow = LocalDate.now();
    }

    public Weight() {

    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Integer getFkId() {
        return fkId;
    }

    public void setFkId(Integer fkId) {
        this.fkId = fkId;
    }

    public LocalDate getDateNow() {
        return dateNow;
    }

    public void setDateNow(LocalDate dateNow) {
        this.dateNow = dateNow;
    }
}
