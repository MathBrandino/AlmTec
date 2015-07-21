package br.com.caelum.almtec;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.test.ActivityInstrumentationTestCase2;

import org.hamcrest.Matchers;
import org.junit.Test;

/**
 * Created by matheus on 21/07/15.
 */
public class MainTest extends ActivityInstrumentationTestCase2 {
    public MainTest() {
        super(MainActivity.class);
    }

    public void teste(){
        getActivity();

        Espresso.onView(
                ViewMatchers.withId(R.id.entra_valor)
        ).perform(
                ViewActions.typeText("123")
        );

        Espresso.onView(

                ViewMatchers.withId(R.id.adiciona_valor)
        ).perform(
                ViewActions.click()
        );

        Espresso.onView(
                ViewMatchers.withId(R.id.mostra_valor)
        ).check(
                ViewAssertions.matches(
                        ViewMatchers.withText("123")
                )
        );

        Espresso.onData(
                Matchers.allOf(
                        Matchers.is(
                                Matchers.instanceOf(Integer.class)
                        )
                )
        ).atPosition(0).perform(
                ViewActions.click()
        );

        Espresso.onView(
                ViewMatchers.withId(R.id.mostra_valor)
        ).check(
                ViewAssertions.matches(
                        Matchers.not(
                                ViewMatchers.withText("123")
                        )
                )
        );
    }
}
