package neilyich;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FilesSaver {
    private FilesSaver() {}
    public static void save(List<List<Integer>> data, String prefix) throws IOException {
        prefix = prefix + "_";
        int i = 0;
        while (i < data.get(0).size()) {
            int address = 0;
            var builder = new StringBuilder();
            for(var d: data) {
                var hexRow = IntelHexRow.builder().address(address).data(d.get(i)).build();
                String formatted = hexRow.format();
                builder.append(formatted).append('\n');
                address++;
            }
            builder.append(":00000001FF");
            Files.writeString(Path.of(prefix + i + ".hex"), builder.toString());
            i++;
        }
    }
}
