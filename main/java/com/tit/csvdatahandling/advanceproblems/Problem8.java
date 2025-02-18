package com.tit.csvdatahandling.advanceproblems;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

    class CryptoUtils {
    private static final String ALGORITHM = "AES";
    private static final byte[] KEY = "MySuperSecretKey".getBytes(); // 16-byte key

    public static String encrypt(String data) throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(KEY, ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedData = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encryptedData);
    }

    public static String decrypt(String encryptedData) throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(KEY, ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decodedData = Base64.getDecoder().decode(encryptedData);
        byte[] decryptedData = cipher.doFinal(decodedData);
        return new String(decryptedData);
    }
}

public class Problem8 {
    public static void main(String[] args) throws IOException, Exception {
        String csvFilePath = "C:\\Users\\patha\\OneDrive\\Desktop\\Week5_Day1\\src\\main\\resources\\CSV15.txt";

        String[] header = {"EmployeeID", "Name", "Department", "Salary", "Email"};
        String[][] data = {
                {"1", "Rajan Singh", "Engineering", "75000.00", "singhRajan.doe@example.com"},
                {"2", "Dev Datt", "Marketing", "68000.00", "datt.dev@example.com"}
        };

        try (CSVWriter writer = new CSVWriter(new FileWriter(csvFilePath))) {
            writer.writeNext(header);

            for (String[] row : data) {
                row[3] = CryptoUtils.encrypt(row[3]); // Encrypt Salary
                row[4] = CryptoUtils.encrypt(row[4]); // Encrypt Email
                writer.writeNext(row);
            }

            System.out.println("CSV file with encrypted data written successfully.");
        }
    }
}

