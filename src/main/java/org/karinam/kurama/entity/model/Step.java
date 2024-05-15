package org.karinam.kurama.entity.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "step")
public class Step {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name="test_case_id", nullable=false)
    @JsonIgnore
    private TestCase testCase;

    @Column(name = "action", nullable = false)
    private String action;

    @Column(name = "expectedResult", nullable = false)
    private String expectedResult;

    @Column(name = "step_number", nullable = false)
    private Integer stepNumber;
}
