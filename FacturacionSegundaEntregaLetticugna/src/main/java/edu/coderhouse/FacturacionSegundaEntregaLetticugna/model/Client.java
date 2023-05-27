package edu.coderhouse.FacturacionSegundaEntregaLetticugna.model;
import jakarta.persistence.*;

@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)//esto genera auto incremental del id en la tabla
    private int id;
    private String name;

    @Column(name="lastname")
    private String lastName;
    @Column(name="docnumber")
    private String docNumber;

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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber;
    }

    // Override toString
    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", docNumber=" + docNumber +
                '}';
    }




}
