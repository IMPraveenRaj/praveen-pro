package com.springheaven.transformx.interviewprep.memory;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class OptimalSolution {


    public static void main(String[] args) throws IOException {


        Path newPath=Path.of("newinput.txt");
        FileWriter writer=new FileWriter(newPath.toFile());
        //simulate a large file
        Path datafile = Path.of("datadump.csv");
        //Path input = Path.of("input.txt");
        Path outputFile = Path.of("output.txt");
        Path inefficient = Path.of("inefficient.txt");
        Path efficient = Path.of("efficient.txt");
        Path extremeEfficient = Path.of("ex_efficient.txt");
        Path stremeEfficient = Path.of("Stream_efficient.txt");


        //generate a large file of 100,000 line
        int no_of_lines = 100000;
        generateLargefile(datafile, no_of_lines, outputFile);


        Long start = System.currentTimeMillis();
        processTheLargeFileWriteInefficiently(datafile,inefficient);
        Long end = System.currentTimeMillis();
        long totalTime = end - start;
        System.out.println("time take to read the large file "+totalTime+" ms" );


        Long startTime1= System.currentTimeMillis();
        processTheLargeFileWriteEfficientlyReadLineByLine(datafile,efficient);
        Long endTime1 = System.currentTimeMillis();
        long totalTime1 = endTime1 - startTime1;
        System.out.println("time take to read the large file processTheLargeFileWriteEfficientlyReadLineByLine:"+totalTime1+" ms" );


        Long startTime2= System.currentTimeMillis();
        processTheLargeFileWriteEfficientlyChunks(datafile,extremeEfficient);
        Long endTime2 = System.currentTimeMillis();
        long totalTime2 = endTime2 - startTime2;
        System.out.println("time take to read the large file processTheLargeFileWriteEfficientlyChunks :"+totalTime2+" ms" );


        Long startTime3= System.currentTimeMillis();
        processLargeFileUsingStreams(datafile,extremeEfficient);
        Long endTime3 = System.currentTimeMillis();
        long totalTime3 = endTime3 - startTime3;
        System.out.println("time take to read the large file  processLargeFileUsingStreams :"+totalTime3+" ms" );




    }


    public static void processLargeFileUsingStreams(Path datafile, Path efficient) {
        try (Stream<String> lines = Files.lines(datafile);
             BufferedWriter writer = Files.newBufferedWriter(efficient)) {
            AtomicInteger lineNumber = new AtomicInteger(1);
            lines.forEach(line -> {
                try {
                    writer.write(lineNumber.getAndIncrement() + ": " + line);
                    writer.newLine();
                } catch (IOException e) {
                    throw new UncheckedIOException(e);
                }
            });

        } catch (IOException e) {
            e.printStackTrace(); // Handle or log the error properly
        }
    }


    private static void processTheLargeFileWriteEfficientlyReadLineByLine(Path datafile, Path efficient) {

        try(BufferedReader br=Files.newBufferedReader(datafile);
        BufferedWriter writer=Files.newBufferedWriter(efficient);){

            String content;
            int lineNumber = 1;
            while ((content=br.readLine()) != null) {
                writer.write(lineNumber + "_" + content);
                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("if exception occurs you can handle it ");
        }

    }

    private static void processTheLargeFileWriteEfficientlyReadLineByLineUsingBuilder(Path datafile, Path efficient) {

        try(BufferedReader br=Files.newBufferedReader(datafile);
            BufferedWriter writer=Files.newBufferedWriter(efficient);){
            String content;
            StringBuilder sb = new StringBuilder();
            int lineNumber = 1;
            while ((content=br.readLine()) != null) {
                writer.write(lineNumber + "_" + content);
                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("if exception occurs you can handle it ");
        }

    }

    public static void processTheLargeFileWriteEfficientlyChunks(Path datafile, Path efficient) {
        try (BufferedReader br = Files.newBufferedReader(datafile);
             BufferedWriter writer = Files.newBufferedWriter(efficient)) {

            char[] buffer = new char[99499];  // Use a buffer instead of line-by-line reading
            int bytesRead;

            while ((bytesRead = br.read(buffer)) != -1) {
                writer.write(buffer, 0, bytesRead);

            }
           // System.out.println(chunks);


        } catch (IOException e) {
            e.printStackTrace(); // Prints the actual error stack trace
        }
    }

    private static void processTheLargeFileWriteInefficiently(Path datafile, Path inefficient) throws IOException {


        List<String> strings = Files.readAllLines(datafile);
        System.out.println(strings.size());
        String result="";
        int lineNo=0;
        for (String line : strings) {
            result+=line+lineNo+"\n";
            lineNo++;
        }
        Files.write(inefficient, result.getBytes());
   //     System.out.println(result);

    }

    private static void generateLargefile(Path datafile, int noOfLines, Path outputFile) throws IOException {
        BufferedReader reader= new BufferedReader(new FileReader(datafile.toFile()));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(datafile.toFile()));
        BufferedWriter write2 = new BufferedWriter(new FileWriter(outputFile.toFile()));
        try {
            for (int i = 0; i < noOfLines; i++) {
                String content = "This is the line" + i + "\r\n";
                bufferedWriter.write(content);
                write2.write(content);
            }
            System.out.println("large file generated successfully" + outputFile);

        } catch (IOException e) {
            bufferedWriter.close();


        }
    }


}
