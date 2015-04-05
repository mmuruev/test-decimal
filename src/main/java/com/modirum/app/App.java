package com.modirum.app;

import java.io.BufferedWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Hello world!
 */
public class App {

    /**
     * Scale value
     */
    private static final int SCALE_BIG_DECIMAL = 3;

    /**
     * Amount of elements in output
     */
    private static final int RANDOM_ELEMENTS_AMOUNT = 10000;

    /**
     * Minimal output value
     */
    private static final BigDecimal MINIMAL_VALUE = new BigDecimal(0);

    /**
     * Maximal output value
     */
    private static final BigDecimal MAXIMAL_VALUE = new BigDecimal(1000000);

    /**
     * File name for output values
     */
    public static final String FILE_NAME = "big_random_numbers.txt";

    public static void main(String[] args) {
        App app = new App();
        System.out.println("Start file generation...");

        try {
            app.generateFile(FILE_NAME);
            System.out.println("File has been successfully created");
        } catch (IOException e) {
            System.err.println("Impossible generate number file");
            e.printStackTrace();
        }
    }

    /**
     * Generate file full of random decimal numbers
     *
     * @param fileName - file name
     */
    public void generateFile(String fileName) throws IOException {
        List<BigDecimal> randomValues = new ArrayList<>(RANDOM_ELEMENTS_AMOUNT);
        for (int i = 0; i < RANDOM_ELEMENTS_AMOUNT; i++) {
            randomValues.add(generateRandomValue(MINIMAL_VALUE, MAXIMAL_VALUE));
        }
        writeFile(fileName, randomValues);
    }

    /**
     * Write data in text file
     *
     * @param fileName    - file name
     * @param fileContent - file content, each element equal file line
     * @throws IOException
     */
    public void writeFile(String fileName, List<BigDecimal> fileContent) throws IOException {
        Path path = Paths.get(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            for (BigDecimal line : fileContent) {
                writer.write(line.toPlainString());
                writer.newLine();
            }
        }
    }

    /**
     * Generate random values with given interval
     *
     * @param min - minimum value
     * @param max - maximum value
     * @return - random value
     */
    public static BigDecimal generateRandomValue(BigDecimal min, BigDecimal max) {
        return generateRandomValue(min, max, SCALE_BIG_DECIMAL);
    }

    /**
     * Generate random values with given interval
     *
     * @param min   - minimum value
     * @param max   - maximum value
     * @param scale - scale value
     * @return - random value
     */
    public static BigDecimal generateRandomValue(BigDecimal min, BigDecimal max, int scale) {
        Random randomGenerator = new Random();
        BigDecimal randomBigDecimal = min.add(new BigDecimal(randomGenerator.nextDouble()).multiply(max.subtract(min)));
        return randomBigDecimal.setScale(scale, BigDecimal.ROUND_HALF_UP);
    }
}
