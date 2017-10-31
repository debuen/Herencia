
package herencia;

import excepciones.ExceptionHerencia;
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
        String[] array = null;
        do{
            try{
                String opcion = br.readLine();
                array = opcion.split(" ");
                if(array[0].toUpperCase().equalsIgnoreCase("A")){
                    altaEscuadron(array);
                }else if(array[0].toUpperCase().equalsIgnoreCase("R")){
                    registrarBatalla(array);
                }else if(array[0].toUpperCase().equalsIgnoreCase("M")){
                    mejorarEscuadron(array);
                }else if(array[0].toUpperCase().equalsIgnoreCase("C")){
                    clasificacion();
                }else if(array[0].toUpperCase().equalsIgnoreCase("S")){
                    salir();
                }else{
                    System.out.println("< ERROR 004: Operación incorrecta >");
                }
            }catch(Exception e){
                
            }
        }while(!array[0].equalsIgnoreCase("S"));
        
    }

    public static void altaEscuadron(String[] array) throws ExceptionHerencia{
        
        String nombre = array[2];
        int vict = 0;
        if(isNumeric(array[3]) && isNumeric(array[4]) && isNumeric(array[5]) && isNumeric(array[6])){
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
            }else{
                System.out.println("< ERROR 002: Especie incorrecta >");
            }
            
        }else{
            System.out.println("< ERROR 003: Dato incorrecto >");
        }    
   
    }
    
    public static void registrarBatalla(String[] array){
     
        if (array.length == 3) {
  
            Escuadron e1 = buscarEscuadron(array[1]);
            Escuadron e2 = buscarEscuadron(array[2]);
            
            int gana1 = 0; int gana2 = 0;
            
            if(e1!=null && e2!=null){
                
                System.out.println("<Inicio batalla...>");
                for (int i=0;i<5;i++){
                    int random1 = (int)(Math.random()*9 +0);
                    int random2 = (int)(Math.random()*9 +0);
                    
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
                if(gana1 > gana2){
                    System.out.println("<OK: La batalla la ha ganado el escuadron " + e1.getNombre() + " con " + gana1 + " asaltos>");
                    e1.setVictorias(e1.getVictorias()+1);
                }else if(gana2 > gana1){
                    System.out.println("<OK: La batalla la ha ganado el escuadron " + e2.getNombre() + " con " + gana2 + " asaltos>");
                    e2.setVictorias(e2.getVictorias()+1);
                }
                
                else{System.out.println("<OK: La batalla ha acabado en empate>");}
                
            }else{
                System.out.println("< ERROR 005: No existe especie con ese nombre >");
            }
            
        }else{
            System.out.print("< ERROR 001: Nº de argumentos inválidos");
        }     
        
    }
    
    public static void mejorarEscuadron(String[] array){
        
        Escuadron e1 = buscarEscuadron(array[1]);
        int posEscuadron = 0;
        String espEscuadron = "";
        int pos = 0;
        
        if(array.length == 4){
            if(isNumeric(array[3])){
                if(e1 != null){
                    for(int i=0;i<escuadronList.size();i++){
                        if(escuadronList.get(i).getNombre().equalsIgnoreCase(array[1])){
                            posEscuadron = i;
                            espEscuadron = escuadronList.get(i).getClass().getSimpleName().toLowerCase();
                        }
                    }

                    if(espEscuadron.equalsIgnoreCase("terran")){

                        for(int i=0;i<terranList.size();i++){
                                if(escuadronList.get(posEscuadron).getNombre().equalsIgnoreCase(terranList.get(i).getNombre())){
                                    i = pos;
                                }
                        }

                        if(array[2].toLowerCase().equalsIgnoreCase("tecnologia")){
                                terranList.get(pos).setTecnologias(Integer.parseInt(array[3]));
                                System.out.println("<OK: Propiedad mejorada>");                            
                        }else if(array[2].toLowerCase().equalsIgnoreCase("edificios")){
                                terranList.get(pos).setEdificios(Integer.parseInt(array[3]));
                                System.out.println("<OK: Propiedad mejorada>");
                        }else{
                                System.out.println("< ERROR 006: Propiedad incorrecta>");
                        }

                    }

                    else if(espEscuadron.equalsIgnoreCase("protoss")){
                        if(array[2].toLowerCase().equalsIgnoreCase("pilones")){
                            for(int i=0;i<protossList.size();i++){
                                if(escuadronList.get(posEscuadron).getNombre().equalsIgnoreCase(protossList.get(i).getNombre())){
                                    protossList.get(i).setPilon(Integer.parseInt(array[3]));
                                    System.out.println("<OK: Propiedad mejorada>");
                                }
                            }
                        }else{
                                System.out.println("< ERROR 006: Propiedad incorrecta>");
                        }
                    }

                    else if(espEscuadron.equalsIgnoreCase("zerg")){

                        for(int i=0;i<zergList.size();i++){
                            if(escuadronList.get(posEscuadron).getNombre().equalsIgnoreCase(zergList.get(i).getNombre())){
                                  i = pos;  
                            }
                        }

                        if(array[2].toLowerCase().equalsIgnoreCase("esbirros")){                     
                                    zergList.get(pos).setEsbirros(Integer.parseInt(array[3]));
                                    System.out.println("<OK: Propiedad mejorada>");
                        }
                        else if(array[2].toLowerCase().equalsIgnoreCase("overlords")){
                                    zergList.get(pos).setOverlords(Integer.parseInt(array[3]));
                                    System.out.println("<OK: Propiedad mejorada>");       
                        }else{
                                System.out.println("< ERROR 006: Propiedad incorrecta>");
                        }
                    } 
                }

                else{
                    System.out.println("< ERROR 005: No existe especie con ese nombre >");
                }
            }else{
                System.out.println("< ERROR 003: Dato incorrecto >");
            }
        }else{
            System.out.print("< ERROR 001: Nº de argumentos inválidos >");
        }
        
    }
    
    public static void clasificacion(){
        System.out.println("< CLASIFICACION ACTUAL >");
        
        Collections.sort(escuadronList);

            int num;
            if (escuadronList.size() < 3) {
                num = 2;
            } else {
                num = escuadronList.size();
            }

            if (escuadronList.size() < 1) {
                
            } else {
                for (int i = 0; i < num; i++) {
                    System.out.println(escuadronList.get(i));
                }
            }
                    
    }
    
    public static void salir(){
        System.exit(0);
    }
    
    public static Escuadron buscarEscuadron(String nombre){
        for(Escuadron e : escuadronList){
            if(e.getNombre().equalsIgnoreCase(nombre)){
                return e;
            }
        }return null;
    }
    
    private static boolean isNumeric(String cadena){
	try {
		Integer.parseInt(cadena);
		return true;
	} catch (NumberFormatException nfe){
		return false;
	}
    }
      
}
