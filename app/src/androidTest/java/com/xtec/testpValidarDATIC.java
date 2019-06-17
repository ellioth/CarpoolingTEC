package com.xtec;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import android.support.test.rule.ActivityTestRule;

//espresso
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
//import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
//import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class testpValidarDATIC {

    @Rule
    public ActivityTestRule<pvalidarDATIC> mActivityRule = new ActivityTestRule<>(pvalidarDATIC.class);

    //valida que si el usuario ya esta registrado el la aplicaciones
    @Test
    public void usuarioExisteDB() {
        onView(withId(R.id.ip_id))
                .perform(typeText("20140057732"), closeSoftKeyboard());
        onView(withId(R.id.ip_contraseña))
                .perform(typeText("8789"), closeSoftKeyboard());
        onView(withId(R.id.btn_ingresar)).perform(click());
    }

    //valida que si alguno de los campos esta incompleto
    @Test
    public void TESTdatosincompletos() {
        onView(withId(R.id.ip_id))
                .perform(typeText("20140057732"), closeSoftKeyboard());
        onView(withId(R.id.ip_contraseña))
                .perform(typeText(""), closeSoftKeyboard());
        onView(withId(R.id.btn_ingresar)).perform(click());
    }


    //valida si el usuario ya existe en la base de datos
    @Test
    public void TESTusuarioInvalidoDB(){
        onView(withId(R.id.ip_id))
                .perform(typeText("2014057735"), closeSoftKeyboard());
        onView(withId(R.id.ip_contraseña))
                .perform(typeText("2789"), closeSoftKeyboard());
        onView(withId(R.id.btn_ingresar)).perform(click());
    }
}
