package com.example.hienpk.checksimlogin.model;

/**
 * Created by TungHH on 8/2/2016.
 *
 *
 */
public class UserInfo {

    // region Field
    private String userName = "";
    private String password = "";
    private String fullName = "";
    private long birthDay;
    private String email = "";
    private String gender = "";
    private String memberClass = "";
    private String Occupation = "";
    //endregion - Field


    // region Getter/Setter
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public long getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(long birthDay) {
        this.birthDay = birthDay;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMemberClass() {
        return memberClass;
    }

    public void setMemberClass(String memberClass) {
        this.memberClass = memberClass;
    }

    public String getOccupation() {
        return Occupation;
    }

    public void setOccupation(String occupation) {
        Occupation = occupation;
    }

    // endregion - Getter/Setter
}
