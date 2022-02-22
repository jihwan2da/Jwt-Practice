package me.silvernine.jwttutorial.repository;

import me.silvernine.jwttutorial.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @EntityGraph(attributePaths = "authorities")
    Optional<User> findOneWithAuthoritiesByUsername(String username);
    //username을 기준으로 User정보를 가져올떄 권한 정보도 같이 가져오게됨.
    //@EntityGraph은 쿼리가 수행이 될때 Lazy조회가 아니고 Eager조회로
    //authrites정보를 같이 가져오게 됨
}
