package edu.qc.seclass.glm.Activites;

import android.view.View;

import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import edu.qc.seclass.glm.R;

import static org.junit.Assert.*;

public class CreateItemActivityTest {
    @Rule
    public ActivityTestRule<CreateItemActivity> createItemActivityTestRule=new ActivityTestRule<>(CreateItemActivity.class);
    private CreateItemActivity createItemActivity=null;

    @Before
    public void setUp() throws Exception {
        createItemActivity=createItemActivityTestRule.getActivity();
    }
    @Test
    public void testCreateItemActivity(){
        View view1=createItemActivity.findViewById(R.id.itemText);
        View view2=createItemActivity.findViewById(R.id.itemName);
        View view3=createItemActivity.findViewById(R.id.itemName_et);
        View view4=createItemActivity.findViewById(R.id.confirmItemName);

        assertNotNull(view1);
        assertNotNull(view2);
        assertNotNull(view3);
        assertNotNull(view4);
    }

    @After
    public void tearDown() throws Exception {
        createItemActivity=null;
    }
}