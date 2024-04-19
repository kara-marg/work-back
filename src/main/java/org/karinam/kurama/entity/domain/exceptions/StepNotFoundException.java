package org.karinam.kurama.entity.domain.exceptions;

public class StepNotFoundException extends NotFoundException{
    public StepNotFoundException (String message) {
        super(message);
    }

    public StepNotFoundException (Long id) {
        super("Step", id);
    }
}