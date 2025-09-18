package org.acme.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.acme.dto.TpUsersDto;
import org.acme.dto.UserDto;
import org.acme.entities.TpUsers;
import org.acme.entities.User;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class UserService {

    public List<UserDto> listUsers() {
        return User.listAll().stream().map(user -> new UserDto((User) user))
                .collect(Collectors.toList());
    }

    public UserDto getUser(Long cdUser) {
        return new UserDto(User.findById(cdUser));
    }

    @Transactional
    public UserDto postUser(UserDto dto) {
        User user = new User(dto);
        user.persist();
        return dto;
    }

    public List<TpUsersDto> listTpUsers() {
        return TpUsers.listAll().stream().map(tp -> new TpUsersDto((TpUsers) tp))
                .collect(Collectors.toList());
    }
}
