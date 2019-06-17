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

public class TESTagregarInfo {
    @Rule
    public ActivityTestRule<pregistarse> mActivityRule = new ActivityTestRule<>(pregistarse.class);

    //valida que si alguno de los campos esta incompleto
    public void TESTdatosIncompletos() {
        onView(withId(R.id.ip_Nombre))
                .perform(typeText("María"), closeSoftKeyboard());
        onView(withId(R.id.ip_PA))
                .perform(typeText("Rojas"), closeSoftKeyboard());
        onView(withId(R.id.ip_SA))
                .perform(typeText("Gonzalez"), closeSoftKeyboard());
        onView(withId(R.id.ip_correo))
                .perform(typeText(""), closeSoftKeyboard());
        onView(withId(R.id.ip_telefono))
                .perform(typeText("87891153"), closeSoftKeyboard());
        onView(withId(R.id.btn_ingresar)).perform(click());
    }
}