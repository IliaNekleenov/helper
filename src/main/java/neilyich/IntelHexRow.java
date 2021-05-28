package neilyich;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class IntelHexRow {
    private int address;
    private int data;

    public String format() {
        int sum = (1 + address + data) % 256;
        sum = 256 - sum;
        return ":" + "01" + toFixedLength(address, 4) + "00" + toFixedLength(data, 2) + toFixedLength(sum, 2);
    }

    private StringBuilder toFixedLength(int n, int len) {
        StringBuilder str = new StringBuilder(Integer.toHexString(n).toUpperCase());
        while (str.length() < len) {
            str.insert(0, "0");
        }
        return str;
    }
}
