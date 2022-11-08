package com.logigear.common.constant;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CSVUtils {
    public static List<String> readData(String path) throws IllegalArgumentException {
        try{
            return Files.readAllLines(Paths.get(path));
        }catch (IOException e){
            throw new IllegalArgumentException(path + "invalid");
        }
    }
}
