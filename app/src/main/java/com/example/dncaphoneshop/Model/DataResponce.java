
package com.example.dncaphoneshop.Model;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class DataResponce {

    @SerializedName("message")
    private String mMessage;
    @SerializedName("result")
    private User mUser;
    @SerializedName("status")
    private Boolean mStatus;

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        mMessage = message;
    }

    public User getResult() {
        return mUser;
    }

    public void setResult(User user) {
        mUser = user;
    }

    public Boolean getStatus() {
        return mStatus;
    }

    public void setStatus(Boolean status) {
        mStatus = status;
    }

}
