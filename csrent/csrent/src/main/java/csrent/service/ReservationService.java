package csrent.service;

import csrent.dto.ReservationDTO;
import csrent.model.Reservation;
import csrent.model.Space;
import csrent.model.User;
import csrent.repository.ReservationJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ReservationService {

    private ReservationJpaRepository repository;
    private UserService serviceU;
    private SpaceService serviceS;

    public ReservationService(ReservationJpaRepository repository, UserService serviceU, SpaceService serviceS) {
        this.repository = repository;
        this.serviceU = serviceU;
        this.serviceS = serviceS;
    }

    public List<Reservation> getAll(){
        return repository.findAll();
    }

    public Reservation add(ReservationDTO reservationDTO) {
        User user = serviceU.getUserByEmail(reservationDTO.getEmailUser());
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado con el email: " + reservationDTO.getEmailUser());
        }

        Space space = serviceS.getSpace(reservationDTO.getIdSpace());
        if (space == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Espacio no encontrado con ID: " + reservationDTO.getIdSpace());
        }

        Reservation reservation = new Reservation();
        reservation.setUser(user);
        reservation.setSpace(space);
        reservation.setDataReservation(reservationDTO.getDate());
        reservation.setStatus(reservationDTO.getStatus());

        return repository.save(reservation);
    }


}
