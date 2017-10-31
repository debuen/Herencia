
package modelo;


public class Protoss extends Escuadron{
    
    private int pilon;

    public Protoss(int pilon, String nombre, int victorias, int nAtaque, int nDefensa) {
        super(nombre, victorias, nAtaque, nDefensa);
        this.pilon = pilon;
    }

    public int getPilon() {
        return pilon;
    }

    public void setPilon(int pilon) {
        this.pilon = pilon;
    }
    
    public double calcularAtaque(){
        double ataque = (0.5 * pilon) + (getnAtaque());
        return ataque;
    }
    
    public double calcularDefensa(){
        double defensa = (0.5 * pilon) + (getnDefensa());
        return defensa;
    }
    
    
}
