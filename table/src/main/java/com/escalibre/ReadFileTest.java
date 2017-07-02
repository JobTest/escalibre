package com.escalibre;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadFileTest {

    public static void main(String[] args) throws IOException {
        try {
            BufferedReader bufferedMaleNames = new BufferedReader(new FileReader("male_names.txt")),
                    bufferedFemaleNames = new BufferedReader(new FileReader("female_names.txt"));
            String name = null;

            while ((name = bufferedMaleNames.readLine()) != null)
                System.out.println(name);

//            while ((name = bufferedFemaleNames.readLine()) != null)
//                System.out.println(name);
        } catch (IOException e) { e.printStackTrace(); }

    }

}
