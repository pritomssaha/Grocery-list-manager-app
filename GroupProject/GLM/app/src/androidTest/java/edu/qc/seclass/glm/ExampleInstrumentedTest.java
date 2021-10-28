package edu.qc.seclass.glm;

import android.content.Context;
import android.content.Intent;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.LiveData;
import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.jraska.livedata.TestObserver;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.List;

import edu.qc.seclass.glm.database.GLMDao;
import edu.qc.seclass.glm.database.GLMDatabase;
import edu.qc.seclass.glm.database.schema.GroceryItem;
import edu.qc.seclass.glm.database.schema.GroceryList;
import edu.qc.seclass.glm.database.schema.Item;
import edu.qc.seclass.glm.database.schema.ItemType;
import edu.qc.seclass.glm.database.schema.User;


import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 **/



@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Rule
    public InstantTaskExecutorRule testRule = new InstantTaskExecutorRule();

    private GLMDao glmDao;
    private GLMDatabase db;

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("edu.qc.seclass.glm", appContext.getPackageName());

    }

    @Before
    public void createDb() {
        Context context = ApplicationProvider.getApplicationContext();
        db = Room.inMemoryDatabaseBuilder(context, GLMDatabase.class).build();
        glmDao = db.glmDao();
    }

    @After
    public void closeDb() throws IOException {
        db.close();
    }

    @Test()
    public void TestDatabaseInsertAndRetrieve() throws Exception {
        glmDao.addType(new ItemType("type 1"));

        glmDao.addItem(new Item("item a1", 1));

        glmDao.addList(new GroceryList("List 1"));

        glmDao.addGroceryItem(new GroceryItem(1,1));

        TestObserver.test(glmDao.getItem(1))
                .awaitValue()
                .assertHasValue()
                .assertValue(value -> value.getItemId() == 1);

    }
    @Test
    public void OpenAppContext() {
        // Context of the app under test.
        Context context = ApplicationProvider.getApplicationContext();
        Intent intent=new Intent(context,MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);

    }
    @Test
    public void UserAPPlISTContext() {
        // Context of the app under test.
        glmDao.addList(new GroceryList("List 1"));
        glmDao.addList(new GroceryList("List 2"));
        glmDao.addList(new GroceryList("List 3"));

    }

    @Test
    public void itemContext() {
        // Context of the app under test.
        glmDao.addItem(new Item("List 1",1));
        glmDao.addItem(new Item("List 2",2));
        glmDao.addItem(new Item("List 3",3));
    }

    @Test
    public void searchitemContext() {
        // Context of the app under test.
        LiveData<List<Item>> ddd= glmDao.getItemsByName("List 1");
    }
    
    @Test
    public void createALLlistContext() {
        // Context of the app under test.
        glmDao.addList(new GroceryList("List 1"));
        glmDao.addList(new GroceryList("List 2"));
        glmDao.addList(new GroceryList("List 3"));
    }
}

