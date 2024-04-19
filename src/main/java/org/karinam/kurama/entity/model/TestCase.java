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

@Table(name = "testCase")
public class TestCase {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;



    @Column(name = "test_case_name", nullable = false)
    private String testCaseName;

    @Column(name = "isAutomated", nullable = false)
    private boolean isAutomated;

    @Column(name = "result", nullable = false)
    private String result;

    @Column(name = "environment", nullable = false)
    private String environment;

    @Column(name = "prerequisites", nullable = false)
    private String prerequisites;

    @Column(name = "post_condition", nullable = false)
    private String postCondition;

    @OneToMany(mappedBy="testCase")
    private List<Steps> stepsList;

    @ManyToMany(mappedBy = "testCases")
    private List<Requirement> requirementsCovered;

}
