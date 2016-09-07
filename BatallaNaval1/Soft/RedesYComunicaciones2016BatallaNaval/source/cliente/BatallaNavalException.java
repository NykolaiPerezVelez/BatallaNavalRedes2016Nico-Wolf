

package cliente;

/**
 * Esta es una excepci�n que se lanza para indicar un problema en el juego
 */
public class BatallaNavalException extends Exception
{
    /**
     * Construye una nueva excepci�n de este tipo con el mensaje indicado
     * @param mensaje El mensaje que describe la causa de la excepci�n - mensaje != null
     */
    public BatallaNavalException( String mensaje )
    {
        super( mensaje );
    }
}
