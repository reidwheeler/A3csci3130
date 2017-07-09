package com.acme.a3csci3130;

import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.acme.a3csci3130.Action.clickFirstOnList;
import static com.acme.a3csci3130.Action.clickItemWithId;
import static com.acme.a3csci3130.Action.textInListIsVisible;
import static com.acme.a3csci3130.Action.type;
import static com.acme.a3csci3130.R.id.listView;
import static com.acme.a3csci3130.R.id.list_item;
import static com.acme.a3csci3130.R.id.name;
import static com.acme.a3csci3130.R.id.primaryBusiness;
import static com.acme.a3csci3130.R.id.updateButton;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.is;

/**
 * Created by Reid on 7/9/2017.
 */

public class UpdateBusinessTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void updateBusiness() throws InterruptedException {
        clickItemWithId(R.id.submitButton);
        type(R.id.businessNumber, "123456789");
        type(R.id.name, "test");
        type(R.id.primaryBusiness, "fisher");
        type(R.id.address, "123 test street");
        Espresso.closeSoftKeyboard();
        type(R.id.province, "NS");
        Espresso.closeSoftKeyboard();
        clickItemWithId(R.id.submitButton);
        Thread.sleep(1000);
        clickFirstOnList(listView);
        onView(allOf(withClassName(endsWith("EditText")), withId(is(primaryBusiness)))).perform(replaceText("fish monger"));
        onView(allOf(withClassName(endsWith("EditText")), withId(is(name)))).perform(replaceText("updated test"));
        clickItemWithId(updateButton);
        textInListIsVisible("updated test",listView,0);
    }
}
