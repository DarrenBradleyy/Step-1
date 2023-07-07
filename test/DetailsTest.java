import Java.Details;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class DetailsTest {


    @Test
    public void testPadManufacturerCode_LongManufacturerName() {
        String manufacturer = "ExampleManufacturerName";

        // Call the padManufacturerCode() method
        String paddedManufacturerCode = Details.padManufacturerCode(manufacturer);

        // Assert that the padded manufacturer code has a length of 4 characters
        Assertions.assertEquals(4, paddedManufacturerCode.length());
    }
    @Test
    public void testPadManufacturerCode_ShortManufacturerName() {
        String manufacturer = "Exam";

        String paddedManufacturerCode = Details.padManufacturerCode(manufacturer);
        Assertions.assertEquals(4, paddedManufacturerCode.length());

        Assertions.assertEquals(manufacturer.toUpperCase(), paddedManufacturerCode.replace("x", "").trim());
    }

}
