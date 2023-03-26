package by.rusak.controller;

import by.rusak.controller.requests.UserCreateRequest;
import by.rusak.domain.User;
import by.rusak.service.UserRoleService;
import by.rusak.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/creation")
public class CreationUserController {
    private final ConversionService converter;

    private final UserService userService;

    private final UserRoleService userRoleService;

    @PostMapping
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED,
            timeout = 300, rollbackFor = Exception.class)
    public ResponseEntity<Object> registration (@Valid @RequestBody UserCreateRequest createRequest) {

        User user = converter.convert(createRequest, User.class);
        Map<String, Object> model = new HashMap<>();
        HttpStatus httpStatus;

        if (userService.findByEmail(user.getEmail()).isPresent()) {
            model.put("message", "User with such email exist");
            httpStatus = HttpStatus.BAD_REQUEST;
        }  else {
            userService.save(user);
            userRoleService.setUserRoles(user);
            model.put("message", "User was created");
            httpStatus = HttpStatus.OK;
        }
        return new ResponseEntity<>(model, httpStatus);
    }
}
