package com.viniciuspadovam.collabpro.domain.project;

import java.util.Date;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record UpdateProjectDto(
    @NotBlank(message = "Invalid ID: Empty id")
    String id,
    String name,
    String description,
    ProjectStatus status,
    @NotNull(message = "Invalid Begin Date: beginDate is NULL")
    Date beginDate,
    Date endDate,
    @NotNull(message = "Invalid  Conclusion Time: Empty conclusionTime")
    @Min(value = 0, message = "Invalid Conclusion Time: conclusionTime is less than 0")
    @Positive(message = "Invalid Conclusion Time: conclusionTime is not positive")
    Integer conclusionTime,
    Integer workedTime
) {
}
