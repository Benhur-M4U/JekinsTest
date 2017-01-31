package com.example.benhursouza.jenkinstest;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import junit.framework.Assert;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by benhur.souza on 27/01/2017.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
//    private String mStringToBetyped;

    @Rule
    public ActivityTestRule<MainActivity> menuActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        assertEquals("com.example.benhursouza.jenkinstest", appContext.getPackageName());
    }


//    @Before
//    public void initValidString() {
        // Specify a valid string.
//        mStringToBetyped = "5";
//    }

    @Test
    public void changeTextSameActivity() {
        // Type text and then press the button.
//        onView(withId(R.id.t))
//                .perform(typeText(mStringToBetyped), closeSoftKeyboard());
        onView(withId(R.id.btn)).perform(click());

        // Check that the text was changed.
        onView(withId(R.id.txt_nome))
                .check(matches(withText("5")));

        Assert.assertEquals(4, 2 + 2);
    }


}
