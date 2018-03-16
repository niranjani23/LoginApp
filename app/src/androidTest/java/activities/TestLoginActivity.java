package activities;

/**
 * Created by niranjani on 10/8/17.
 */

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import com.example.livepresso.R;

public class TestLoginActivity {

    // Initialize UiDevice instance
    android.support.test.uiautomator.UiDevice mDevice =
            android.support.test.uiautomator.UiDevice.getInstance(android.support.
                    test.InstrumentationRegistry.getInstrumentation());

        public TestLoginActivity() {
            // verify if the email form loads
            onView(withId(R.id.email_login_form)).check(matches(isDisplayed()));
        }

        public void enterUsername(String username) {
            onView(withId(R.id.email)).check(matches(isDisplayed()));
            onView(withId(com.example.livepresso.R.id.email)).perform(replaceText(username));
        }

        public void enterPassword(String password) {
            onView(withId(R.id.password)).check(matches(isDisplayed()));
            onView(withId(R.id.password)).perform(replaceText(password));
        }

        public void clickLogin() {
            onView(withId(R.id.sign_in)).check(matches(isDisplayed()));
            onView(withId(R.id.sign_in)).perform(click());
        }

        public void clickRegister() {
            onView(withId(R.id.register)).check(matches(isDisplayed()));
            onView(withId(R.id.register)).perform(click());
        }

        public void verifyProgressView() {
            onView(withId(R.id.login_progress)).check(matches(isDisplayed()));
        }
        public void verifyIncorrectPassword() {
            onView(withText(R.string.error_incorrect_password)).check(matches(isDisplayed()));
        }

        public void verifyInvalidPassword() {
            onView(withText(R.string.error_invalid_password)).check(matches(isDisplayed()));
        }

        public void verifyInvalidEmail() {
            onView(withText(R.string.error_invalid_email)).check(matches(isDisplayed()));
        }

        public void verifySuccessToastContainer() {
            onView(withText(R.string.toast_positive)).check(matches(isDisplayed()));
            onView(withId(R.id.success)).check(matches(withText("You typed the " +
                    "right thing mate!"))).check(matches(isDisplayed()));
        }

        public void verifyBadUserToastContainer() {
            onView(withText(R.string.toast_negative)).check(matches(isDisplayed()));
        }

        public void verifyRequiredWarning() {
            onView(withText(R.string.error_field_required)).check(matches(isDisplayed()));
        }

        public void rotateScreen() {
            try {
                // rotate emulator
                mDevice.setOrientationRight();
            } catch (android.os.RemoteException e) {
                e.printStackTrace();
            }
        }

}
