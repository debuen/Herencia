
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
                registrarBatalla(array);
                break;
            case "M":
                mejorarEscuadron(array);
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
        
        if(array[1].toLowerCase().equalsIgnoreCase("terran")){
            Terran t = new Terran(hab1, hab2, nombre, vict, nAtq, nDef);
            escuadronList.add(t);
            terranList.add(t);
            System.out.println("< OK: Escuadrón registrado >");
        }else if(array[1].toLowerCase().equalsIgnoreCase("zerg")){
            Zerg z = new Zerg(hab1, hab2, nombre, vict, nAtq, nDef);
            escuadronList.add(z);
            zergList.add(z);
            System.out.println("< OK: Escuadrón registrado >");
        }else if(array[1].toLowerCase().equalsIgnoreCase("protoss")){
            Protoss p = new Protoss(hab1, nombre, vict, nAtq, nDef);
            escuadronList.add(p);
            protossList.add(p);
            System.out.println("< OK: Escuadrón registrado >");
        }
        
    }
    
    public static void registrarBatalla(String[] array){
     
        if (array.length == 3) {
            
            int random1 = (int)(Math.random()*9 +0);
            int random2 = (int)(Math.random()*9 +0);
            
            Escuadron e1 = buscarEscuadron(array[1]);
            Escuadron e2 = buscarEscuadron(array[2]);
            
            int gana1 = 0; int gana2 = 0;
            
            if(e1!=null && e2!=null){
                
                System.out.println("<Inicio batalla...>");
                for (int i=0;i<5;i++){
                    System.out.println("Asalto nº " + (i+1));
                    int p1 = (random1 + e1.getnAtaque())- e2.getnDefensa();
                    int p2 = (random2 + e2.getnAtaque())- e1.getnDefensa();
                    
                    System.out.println("Ataca " + e1.getNombre() + " - Nº Aleatorio: " + random1 + " - Valor de su ataque: " + p1);
                    System.out.println("Ataca " + e2.getNombre() + " - Nº Aleatorio: " + random2 + " - Valor de su ataque: " + p2);
                    if(p1 > p2){
                        System.out.println("Ganador del asalto: " + e1.getNombre());
                        gana1++;
                    }else if(p2 > p1){
                        System.out.println("Ganador del asalto: " + e2.getNombre());
                        gana2++;
                    }else{
                        System.out.println("Asalto sin ganador. Ha habido empate");
                    }
                }
                
                System.out.println("<Fin batalla...>");
                if(gana1 > gana2){System.out.println("<OK: La batalla la ha ganado el escuadron " + e1.getNombre() + " con " + gana1 + "asaltos>");}
                else if(gana2 > gana1){System.out.println("<OK: La batalla la ha ganado el escuadron " + e2.getNombre() + " con " + gana2 + "asaltos>");}
                else{System.out.println("<OK: La batalla ha acabado en empate>");}
                
            }else{
                System.out.print("< ERROR 005: No existe especie con ese nombre >");
            }
            
        }else{
            System.out.print("< ERROR 001: Nº de argumentos inválidos");
        }     
        
    }
    
    public static void mejorarEscuadron(String[] array){
        
        Escuadron e1 = buscarEscuadron(array[1]);
        int posEscuadron = 0;
        String espEscuadron = "";
        
        if(array.length == 4){
            
            if(e1 != null){
                for(int i=0;i<escuadronList.size();i++){
                    if(escuadronList.get(i).getNombre().equalsIgnoreCase(array[1])){
                        posEscuadron = i;
                        espEscuadron = escuadronList.get(i).getClass().getSimpleName().toLowerCase();
                    }
                }
                
                if(espEscuadron.equalsIgnoreCase("terran")){
                    if(array[2].toLowerCase().equalsIgnoreCase("tecnologia")){
                        //escuadronList.get(posEscuadron).;
                    }else if(array[2].toLowerCase().equalsIgnoreCase("edificios")){
                        
                    }
                    System.out.println("<OK: Propiedad mejorada>");
                }
                
                
            }
            else{
                System.out.println("< ERROR 005: No existe especie con ese nombre >");
            }
            
        }else{
            System.out.print("< ERROR 001: Nº de argumentos inválidos");
        }
        
    }
    
    public static void clasificacion(){
        
    }
    
    public static void salir(){
        
    }
    
    public static Escuadron buscarEscuadron(String nombre){
        for(Escuadron e : escuadronList){
            if(e.getNombre().equalsIgnoreCase(nombre)){
                return e;
            }
        }return null;
    }
    
    
    
}
