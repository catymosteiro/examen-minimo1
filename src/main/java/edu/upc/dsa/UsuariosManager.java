package edu.upc.dsa;

import edu.upc.dsa.models.Usuario;
import edu.upc.dsa.models.PuntoInteres;

import java.util.List;

public interface UsuariosManager {


    public void añadirUsuario(Usuario u, PuntoInteres a);
    public List<Usuario> ListaUsuariosAlf();
    public String  InfoUsuario (Usuario u);
    public List<PuntoInteres> ListaPuntoInteresUsuario(Usuario u);
    public List<PuntoInteres> ListaPuntoInteres();
    public List<Usuario> ListaUsuariosPunto(String punto);
    public List<Usuario> ListaUsuariosDesc();
    public void clear();
    public void dirty();
    public boolean isDirty();
    /*
    public void deleteTrack(String id);
    public Track updateTrack(Track t);
    public int size();
 */
}
