package src.main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class BankStatementAnalyzerProblematic {

    private static final String RESOURCES = "src/main/resources/";
    public static DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public static void main(String[] args) throws IOException {
        Path path = Paths.get(RESOURCES + "bank-data-simple.csv");
        List<String> lines = Files.readAllLines(path);
        double total = 0;
        for (String line : lines) {
            String[] columns = line.split(",");
            double amount = Double.parseDouble(columns[1]);
            total += amount;
        }

        System.out.println("The total for all transactions is " + total);

        total = 0;
        for (String line : lines) {
            String[] columns = line.split(",");
            LocalDate date = LocalDate.parse(columns[0], DATE_FORMATTER);
            if (date.getMonth() == Month.JANUARY) {
                double amount = Double.parseDouble(columns[1]);
                total += amount;
            }

        }

        System.out.println("The total for all transactions in January is " + total);

    }
}
