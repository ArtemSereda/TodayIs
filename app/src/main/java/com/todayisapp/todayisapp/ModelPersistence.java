package com.todayisapp.todayisapp;

import android.content.SharedPreferences;

public class ModelPersistence {


    /**
     * After calling this method, model {@code m} will be initialized from these preferences,
     * plus any changes to the model will be automatically written back to the preferences.
     *
     * @param m
     * @param sharedPreferences
     */
    public static void persistModel(final Model m, final SharedPreferences sharedPreferences) {

        loadModel(m, sharedPreferences);

        m.onChange(new Runnable() {
            @Override
            public void run() {
                saveModel(m, sharedPreferences);
            }
        });
    }

    private static void saveModel(Model m, SharedPreferences sharedPreferences) {
        // todo DOMASHKA

        // Inspect other parts of the app
        // Figure out how we saved and loaded values from/to shared preferences
        // Do the same here.
    }

    private static void loadModel(Model m, SharedPreferences sharedPreferences) {
    }
}
