package org.karinam.kurama.entity.domain.exceptions;

public class TestCaseNotFoundException extends NotFoundException{
    public TestCaseNotFoundException (String message) {
        super(message);
    }

    public TestCaseNotFoundException (Long id) {
        super("Test-case", id);
    }
}


