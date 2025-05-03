package tcucl.back_tcucl.exceptionPersonnalisee;

import jakarta.persistence.EntityNotFoundException;

public class NonTrouveCustomException extends EntityNotFoundException {

    public NonTrouveCustomException(String message) {
        super(message);
    }
}
