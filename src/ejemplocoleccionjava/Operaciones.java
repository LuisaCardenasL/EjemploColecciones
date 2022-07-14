/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemplocoleccionjava;

import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author Lu
 */
public class Operaciones {
    
    //declaracion de variables de clase
    private ArrayList<String> arrayList;
    private HashSet<String> conjunto;
    private String[] arreglo;
    private int pos;
    
    public Operaciones()
    {
        arrayList = new ArrayList<>();
        conjunto = new HashSet<>();
        arreglo = new String[100];
        pos = 0;
    }
    
    /**
     * ingresar valores en una coleccion dependiendo el tipo recibido
     * @param valor: el dato que se va almacenar en la coleccion
     * @param tipoColeccion: la coleccion donde se va a almacenar (arraylist, set, arreglo estatico)
     * @return : mensaje de exito en ingreso del dato
     */
    public String ingresarDato (String valor, String tipoColeccion)
    {
        String mensajeSalida = "";
        switch (tipoColeccion) {
            case "ArrayList": arrayList.add(valor);
                              mensajeSalida = "se adiciono en ArrayList con exito";
                              break;
            case "Set": conjunto.add(valor);
                        mensajeSalida = "se adiciono en Conjunto con exito";
                        break;
            case "arreglo": arreglo[pos] = valor;
                            pos++; // pos = pos + 1
                            mensajeSalida = "se adiciono en arreglo estatico con exito";
                            break;
            default: mensajeSalida = "no se pudo adicionar el elemento porque selecciono una estructura inexistente";
        }
        return mensajeSalida;
    }
    
    public String mostrarDatosColeccion(String tipo)
    {
        String salida="";
        //logica:
        switch (tipo) {
            case "ArrayList": salida = "Los datos que estan en el arrayList son:\n";
                              for (int i = 0; i <arrayList.size(); i++)
                              {
                                  salida += arrayList.get(i)+"\n";
                              }
                              break;
            case "Set": salida = "Los datos que estan en el HashSet son:\n";
                        for(String elemento: conjunto)
                        {
                            salida += elemento+"\n";
                        }
                        break;
            case "arreglo": salida = "Los datos que estan en el arreglo estatico son:\n";
                            for (int i = 0; i < arreglo.length; i++)
                            {
                                salida += arreglo[i]+"\n";
                            }
                            break;
            default: salida = "no se pudo mostrar los datos";
        }
        
        return salida;
    }
}
