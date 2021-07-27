package whiteheadcrab.springframework.Repositories;

import whiteheadcrab.springframework.Model.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository
{

}
