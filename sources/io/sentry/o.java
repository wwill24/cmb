package io.sentry;

import java.io.StringReader;
import java.nio.charset.Charset;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public final class o implements e0 {

    /* renamed from: b  reason: collision with root package name */
    private static final Charset f31360b = Charset.forName("UTF-8");

    /* renamed from: a  reason: collision with root package name */
    private final l0 f31361a;

    public o(l0 l0Var) {
        this.f31361a = l0Var;
    }

    private x2 b(byte[] bArr, int i10, int i11) {
        return (x2) this.f31361a.c(new StringReader(new String(bArr, i10, i11, f31360b)), x2.class);
    }

    private o3 c(byte[] bArr, int i10, int i11) {
        return (o3) this.f31361a.c(new StringReader(new String(bArr, i10, i11, f31360b)), o3.class);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x007f, code lost:
        if (r11[r6] != 10) goto L_0x008a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0091, code lost:
        throw new java.lang.IllegalArgumentException("Envelope has invalid data following an item.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00e2, code lost:
        throw new java.lang.IllegalArgumentException("Item header at index '" + r2.size() + "' is null or empty.");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public io.sentry.w2 a(java.io.InputStream r11) throws java.io.IOException {
        /*
            r10 = this;
            r0 = 1024(0x400, float:1.435E-42)
            byte[] r0 = new byte[r0]
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream
            r1.<init>()
            r2 = 0
            r3 = -1
            r5 = r2
            r4 = r3
        L_0x000d:
            int r6 = r11.read(r0)     // Catch:{ all -> 0x011b }
            r7 = 10
            if (r6 <= 0) goto L_0x0029
            r8 = r2
        L_0x0016:
            if (r4 != r3) goto L_0x0024
            if (r8 >= r6) goto L_0x0024
            byte r9 = r0[r8]     // Catch:{ all -> 0x011b }
            if (r9 != r7) goto L_0x0021
            int r4 = r5 + r8
            goto L_0x0024
        L_0x0021:
            int r8 = r8 + 1
            goto L_0x0016
        L_0x0024:
            r1.write(r0, r2, r6)     // Catch:{ all -> 0x011b }
            int r5 = r5 + r6
            goto L_0x000d
        L_0x0029:
            byte[] r11 = r1.toByteArray()     // Catch:{ all -> 0x011b }
            int r0 = r11.length     // Catch:{ all -> 0x011b }
            if (r0 == 0) goto L_0x0113
            if (r4 == r3) goto L_0x010b
            io.sentry.x2 r0 = r10.b(r11, r2, r4)     // Catch:{ all -> 0x011b }
            if (r0 == 0) goto L_0x0103
            int r4 = r4 + 1
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x011b }
            r2.<init>()     // Catch:{ all -> 0x011b }
        L_0x003f:
            r5 = r4
        L_0x0040:
            int r6 = r11.length     // Catch:{ all -> 0x011b }
            if (r5 >= r6) goto L_0x004b
            byte r6 = r11[r5]     // Catch:{ all -> 0x011b }
            if (r6 != r7) goto L_0x0048
            goto L_0x004c
        L_0x0048:
            int r5 = r5 + 1
            goto L_0x0040
        L_0x004b:
            r5 = r3
        L_0x004c:
            if (r5 == r3) goto L_0x00e3
            int r6 = r5 - r4
            io.sentry.o3 r4 = r10.c(r11, r4, r6)     // Catch:{ all -> 0x011b }
            if (r4 == 0) goto L_0x00c3
            int r6 = r4.a()     // Catch:{ all -> 0x011b }
            if (r6 <= 0) goto L_0x00c3
            int r6 = r4.a()     // Catch:{ all -> 0x011b }
            int r6 = r6 + r5
            int r6 = r6 + 1
            int r8 = r11.length     // Catch:{ all -> 0x011b }
            if (r6 > r8) goto L_0x0092
            int r5 = r5 + 1
            byte[] r5 = java.util.Arrays.copyOfRange(r11, r5, r6)     // Catch:{ all -> 0x011b }
            io.sentry.n3 r8 = new io.sentry.n3     // Catch:{ all -> 0x011b }
            r8.<init>((io.sentry.o3) r4, (byte[]) r5)     // Catch:{ all -> 0x011b }
            r2.add(r8)     // Catch:{ all -> 0x011b }
            int r4 = r11.length     // Catch:{ all -> 0x011b }
            if (r6 != r4) goto L_0x0078
            goto L_0x0081
        L_0x0078:
            int r4 = r6 + 1
            int r5 = r11.length     // Catch:{ all -> 0x011b }
            if (r4 != r5) goto L_0x003f
            byte r11 = r11[r6]     // Catch:{ all -> 0x011b }
            if (r11 != r7) goto L_0x008a
        L_0x0081:
            io.sentry.w2 r11 = new io.sentry.w2     // Catch:{ all -> 0x011b }
            r11.<init>(r0, r2)     // Catch:{ all -> 0x011b }
            r1.close()
            return r11
        L_0x008a:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x011b }
            java.lang.String r0 = "Envelope has invalid data following an item."
            r11.<init>(r0)     // Catch:{ all -> 0x011b }
            throw r11     // Catch:{ all -> 0x011b }
        L_0x0092:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x011b }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x011b }
            r3.<init>()     // Catch:{ all -> 0x011b }
            java.lang.String r4 = "Invalid length for item at index '"
            r3.append(r4)     // Catch:{ all -> 0x011b }
            int r2 = r2.size()     // Catch:{ all -> 0x011b }
            r3.append(r2)     // Catch:{ all -> 0x011b }
            java.lang.String r2 = "'. Item is '"
            r3.append(r2)     // Catch:{ all -> 0x011b }
            r3.append(r6)     // Catch:{ all -> 0x011b }
            java.lang.String r2 = "' bytes. There are '"
            r3.append(r2)     // Catch:{ all -> 0x011b }
            int r11 = r11.length     // Catch:{ all -> 0x011b }
            r3.append(r11)     // Catch:{ all -> 0x011b }
            java.lang.String r11 = "' in the buffer."
            r3.append(r11)     // Catch:{ all -> 0x011b }
            java.lang.String r11 = r3.toString()     // Catch:{ all -> 0x011b }
            r0.<init>(r11)     // Catch:{ all -> 0x011b }
            throw r0     // Catch:{ all -> 0x011b }
        L_0x00c3:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x011b }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x011b }
            r0.<init>()     // Catch:{ all -> 0x011b }
            java.lang.String r3 = "Item header at index '"
            r0.append(r3)     // Catch:{ all -> 0x011b }
            int r2 = r2.size()     // Catch:{ all -> 0x011b }
            r0.append(r2)     // Catch:{ all -> 0x011b }
            java.lang.String r2 = "' is null or empty."
            r0.append(r2)     // Catch:{ all -> 0x011b }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x011b }
            r11.<init>(r0)     // Catch:{ all -> 0x011b }
            throw r11     // Catch:{ all -> 0x011b }
        L_0x00e3:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x011b }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x011b }
            r0.<init>()     // Catch:{ all -> 0x011b }
            java.lang.String r3 = "Invalid envelope. Item at index '"
            r0.append(r3)     // Catch:{ all -> 0x011b }
            int r2 = r2.size()     // Catch:{ all -> 0x011b }
            r0.append(r2)     // Catch:{ all -> 0x011b }
            java.lang.String r2 = "'. has no header delimiter."
            r0.append(r2)     // Catch:{ all -> 0x011b }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x011b }
            r11.<init>(r0)     // Catch:{ all -> 0x011b }
            throw r11     // Catch:{ all -> 0x011b }
        L_0x0103:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x011b }
            java.lang.String r0 = "Envelope header is null."
            r11.<init>(r0)     // Catch:{ all -> 0x011b }
            throw r11     // Catch:{ all -> 0x011b }
        L_0x010b:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x011b }
            java.lang.String r0 = "Envelope contains no header."
            r11.<init>(r0)     // Catch:{ all -> 0x011b }
            throw r11     // Catch:{ all -> 0x011b }
        L_0x0113:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x011b }
            java.lang.String r0 = "Empty stream."
            r11.<init>(r0)     // Catch:{ all -> 0x011b }
            throw r11     // Catch:{ all -> 0x011b }
        L_0x011b:
            r11 = move-exception
            r1.close()     // Catch:{ all -> 0x0120 }
            goto L_0x0124
        L_0x0120:
            r0 = move-exception
            r11.addSuppressed(r0)
        L_0x0124:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.o.a(java.io.InputStream):io.sentry.w2");
    }
}
