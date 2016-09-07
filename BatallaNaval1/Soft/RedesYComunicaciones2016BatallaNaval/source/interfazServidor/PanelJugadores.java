

package interfazServidor;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
import javax.swing.border.*;

/**
 * Es el panel donde se muestran los jugadores registrados en la base de datos
 */
public class PanelJugadores extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Comando para el botón Refrescar
     */
    private static final String REFRESCAR = "Refrescar";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es una referencia a la ventana principal de la aplicación del servidor
     */
    private InterfazBatallaNaval principal;

    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------

    /**
     * Es la lista donde se muestran los jugadores
     */
    private JList listaJugadores;

    /**
     * Es el botón que se usa para refrescar la lista de jugadores
     */
    private JButton botonRefrescar;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Inicializa el panel
     * @param ventanaPrincipal Es una referencia a la ventana principal del servidor
     */
    public PanelJugadores( InterfazBatallaNaval ventanaPrincipal )
    {
        principal = ventanaPrincipal;
        inicializarPanel( );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Inicializa los elementos dentro del panel
     */
    private void inicializarPanel( )
    {
        setLayout( new BorderLayout( ) );

        JScrollPane scroll = new JScrollPane( );
        scroll.setPreferredSize(new Dimension(500, 150));
        listaJugadores = new JList( );
        scroll.getViewport( ).add( listaJugadores );
        add(scroll, BorderLayout.CENTER);
        
        JPanel panelRefrescar= new JPanel();
        panelRefrescar.setLayout(new GridBagLayout());
        botonRefrescar = new JButton( "Refrescar" );
        botonRefrescar.addActionListener( this );
        botonRefrescar.setActionCommand( REFRESCAR );
        GridBagConstraints gbc= new GridBagConstraints(); 
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.fill= GridBagConstraints.BOTH;
        panelRefrescar.add( botonRefrescar, gbc );

        add(panelRefrescar, BorderLayout.SOUTH); 
        setBorder( new TitledBorder( "Registro Jugadores" ) );
    }

    /**
     * Actualiza la lista mostrada de jugadores
     * @param jugadores Es una colección con la información de los jugadores que hay actualmente en la bd
     */
    public void actualizarJugadores( Collection jugadores )
    {
        listaJugadores.setListData( jugadores.toArray( ) );
    }

    /**
     * Es el método llamado cuando se hace click sobre el botón refrescar
     * @param evento Es el evento de click sobre el botón
     */
    @Override
	public void actionPerformed( ActionEvent evento )
    {
        String comando = evento.getActionCommand( );

        if( REFRESCAR.equals( comando ) )
        {
            principal.actualizarJugadores( );
        }
    }

}
