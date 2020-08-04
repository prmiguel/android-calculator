package com.github.prmiguel.android.calculator;

import android.widget.Button;
import android.widget.TextView;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.SmallTest;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import com.robotium.solo.Solo;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@SmallTest
public class CalculatorInstrumentedTest {

    @Rule
    public ActivityTestRule<CalculatorActivity> activityRule =
            new ActivityTestRule<>(CalculatorActivity.class);

    private Solo solo;

    @Before
    public void setup() {
        solo = new Solo(InstrumentationRegistry.getInstrumentation(),
                activityRule.getActivity());
    }

    @After
    public void teardown() {
        solo.finishOpenedActivities();
    }

    @Test
    public void AdditionNumbersOfOneDigit() {
        solo.unlockScreen();
        Button one = (Button) solo.getView(R.id.number1);
        Button add = (Button) solo.getView(R.id.addition);
        Button seven = (Button) solo.getView(R.id.number7);
        Button equals = (Button) solo.getView(R.id.equals);
        TextView result = (TextView) solo.getView(R.id.textView4);

        solo.clickOnView(one);
        solo.clickOnView(add);
        solo.clickOnView(seven);
        solo.clickOnView(equals);
        String actualResult = result.getText().toString();

        Assert.assertEquals("8", actualResult);
    }
}