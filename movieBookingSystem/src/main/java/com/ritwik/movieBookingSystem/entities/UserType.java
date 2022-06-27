package com.ritwik.movieBookingSystem.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class UserType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userTypeId;

    @Column(length = 20, unique = true)
    private String userTypeName = "Customer";

    @OneToMany(mappedBy = "userType", fetch = FetchType.EAGER)
    private List<Users> users;

    public UserType() {
    }

    public UserType(String userTypeName) {
        this.userTypeName = userTypeName;
    }

    public int getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(int userTypeId) {
        this.userTypeId = userTypeId;
    }

    public String getUserTypeName() {
        return userTypeName;
    }

    public void setUserTypeName(String userTypeName) {
        this.userTypeName = userTypeName;
    }

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "UserType{" +
                "userTypeId=" + userTypeId +
                ", userTypeName='" + userTypeName + '\'' +
                '}';
    }
}
