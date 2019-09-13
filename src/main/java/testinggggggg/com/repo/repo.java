
package testinggggggg.com.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import testinggggggg.com.model.Student;


@Repository
public interface repo extends JpaRepository<Student, Integer> {

}
