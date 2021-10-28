package edu.qc.seclass.glm.Activites;

import android.view.View;

import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import edu.qc.seclass.glm.R;

import static org.junit.Assert.*;

public class HomeActivityTest {

    @Rule
    public ActivityTestRule<HomeActivity> homeActivityTestRule= new ActivityTestRule<HomeActivity>(HomeActivity.class);
    private HomeActivity homeActivity=null;

    @Before
    public void setUp() throws Exception {
        homeActivity=homeActivityTestRule.getActivity();
    }

    @Test
    public void testHomeActivityTest(){
        View v1=homeActivity.findViewById(R.id.homePageTitle_tv);
        View v2=homeActivity.findViewById(R.id.userLists_tv);
        View v3=homeActivity.findViewById(R.id.lists_rv);
        View v4=homeActivity.findViewById(R.id.newList_btn);
        View v5=homeActivity.findViewById(R.id.deleteList_btn);

        assertNotNull(v1);
        assertNotNull(v2);
        assertNotNull(v3);
        assertNotNull(v4);
        assertNotNull(v5);



    }

    @After
    public void tearDown() throws Exception {
        homeActivity=null;
    }
}