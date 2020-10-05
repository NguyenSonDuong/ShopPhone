
package com.example.dncaphoneshop.Model;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class User {

    @SerializedName("address")
    private Object mAddress;
    @SerializedName("admin")
    private Boolean mAdmin;
    @SerializedName("birth_day")
    private Object mBirthDay;
    @SerializedName("create_at")
    private Object mCreateAt;
    @SerializedName("email")
    private Object mEmail;
    @SerializedName("full_name")
    private String mFullName;
    @SerializedName("id")
    private Long mId;
    @SerializedName("password")
    private String mPassword;
    @SerializedName("phone_number")
    private Object mPhoneNumber;
    @SerializedName("sex")
    private String mSex;
    @SerializedName("update_at")
    private Object mUpdateAt;
    @SerializedName("username")
    private String mUsername;

    public Object getAddress() {
        return mAddress;
    }

    public void setAddress(Object address) {
        mAddress = address;
    }

    public Boolean getAdmin() {
        return mAdmin;
    }

    public void setAdmin(Boolean admin) {
        mAdmin = admin;
    }

    public Object getBirthDay() {
        return mBirthDay;
    }

    public void setBirthDay(Object birthDay) {
        mBirthDay = birthDay;
    }

    public Object getCreateAt() {
        return mCreateAt;
    }

    public void setCreateAt(Object createAt) {
        mCreateAt = createAt;
    }

    public Object getEmail() {
        return mEmail;
    }

    public void setEmail(Object email) {
        mEmail = email;
    }

    public String getFullName() {
        return mFullName;
    }

    public void setFullName(String fullName) {
        mFullName = fullName;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        mPassword = password;
    }

    public Object getPhoneNumber() {
        return mPhoneNumber;
    }

    public void setPhoneNumber(Object phoneNumber) {
        mPhoneNumber = phoneNumber;
    }

    public String getSex() {
        return mSex;
    }

    public void setSex(String sex) {
        mSex = sex;
    }

    public Object getUpdateAt() {
        return mUpdateAt;
    }

    public void setUpdateAt(Object updateAt) {
        mUpdateAt = updateAt;
    }

    public String getUsername() {
        return mUsername;
    }

    public void setUsername(String username) {
        mUsername = username;
    }

}
