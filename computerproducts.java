import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ProductDetails {

    public static void main(String[] args) {
        File file = new File("D:\\Details\\ProductDetails.txt");
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
            //Appending product id, name and price
            bw.write("Product ID: 12345");
            bw.newLine();
            bw.write("Product Name: Laptop");
            bw.newLine();
            bw.write("Product Price: 1500.00");
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
