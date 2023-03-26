package by.rusak.controller.requests;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.regex.*;

@Data
@Validated
@ApiModel(description = "Create user object")
public class UserCreateRequest {

    @ApiModelProperty(required = true, allowableValues = "kate", dataType = "string", notes = "user's name")
    @NotNull
    @Size(min = 2, max = 20, message = "Name length must be from 2 to 20")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Name must contain only letters a-z and A-Z")
    private String userName;

    @ApiModelProperty(required = true, allowableValues = "rusak", dataType = "string", notes = "user's surname")
    @NotNull
    @Size(min = 2, max = 40, message = "Surname length must be from 2 to 40")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Surname must contain only letters a-z and A-Z")
    private String surname;

    @ApiModelProperty(required = true, allowableValues = "konstantinovna", dataType = "string", notes = "user's patronymic")
    @NotNull
    @Size(min = 2, max = 40, message = "Patronymic length must be from 2 to 40")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Patronymic must contain only letters a-z and A-Z")
    private String patronymic;

    @ApiModelProperty(required = true, allowableValues = "melitrica_red@mail.ru", dataType = "string", notes = "user's email")
    @Email
    private String email;

}
