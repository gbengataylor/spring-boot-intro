package com.example.lombock.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlIDREF;
import java.util.Date;

@Entity
@Data // lombok.. with this look at data structure or the compiled class, you'll notice that it has generated all the getter/settes/ hashcode, canEqual, toString
public class User{

    @Id
            @GeneratedValue
    Long id;

    //@Getter @Setter // if you just want on certain fields, comment out @Data, and use these annotations
    String first;
    String last;
    String email;
    Date dob;
    Boolean active;


    private User(){  }
/*
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (first != null ? !first.equals(user.first) : user.first != null) return false;
        if (last != null ? !last.equals(user.last) : user.last != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (dob != null ? !dob.equals(user.dob) : user.dob != null) return false;
        return active != null ? active.equals(user.active) : user.active == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (first != null ? first.hashCode() : 0);
        result = 31 * result + (last != null ? last.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (dob != null ? dob.hashCode() : 0);
        result = 31 * result + (active != null ? active.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", first='" + first + '\'' +
                ", last='" + last + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", active=" + active +
                '}';
    }
    */

} // 112 lines! for a data access object...let's get away from this
