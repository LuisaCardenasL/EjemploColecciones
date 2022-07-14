/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemplocoleccionjava;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Lu
 */
public class EjemploColeccionJavaGUI extends JFrame{
    
    //componentes de la GUI
    private JPanel pNorte, pBotones, pDatos;
    private JTextArea area; 
    private JTextField tfValor; 
    private JScrollPane barrasDesplazamiento;
    private JLabel eValor, eMostrarR;
    private JButton bIngresar, bMostrar;
    private JComboBox<String> cbColecciones;
    private ManejaEventos evento;
    
    public EjemploColeccionJavaGUI ()
    {
        initComponents();
        //configuracion del frame
        setTitle("Ejemplo Colecciones en Java FPOE");
        setSize(450,400);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);        
    }
    
    private void initComponents ()
    {
        eValor = new JLabel("Ingrese un Valor: ");
        eMostrarR = new JLabel("Resultado: ");
        tfValor = new JTextField();
        String[] tiposC = {"Seleccione una opcion", "ArrayList","Set","arreglo"};
        cbColecciones = new JComboBox<>(tiposC);
        bIngresar = new JButton("Ingresar valor");
        bMostrar = new JButton("Mostrar valores");
        
        ManejaEventos evento = new ManejaEventos();
        bIngresar.addActionListener(evento);
        bMostrar.addActionListener(evento);
        tfValor.addFocusListener(evento);
        
        area = new JTextArea(15,30);
        barrasDesplazamiento = new JScrollPane(area);
        
        pNorte = new JPanel(new GridLayout(2,1));
        pDatos = new JPanel(new GridLayout(1,2,2,2));
        pBotones = new JPanel();
        
        pDatos.add(eValor);
        pDatos.add(tfValor);
        pBotones.add(cbColecciones);
        pBotones.add(bIngresar);
        pBotones.add(bMostrar);
        pNorte.add(pDatos);
        pNorte.add(pBotones);
        
        //adicionando paneles al frame
        add(pNorte, BorderLayout.NORTH);
        add(barrasDesplazamiento, BorderLayout.CENTER);
        add(eMostrarR, BorderLayout.SOUTH);
        
    }
            
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EjemploColeccionJavaGUI obj = new EjemploColeccionJavaGUI();
    }
    
    class ManejaEventos implements ActionListener, FocusListener
    {
        Operaciones operacion;
        
        public ManejaEventos()
        {
            operacion = new Operaciones();
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            if(ae.getSource() == bIngresar)
            {
                String resultadoMetodo = operacion.ingresarDato(tfValor.getText(), cbColecciones.getSelectedItem().toString());
                eMostrarR.setText(resultadoMetodo);
                tfValor.setText("");
            }
            if(ae.getSource() == bMostrar)
            {
                area.setText(operacion.mostrarDatosColeccion(cbColecciones.getSelectedItem().toString()));
            }
          }

        @Override
        public void focusGained(FocusEvent e) {
            eMostrarR.setText("Resultado: ");
            area.setText("");
        }

        @Override
        public void focusLost(FocusEvent e) {
        }
        
    }
    
}
