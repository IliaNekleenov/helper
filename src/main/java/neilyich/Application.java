package neilyich;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) throws IOException {
        //System.out.println(IntelHexRow.builder().address(1).data(10).build().format());

        var sc = new Scanner(System.in);
        System.out.println("Enter bits count for one ROM");
        int bitsPerRom = sc.nextInt();
        List<String> lines = new ArrayList<>();
        while (sc.hasNextLine()) {
            var s = sc.nextLine();
            if (!s.isBlank()) {
                lines.add(s);
            }
        }
        var splitter = new Splitter(lines);
        var rows = splitter.split(bitsPerRom);
        FilesSaver.save(rows, "rom");

    }
}
