package com.example.livepresso;

import android.support.test.rule.ActivityTestRule;

import org.junit.Test;


/**
 * Created by niranjani on 10/8/17.
 */


@org.junit.runner.RunWith(android.support.test.runner.AndroidJUnit4.class)
    public class LoginTest {
        activities.TestLoginActivity login = new activities.TestLoginActivity();
        android.content.Context appContext = android.support.test.InstrumentationRegistry.getTargetContext();

        @org.junit.Rule
        public ActivityTestRule<LoginActivity> mActivityRule =
                new ActivityTestRule<>(LoginActivity.class);

        @org.junit.Before
        public void setup() {
       //     mActivityRule.launchActivity(null);
//        android.content.Intent intent = new android.content.Intent();
//        intent.putExtra("EXTRA", "Test");
//        mActivityRule.launchActivity(intent);
        }

    @Test
    public void testLoginSuccessful() {
        login.enterUsername("bar@example.com");
        login.enterPassword("world");
        login.clickLogin();

        login.verifyProgressView();
        login.verifySuccessToastContainer();
    }

    @Test
    public void testLoginBlank() {
        login.clickLogin();
        login.verifyRequiredWarning();
    }

    @Test
    public void testInvalidUsername() {
        login.enterUsername("bar");
        login.clickLogin();

        login.verifyInvalidEmail();
    }

    @Test
    public void testShortPassword() {
        login.enterUsername("bar@example.com");
        login.enterPassword("wo");

        login.verifyInvalidPassword();
    }

    @Test
    public void testInvalidPassword() {
        login.enterUsername("bar@example.com");
        login.enterPassword("hello");

        login.verifyIncorrectPassword();
    }

    @Test
    public void testRotateScreen() {
        login.rotateScreen();
        testLoginSuccessful();
    }

    @Test
    public void testUnregisteredUser() {
        login.enterUsername("dfsdf@gmail.com");
        login.verifyProgressView();
        login.verifyBadUserToastContainer();
    }

    @Test
    public void testRegister() {
        login.enterUsername("abc@gmail.com");
        login.clickRegister();

        // app crashes since this piece is not implemented.
    }





}
