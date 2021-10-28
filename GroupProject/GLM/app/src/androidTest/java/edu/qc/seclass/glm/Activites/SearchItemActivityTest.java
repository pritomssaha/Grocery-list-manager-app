package edu.qc.seclass.glm.Activites;

import android.view.View;

import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import edu.qc.seclass.glm.R;

import static org.junit.Assert.*;

public class SearchItemActivityTest {

    @Rule
    public ActivityTestRule<SearchItemActivity> searchItemActivityTestRule=new ActivityTestRule<SearchItemActivity>(SearchItemActivity.class);
    private SearchItemActivity searchItemActivity=null;
    @Before
    public void setUp() throws Exception {
        searchItemActivity=searchItemActivityTestRule.getActivity();
    }

    @Test
    public void testSearchItemActivity(){
        View v1=searchItemActivity.findViewById(R.id.searchItemTitle_tv);
        View v2=searchItemActivity.findViewById(R.id.radioItem);
        View v3=searchItemActivity.findViewById(R.id.radioType);
        View v4=searchItemActivity.findViewById(R.id.searchInput);
        View v5=searchItemActivity.findViewById(R.id.Search_Box);
        View v6=searchItemActivity.findViewById(R.id.searchCancel);
        View v7=searchItemActivity.findViewById(R.id.search_btn);

        assertNotNull(v1);
        assertNotNull(v2);
        assertNotNull(v3);
        assertNotNull(v4);
        assertNotNull(v5);
        assertNotNull(v6);
        assertNotNull(v7);

    }

    @After
    public void tearDown() throws Exception {
    }
}