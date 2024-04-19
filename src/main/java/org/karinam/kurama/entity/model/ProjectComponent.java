package org.karinam.kurama.entity.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "components")
public class ProjectComponent {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "component_name", nullable = false)
    private String name;

    @Column(name = "finished", nullable = false)
    private Boolean finished;

    @Column(name = "description", nullable = false)
    private String description;

    @OneToMany(mappedBy="projectComponent")
    private List<Requirement> requirements;

    @ManyToOne
    @JoinColumn(name="project_id", nullable=false)
    @JsonIgnore
    private Project project;
}
