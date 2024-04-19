package org.karinam.kurama.entity.domain.exceptions;

public class ProjectNotFoundException extends NotFoundException{
    public ProjectNotFoundException (String message) {
        super(message);
    }

    public ProjectNotFoundException (Long id) {
        super("Project", id);
    }


}
