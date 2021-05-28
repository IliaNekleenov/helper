package neilyich;

import lombok.Value;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Value
public class Splitter {
    List<String> lines;
    public Splitter(List<String> lines) {
        this.lines = lines.stream().map(s -> s.replace(" ", "")).collect(Collectors.toList());
    }

    public List<List<Integer>> split(int bitsPerRom) {
        List<List<Integer>> result = new ArrayList<>();
        for(var l: lines) {
            List<Integer> row = splitString(l, bitsPerRom);
            result.add(row);
        }
        return result;
    }

    private List<Integer> splitString(String s, int bitsPerRom) {
        int i = 0;
        List<Integer> result = new ArrayList<>(s.length() / 8 + 1);
        while (i < s.length()) {
            int index = i + bitsPerRom;
            if(index >= s.length()) {
                index = s.length();
            }
            result.add(Integer.parseInt(s.substring(i, index), 2));
            i += bitsPerRom;
        }
        return result;
    }
}
