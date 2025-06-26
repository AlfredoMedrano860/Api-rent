package csrent.dto;

import jakarta.validation.MessageInterpolator;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class UserDTO {

    @NotBlank (message = "El nombre no puede quedar vacio.")
    private String name;
    private String type;

    @Email (message = "El correo no es válido.")
    @NotBlank (message = "El correo no puede quedar vacio.")
    private String email;

    @Pattern(regexp = "^(?=.[A-Z])(?=.[a-z])(?=.\\d)(?=.[!@#$%^&*()]).{8,}$", message = "La contraseña debe llevar esto.")
    private String password;
    private String rol;


}
