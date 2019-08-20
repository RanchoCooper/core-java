package volume1.fundamentals.ch07.exceptions;

/**
 * @author rancho
 * @date 2019-08-20
 */
public class DecoupleWay {

    public static void main(String[] args) {
        // outer try block make sure errors are reported
        // which even in the finally block
        try {
            // inner try block has a single responsibility
            // make sure finally was done
            try {
                // something may throw a exception
            } finally {
                //
            }
        } catch (Exception e) {
            // handle exception
        }
    }

}
