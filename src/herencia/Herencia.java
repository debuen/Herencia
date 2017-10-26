
package herencia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import modelo.Protoss;
import modelo.Terran;
import modelo.Zerg;

public class Herencia {

    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String opcion = br.readLine();
        String[] array = opcion.split(" ");
        
        if(array[0] == "A"){
            altaEscuadron(array);
        }else if(array[0] == "R"){
            registrarBatalla();
        }else if(array[0] == "M"){
            mejorarEscuadron();
        }else if(array[0] == "C"){
            clasificacion();
        }else if(array[0] == "S"){
            salir();
        }    
        
    }
    
    public static void altaEscuadron(String array[]){
        
        if(array[1] == "terran"){
            Terran t = new Terran(Integer.parseInt(array[5]), Integer.parseInt(array[6]), array[2], 0, Integer.parseInt(array[3]), Integer.parseInt(array[4]));
        }else if(array[1] == "zerg"){
            Zerg z = new Zerg(Integer.parseInt(array[5]), Integer.parseInt(array[6]), array[2], 0, Integer.parseInt(array[3]), Integer.parseInt(array[4]));
        }else if(array[1] == "protoss"){
            Protoss p = new Protoss(Integer.parseInt(array[5]), array[2], 0, Integer.parseInt(array[3]), Integer.parseInt(array[4]));
        }
        
    }
    
    public static void registrarBatalla(){
        
    }
    
    public static void mejorarEscuadron(){
        
    }
    
    public static void clasificacion(){
        
    }
    
    public static void salir(){
        
    }
    
    
    
}
