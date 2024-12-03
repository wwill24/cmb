package zm;

public class d {
    public static StringBuilder a(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder(bArr.length * 2);
        int length = bArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            sb2.append(String.format("%02X ", new Object[]{Byte.valueOf(bArr[i10])}));
        }
        return sb2;
    }
}
