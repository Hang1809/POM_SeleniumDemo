package com.logigear.dataObjects.invalidPass;

import com.logigear.common.CSVUtils;

import java.util.ArrayList;
import java.util.List;

public class InvalidPassService {

    public List<InvalidPass> getInvalidPassData() {
        List<InvalidPass> invalidPass = new ArrayList<>();
        List<String> records = CSVUtils.readData(CSVUtils.path);
        for (String record : records) {
            if (!record.trim().isEmpty())
                invalidPass.add(new InvalidPass(record));
        }
        return invalidPass;
    }

    public List<InvalidPass> getInvalidPassById(int id) {
        List<InvalidPass> invalidPass = getInvalidPassData();
        for (InvalidPass invalidPass1 : invalidPass) {
            if (invalidPass1.getId() == id)
                return invalidPass;
        }
        return null;
    }

}



