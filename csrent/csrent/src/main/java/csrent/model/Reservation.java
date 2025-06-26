package csrent.model;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name= "user_email", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "space_id", nullable = false)
    private Space space;

    private LocalDate dataReservation;
    private String status;

    public Reservation() {
    }

    public Reservation(Integer id, String status, User user, Space space, LocalDate dataReservation) {
        this.id = id;
        this.status = status;
        this.user = user;
        this.space = space;
        this.dataReservation = dataReservation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Space getSpace() {
        return space;
    }

    public void setSpace(Space space) {
        this.space = space;
    }

    public LocalDate getDataReservation() {
        return dataReservation;
    }

    public void setDataReservation(LocalDate dataReservation) {
        this.dataReservation = dataReservation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
