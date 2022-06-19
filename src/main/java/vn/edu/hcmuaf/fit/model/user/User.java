package vn.edu.hcmuaf.fit.model.user;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private Long id;
    private String username;
    private String password;
    private boolean active;
    private Date createdDate;
    private String role;
    private String Sku;

    public User() {

    }

    public User(Long id, String username, String password, boolean active, Date createdDate, String role, String sku) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.active = active;
        this.createdDate = createdDate;
        this.role = role;
        Sku = sku;
    }
    public User( String username, String password, boolean active, Date createdDate, String role) {
        this.id = 0L;
        this.username = username;
        this.password = password;
        this.active = active;
        this.createdDate = createdDate;
        this.role = role;
    }

    public String getName() {
        return username;
    }

    public void setName(String username) {
        this.username = username;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSku() {
        return Sku;
    }
    public String setSku(String sku) {
        return Sku = sku;
    }

    public Date getDate() {
        return createdDate;
    }

    public void setDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    //    public void setPassword(String password) {
//        this.password = password;
//    }
}
