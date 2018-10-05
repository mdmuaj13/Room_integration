package com.example.vaibhav.k_login;


import android.content.Intent;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;


import java.util.List;

public class dbInit {

    private static final String TAG = dbInit.class.getName();

    public static void populateAsync(@NonNull final AppDatabase db) {
        PopulateDbAsync task = new PopulateDbAsync(db);
        task.execute();
    }

    public static void populateSync(@NonNull final AppDatabase db) {
        populateWithTestData(db);
    }

    private static User addUser(final AppDatabase db, User user) {
        db.userDao().insertAll(user);
        return user;
    }

    private static void populateWithTestData(AppDatabase db) {
        User user = new User();
        user.setFirstName("md");
        user.setLastName("muaj");
        user.setEmail("iammuaj@gmail.com");
        user.setPassword("1234");
        addUser(db, user);

        List<User> userList = db.userDao().getAll();
        Log.d("data: ", String.valueOf(userList.get(1).getEmail()));
        Log.d(dbInit.TAG, "Rows Count: " + userList.size());



        // Toast.makeText( ,"Populating " + String.valueOf(userList.get(1)), Toast.LENGTH_SHORT ).show();
    }

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final AppDatabase mDb;

        PopulateDbAsync(AppDatabase db) {
            mDb = db;

        }

        @Override
        protected Void doInBackground(final Void... params) {
            populateWithTestData(mDb);
            return null;
        }

    }

     
}