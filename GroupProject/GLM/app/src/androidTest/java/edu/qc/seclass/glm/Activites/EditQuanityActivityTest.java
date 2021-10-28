package edu.qc.seclass.glm.Activites;

import android.view.View;

import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import edu.qc.seclass.glm.R;

import static org.junit.Assert.*;

public class EditQuanityActivityTest {
    @Rule
    public ActivityTestRule<EditQuanityActivity> editQuanityActivityTestRule=new ActivityTestRule<EditQuanityActivity>(EditQuanityActivity.class);
    private EditQuanityActivity editQuanityActivity=null;

    @Before
    public void setUp() throws Exception {
        editQuanityActivity=editQuanityActivityTestRule.getActivity();
    }

    @Test
    public void testEditQuanityActivity(){
        View v1=editQuanityActivity.findViewById(R.id.testTitle);
        View v2=editQuanityActivity.findViewById(R.id.editQuanity_rv);
        View v3=editQuanityActivity.findViewById(R.id.editQuanity_btn);

        assertNotNull(v1);
        assertNotNull(v2);
        assertNotNull(v3);


    }

    @After
    public void tearDown() throws Exception {
        editQuanityActivity=null;
    }
}