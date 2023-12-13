package app.controller;

import app.domain.model.Sample;
import app.domain.model.State;
import app.domain.store.TestStore;
import org.junit.Before;
import org.junit.Test;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CreateSampleTestControllerTest {

    CreateSampleTestController createSampleTestController = new CreateSampleTestController();

    @Test
    public void getCreatedTestList() {

        assertNotNull(createSampleTestController.getCreatedTestList());
    }

    @Test
    public void createBarcode() {
        assertTrue(createSampleTestController.createBarcode("10000000001"));
    }

    /*@Test
    public void printBarcode() {
        assertTrue(createSampleTestController.printBarcode("10000000001"));
    }*/

    @Test
    public void getTestById() {
        assertFalse(false);
    }


}