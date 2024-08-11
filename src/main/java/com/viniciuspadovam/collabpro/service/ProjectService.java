package com.viniciuspadovam.collabpro.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viniciuspadovam.collabpro.domain.project.Project;
import com.viniciuspadovam.collabpro.domain.project.UpdateProjectDto;
import com.viniciuspadovam.collabpro.repository.ProjectRepository;
import com.viniciuspadovam.collabpro.utils.DateUtils;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository repo;

    public List<Project> list() {
        return repo.findAll();
    }

    public Optional<Project> get(String id) {
        return repo.findById(id);
    }

    public Project create(Project project) {
        return repo.save(project);
    }

    public int update(UpdateProjectDto dto) {
        Timestamp beginDateAsTimestamp = new Timestamp(dto.beginDate().getTime());
        Timestamp endDateAsTimestamp = verifyDate(dto.beginDate(), dto.endDate(), dto.conclusionTime());
        
        return repo.updateProject(
            dto.id(),
            dto.name(),
            dto.description(),
            dto.status(),
            beginDateAsTimestamp,
            endDateAsTimestamp,
            dto.conclusionTime(),
            dto.workedTime()
        );
    }

    public int delete(String id) {
        repo.deleteById(id);

        if(repo.existsById(id)) {
            return 1;
        }

        return 0;
    }

    private Timestamp verifyDate(Date beginDate, Date endDate, Integer conclusionTime) {
        if(endDate != null) {
            return new Timestamp(endDate.getTime());
        }

        Timestamp timestamp = new Timestamp(beginDate.getTime());
        return DateUtils.
            addTimestampAndInteger(timestamp, conclusionTime);
    }

}
