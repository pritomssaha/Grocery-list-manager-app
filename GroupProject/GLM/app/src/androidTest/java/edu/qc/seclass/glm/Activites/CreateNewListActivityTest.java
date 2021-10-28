package edu.qc.seclass.glm.Activites;

import android.view.View;

import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import edu.qc.seclass.glm.R;

import static org.junit.Assert.*;

public class CreateNewListActivityTest {
    @Rule
    public ActivityTestRule<CreateNewListActivity> createNewListActivityTestRule=new ActivityTestRule<CreateNewListActivity>(CreateNewListActivity.class);
    private CreateNewListActivity createNewListActivity=null;

    @Before
    public void setUp() throws Exception {
        createNewListActivity=createNewListActivityTestRule.getActivity();
    }
    @Test
    public void testCreateNewListActivity(){

        View view1=createNewListActivity.findViewById(R.id.textTitle);
        View view2=createNewListActivity.findViewById(R.id.listNameTitle_tv);
        View view3=createNewListActivity.findViewById(R.id.listName_et);
        View view4=createNewListActivity.findViewById(R.id.createList_btn);

        assertNotNull(view1);
        assertNotNull(view2);
        assertNotNull(view3);
        assertNotNull(view4);
    }

    @After
    public void tearDown() throws Exception {
        createNewListActivity=null;
    }
}