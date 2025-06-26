package csrent.model;

import jakarta.persistence.*;

@Entity
@Table(name="tbuser")
public class User implements Identifiable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String type;
    private String email;
    private String password;
    private String rol;

    public User() {
    }

    public User(Integer id, String email, String type, String name, String password, String rol) {
        this.id = id;
        this.email = email;
        this.type = type;
        this.name = name;
        this.password = password;
        this.rol = rol;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public void set(int Integer) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
