package app.domain.model;

import app.domain.utils.SaveDate;
import net.sourceforge.barbecue.Barcode;


/**
 * The type Sample.
 */
public class Sample {
    private Barcode barcode;
    private String date;

    /**
     * Instantiates a new Sample.
     *
     * @param barcode the barcode
     */
    public Sample(Barcode barcode) {
        this.barcode = barcode;
        this.date= SaveDate.dataCreation();
    }

    @Override
    public String toString() {
        return "Sample{" +
                "code='" + barcode + '\'' +
                '}';
    }
}
