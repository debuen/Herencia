
package herencia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import modelo.Escuadron;
import modelo.Protoss;
import modelo.Terran;
import modelo.Zerg;

public class Herencia {
    
    static ArrayList<Escuadron> escuadronList = new ArrayList<>();
    static ArrayList<Protoss> protossList = new ArrayList<>();
    static ArrayList<Terran> terranList = new ArrayList<>();
    static ArrayList<Zerg> zergList = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String opcion = br.readLine();
        String[] array = opcion.split(" ");
        
        switch(array[0].toUpperCase()){
            case "A":
                altaEscuadron(array);
                break;
            case "R":
                registrarBatalla();
                break;
            case "M":
                mejorarEscuadron();
                break;
            case "C":
                clasificacion();
                break;
            case "S":
                salir();
            }while(!array[0].equalsIgnoreCase("S"));    
    }
    
    
    public static void altaEscuadron(String[] array){
        
        String nombre = array[2];
        int vict = 0;
        int nAtq = Integer.parseInt(array[3]);
        int nDef = Integer.parseInt(array[4]);
        int hab1 = Integer.parseInt(array[5]);
        int hab2 = Integer.parseInt(array[6]);
        
        if(array[1].toLowerCase() == "terran"){
            Terran t = new Terran(hab1, hab2, nombre, vict, nAtq, nDef);
            escuadronList.add(t);
            terranList.add(t);
        }else if(array[1] == "zerg"){
            Zerg z = new Zerg(hab1, hab2, nombre, vict, nAtq, nDef);
            escuadronList.add(z);
            zergList.add(z);
        }else if(array[1] == "protoss"){
            Protoss p = new Protoss(hab1, nombre, vict, nAtq, nDef);
            escuadronList.add(p);
            protossList.add(p);
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
