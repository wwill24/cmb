package zm;

public final class a {
    public static String a(byte[] bArr) {
        int length = ((int) (8.0d - (((double) (bArr.length % 5)) * 1.6d))) % 8;
        byte[] bArr2 = new byte[(bArr.length + length)];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < bArr.length; i10 += 5) {
            long j10 = (((long) (bArr2[i10] & 255)) << 32) + (((long) (bArr2[i10 + 1] & 255)) << 24) + ((long) ((bArr2[i10 + 2] & 255) << Tnaf.POW_2_WIDTH)) + ((long) ((bArr2[i10 + 3] & 255) << 8)) + ((long) (bArr2[i10 + 4] & 255));
            sb2.append("0123456789ABCDEFGHIJKLMNOPQRSTUV".charAt((int) ((j10 >> 35) & 31)));
            sb2.append("0123456789ABCDEFGHIJKLMNOPQRSTUV".charAt((int) ((j10 >> 30) & 31)));
            sb2.append("0123456789ABCDEFGHIJKLMNOPQRSTUV".charAt((int) ((j10 >> 25) & 31)));
            sb2.append("0123456789ABCDEFGHIJKLMNOPQRSTUV".charAt((int) ((j10 >> 20) & 31)));
            sb2.append("0123456789ABCDEFGHIJKLMNOPQRSTUV".charAt((int) ((j10 >> 15) & 31)));
            sb2.append("0123456789ABCDEFGHIJKLMNOPQRSTUV".charAt((int) ((j10 >> 10) & 31)));
            sb2.append("0123456789ABCDEFGHIJKLMNOPQRSTUV".charAt((int) ((j10 >> 5) & 31)));
            sb2.append("0123456789ABCDEFGHIJKLMNOPQRSTUV".charAt((int) (j10 & 31)));
        }
        return sb2.substring(0, sb2.length() - length) + "======".substring(0, length);
    }
}
