package ni.gob.inss.exchangerate.scraper;

public class TipoCambioException extends RuntimeException {

    public TipoCambioException(String message) {
        super(message);
    }

    public TipoCambioException(String message, Throwable cause) {
        super(message, cause);
    }
}
