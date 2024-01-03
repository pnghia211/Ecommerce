package tests_data;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;

public class DataObjectBuilder {
    public static <T> T buildDataObject(String filePath, Class<T> dataType) {
        T dataObject;
        String absolutePath = System.getProperty("user.dir").concat(filePath);

        try (
                Reader reader = Files.newBufferedReader(Paths.get(absolutePath));
        ) {
            Gson gson = new Gson();
            dataObject = gson.fromJson(reader, dataType);

        } catch (NoSuchFileException noSuchExpection) {
            throw new RuntimeException("[ERR] cannot locate " + absolutePath);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
        return dataObject;
    }
}
