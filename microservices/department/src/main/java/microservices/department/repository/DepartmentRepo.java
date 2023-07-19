package microservices.department.repository;

import microservices.department.entity.Department;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentRepo extends MongoRepository<Department, String> {
    Optional<Department> findByCode(String code);
}
