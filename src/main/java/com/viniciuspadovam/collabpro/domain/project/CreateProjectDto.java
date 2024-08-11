package com.viniciuspadovam.collabpro.domain.project;

import java.util.Date;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record CreateProjectDto(
    @NotBlank(message = "Invalid Name: Blank name")
    String name,
    @NotBlank(message = "Invalid Description: Blank description")
    String description,
    @NotNull(message = "Invalid Status: status is NULL")
    ProjectStatus status,
    @FutureOrPresent(message = "Invalid Begin Date: beginDate is before today")
    Date beginDate,
    @NotNull(message = "Invalid  Conclusion Time: Empty conclusionTime")
    @Min(value = 0, message = "Invalid Conclusion Time: conclusionTime is less than 0")
    @Positive(message = "Invalid Conclusion Time: conclusionTime is not positive")
    Integer conclusionTime
) {}
