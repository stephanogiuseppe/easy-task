package com.ste.easytaks.api.model;

import com.ste.easytaks.api.enums.TaskStatus;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Builder
@Document
public class Task {

    @Id
    private String id;
    @NonNull
    private String description;
    private LocalDate createDate;
    private LocalDate updateDate;
    private LocalDate finishDate;
    private TaskStatus taskStatus;

}
