package br.com.CarlosManoel.CRUDCursos.modules.courses.repositories;

import br.com.CarlosManoel.CRUDCursos.modules.courses.entities.CoursesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CourseRepository extends JpaRepository<CoursesEntity, UUID> {
    Optional<CoursesEntity> findByName(String name);

}