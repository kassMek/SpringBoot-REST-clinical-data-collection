package clinical.com.clinicalrestfuldatacollection.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
//@JsonIgnoreProperties({"clinicalData"})
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private int age;

    @OneToMany(cascade = CascadeType.ALL,fetch=FetchType.LAZY, mappedBy = "patient")
    private List<ClinicalData> clinicalData;

    public Patient() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<ClinicalData> getClinicalData() {
        return clinicalData;
    }

    public void setClinicalData(List<ClinicalData> clinicalData) {
        this.clinicalData = clinicalData;
    }
}
