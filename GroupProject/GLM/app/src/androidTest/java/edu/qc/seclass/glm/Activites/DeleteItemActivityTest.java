package edu.qc.seclass.glm.Activites;

import android.view.View;

import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import edu.qc.seclass.glm.R;

import static org.junit.Assert.*;

public class DeleteItemActivityTest {

    @Rule
    public ActivityTestRule<DeleteItemActivity> deleteItemActivityTestRule=new ActivityTestRule<DeleteItemActivity>(DeleteItemActivity.class);
    private DeleteItemActivity deleteItemActivity =null;

    @Before
    public void setUp() throws Exception {
        deleteItemActivity=deleteItemActivityTestRule.getActivity();
    }

    @Test
    public void testDeleteItemActivity(){
        View view1=deleteItemActivity.findViewById(R.id.homePageTitle_tv);
        View view2=deleteItemActivity.findViewById(R.id.deleteItem_rv);
        View view3=deleteItemActivity.findViewById(R.id.deleteList_btn);

        assertNotNull(view1);
        assertNotNull(view2);
        assertNotNull(view3);


    }
    @After
    public void tearDown() throws Exception {

        deleteItemActivity=null;
    }
}