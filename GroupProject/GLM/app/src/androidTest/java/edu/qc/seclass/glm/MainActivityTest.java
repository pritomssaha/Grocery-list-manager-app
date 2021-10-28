package edu.qc.seclass.glm;

import android.view.View;

import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule=new ActivityTestRule<MainActivity>(MainActivity.class);
    private MainActivity mActivity=null;

    @Before
    public void setUp() throws Exception {
        mActivity=mActivityTestRule.getActivity();
    }

    @Test
    public void testLaunch(){
        View view1=mActivity.findViewById(R.id.textView);
        View view2=mActivity.findViewById(R.id.email_et);
        View view3=mActivity.findViewById(R.id.password_et);
        View view4=mActivity.findViewById(R.id.login_btn);
        View view5=mActivity.findViewById(R.id.signup_btn);
        assertNotNull(view1);
        assertNotNull(view2);
        assertNotNull(view3);
        assertNotNull(view4);
        assertNotNull(view5);

    }

    @After
    public void tearDown() throws Exception {
        mActivity=null;
    }
}