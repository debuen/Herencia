
package modelo;


public class Terran extends Escuadron{
    
    private int edificios;
    private int tecnologias;

    public Terran(int edificios, int tecnologias, String nombre, int victorias, int nAtaque, int nDefensa) {
        super(nombre, victorias, nAtaque, nDefensa);
        this.edificios = edificios;
        this.tecnologias = tecnologias;
    }

    public int getEdificios() {
        return edificios;
    }

    public void setEdificios(int edificios) {
        this.edificios = edificios;
    }

    public int getTecnologias() {
        return tecnologias;
    }

    public void setTecnologias(int tecnologias) {
        this.tecnologias = tecnologias;
    }
    
    public double calcularAtaque(){
        double ataque = (0.5 * tecnologias) + (getnAtaque());
        return ataque;
    }
    
    public double calcularDefensa(){
        double defensa = (0.25 * edificios) + (getnDefensa());
        return defensa;
    }
    
}
