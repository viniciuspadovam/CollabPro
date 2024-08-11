package com.viniciuspadovam.collabpro.domain.project;

import java.sql.Timestamp;

import com.viniciuspadovam.collabpro.utils.DateUtils;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Table(name = "projects")
@Entity(name = "projects")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String description;
    @Enumerated(EnumType.STRING)
    private ProjectStatus status;
    @Column(name = "begin_date")
    private Timestamp beginDate;
    @Column(name = "end_date")
    private Timestamp endDate;
    @Column(name = "conclusion_time")
    private Integer conclusionTime;
    @Column(name = "worked_time")
    private Integer workedTime;

    public Project(CreateProjectDto dto) {
        this.name = dto.name();
        this.description = dto.description();
        this.status = dto.status();
        this.beginDate = new Timestamp(dto.beginDate().getTime());
        this.endDate = DateUtils.
            addTimestampAndInteger(this.beginDate, dto.conclusionTime());
        this.conclusionTime = dto.conclusionTime();
        this.workedTime = 0;
    }

}
