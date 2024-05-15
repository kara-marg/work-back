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
@Table(name = "testCase")
public class
TestCase {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "test_case_name", nullable = false)
    private String testCaseName;

    @Column(name = "description", nullable = false)
    private String description;

    @ManyToMany
    @JoinTable(
            name = "test_case_requirement",
            joinColumns = @JoinColumn(name = "test_case_id"),
            inverseJoinColumns = @JoinColumn(name = "requirement_id"))
    private List<Requirement> requirements;

    @OneToMany(mappedBy="testCase", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Step> steps;


}
