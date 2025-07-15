package stepDef;

import io.cucumber.java.*;

import static helper.Utility.quitDriver;
import static helper.Utility.startDriver;


public class Hooks {

    @BeforeAll
    public static void setUp() {

    }

    @AfterAll
    public static void tearDown() {

    }

    @Before
    public static void beforeTest() {
       startDriver();
    }

    @After
    public static void afterTest() {
        quitDriver();
    }

}
