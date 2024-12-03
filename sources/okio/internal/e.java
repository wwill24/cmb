package okio.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.j;
import net.bytebuddy.asm.Advice;
import okio.Buffer;
import okio.ByteString;

@Metadata(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0002\b\b\u001a$\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0000\u001a\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0002\u001a\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0003H\u0002\" \u0010\u0015\u001a\u00020\u000e8\u0000X\u0004¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lokio/ByteString;", "Lokio/Buffer;", "buffer", "", "offset", "byteCount", "", "d", "", "c", "e", "", "s", "codePointCount", "", "a", "[C", "f", "()[C", "getHEX_DIGIT_CHARS$annotations", "()V", "HEX_DIGIT_CHARS", "okio"}, k = 2, mv = {1, 6, 0})
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f33465a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', Advice.OffsetMapping.ForOrigin.Renderer.ForDescriptor.SYMBOL, 'e', 'f'};

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:251:0x0213 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:258:0x0047 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:261:0x016a A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:264:0x0081 A[EDGE_INSN: B:264:0x0081->B:51:0x0081 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:275:0x00da A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final int c(byte[] r19, int r20) {
        /*
            r0 = r19
            r1 = r20
            int r2 = r0.length
            r4 = 0
            r5 = 0
            r6 = 0
        L_0x0008:
            if (r4 >= r2) goto L_0x0225
            byte r7 = r0[r4]
            r8 = 160(0xa0, float:2.24E-43)
            r9 = 127(0x7f, float:1.78E-43)
            r10 = 32
            r11 = 13
            r12 = 65533(0xfffd, float:9.1831E-41)
            r13 = 10
            r14 = 65536(0x10000, float:9.18355E-41)
            r16 = -1
            r17 = 1
            if (r7 < 0) goto L_0x008a
            int r18 = r6 + 1
            if (r6 != r1) goto L_0x0026
            return r5
        L_0x0026:
            if (r7 == r13) goto L_0x0045
            if (r7 == r11) goto L_0x0045
            if (r7 < 0) goto L_0x0031
            if (r7 >= r10) goto L_0x0031
            r6 = r17
            goto L_0x0032
        L_0x0031:
            r6 = 0
        L_0x0032:
            if (r6 != 0) goto L_0x0041
            if (r9 > r7) goto L_0x003b
            if (r7 >= r8) goto L_0x003b
            r6 = r17
            goto L_0x003c
        L_0x003b:
            r6 = 0
        L_0x003c:
            if (r6 == 0) goto L_0x003f
            goto L_0x0041
        L_0x003f:
            r6 = 0
            goto L_0x0043
        L_0x0041:
            r6 = r17
        L_0x0043:
            if (r6 != 0) goto L_0x0047
        L_0x0045:
            if (r7 != r12) goto L_0x0048
        L_0x0047:
            return r16
        L_0x0048:
            if (r7 >= r14) goto L_0x004d
            r6 = r17
            goto L_0x004e
        L_0x004d:
            r6 = 2
        L_0x004e:
            int r5 = r5 + r6
            int r4 = r4 + 1
        L_0x0051:
            r6 = r18
            if (r4 >= r2) goto L_0x0008
            byte r7 = r0[r4]
            if (r7 < 0) goto L_0x0008
            int r4 = r4 + 1
            int r18 = r6 + 1
            if (r6 != r1) goto L_0x0060
            return r5
        L_0x0060:
            if (r7 == r13) goto L_0x007f
            if (r7 == r11) goto L_0x007f
            if (r7 < 0) goto L_0x006b
            if (r7 >= r10) goto L_0x006b
            r6 = r17
            goto L_0x006c
        L_0x006b:
            r6 = 0
        L_0x006c:
            if (r6 != 0) goto L_0x007b
            if (r9 > r7) goto L_0x0075
            if (r7 >= r8) goto L_0x0075
            r6 = r17
            goto L_0x0076
        L_0x0075:
            r6 = 0
        L_0x0076:
            if (r6 == 0) goto L_0x0079
            goto L_0x007b
        L_0x0079:
            r6 = 0
            goto L_0x007d
        L_0x007b:
            r6 = r17
        L_0x007d:
            if (r6 != 0) goto L_0x0081
        L_0x007f:
            if (r7 != r12) goto L_0x0082
        L_0x0081:
            return r16
        L_0x0082:
            if (r7 >= r14) goto L_0x0087
            r6 = r17
            goto L_0x0088
        L_0x0087:
            r6 = 2
        L_0x0088:
            int r5 = r5 + r6
            goto L_0x0051
        L_0x008a:
            int r3 = r7 >> 5
            r15 = -2
            r14 = 128(0x80, float:1.794E-43)
            if (r3 != r15) goto L_0x00e9
            int r3 = r4 + 1
            if (r2 > r3) goto L_0x0099
            if (r6 != r1) goto L_0x0098
            return r5
        L_0x0098:
            return r16
        L_0x0099:
            byte r3 = r0[r3]
            r15 = r3 & 192(0xc0, float:2.69E-43)
            if (r15 != r14) goto L_0x00a2
            r15 = r17
            goto L_0x00a3
        L_0x00a2:
            r15 = 0
        L_0x00a3:
            if (r15 != 0) goto L_0x00a9
            if (r6 != r1) goto L_0x00a8
            return r5
        L_0x00a8:
            return r16
        L_0x00a9:
            r3 = r3 ^ 3968(0xf80, float:5.56E-42)
            int r7 = r7 << 6
            r3 = r3 ^ r7
            if (r3 >= r14) goto L_0x00b4
            if (r6 != r1) goto L_0x00b3
            return r5
        L_0x00b3:
            return r16
        L_0x00b4:
            int r7 = r6 + 1
            if (r6 != r1) goto L_0x00b9
            return r5
        L_0x00b9:
            if (r3 == r13) goto L_0x00d8
            if (r3 == r11) goto L_0x00d8
            if (r3 < 0) goto L_0x00c4
            if (r3 >= r10) goto L_0x00c4
            r6 = r17
            goto L_0x00c5
        L_0x00c4:
            r6 = 0
        L_0x00c5:
            if (r6 != 0) goto L_0x00d4
            if (r9 > r3) goto L_0x00ce
            if (r3 >= r8) goto L_0x00ce
            r6 = r17
            goto L_0x00cf
        L_0x00ce:
            r6 = 0
        L_0x00cf:
            if (r6 == 0) goto L_0x00d2
            goto L_0x00d4
        L_0x00d2:
            r6 = 0
            goto L_0x00d6
        L_0x00d4:
            r6 = r17
        L_0x00d6:
            if (r6 != 0) goto L_0x00da
        L_0x00d8:
            if (r3 != r12) goto L_0x00db
        L_0x00da:
            return r16
        L_0x00db:
            r6 = 65536(0x10000, float:9.18355E-41)
            if (r3 >= r6) goto L_0x00e2
            r15 = r17
            goto L_0x00e3
        L_0x00e2:
            r15 = 2
        L_0x00e3:
            int r5 = r5 + r15
            int r4 = r4 + 2
        L_0x00e6:
            r6 = r7
            goto L_0x0008
        L_0x00e9:
            int r3 = r7 >> 4
            r12 = 57344(0xe000, float:8.0356E-41)
            r8 = 55296(0xd800, float:7.7486E-41)
            if (r3 != r15) goto L_0x0178
            int r3 = r4 + 2
            if (r2 > r3) goto L_0x00fb
            if (r6 != r1) goto L_0x00fa
            return r5
        L_0x00fa:
            return r16
        L_0x00fb:
            int r15 = r4 + 1
            byte r15 = r0[r15]
            r9 = r15 & 192(0xc0, float:2.69E-43)
            if (r9 != r14) goto L_0x0106
            r9 = r17
            goto L_0x0107
        L_0x0106:
            r9 = 0
        L_0x0107:
            if (r9 != 0) goto L_0x010d
            if (r6 != r1) goto L_0x010c
            return r5
        L_0x010c:
            return r16
        L_0x010d:
            byte r3 = r0[r3]
            r9 = r3 & 192(0xc0, float:2.69E-43)
            if (r9 != r14) goto L_0x0116
            r9 = r17
            goto L_0x0117
        L_0x0116:
            r9 = 0
        L_0x0117:
            if (r9 != 0) goto L_0x011d
            if (r6 != r1) goto L_0x011c
            return r5
        L_0x011c:
            return r16
        L_0x011d:
            r9 = -123008(0xfffffffffffe1f80, float:NaN)
            r3 = r3 ^ r9
            int r9 = r15 << 6
            r3 = r3 ^ r9
            int r7 = r7 << 12
            r3 = r3 ^ r7
            r7 = 2048(0x800, float:2.87E-42)
            if (r3 >= r7) goto L_0x012f
            if (r6 != r1) goto L_0x012e
            return r5
        L_0x012e:
            return r16
        L_0x012f:
            if (r8 > r3) goto L_0x0136
            if (r3 >= r12) goto L_0x0136
            r7 = r17
            goto L_0x0137
        L_0x0136:
            r7 = 0
        L_0x0137:
            if (r7 == 0) goto L_0x013d
            if (r6 != r1) goto L_0x013c
            return r5
        L_0x013c:
            return r16
        L_0x013d:
            int r7 = r6 + 1
            if (r6 != r1) goto L_0x0142
            return r5
        L_0x0142:
            if (r3 == r13) goto L_0x0165
            if (r3 == r11) goto L_0x0165
            if (r3 < 0) goto L_0x014d
            if (r3 >= r10) goto L_0x014d
            r6 = r17
            goto L_0x014e
        L_0x014d:
            r6 = 0
        L_0x014e:
            if (r6 != 0) goto L_0x0161
            r6 = 127(0x7f, float:1.78E-43)
            if (r6 > r3) goto L_0x015b
            r6 = 160(0xa0, float:2.24E-43)
            if (r3 >= r6) goto L_0x015b
            r6 = r17
            goto L_0x015c
        L_0x015b:
            r6 = 0
        L_0x015c:
            if (r6 == 0) goto L_0x015f
            goto L_0x0161
        L_0x015f:
            r6 = 0
            goto L_0x0163
        L_0x0161:
            r6 = r17
        L_0x0163:
            if (r6 != 0) goto L_0x016a
        L_0x0165:
            r6 = 65533(0xfffd, float:9.1831E-41)
            if (r3 != r6) goto L_0x016b
        L_0x016a:
            return r16
        L_0x016b:
            r6 = 65536(0x10000, float:9.18355E-41)
            if (r3 >= r6) goto L_0x0172
            r15 = r17
            goto L_0x0173
        L_0x0172:
            r15 = 2
        L_0x0173:
            int r5 = r5 + r15
            int r4 = r4 + 3
            goto L_0x00e6
        L_0x0178:
            int r3 = r7 >> 3
            if (r3 != r15) goto L_0x0221
            int r3 = r4 + 3
            if (r2 > r3) goto L_0x0184
            if (r6 != r1) goto L_0x0183
            return r5
        L_0x0183:
            return r16
        L_0x0184:
            int r9 = r4 + 1
            byte r9 = r0[r9]
            r15 = r9 & 192(0xc0, float:2.69E-43)
            if (r15 != r14) goto L_0x018f
            r15 = r17
            goto L_0x0190
        L_0x018f:
            r15 = 0
        L_0x0190:
            if (r15 != 0) goto L_0x0196
            if (r6 != r1) goto L_0x0195
            return r5
        L_0x0195:
            return r16
        L_0x0196:
            int r15 = r4 + 2
            byte r15 = r0[r15]
            r10 = r15 & 192(0xc0, float:2.69E-43)
            if (r10 != r14) goto L_0x01a1
            r10 = r17
            goto L_0x01a2
        L_0x01a1:
            r10 = 0
        L_0x01a2:
            if (r10 != 0) goto L_0x01a8
            if (r6 != r1) goto L_0x01a7
            return r5
        L_0x01a7:
            return r16
        L_0x01a8:
            byte r3 = r0[r3]
            r10 = r3 & 192(0xc0, float:2.69E-43)
            if (r10 != r14) goto L_0x01b1
            r10 = r17
            goto L_0x01b2
        L_0x01b1:
            r10 = 0
        L_0x01b2:
            if (r10 != 0) goto L_0x01b8
            if (r6 != r1) goto L_0x01b7
            return r5
        L_0x01b7:
            return r16
        L_0x01b8:
            r10 = 3678080(0x381f80, float:5.154088E-39)
            r3 = r3 ^ r10
            int r10 = r15 << 6
            r3 = r3 ^ r10
            int r9 = r9 << 12
            r3 = r3 ^ r9
            int r7 = r7 << 18
            r3 = r3 ^ r7
            r7 = 1114111(0x10ffff, float:1.561202E-39)
            if (r3 <= r7) goto L_0x01ce
            if (r6 != r1) goto L_0x01cd
            return r5
        L_0x01cd:
            return r16
        L_0x01ce:
            if (r8 > r3) goto L_0x01d5
            if (r3 >= r12) goto L_0x01d5
            r7 = r17
            goto L_0x01d6
        L_0x01d5:
            r7 = 0
        L_0x01d6:
            if (r7 == 0) goto L_0x01dc
            if (r6 != r1) goto L_0x01db
            return r5
        L_0x01db:
            return r16
        L_0x01dc:
            r7 = 65536(0x10000, float:9.18355E-41)
            if (r3 >= r7) goto L_0x01e4
            if (r6 != r1) goto L_0x01e3
            return r5
        L_0x01e3:
            return r16
        L_0x01e4:
            int r7 = r6 + 1
            if (r6 != r1) goto L_0x01e9
            return r5
        L_0x01e9:
            if (r3 == r13) goto L_0x020e
            if (r3 == r11) goto L_0x020e
            if (r3 < 0) goto L_0x01f6
            r6 = 32
            if (r3 >= r6) goto L_0x01f6
            r6 = r17
            goto L_0x01f7
        L_0x01f6:
            r6 = 0
        L_0x01f7:
            if (r6 != 0) goto L_0x020a
            r6 = 127(0x7f, float:1.78E-43)
            if (r6 > r3) goto L_0x0204
            r6 = 160(0xa0, float:2.24E-43)
            if (r3 >= r6) goto L_0x0204
            r6 = r17
            goto L_0x0205
        L_0x0204:
            r6 = 0
        L_0x0205:
            if (r6 == 0) goto L_0x0208
            goto L_0x020a
        L_0x0208:
            r6 = 0
            goto L_0x020c
        L_0x020a:
            r6 = r17
        L_0x020c:
            if (r6 != 0) goto L_0x0213
        L_0x020e:
            r6 = 65533(0xfffd, float:9.1831E-41)
            if (r3 != r6) goto L_0x0214
        L_0x0213:
            return r16
        L_0x0214:
            r6 = 65536(0x10000, float:9.18355E-41)
            if (r3 >= r6) goto L_0x021b
            r15 = r17
            goto L_0x021c
        L_0x021b:
            r15 = 2
        L_0x021c:
            int r5 = r5 + r15
            int r4 = r4 + 4
            goto L_0x00e6
        L_0x0221:
            if (r6 != r1) goto L_0x0224
            return r5
        L_0x0224:
            return r16
        L_0x0225:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.e.c(byte[], int):int");
    }

    public static final void d(ByteString byteString, Buffer buffer, int i10, int i11) {
        j.g(byteString, "<this>");
        j.g(buffer, "buffer");
        buffer.write(byteString.j(), i10, i11);
    }

    /* access modifiers changed from: private */
    public static final int e(char c10) {
        boolean z10 = true;
        if ('0' <= c10 && c10 < ':') {
            return c10 - '0';
        }
        char c11 = 'a';
        if (!('a' <= c10 && c10 < 'g')) {
            c11 = 'A';
            if ('A' > c10 || c10 >= 'G') {
                z10 = false;
            }
            if (!z10) {
                throw new IllegalArgumentException("Unexpected hex digit: " + c10);
            }
        }
        return (c10 - c11) + 10;
    }

    public static final char[] f() {
        return f33465a;
    }
}
