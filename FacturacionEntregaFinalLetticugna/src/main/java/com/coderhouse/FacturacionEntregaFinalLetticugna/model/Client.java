package com.coderhouse.FacturacionEntregaFinalLetticugna.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String lastname;
    private long docnumber;

    @OneToMany(mappedBy = "client")
    private List<Invoice> invoice;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public long getDocnumber() {
        return docnumber;
    }

    public void setDocnumber(long docnumber) {
        this.docnumber = docnumber;
    }

    //Validators
    public boolean naneValidate(String name) {
        return name != null && name != "";
    }

    public boolean lastNameValidate(String lastName) {
        return lastName != null && lastName != "";
    }

    public boolean docNumberValidate(Long docNumber) {

        System.out.println("docNumber != null: "+ (docNumber == null));
        System.out.println("docNumber: "+ docNumber );
        return docNumber == null || docNumber == 0;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", docnumber='" + docnumber + '\'' +
                '}';
    }
}
