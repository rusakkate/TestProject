package by.rusak.repository;

import by.rusak.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long>, JpaRepository<User, Long>,
        PagingAndSortingRepository<User, Long> {

    @Override
    List<User> findAll();

    Optional<User> findByEmail(String email);
}
