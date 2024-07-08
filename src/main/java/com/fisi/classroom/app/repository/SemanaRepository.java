package com.fisi.classroom.app.repository;

import com.fisi.classroom.app.models.entity.Curso;
import com.fisi.classroom.app.models.entity.Semana;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SemanaRepository extends JpaRepository<Semana, Integer> {


    List<Semana> findAllByCursoid(String curso);
    @Query("SELECT s.semanaid from Semana s order by s.semanaid desc")
    List<Integer> getLastCodeSemana();

}
