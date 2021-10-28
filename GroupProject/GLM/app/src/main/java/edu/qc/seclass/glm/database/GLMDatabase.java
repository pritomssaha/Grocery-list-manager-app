package edu.qc.seclass.glm.database;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import edu.qc.seclass.glm.database.schema.GroceryItem;
import edu.qc.seclass.glm.database.schema.GroceryList;
import edu.qc.seclass.glm.database.schema.Item;
import edu.qc.seclass.glm.database.schema.ItemType;

@Database(entities = {GroceryList.class, GroceryItem.class, Item.class, ItemType.class}, version = 1, exportSchema = false)
public abstract class GLMDatabase extends RoomDatabase {
    public abstract GLMDao glmDao();

    private static volatile GLMDatabase database;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public synchronized static GLMDatabase getDatabase(Context context) {
        // FIXME: Reset Database for testing
        // Do not touch the below
                context.deleteDatabase("glm_database"); // REMOVE BEFORE PRODUCTION -- RESETS Database
        if (database == null) {
            database = Room.databaseBuilder(context.getApplicationContext(),
                    GLMDatabase.class, "glm_database")
                    .addCallback(callback)
                    .build();
        }

        return database;
    }

    private static final RoomDatabase.Callback callback = new RoomDatabase.Callback(){

        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            Log.i("Initialized APP", "Initialized APP");
            databaseExecutor.execute(()->{
                GLMDao dao = database.glmDao();
                dao.addType(new ItemType("type 1"));
                dao.addType(new ItemType("type 2"));
                dao.addType(new ItemType("type 3"));

                dao.addItem(new Item("item a1", 1));
                dao.addItem(new Item("item a2", 1));
                dao.addItem(new Item("item b1", 2));
                dao.addItem(new Item("item b2", 2));
                dao.addItem(new Item("item c1", 3));
                dao.addItem(new Item("item c2", 3));

                dao.addList(new GroceryList("List 1"));
                dao.addList(new GroceryList("List 2"));

                dao.addGroceryItem(new GroceryItem(1,1, 1,"item a1", "Type 1"));
                dao.addGroceryItem(new GroceryItem(1,2,1, "item a2", "Type 1"));
                dao.addGroceryItem(new GroceryItem(2,2, 1,"item a1", "Type 1"));
                dao.addGroceryItem(new GroceryItem(2,3, 2,"item b1", "Type 2"));
            });
        }

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            Log.i("12345", "haha");
            databaseExecutor.execute(()->{
                GLMDao dao = database.glmDao();
            });
        }
    };
}