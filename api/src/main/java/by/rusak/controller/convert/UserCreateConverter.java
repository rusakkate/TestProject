package by.rusak.controller.convert;

import by.rusak.controller.requests.UserCreateRequest;
import by.rusak.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class UserCreateConverter extends UserBaseConverter<UserCreateRequest, User>{

    @Override
    public User convert(UserCreateRequest source) {

        User user = new User();

        return doConvert(user, source);
    }


}
