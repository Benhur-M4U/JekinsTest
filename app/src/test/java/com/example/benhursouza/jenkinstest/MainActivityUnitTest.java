package com.example.benhursouza.jenkinstest;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
//@RunWith(RobolectricTestRunner.class)
//@Config(constants = BuildConfig.class)
public class MainActivityUnitTest {

//    private TextView txt;
//    private Button button;

    @Test
    public void additionIsCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }



//    @Before
//    public void setUp() {
//        MainActivity activity = Robolectric.setupActivity(MainActivity.class);
//        button = (Button) activity.findViewById(R.id.btn);
//        txt = (TextView) activity.findViewById(R.id.txt_nome);
//    }
//
//    @Test
//    public void metodoSomar() {
//        button.performClick();
//        assertEquals(txt.getText().toString(),"4");
//    }
}