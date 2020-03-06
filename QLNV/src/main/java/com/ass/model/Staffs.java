package com.ass.model;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name ="staffs")
public class Staffs {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String adress;
    private String Birthday;
    private String photo;
    private String Email;
    private String Phone;
    private String salary;
    private String Notes;

    @OneToMany(mappedBy = "staffs")
    private Set<Records> records;



    @ManyToOne
    @JoinColumn(name = "departs_id")
    private Depart departs;


    public Staffs() {
    }



    public Staffs(String name, String adress, String Birthday, String photo, String Email, String Phone, String salary, String Notes ) {
        this.name = name;
        this.adress = adress;
        this.Birthday = Birthday;
        this.photo = photo;
        this.Email = Email;
        this.Phone = Phone;
        this.salary = salary;
        this.Notes = Notes;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getBirthday() {
        return Birthday;
    }

    public void setBirthday(String Birthday) {
        this.Birthday = Birthday;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String Notes) {
        this.Notes = Notes;
    }

    public Depart getDeparts() {
        return departs;
    }

    public void setDeparts(Depart departs) {
        this.departs = departs;
    }
    public Set<Records> getRecords() {
        return records;
    }

    public void setRecords(Set<Records> records) {
        this.records = records;
    }

}
