package edu.upc.dsa.models;


public class PuntoInteres {

    private String tipo;
    private int numPuertas;
    private int numCasillasX;
    private int numCasillasY;
    private int numPuentes;

    public PuntoInteres( String t) {

        this.tipo = t;
        if (t == "Puerta"){
            this.numPuertas++;
        }
        if (t == "CasillaX"){
            this.numCasillasX++;
        }
        if (t == "CasillaY"){
            this.numCasillasY++;
        }
        if (t == "Puente"){
            this.numPuentes++;
        }
    }
    public PuntoInteres() {
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String a) {
        this.tipo = a;
    }

    public int getNumPuertas() {
        return numPuertas;
    }

    public void setNumPuertas(int a) {
        this.numPuertas = a;
    }

    public int getNumCasillasX() {
        return numCasillasX;
    }

    public void setNumCasillasX(int a) {
        this.numCasillasX = a;
    }

    public int getNumCasillasY() {
        return numCasillasY;
    }

    public void setNumCasillasY(int a) {
        this.numCasillasY = a;
    }

    public int getNumPuentes() {
        return numPuentes;
    }

    public void setNumPuentes(int a) {
        this.numPuentes = a;
    }

    public String toString() {
        return "Puntos de interes [puertas = " + numPuertas + " casillasX = " + numCasillasX + " casillasY = " + numCasillasY + " puentes = " + numPuentes +"]";
    }

}
