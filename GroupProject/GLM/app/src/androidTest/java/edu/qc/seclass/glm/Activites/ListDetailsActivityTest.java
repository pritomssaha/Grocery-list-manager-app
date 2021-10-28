package edu.qc.seclass.glm.Activites;

import android.view.View;

import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import edu.qc.seclass.glm.R;

import static org.junit.Assert.*;

public class ListDetailsActivityTest {

    @Rule
    public ActivityTestRule<ListDetailsActivity> listDetailsActivityTestRule=new ActivityTestRule<ListDetailsActivity>(ListDetailsActivity.class);
    private ListDetailsActivity listDetailsActivity=null;

    @Before
    public void setUp() throws Exception {
        listDetailsActivity=listDetailsActivityTestRule.getActivity();
    }

    @Test
    public void testListDetailsActivityTest(){
        View v1=listDetailsActivity.findViewById(R.id.listDetailsTitle_tv);
        View v2=listDetailsActivity.findViewById(R.id.bycategory_radioBtn);
        View v3=listDetailsActivity.findViewById(R.id.byName_radioBtn);
        View v4=listDetailsActivity.findViewById(R.id.item_rv);
        View v5=listDetailsActivity.findViewById(R.id.deleteItem_btn);
        View v6=listDetailsActivity.findViewById(R.id.editQuanity_btn);
        View v7=listDetailsActivity.findViewById(R.id.userLists_btn);
        View v8=listDetailsActivity.findViewById(R.id.addItem_btn);
        View v9=listDetailsActivity.findViewById(R.id.selectAll_btn);
        View v10=listDetailsActivity.findViewById(R.id.unSlectAll_btn);

        assertNotNull(v1);
        assertNotNull(v2);
        assertNotNull(v3);
        assertNotNull(v4);
        assertNotNull(v5);
        assertNotNull(v6);
        assertNotNull(v7);
        assertNotNull(v8);
        assertNotNull(v9);
        assertNotNull(v10);
    }

    @After
    public void tearDown() throws Exception {
        listDetailsActivity=null;
    }
}