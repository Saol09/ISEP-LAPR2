package app.domain.model;

import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.BarcodeFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class SampleTest {

    @Test
    public void testToString() {
        try {
            Barcode barcode = BarcodeFactory.createUPCA("12345678911");
            Sample sample = new Sample(barcode);
            assertEquals(sample.toString(),"Sample{code='12345678911'}");
        }catch (BarcodeException e){
            assertFalse(true);
        }
    }
}