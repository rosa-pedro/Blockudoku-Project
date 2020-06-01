package game;

/**
 * This class serves to treat ErrorCodes and transform them into String objects
 *
 * @author Pedro Rosa - 190221015 - 190221015@estudantes.ips.pt
 * @author Joao Cetano - 190221010 - 190221010@estudantes.ips.pt
 */
public class GameIllegalArgumentException extends IllegalArgumentException {

    /**
     * Method to transform the error code into a String
     *
     * @param errorCode String value of the error code
     */
    public GameIllegalArgumentException(ErrorCode errorCode) {
        super(errorCode.toString());
    }
}
