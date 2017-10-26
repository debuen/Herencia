
package modelo;


public class Escuadron {
    
    private String nombre;
    private int victorias;
    private int nAtaque;
    private int nDefensa;

    public Escuadron(String nombre, int victorias, int nAtaque, int nDefensa) {
        this.nombre = nombre;
        this.victorias = victorias;
        this.nAtaque = nAtaque;
        this.nDefensa = nDefensa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVictorias() {
        return victorias;
    }

    public void setVictorias(int victorias) {
        this.victorias = victorias;
    }

    public int getnAtaque() {
        return nAtaque;
    }

    public void setnAtaque(int nAtaque) {
        this.nAtaque = nAtaque;
    }

    public int getnDefensa() {
        return nDefensa;
    }

    public void setnDefensa(int nDefensa) {
        this.nDefensa = nDefensa;
    }
    
    
    
    
}
