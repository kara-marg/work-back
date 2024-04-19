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
public class Requirement {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "requirement_name", nullable = false)
    private String requirementName;

    @Column(name = "descroption", nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name="component_id", nullable=false)
    @JsonIgnore
    private ProjectComponent projectComponent;

    @ManyToMany
    @JoinTable(
            name = "test_case_environment",
            joinColumns = @JoinColumn(name = "requirement_id"),
            inverseJoinColumns = @JoinColumn(name = "test_case_id"))
    private List<TestCase> testCases;

}
