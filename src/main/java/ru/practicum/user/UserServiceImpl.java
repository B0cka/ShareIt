package ru.practicum.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
class UserServiceImpl implements UserService {

    private final UserRepositoryImpl repository;

    @Override
    public List<User> getAllUsers() {
        log.info("Запрос на всех пользователей");
        return repository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        log.info("Запрос на пользователя с id {}", id);
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Пользователь не найден: id=" + id));
    }

    @Override
    public User saveUser(User user) {
        log.info("Запрос на создание пользователя");
        return repository.save(user);
    }

    @Override
    public User updateUser(Long id, UserDto userDto) {
        log.info("Запрос на обновление пользователя id={}", id);
        User existingUser = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Пользователь не найден: id=" + id));

        if (userDto.getName() != null) {
            existingUser.setName(userDto.getName());
        }
        if (userDto.getEmail() != null) {
            existingUser.setEmail(userDto.getEmail());
        }
        return repository.save(existingUser);
    }

    @Override
    public void deleteUser(Long id) {
        log.info("Запрос на удаление пользователя id={}", id);
        repository.deleteById(id);
    }
}
