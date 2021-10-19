package com.example.myapplication;

import static android.os.Build.VERSION_CODES.LOLLIPOP;
import androidx.test.platform.app.InstrumentationRegistry;
//import androidx.test.runner.AndroidJUnitRunner;
import androidx.test.platform.app.InstrumentationRegistry;
//import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.core.app.ApplicationProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
//import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.*;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

@RunWith(RobolectricTestRunner.class)
public class ExampleUnitTest{

    @Test
    public void DatabaseTest() {
        MyDatabaseHelper m = new MyDatabaseHelper(ApplicationProvider.getApplicationContext());
        m.addEntry("test","testo","oui");
        m.addEntry("test1","testo2","oui");
        Cursor c = m.getEntry("Mot_Lang1","WHERE Mot_Lang2=\"testo\"",null);
        c.moveToFirst();
        /*while(c.isLast()!=true){

        }*/
        //Test on the number of rows
        assertEquals(2,c.getCount());
        m.close();
    }
}