
package modelo;


public class Zerg extends Escuadron{
    
    private int esbirros;
    private int overlords;

    public Zerg(int esbirros, int overlords, String nombre, int victorias, int nAtaque, int nDefensa) {
        super(nombre, victorias, nAtaque, nDefensa);
        this.esbirros = esbirros;
        this.overlords = overlords;
    }

    public int getEsbirros() {
        return esbirros;
    }

    public void setEsbirros(int esbirros) {
        this.esbirros = esbirros;
    }

    public int getOverlords() {
        return overlords;
    }

    public void setOverlords(int overlords) {
        this.overlords = overlords;
    }
    
    public double calcularAtaque(){
        double ataque = (0.4 * overlords) + (0.15 * esbirros) + (getnAtaque());
        return ataque;
    }
    
    public double calcularDefensa(){
        double defensa = (0.3 * esbirros) + (getnDefensa());
        return defensa;
    }
    
    
}
