
package com.example.dncaphoneshop;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class User {

    @Expose
    private Object address;
    @SerializedName("birth_day")
    private Object birthDay;
    @Expose
    private Object email;
    @SerializedName("full_name")
    private Object fullName;
    @Expose
    private Object password;
    @SerializedName("phone_number")
    private Object phoneNumber;
    @Expose
    private Object sex;
    @Expose
    private Object username;

    public User(Object address, Object birthDay, Object email, Object fullName, Object password, Object phoneNumber, Object sex, Object username) {
        this.address = address;
        this.birthDay = birthDay;
        this.email = email;
        this.fullName = fullName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.sex = sex;
        this.username = username;
    }

    public User() {
    }

    public Object getAddress() {
        return address;
    }

    public void setAddress(Object address) {
        this.address = address;
    }

    public Object getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Object birthDay) {
        this.birthDay = birthDay;
    }

    public Object getEmail() {
        return email;
    }

    public void setEmail(Object email) {
        this.email = email;
    }

    public Object getFullName() {
        return fullName;
    }

    public void setFullName(Object fullName) {
        this.fullName = fullName;
    }

    public Object getPassword() {
        return password;
    }

    public void setPassword(Object password) {
        this.password = password;
    }

    public Object getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Object phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Object getSex() {
        return sex;
    }

    public void setSex(Object sex) {
        this.sex = sex;
    }

    public Object getUsername() {
        return username;
    }

    public void setUsername(Object username) {
        this.username = username;
    }
}
