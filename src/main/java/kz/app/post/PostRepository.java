package kz.app.post;

import kz.app.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Repository
@Transactional
public interface PostRepository extends JpaRepository<Post, Long> {
    Collection<Post> findAllByAccount(Account account);
}
