package com.itvdn.javaProfessional.ex_004_JSON.JSON;

import com.google.gson.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Try {

    public static final Path PATH = Paths.get("./Query.json");

    public static void main(String[] args) throws IOException {

//        writeToFile();

//read file
        BufferedReader reader = Files.newBufferedReader(PATH);

        Query query1 = new Gson().fromJson(reader, Query.class);

        System.out.println(query1);

    }

    public static void writeToFile() throws IOException {

        Query query = new Query(10, "now", "ukr");
//write file
        try (Writer writer = Files.newBufferedWriter(PATH)) {

            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            JsonElement tree = gson.toJsonTree(query);
            gson.toJson(tree, writer);
        }
    }
}

