package edu.qc.seclass.glm.Activites;

import android.view.View;

import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import edu.qc.seclass.glm.R;

import static org.junit.Assert.*;

public class DeleteListActivityTest {
    @Rule
    public ActivityTestRule<DeleteListActivity> deleteListActivityTestRule=new ActivityTestRule<DeleteListActivity>(DeleteListActivity.class);
    private DeleteListActivity deleteListActivity=null;
    @Before
    public void setUp() throws Exception {
        deleteListActivity=deleteListActivityTestRule.getActivity();
    }
    @Test
    public void testdeleteListActivity(){
        View v1=deleteListActivity.findViewById(R.id.homePageTitle_tv);
        View v2=deleteListActivity.findViewById(R.id.deletelists_rv);
        View v3=deleteListActivity.findViewById(R.id.deleteList_btn);

        assertNotNull(v1);
        assertNotNull(v2);
        assertNotNull(v3);
    }

    @After
    public void tearDown() throws Exception {
        deleteListActivity=null;
    }
}