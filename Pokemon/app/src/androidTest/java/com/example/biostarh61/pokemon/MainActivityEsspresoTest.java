package com.example.biostarh61.pokemon;

import android.app.Activity;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.biostarh61.pokemon.Activities.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.IsNot.not;

/**
 * Created by eduardo on 4/10/17.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityEsspresoTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<MainActivity>(MainActivity.class);
    //Test para probar que luego de presionar el boton random el cuadro de texto nombre cambia al nombre del pokemon
    @Test
    public void ensureChangeText(){
        onView(withId(R.id.btnRandom)).perform(click());

        onView(withId(R.id.pkmNameOne)).check(matches(withText("Nombre: bulbasaur")));
    }
    //Test para probar que al iniciar al aplicacion el boton de lucha no esta disponible
    @Test
    public void ensurebtnPelearIsNotClickeable(){
        onView(withId(R.id.btnFight)).check(matches(not(isEnabled())));
    }
    //Test para probar que el boton de lucha esta disponible luego de presionar el boton de random
    @Test
    public void ensurebtnPelearIsEnable(){
        onView(withId(R.id.btnRandom)).perform(click());
        onView(withId(R.id.btnFight)).check(matches(not(isEnabled())));
    }

}
