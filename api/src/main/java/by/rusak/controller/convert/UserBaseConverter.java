package by.rusak.controller.convert;

import by.rusak.controller.requests.UserCreateRequest;
import by.rusak.domain.User;
import org.springframework.core.convert.converter.Converter;

import java.sql.Timestamp;
import java.util.Date;

public abstract class UserBaseConverter<S, T> implements Converter<S, T> {

    public User doConvert(User userForUpdate, UserCreateRequest request) {

        userForUpdate.setSurname(request.getSurname());
        userForUpdate.setUserName(request.getUserName());
        userForUpdate.setPatronymic(request.getPatronymic());
        userForUpdate.setEmail(request.getEmail());

        return userForUpdate;
    }

}