package me;

import androidx.annotation.NonNull;
import net.bytebuddy.asm.Advice;

public class k {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f41267a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: b  reason: collision with root package name */
    private static final char[] f41268b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', Advice.OffsetMapping.ForOrigin.Renderer.ForDescriptor.SYMBOL, 'e', 'f'};

    @NonNull
    public static String a(@NonNull byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[(length + length)];
        int i10 = 0;
        for (byte b10 : bArr) {
            byte b11 = b10 & 255;
            int i11 = i10 + 1;
            char[] cArr2 = f41268b;
            cArr[i10] = cArr2[b11 >>> 4];
            i10 = i11 + 1;
            cArr[i11] = cArr2[b11 & 15];
        }
        return new String(cArr);
    }

    @NonNull
    public static String b(@NonNull byte[] bArr) {
        return c(bArr, false);
    }

    @NonNull
    public static String c(@NonNull byte[] bArr, boolean z10) {
        int length = bArr.length;
        StringBuilder sb2 = new StringBuilder(length + length);
        int i10 = 0;
        while (i10 < length && (!z10 || i10 != length - 1 || (bArr[i10] & 255) != 0)) {
            char[] cArr = f41267a;
            sb2.append(cArr[(bArr[i10] & 240) >>> 4]);
            sb2.append(cArr[bArr[i10] & 15]);
            i10++;
        }
        return sb2.toString();
    }
}
