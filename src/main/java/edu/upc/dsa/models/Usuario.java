package edu.upc.dsa.models;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private String name;
    private String info;
    private int numtotal;
    private List<PuntoInteres> listPuntos = new ArrayList<>();
    public Usuario(String name) {
        this.name = name;
    }
    public Usuario() {
    }

    public void addPunto(PuntoInteres s)
    {
        listPuntos.add(s);
        this.numtotal ++;
    }

    public int getNumTotal() {
        return numtotal;
    }

    public void setNumtotal(int a) {
        this.numtotal = a;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInfo(String i) {
        this.info = i;
    }

    public String getInfo() {
        return info;
    }

    public List<PuntoInteres> getListPuntos() {
        return listPuntos;
    }

    public void setListPuntos(List<PuntoInteres> ls) {
        this.listPuntos = ls;
    }

    public String toString() {
        return "Usuario [Nombre= "+name+ " info "+ info+"]";
    }
}
