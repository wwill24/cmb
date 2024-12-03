package com.bumptech.glide.load.resource.bitmap;

import androidx.annotation.NonNull;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import m3.b;

public class RecyclableBufferedInputStream extends FilterInputStream {

    /* renamed from: a  reason: collision with root package name */
    private volatile byte[] f9466a;

    /* renamed from: b  reason: collision with root package name */
    private int f9467b;

    /* renamed from: c  reason: collision with root package name */
    private int f9468c;

    /* renamed from: d  reason: collision with root package name */
    private int f9469d;

    /* renamed from: e  reason: collision with root package name */
    private int f9470e;

    /* renamed from: f  reason: collision with root package name */
    private final b f9471f;

    static class InvalidMarkException extends IOException {
        private static final long serialVersionUID = -4338378848813561757L;

        InvalidMarkException(String str) {
            super(str);
        }
    }

    public RecyclableBufferedInputStream(@NonNull InputStream inputStream, @NonNull b bVar) {
        this(inputStream, bVar, 65536);
    }

    private int a(InputStream inputStream, byte[] bArr) throws IOException {
        int i10;
        int i11 = this.f9469d;
        if (i11 == -1 || this.f9470e - i11 >= (i10 = this.f9468c)) {
            int read = inputStream.read(bArr);
            if (read > 0) {
                this.f9469d = -1;
                this.f9470e = 0;
                this.f9467b = read;
            }
            return read;
        }
        if (i11 == 0 && i10 > bArr.length && this.f9467b == bArr.length) {
            int length = bArr.length * 2;
            if (length <= i10) {
                i10 = length;
            }
            byte[] bArr2 = (byte[]) this.f9471f.c(i10, byte[].class);
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            this.f9466a = bArr2;
            this.f9471f.put(bArr);
            bArr = bArr2;
        } else if (i11 > 0) {
            System.arraycopy(bArr, i11, bArr, 0, bArr.length - i11);
        }
        int i12 = this.f9470e - this.f9469d;
        this.f9470e = i12;
        this.f9469d = 0;
        this.f9467b = 0;
        int read2 = inputStream.read(bArr, i12, bArr.length - i12);
        int i13 = this.f9470e;
        if (read2 > 0) {
            i13 += read2;
        }
        this.f9467b = i13;
        return read2;
    }

    private static IOException e() throws IOException {
        throw new IOException("BufferedInputStream is closed");
    }

    public synchronized int available() throws IOException {
        InputStream inputStream;
        inputStream = this.in;
        if (this.f9466a == null || inputStream == null) {
            throw e();
        }
        return (this.f9467b - this.f9470e) + inputStream.available();
    }

    public synchronized void b() {
        this.f9468c = this.f9466a.length;
    }

    public synchronized void c() {
        if (this.f9466a != null) {
            this.f9471f.put(this.f9466a);
            this.f9466a = null;
        }
    }

