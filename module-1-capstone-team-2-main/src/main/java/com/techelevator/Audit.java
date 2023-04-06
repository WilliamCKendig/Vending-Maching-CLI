package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Audit {


    public Audit() {
    }


    File destinationFile = new File("src/main/resources","Audit.txt");

    public void auditWriter(String auditLine) throws FileNotFoundException {

        try (PrintWriter writer = new PrintWriter(new FileOutputStream(this.destinationFile, true))){

            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a");
            String dateTime = LocalDateTime.now().format(dateTimeFormatter);

            writer.println(dateTime + " " + auditLine);

        }
    }



}
