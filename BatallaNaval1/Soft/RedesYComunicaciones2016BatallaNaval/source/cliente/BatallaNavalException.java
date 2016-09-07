

package cliente;

/**
 * Esta es una excepción que se lanza para indicar un problema en el juego
 */
public class BatallaNavalException extends Exception
{
    /**
     * Construye una nueva excepción de este tipo con el mensaje indicado
     * @param mensaje El mensaje que describe la causa de la excepción - mensaje != null
     */
    public BatallaNavalException( String mensaje )
    {
        super( mensaje );
    }
}
