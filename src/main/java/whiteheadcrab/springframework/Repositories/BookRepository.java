package whiteheadcrab.springframework.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import whiteheadcrab.springframework.Model.Book;

@Repository
public interface BookRepository extends CrudRepository<Book,Long>
{

}
