package org.karinam.kurama.entity.domain.exceptions;

public class RequirementNotFoundException extends NotFoundException {
    public RequirementNotFoundException (Long id){
        super("Requirement", id);
    }

}
