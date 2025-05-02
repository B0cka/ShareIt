package ru.practicum.user;

import java.util.List;

interface UserService {
    List<User> getAllUsers();
    User getUserById(Long id);
    User saveUser(User user);
    User updateUser(Long id, UserDto userDto);
    void deleteUser(Long id);
}
