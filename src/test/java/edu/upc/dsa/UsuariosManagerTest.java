package edu.upc.dsa;

import edu.upc.dsa.models.PuntoInteres;
import edu.upc.dsa.models.Usuario;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class UsuariosManagerTest {

    UsuariosManagerImpl cm = (UsuariosManagerImpl) UsuariosManagerImpl.getInstance();
    Usuario u1;
    Usuario u2;

    @Before
    public void init(){
        PuntoInteres p1 = new PuntoInteres("CasillaX");
        PuntoInteres p2 = new PuntoInteres("Puerta");
        PuntoInteres p3 = new PuntoInteres("Puente");

        u1= new Usuario("Juan");
        u2= new Usuario("Maria");

        cm.añadirUsuario(u1,p2);
        cm.añadirUsuario(u1,p3);
        cm.añadirUsuario(u2,p1);

    }

    @Test
    public void test1(){
        //Test para consultar los usuarios que han pasado por un puente
        Assert.assertEquals(cm.ListaUsuariosPunto("Puente").get(0).getName(), "Juan" );
    }
    @Test
    public void test2(){
        //Test para consultar los usuarios que han pasado por menor numero de puntos de interes
        Assert.assertEquals(cm.ListaUsuariosDesc().get(0).getName(), "Maria" );
    }

    @Test
    public void test3(){
        //Test para consultar el primer usuario de la lista ordenada por nombre alf.
        Assert.assertEquals(cm.ListaUsuariosAlf().get(0).getName(), "Juan" );
    }

}
