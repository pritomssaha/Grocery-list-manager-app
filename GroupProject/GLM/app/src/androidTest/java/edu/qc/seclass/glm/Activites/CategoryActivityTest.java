package edu.qc.seclass.glm.Activites;
import android.view.View;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import edu.qc.seclass.glm.R;

import static org.junit.Assert.*;

public class CategoryActivityTest {
    @Rule
    public ActivityTestRule<CategoryActivity> categoryActivityTestRule=new ActivityTestRule<>(CategoryActivity.class);
    private CategoryActivity categoryActivity=null;

    @Before
    public void setUp() throws Exception {
        categoryActivity=categoryActivityTestRule.getActivity();
    }

    @Test
    public void testCategoryActivity(){
        View view1=categoryActivity.findViewById(R.id.cartegory_rv);
        View view2=categoryActivity.findViewById(R.id.confirmCatagory);
        View view3=categoryActivity.findViewById(R.id.addnewcat);

        assertNotNull(view1);
        assertNotNull(view2);
        assertNotNull(view3);

    }

    @After
    public void tearDown() throws Exception {
        categoryActivity=null;
    }
}