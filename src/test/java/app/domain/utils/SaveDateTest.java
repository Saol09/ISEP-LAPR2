package app.domain.utils;

import org.junit.Test;

import java.sql.DatabaseMetaData;

import static org.junit.Assert.*;

public class SaveDateTest {

    @Test
    public void dataCreation() {
        assertNotNull(SaveDate.dataCreation());
    }
}