    public void close() throws IOException {
        if (this.f9466a != null) {
            this.f9471f.put(this.f9466a);
            this.f9466a = null;
        }
        InputStream inputStream = this.in;
        this.in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    public synchronized void mark(int i10) {
        this.f9468c = Math.max(this.f9468c, i10);
        this.f9469d = this.f9470e;
    }

    public boolean markSupported() {
        return true;
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:11:0x0018=Splitter:B:11:0x0018, B:27:0x0039=Splitter:B:27:0x0039} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int read() throws java.io.IOException {
        /*
            r5 = this;
            monitor-enter(r5)
            byte[] r0 = r5.f9466a     // Catch:{ all -> 0x003e }
            java.io.InputStream r1 = r5.in     // Catch:{ all -> 0x003e }
            if (r0 == 0) goto L_0x0039
            if (r1 == 0) goto L_0x0039
            int r2 = r5.f9470e     // Catch:{ all -> 0x003e }
            int r3 = r5.f9467b     // Catch:{ all -> 0x003e }
            r4 = -1
            if (r2 < r3) goto L_0x0018
            int r1 = r5.a(r1, r0)     // Catch:{ all -> 0x003e }
            if (r1 != r4) goto L_0x0018
            monitor-exit(r5)
            return r4
        L_0x0018:
            byte[] r1 = r5.f9466a     // Catch:{ all -> 0x003e }
            if (r0 == r1) goto L_0x0026
            byte[] r0 = r5.f9466a     // Catch:{ all -> 0x003e }
            if (r0 == 0) goto L_0x0021
            goto L_0x0026
        L_0x0021:
            java.io.IOException r0 = e()     // Catch:{ all -> 0x003e }
            throw r0     // Catch:{ all -> 0x003e }
        L_0x0026:
            int r1 = r5.f9467b     // Catch:{ all -> 0x003e }
            int r2 = r5.f9470e     // Catch:{ all -> 0x003e }
            int r1 = r1 - r2
            if (r1 <= 0) goto L_0x0037
            int r1 = r2 + 1
            r5.f9470e = r1     // Catch:{ all -> 0x003e }
            byte r0 = r0[r2]     // Catch:{ all -> 0x003e }
            r0 = r0 & 255(0xff, float:3.57E-43)
            monitor-exit(r5)
            return r0
        L_0x0037:
            monitor-exit(r5)
            return r4
        L_0x0039:
            java.io.IOException r0 = e()     // Catch:{ all -> 0x003e }
            throw r0     // Catch:{ all -> 0x003e }
        L_0x003e:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream.read():int");
    }

    public synchronized void reset() throws IOException {
        if (this.f9466a != null) {
            int i10 = this.f9469d;
            if (-1 != i10) {
                this.f9470e = i10;
            } else {
                throw new InvalidMarkException("Mark has been invalidated, pos: " + this.f9470e + " markLimit: " + this.f9468c);
            }
        } else {
            throw new IOException("Stream is closed");
        }
    }

    public synchronized long skip(long j10) throws IOException {
        if (j10 < 1) {
            return 0;
        }
        byte[] bArr = this.f9466a;
        if (bArr != null) {
            InputStream inputStream = this.in;
            if (inputStream != null) {
                int i10 = this.f9467b;
                int i11 = this.f9470e;
                if (((long) (i10 - i11)) >= j10) {
                    this.f9470e = (int) (((long) i11) + j10);
                    return j10;
                }
                long j11 = ((long) i10) - ((long) i11);
                this.f9470e = i10;
                if (this.f9469d == -1 || j10 > ((long) this.f9468c)) {
                    return j11 + inputStream.skip(j10 - j11);
                } else if (a(inputStream, bArr) == -1) {
                    return j11;
                } else {
                    int i12 = this.f9467b;
                    int i13 = this.f9470e;
                    if (((long) (i12 - i13)) >= j10 - j11) {
                        this.f9470e = (int) ((((long) i13) + j10) - j11);
                        return j10;
                    }
                    long j12 = (j11 + ((long) i12)) - ((long) i13);
                    this.f9470e = i12;
                    return j12;
                }
            } else {
                throw e();
            }
        } else {
            throw e();
        }
    }

    RecyclableBufferedInputStream(@NonNull InputStream inputStream, @NonNull b bVar, int i10) {
        super(inputStream);
        this.f9469d = -1;
        this.f9471f = bVar;
        this.f9466a = (byte[]) bVar.c(i10, byte[].class);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0031, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0047, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0054, code lost:
        return r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int read(@androidx.annotation.NonNull byte[] r7, int r8, int r9) throws java.io.IOException {
        /*
            r6 = this;
            monitor-enter(r6)
            byte[] r0 = r6.f9466a     // Catch:{ all -> 0x0090 }
            if (r0 == 0) goto L_0x008b
            if (r9 != 0) goto L_0x000a
            r7 = 0
            monitor-exit(r6)
            return r7
        L_0x000a:
            java.io.InputStream r1 = r6.in     // Catch:{ all -> 0x0090 }
            if (r1 == 0) goto L_0x0086
            int r2 = r6.f9470e     // Catch:{ all -> 0x0090 }
            int r3 = r6.f9467b     // Catch:{ all -> 0x0090 }
            if (r2 >= r3) goto L_0x0032
            int r4 = r3 - r2
            if (r4 < r9) goto L_0x001a
            r3 = r9
            goto L_0x001b
        L_0x001a:
            int r3 = r3 - r2
        L_0x001b:
            java.lang.System.arraycopy(r0, r2, r7, r8, r3)     // Catch:{ all -> 0x0090 }
            int r2 = r6.f9470e     // Catch:{ all -> 0x0090 }
            int r2 = r2 + r3
            r6.f9470e = r2     // Catch:{ all -> 0x0090 }
            if (r3 == r9) goto L_0x0030
            int r2 = r1.available()     // Catch:{ all -> 0x0090 }
            if (r2 != 0) goto L_0x002c
            goto L_0x0030
        L_0x002c:
            int r8 = r8 + r3
            int r2 = r9 - r3
            goto L_0x0033
        L_0x0030:
            monitor-exit(r6)
            return r3
        L_0x0032:
            r2 = r9
        L_0x0033:
            int r3 = r6.f9469d     // Catch:{ all -> 0x0090 }
            r4 = -1
            if (r3 != r4) goto L_0x0048
            int r3 = r0.length     // Catch:{ all -> 0x0090 }
            if (r2 < r3) goto L_0x0048
            int r3 = r1.read(r7, r8, r2)     // Catch:{ all -> 0x0090 }
            if (r3 != r4) goto L_0x0076
            if (r2 != r9) goto L_0x0044
            goto L_0x0046
        L_0x0044:
            int r4 = r9 - r2
        L_0x0046:
            monitor-exit(r6)
            return r4
        L_0x0048:
            int r3 = r6.a(r1, r0)     // Catch:{ all -> 0x0090 }
            if (r3 != r4) goto L_0x0055
            if (r2 != r9) goto L_0x0051
            goto L_0x0053
        L_0x0051:
            int r4 = r9 - r2
        L_0x0053:
            monitor-exit(r6)
            return r4
        L_0x0055:
            byte[] r3 = r6.f9466a     // Catch:{ all -> 0x0090 }
            if (r0 == r3) goto L_0x0063
            byte[] r0 = r6.f9466a     // Catch:{ all -> 0x0090 }
            if (r0 == 0) goto L_0x005e
            goto L_0x0063
        L_0x005e:
            java.io.IOException r7 = e()     // Catch:{ all -> 0x0090 }
            throw r7     // Catch:{ all -> 0x0090 }
        L_0x0063:
            int r3 = r6.f9467b     // Catch:{ all -> 0x0090 }
            int r4 = r6.f9470e     // Catch:{ all -> 0x0090 }
            int r5 = r3 - r4
            if (r5 < r2) goto L_0x006d
            r3 = r2
            goto L_0x006e
        L_0x006d:
            int r3 = r3 - r4
        L_0x006e:
            java.lang.System.arraycopy(r0, r4, r7, r8, r3)     // Catch:{ all -> 0x0090 }
            int r4 = r6.f9470e     // Catch:{ all -> 0x0090 }
            int r4 = r4 + r3
            r6.f9470e = r4     // Catch:{ all -> 0x0090 }
        L_0x0076:
            int r2 = r2 - r3
            if (r2 != 0) goto L_0x007b
            monitor-exit(r6)
            return r9
        L_0x007b:
            int r4 = r1.available()     // Catch:{ all -> 0x0090 }
            if (r4 != 0) goto L_0x0084
            int r9 = r9 - r2
            monitor-exit(r6)
            return r9
        L_0x0084:
            int r8 = r8 + r3
            goto L_0x0033
        L_0x0086:
            java.io.IOException r7 = e()     // Catch:{ all -> 0x0090 }
            throw r7     // Catch:{ all -> 0x0090 }
        L_0x008b:
            java.io.IOException r7 = e()     // Catch:{ all -> 0x0090 }
            throw r7     // Catch:{ all -> 0x0090 }
        L_0x0090:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream.read(byte[], int, int):int");
    }
}
