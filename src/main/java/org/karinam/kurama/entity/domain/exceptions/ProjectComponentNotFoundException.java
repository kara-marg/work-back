package org.karinam.kurama.entity.domain.exceptions;

public class ProjectComponentNotFoundException extends NotFoundException{

    public ProjectComponentNotFoundException(Long id){
        super("ProjectComponent",id);
    }

}
