package com.romanenich;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Roman on 23.12.2018.
 */
public abstract class AbstractDataLoader<T> implements DataLoader {

    private String filePath;

    public AbstractDataLoader(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<T> loadData() {
        List<T> retVal = new ArrayList<>();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(Utils.getFileByName(getClass(), filePath)))) {
            String line = fileReader.readLine();
            while (line != null) {
                retVal.add(convert(line));
                line = fileReader.readLine();
            }
        } catch (IOException | NumberFormatException e) {
            throw new AdventOfCodeException("Something went wrong", e);
        }

        return retVal;
    }

    protected abstract T convert(String line);
}
