package com.max.sample;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.TypeFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        FileInputStream fileStream = null;
        try {
            fileStream = new FileInputStream("src/main/resources/students.json");

            ObjectMapper mapper = new ObjectMapper();
            List<Student> list = mapper.readValue(fileStream,
                    TypeFactory.defaultInstance().constructCollectionType(List.class, Student.class));

            Collections.sort(list);
            printStudents(list);
        } catch (FileNotFoundException e) {
            System.out.println("Input file not found");
        } catch (IOException e) {
            System.out.println("Something bad has happened");
            e.printStackTrace();
        } finally {
            closeQuietly(fileStream);
        }
    }

    private static void printStudents(List<Student> studentList) {
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    private static void closeQuietly(FileInputStream fileStream) {
        if (fileStream != null) {
            try {
                fileStream.close();
            } catch (IOException e) {
                // Don't do anything here
            }
        }
    }

}
