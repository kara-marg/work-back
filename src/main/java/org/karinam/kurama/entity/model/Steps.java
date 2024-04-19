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
@Table(name = "steps")
public class Steps {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name="testCase_id", nullable=false)
    @JsonIgnore
    private TestCase testCase;

    @Column(name = "step", nullable = false)
    private String step;

    @Column(name = "expectedResult", nullable = false)
    private String expectedResult;
}
