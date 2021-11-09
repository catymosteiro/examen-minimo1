package edu.upc.dsa;

import edu.upc.dsa.UsuariosManager;
import edu.upc.dsa.models.*;
import org.apache.log4j.Logger;

import java.util.*;

public class UsuariosManagerImpl implements UsuariosManager {

    private HashMap<String, Usuario> hmUsuarios;
    protected List<PuntoInteres> listPuntos;
    protected List<Usuario> listUsuarios;
    protected List<Usuario> listUsuarios2;

    final static Logger logger = Logger.getLogger(UsuariosManagerImpl.class);
    private static UsuariosManager instance;
    private boolean dirty=false;

    private UsuariosManagerImpl() {
        listPuntos = new ArrayList<>();
        listUsuarios = new ArrayList<>();
        listUsuarios2 = new ArrayList<>();
        hmUsuarios = new HashMap<String,Usuario>();
        logger.info("Inicio del programa");
    }

    public static UsuariosManager getInstance() {
        if (instance==null)
        {
            instance = new UsuariosManagerImpl();
        }
        return instance;
    }

    @Override
    public void añadirUsuario(Usuario u, PuntoInteres a) {
        u.setInfo("EquipoA");
        hmUsuarios.put(u.getName(),u);
        logger.info("Usuario añadido con nombre = " + u.getName());
        u.addPunto(a);
        listPuntos.add(a);
    }

    @Override
    public List<Usuario> ListaUsuariosAlf() {
        logger.info("Lista de usuarios ordenado alfabeticamente.");
        if (hmUsuarios.size()==0)
        {
            logger.warn("No hay usuarios.");
        }
        else {
            Collections.sort(listUsuarios, new Comparator<Usuario>() {
                @Override
                public int compare(Usuario m1, Usuario m2) {
                    return m1.getName().compareTo(m2.getName()) ;
                }
            });
            logger.info("El primer usuario en orden alfabetico es " + listUsuarios.get(0).getName());
        }
        return listUsuarios;
    }

    @Override
    public String InfoUsuario(Usuario u) {
        logger.info("Consulta de la informacion del usuario" + u.getName());
        return u.getInfo();
    }

    @Override
    public List<PuntoInteres> ListaPuntoInteresUsuario(Usuario u) {
        logger.info("Lista de puntos de interes del usuario" + u.getName());
        if (hmUsuarios.get(u).getListPuntos().size() == 0)
            logger.warn("No hay lista de puntos para ese usuario");
        else
            logger.info("El usuario ha pasado por un total de puntos de interes de " + hmUsuarios.get(u).getNumTotal());
        return hmUsuarios.get(u).getListPuntos();
    }

    @Override
    public List<PuntoInteres> ListaPuntoInteres() {
       return listPuntos;
    }

    @Override
    public List<Usuario> ListaUsuariosPunto(String punto) {
        logger.info("Lista de usuarios que pasan por el puntos de int."+ punto);
        if (hmUsuarios.size()==0)
        {
            logger.warn("No hay usuarios.");
        }
        else {
            for (int i = 0; i < hmUsuarios.size(); i++) {
                for (int j = 0; i < hmUsuarios.get(i).getListPuntos().size(); i++) {
                    if (punto == hmUsuarios.get(i).getListPuntos().get(j).getTipo()) {
                        listUsuarios2.add(hmUsuarios.get(i));
                    }
                }
            }
        }
        return listUsuarios2;
    }

    @Override
    public List<Usuario> ListaUsuariosDesc() {
        logger.info("Lista de usuarios ordenado desc. por el numero de puntos de int.");
        if (hmUsuarios.size()==0)
        {
            logger.warn("No hay usuarios.");
        }
        else {
            Collections.sort(listUsuarios, new Comparator<Usuario>() {
                @Override
                public int compare(Usuario m1, Usuario m2) {
                    return m2.getNumTotal() - m1.getNumTotal();
                }
            });
            logger.info("El usuario con menos puntos de interes es" + listUsuarios.get(0).getName());
        }
        return listUsuarios;
    }
    public void dirty() {
        this.dirty = true;
    }
    public boolean isDirty(){
        return dirty;
    }
    public void clear(){
        listUsuarios2.clear();
        listUsuarios.clear();
        hmUsuarios.clear();
        listPuntos.clear();
    }
}