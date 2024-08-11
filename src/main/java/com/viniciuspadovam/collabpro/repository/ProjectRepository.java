package com.viniciuspadovam.collabpro.repository;

import java.sql.Timestamp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.viniciuspadovam.collabpro.domain.project.Project;
import com.viniciuspadovam.collabpro.domain.project.ProjectStatus;

public interface ProjectRepository extends JpaRepository<Project, String> {

    @Modifying
    @Query(
        "UPDATE projects p SET " +
        "p.name = COALESCE(:name, p.name), " +
        "p.description = COALESCE(:description, p.description), " +
        "p.status = COALESCE(:status, p.status), " +
        "p.beginDate = COALESCE(:beginDate, p.beginDate), " +
        "p.endDate = COALESCE(:endDate, p.endDate), " +
        "p.conclusionTime = COALESCE(:conclusionTime, p.conclusionTime), " +
        "p.workedTime = COALESCE(:workedTime, p.workedTime) " +
        "WHERE p.id = :id")
    int updateProject(
        @Param("id") String id,
        @Param("name") String name,
        @Param("description") String description,
        @Param("status") ProjectStatus status,
        @Param("beginDate") Timestamp beginDate,
        @Param("endDate") Timestamp endDate,
        @Param("conclusionTime") Integer conclusionTime,
        @Param("workedTime") Integer workedTime
    );

}
