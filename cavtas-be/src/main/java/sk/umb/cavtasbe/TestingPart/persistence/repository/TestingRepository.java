package sk.umb.cavtasbe.TestingPart.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sk.umb.cavtasbe.TestingPart.persistence.entity.TestingEntity;

@Repository
public interface TestingRepository extends JpaRepository<TestingEntity, Long> {
    
}
