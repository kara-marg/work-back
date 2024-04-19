package org.karinam.kurama.entity.domain.exceptions;

public class TicketNotFoundException extends NotFoundException{
    public TicketNotFoundException (String message) {
        super(message);
    }

    public TicketNotFoundException (Long id) {
        super("Ticket", id);
    }
}
