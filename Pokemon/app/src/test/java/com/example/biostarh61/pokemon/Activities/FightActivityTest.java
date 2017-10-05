package com.example.biostarh61.pokemon.Activities;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by eduardo on 4/10/17.
 */
public class FightActivityTest {
    //aplicando test a el metodo setLife de la actividad FightActivity
    //el metodo obtiene dos entradas enteras y retorna un numero entero
    @Test
    public void setLife() throws Exception {
        int expected = 10;
        int inputLife=20, inputDamage=10;
        int output;
        FightActivity salida = new FightActivity();
        output = salida.setLife(inputLife,inputDamage);
        assertEquals(expected,output);
    }

}