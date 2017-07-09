package com.acme.a3csci3130;

import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.acme.a3csci3130.Action.textIsVisible;
import static com.acme.a3csci3130.R.id.listView;
import static org.hamcrest.Matchers.allOf;

/**
 * Created by Reid on 7/9/2017.
 */

public class CreateNewBusinessTest extends Action {
    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void createBusiness() throws InterruptedException {
        int size;
        clickItemWithId(R.id.submitButton);
        type(R.id.businessNumber, "123456789");
        type(R.id.name, "test");
        type(R.id.primaryBusiness, "fisher");
        type(R.id.address, "123 test street");
        Espresso.closeSoftKeyboard();
        type(R.id.province, "NS");
        Espresso.closeSoftKeyboard();
        clickItemWithId(R.id.submitButton);
    }

}
