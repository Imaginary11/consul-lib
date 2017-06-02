package cn.org.imaginary.common.exception;

/**
 * parsing consul config file 'application.yml' error
 *
 * @author Imaginary
 * @see
 * @since 1.0
 */
public class ConsulConfigParsingException extends RuntimeException {

    public ConsulConfigParsingException(Throwable cause) {
        super(cause);
    }

    public ConsulConfigParsingException(String msg) {
        super(msg);
    }

    public ConsulConfigParsingException(String message, Throwable cause) {
        super(message, cause);
    }

}
