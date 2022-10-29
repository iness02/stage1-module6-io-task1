package com.epam.mjc.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class FileReader {

    public Profile getDataFromFile(File file) {

        Profile profile = new Profile();
        String line;
        List<String> value = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(file))) {
            while ((line = reader.readLine()) != null) {
                String[] keyValuePair = line.split(":", 2);
                System.out.println(Arrays.toString(keyValuePair));
                value.add(keyValuePair[1].trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        profile.setName(value.get(0));
        profile.setAge(Integer.valueOf((value.get(1))));
        profile.setEmail(value.get(2));
        profile.setPhone(Long.valueOf(value.get(3)));
        return profile;
    }
}

