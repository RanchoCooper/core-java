package volume1.fundamentals.ch07.exceptions;

import java.sql.SQLTimeoutException;

/**
 * @author rancho
 * @date 2019-08-20
 */
public class WrappingException {

    public static void main(String[] args) throws Throwable {
        try {
            // asume something wrong
            throw new SQLTimeoutException("cannot connect");
        } catch (Throwable origin) {
            // construct with `cause` so that we can got all original exception information
            throw new Exception("database error", origin);
        }
    }

}
