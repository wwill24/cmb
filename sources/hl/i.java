package hl;

import bl.d;
import com.leanplum.messagetemplates.MessageTemplateConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;

@Metadata(bv = {}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J\u0016\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\bJ\u001e\u0010\u0012\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\nR\u0014\u0010\u0015\u001a\u00020\u00138\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00198\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u001a¨\u0006\u001e"}, d2 = {"Lhl/i;", "", "", "symbol", "code", "codeBitCount", "", "a", "Lokio/ByteString;", "source", "Lokio/BufferedSink;", "sink", "c", "bytes", "d", "Lokio/BufferedSource;", "", "byteCount", "b", "", "[I", "CODES", "", "[B", "CODE_BIT_COUNTS", "Lhl/i$a;", "Lhl/i$a;", "root", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class i {

    /* renamed from: a  reason: collision with root package name */
    public static final i f29933a = new i();

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f29934b = {8184, 8388568, 268435426, 268435427, 268435428, 268435429, 268435430, 268435431, 268435432, 16777194, 1073741820, 268435433, 268435434, 1073741821, 268435435, 268435436, 268435437, 268435438, 268435439, 268435440, 268435441, 268435442, 1073741822, 268435443, 268435444, 268435445, 268435446, 268435447, 268435448, 268435449, 268435450, 268435451, 20, 1016, 1017, 4090, 8185, 21, 248, 2042, 1018, 1019, 249, 2043, MessageTemplateConstants.Values.CENTER_POPUP_HEIGHT, 22, 23, 24, 0, 1, 2, 25, 26, 27, 28, 29, 30, 31, 92, 251, 32764, 32, 4091, 1020, 8186, 33, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 252, 115, 253, 8187, 524272, 8188, 16380, 34, 32765, 3, 35, 4, 36, 5, 37, 38, 39, 6, 116, 117, 40, 41, 42, 7, 43, 118, 44, 8, 9, 45, 119, 120, 121, 122, 123, 32766, 2044, 16381, 8189, 268435452, 1048550, 4194258, 1048551, 1048552, 4194259, 4194260, 4194261, 8388569, 4194262, 8388570, 8388571, 8388572, 8388573, 8388574, 16777195, 8388575, 16777196, 16777197, 4194263, 8388576, 16777198, 8388577, 8388578, 8388579, 8388580, 2097116, 4194264, 8388581, 4194265, 8388582, 8388583, 16777199, 4194266, 2097117, 1048553, 4194267, 4194268, 8388584, 8388585, 2097118, 8388586, 4194269, 4194270, 16777200, 2097119, 4194271, 8388587, 8388588, 2097120, 2097121, 4194272, 2097122, 8388589, 4194273, 8388590, 8388591, 1048554, 4194274, 4194275, 4194276, 8388592, 4194277, 4194278, 8388593, 67108832, 67108833, 1048555, 524273, 4194279, 8388594, 4194280, 33554412, 67108834, 67108835, 67108836, 134217694, 134217695, 67108837, 16777201, 33554413, 524274, 2097123, 67108838, 134217696, 134217697, 67108839, 134217698, 16777202, 2097124, 2097125, 67108840, 67108841, 268435453, 134217699, 134217700, 134217701, 1048556, 16777203, 1048557, 2097126, 4194281, 2097127, 2097128, 8388595, 4194282, 4194283, 33554414, 33554415, 16777204, 16777205, 67108842, 8388596, 67108843, 134217702, 67108844, 67108845, 134217703, 134217704, 134217705, 134217706, 134217707, 268435454, 134217708, 134217709, 134217710, 134217711, 134217712, 67108846};

    /* renamed from: c  reason: collision with root package name */
    private static final byte[] f29935c;

    /* renamed from: d  reason: collision with root package name */
    private static final a f29936d = new a();

    static {
        byte[] bArr = {13, 23, 28, 28, 28, 28, 28, 28, 28, 24, 30, 28, 28, 30, 28, 28, 28, 28, 28, 28, 28, 28, 30, 28, 28, 28, 28, 28, 28, 28, 28, 28, 6, 10, 10, 12, 13, 6, 8, 11, 10, 10, 8, 11, 8, 6, 6, 6, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7, 8, 15, 6, 12, 10, 13, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 7, 8, 13, 19, 13, 14, 6, 15, 5, 6, 5, 6, 5, 6, 6, 6, 5, 7, 7, 6, 6, 6, 5, 6, 7, 6, 5, 5, 6, 7, 7, 7, 7, 7, 15, 11, 14, 13, 28, 20, 22, 20, 20, 22, 22, 22, 23, 22, 23, 23, 23, 23, 23, 24, 23, 24, 24, 22, 23, 24, 23, 23, 23, 23, 21, 22, 23, 22, 23, 23, 24, 22, 21, 20, 22, 22, 23, 23, 21, 23, 22, 22, 24, 21, 22, 23, 23, 21, 21, 22, 21, 23, 22, 23, 23, 20, 22, 22, 22, 23, 22, 22, 23, 26, 26, 20, 19, 22, 23, 22, 25, 26, 26, 26, 27, 27, 26, 24, 25, 19, 21, 26, 27, 27, 26, 27, 24, 21, 21, 26, 26, 28, 27, 27, 27, 20, 24, 20, 21, 22, 21, 21, 23, 22, 22, 25, 25, 24, 24, 26, 23, 26, 27, 26, 26, 27, 27, 27, 27, 27, 28, 27, 27, 27, 27, 27, 26};
        f29935c = bArr;
        int length = bArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            f29933a.a(i10, f29934b[i10], f29935c[i10]);
        }
    }

    private i() {
    }

    private final void a(int i10, int i11, int i12) {
        a aVar = new a(i10, i12);
        a aVar2 = f29936d;
        while (i12 > 8) {
            i12 -= 8;
            int i13 = (i11 >>> i12) & 255;
            a[] a10 = aVar2.a();
            j.d(a10);
            a aVar3 = a10[i13];
            if (aVar3 == null) {
                aVar3 = new a();
                a10[i13] = aVar3;
            }
            aVar2 = aVar3;
        }
        int i14 = 8 - i12;
        int i15 = (i11 << i14) & 255;
        a[] a11 = aVar2.a();
        j.d(a11);
        k.m(a11, aVar, i15, (1 << i14) + i15);
    }

    public final void b(BufferedSource bufferedSource, long j10, BufferedSink bufferedSink) {
        j.g(bufferedSource, "source");
        j.g(bufferedSink, "sink");
        a aVar = f29936d;
        int i10 = 0;
        long j11 = 0;
        int i11 = 0;
        while (j11 < j10) {
            j11++;
            i10 = (i10 << 8) | d.d(bufferedSource.readByte(), 255);
            i11 += 8;
            while (i11 >= 8) {
                a[] a10 = aVar.a();
                j.d(a10);
                aVar = a10[(i10 >>> (i11 - 8)) & 255];
                j.d(aVar);
                if (aVar.a() == null) {
                    bufferedSink.writeByte(aVar.b());
                    i11 -= aVar.c();
                    aVar = f29936d;
                } else {
                    i11 -= 8;
                }
            }
        }
        while (i11 > 0) {
            a[] a11 = aVar.a();
            j.d(a11);
            a aVar2 = a11[(i10 << (8 - i11)) & 255];
            j.d(aVar2);
            if (aVar2.a() == null && aVar2.c() <= i11) {
                bufferedSink.writeByte(aVar2.b());
                i11 -= aVar2.c();
                aVar = f29936d;
            } else {
                return;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: long} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(okio.ByteString r9, okio.BufferedSink r10) throws java.io.IOException {
        /*
            r8 = this;
            java.lang.String r0 = "source"
            kotlin.jvm.internal.j.g(r9, r0)
            java.lang.String r0 = "sink"
            kotlin.jvm.internal.j.g(r10, r0)
            int r0 = r9.H()
            r1 = 0
            r2 = 0
            r3 = r2
            r2 = r1
        L_0x0013:
            if (r1 >= r0) goto L_0x003c
            int r5 = r1 + 1
            byte r1 = r9.i(r1)
            r6 = 255(0xff, float:3.57E-43)
            int r1 = bl.d.d(r1, r6)
            int[] r6 = f29934b
            r6 = r6[r1]
            byte[] r7 = f29935c
            byte r1 = r7[r1]
            long r3 = r3 << r1
            long r6 = (long) r6
            long r3 = r3 | r6
            int r2 = r2 + r1
        L_0x002d:
            r1 = 8
            if (r2 < r1) goto L_0x003a
            int r2 = r2 + -8
            long r6 = r3 >> r2
            int r1 = (int) r6
            r10.writeByte(r1)
            goto L_0x002d
        L_0x003a:
            r1 = r5
            goto L_0x0013
        L_0x003c:
            if (r2 <= 0) goto L_0x004b
            int r9 = 8 - r2
            long r0 = r3 << r9
            r3 = 255(0xff, double:1.26E-321)
            long r2 = r3 >>> r2
            long r0 = r0 | r2
            int r9 = (int) r0
            r10.writeByte(r9)
        L_0x004b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: hl.i.c(okio.ByteString, okio.BufferedSink):void");
    }

    public final int d(ByteString byteString) {
        j.g(byteString, "bytes");
        int H = byteString.H();
        long j10 = 0;
        int i10 = 0;
        while (i10 < H) {
            int i11 = i10 + 1;
            j10 += (long) f29935c[d.d(byteString.i(i10), 255)];
            i10 = i11;
        }
        return (int) ((j10 + ((long) 7)) >> 3);
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\b\u0002\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u000e\u0010\u000fB\u0019\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u0007¢\u0006\u0004\b\u000e\u0010\u0011R!\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u0017\u0010\u000b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\nR\u0017\u0010\r\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\f\u0010\n¨\u0006\u0012"}, d2 = {"Lhl/i$a;", "", "", "a", "[Lhl/i$a;", "()[Lhl/i$a;", "children", "", "b", "I", "()I", "symbol", "c", "terminalBitCount", "<init>", "()V", "bits", "(II)V", "okhttp"}, k = 1, mv = {1, 6, 0})
    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final a[] f29937a;

        /* renamed from: b  reason: collision with root package name */
        private final int f29938b;

        /* renamed from: c  reason: collision with root package name */
        private final int f29939c;

        public a() {
            this.f29937a = new a[256];
            this.f29938b = 0;
            this.f29939c = 0;
        }

        public final a[] a() {
            return this.f29937a;
        }

        public final int b() {
            return this.f29938b;
        }

        public final int c() {
            return this.f29939c;
        }

        public a(int i10, int i11) {
            this.f29937a = null;
            this.f29938b = i10;
            int i12 = i11 & 7;
            this.f29939c = i12 == 0 ? 8 : i12;
        }
    }
}
