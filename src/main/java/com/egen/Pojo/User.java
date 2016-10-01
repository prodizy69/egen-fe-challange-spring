package com.egen.Pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

/**
 * Created by Sateesh on 10/1/2016.
 */

@Entity
@org.hibernate.annotations.Entity(dynamicUpdate = true)
@Table(name = "User", uniqueConstraints = {@UniqueConstraint(columnNames = "ID")})
public class User implements Serializable {
    private static final long serialVersionUID = -1798070786993154676L;
    @Id
    @Column(name = "ID", unique = true, nullable = false)
    private UUID id;
    @Column(name = "FIRST_NAME", unique = false, nullable = false, length = 100)
    private String firstName;
    @Column(name = "LAST_NAME", unique = false, nullable = false, length = 100)
    private String lastName;
    @Column(name="MIDDLE_NAME",unique = false,nullable = true,length = 100)
    private String middleName;
    @Column(name = "AGE" ,unique = false,nullable = true,length = 2)
    private int age;
    @Column(name = "GENDER",unique = false,nullable = true,length = 1)
    private String gender;
    @Column(name = "PHONE",unique = true,nullable = true,length = 10)
    private String phone;
    @Column(name = "ZIP_CODE" ,unique = false,nullable = true,length = 6)
    private  String zip;

    public User(){

    }
    public User(UUID id, String firstName, String middleName, String lastName, int age, String gender, String phone, String zip) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.zip = zip;
    }

    public User(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", phone='" + phone + '\'' +
                ", zip='" + zip + '\'' +
                '}';
    }
}
