import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import Java.ProductCatalogue;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ProductCatalogueTest {

    @Test
    public void testSaveProductCodeToFile() {
        String productCode = "ABC123";
        String filePath = "C:/uni files/cs112/src/TextFiles/product_codes.txt";
        ProductCatalogue.saveProductCodeToFile(productCode);
        ArrayList<String> savedProductCodes = readProductCodesFromFile(filePath);
        Assertions.assertTrue(savedProductCodes.contains(productCode));
    }

    private ArrayList<String> readProductCodesFromFile(String filePath) {
        ArrayList<String> productCodes = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                productCodes.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading product codes from file: " + e.getMessage());
        }

        return productCodes;
    }
}
