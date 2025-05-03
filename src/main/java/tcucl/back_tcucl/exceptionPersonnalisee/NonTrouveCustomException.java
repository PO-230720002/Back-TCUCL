package tcucl.back_tcucl.exceptionPersonnalisee;

public class NonTrouveeCustomException extends RuntimeException {
  public NonTrouveeCustomException(String message) {
    super(message);
  }
}
