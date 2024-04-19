package org.karinam.kurama.entity.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "projects")
public class Project {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "project_name", nullable = false)
    private String projectName;

    @Column(name = "description", nullable = false)
    private String description;

    @OneToMany(mappedBy="project")
    private List<ProjectComponent> projectComponents;
}
