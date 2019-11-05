package com.sony.model.entity;

import javax.persistence.*;

@Entity  
@Table(name="user_detail")  
public class UserDetail {  
      
    @Id  
    @GeneratedValue(strategy=GenerationType.AUTO)  
    @Column(name="user_id")  
    private int userId;  
      
    @Column(name="email_id")  
    public String emailId;  
      
    @Column(name="name")  
    public String name;  
      
    @Column(name="profile_image")  
    public String profileImage;  
      
    public UserDetail() { }  
  
    public UserDetail(int userId, String emailId, String name, String profileImage) {  
        super();  
        this.userId = userId;  
        this.emailId = emailId;  
        this.name = name;  
        this.profileImage = profileImage;  
    }  
  
    public int getUserId() {  
        return userId;  
    }  
  
    public void setUserId(int userId) {  
        this.userId = userId;  
    }  
  
    public String getEmailId() {  
        return emailId;  
    }  
  
    public void setEmailId(String emailId) {  
        this.emailId = emailId;  
    }  
  
    public String getName() {  
        return name;  
    }  
  
    public void setName(String name) {  
        this.name = name;  
    }  
  
    public String getProfileImage() {  
        return profileImage;  
    }  
  
    public void setProfileImage(String profileImage) {  
        this.profileImage = profileImage;  
    }  
  
    @Override  
    public String toString() {  
        return "UserDetail [userId=" + userId + ", emailId=" + emailId + ", name=" + name + ", profileImage="  
                + profileImage + "]";  
    }  
}  
