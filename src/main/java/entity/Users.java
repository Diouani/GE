package entity;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Entity
@DynamicUpdate
@Table(schema = "public",name = "Users")
public class Users {

@NotNull
@Id
@Column(name = "user_id", nullable = false)
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

@NotNull(message = "email doesn't take a null value")
@Email
@Column(name = "email")
    private String email;
@NotNull(message = "first_name doesn't take a null value")
@Column(name = "first_name")
    private String first_name;
@NotNull(message = "last_name doesn't take a null value")
@Column(name = "last_name")
    private String last_name;
@NotNull(message = "password doesn't take a null value")
@Column(name = "password")
    private String password;

    @OneToOne()
    @JoinColumn(name = "id_address", referencedColumnName = "id_address", unique = false)
    private Address address;

    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name = "id_role",unique = false,referencedColumnName = "id_role")
    private Role role;


    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Users{" +
                "userId=" + userId +
                ", email='" + email + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", password='" + password + '\'' +
                ", address=" + address +
                ", role=" + role +
                '}';
    }
}
