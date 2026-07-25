package br.com.CarlosManoel.CRUDCursos.modules.courses.repositories;

import br.com.CarlosManoel.CRUDCursos.modules.courses.entities.CoursesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CourseRepository extends JpaRepository<CoursesEntity, UUID> {

    List<CoursesEntity> findByNameOrCategoryContainingIgnoreCase(String name, String category);

    List<CoursesEntity> findByNameContainingIgnoreCase(String name);

    List<CoursesEntity> findByCategoryContainingIgnoreCase(String category);

}