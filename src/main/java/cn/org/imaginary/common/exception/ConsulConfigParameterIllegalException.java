package cn.org.imaginary.common.exception;

/**
 * @author Imaginary
 * @see
 * @since 1.0
 */
public class ConsulConfigParameterIllegalException extends RuntimeException {

    public ConsulConfigParameterIllegalException(Throwable cause) {
        super(cause);
    }

    public ConsulConfigParameterIllegalException(String msg) {
        super(msg);
    }

    public ConsulConfigParameterIllegalException(String message, Throwable cause) {
        super(message, cause);
    }
}
