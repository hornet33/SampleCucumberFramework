package dataProviders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import managers.FileReaderManager;
import testDataTypes.CustomerType;

public class JsonDataReader {
    private final String customerFilePath = FileReaderManager.getInstance().getConfigReader().getTestDataPath() +
            "CustomerDetails.json";
    private List<CustomerType> customerList;

    public JsonDataReader() {
        customerList = getCustomerData();
    }

    private List<CustomerType> getCustomerData() {
        Gson gson = new Gson();
        BufferedReader bufferReader = null;
        try {
            bufferReader = new BufferedReader(new FileReader(customerFilePath));
            CustomerType[] customers = gson.fromJson(bufferReader, CustomerType[].class);
            return Arrays.asList(customers);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Json file not found at path : " + customerFilePath);
        } finally {
            try {
                if (bufferReader != null) bufferReader.close();
            } catch (IOException ignore) {
            }
        }
    }

    public final CustomerType getCustomerByName(String customerName) {
        for (CustomerType customer : customerList) {
            if (customer.firstName.equalsIgnoreCase(customerName)) return customer;
        }
        return null;
    }
}