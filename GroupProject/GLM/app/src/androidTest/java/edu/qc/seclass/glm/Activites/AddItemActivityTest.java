package edu.qc.seclass.glm.Activites;
import android.view.View;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import edu.qc.seclass.glm.R;

import static org.junit.Assert.*;

public class AddItemActivityTest {
    @Rule
    public ActivityTestRule<AddItemActivity> addActivityTestRule =new ActivityTestRule<AddItemActivity>(AddItemActivity.class);
    private AddItemActivity addItemActivity=null;

    @Before
    public void setUp() throws Exception {
        addItemActivity=addActivityTestRule.getActivity();
    }

    @Test
    public  void test2(){

        View view3=addItemActivity.findViewById(R.id.bycategory_radioBtn);
        View view4=addItemActivity.findViewById(R.id.byName_radioBtn);
        View view5=addItemActivity.findViewById(R.id.cartegory_rv);
        View view6=addItemActivity.findViewById(R.id.items_rv);
        View view7=addItemActivity.findViewById(R.id.backToList_btn);
        View view8=addItemActivity.findViewById(R.id.createNewItem_btn);
        View view9=addItemActivity.findViewById(R.id.addtolist);


        assertNotNull(view3);
        assertNotNull(view4);
        assertNotNull(view5);
        assertNotNull(view6);
        assertNotNull(view7);
        assertNotNull(view8);
        assertNotNull(view9);

    }

    @After
    public void tearDown() throws Exception {
        addItemActivity=null;
    }

}