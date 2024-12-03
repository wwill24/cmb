package androidx.emoji2.text;

import androidx.annotation.NonNull;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.jivesoftware.smack.datatypes.UInt32;

class l {

    private static class a implements c {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        private final ByteBuffer f5486a;

        a(@NonNull ByteBuffer byteBuffer) {
            this.f5486a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        public int a() throws IOException {
            return this.f5486a.getInt();
        }

        public void b(int i10) throws IOException {
            ByteBuffer byteBuffer = this.f5486a;
            byteBuffer.position(byteBuffer.position() + i10);
        }

        public long c() throws IOException {
            return l.c(this.f5486a.getInt());
        }

        public long getPosition() {
            return (long) this.f5486a.position();
        }

        public int readUnsignedShort() throws IOException {
            return l.d(this.f5486a.getShort());
        }
    }

    private static class b {

        /* renamed from: a  reason: collision with root package name */
        private final long f5487a;

        /* renamed from: b  reason: collision with root package name */
        private final long f5488b;

        b(long j10, long j11) {
            this.f5487a = j10;
            this.f5488b = j11;
        }

        /* access modifiers changed from: package-private */
        public long a() {
            return this.f5487a;
        }
    }

    private interface c {
        int a() throws IOException;

        void b(int i10) throws IOException;

        long c() throws IOException;

        long getPosition();

        int readUnsignedShort() throws IOException;
    }

    private static b a(c cVar) throws IOException {
        long j10;
        cVar.b(4);
        int readUnsignedShort = cVar.readUnsignedShort();
        if (readUnsignedShort <= 100) {
            cVar.b(6);
            int i10 = 0;
            while (true) {
                if (i10 >= readUnsignedShort) {
                    j10 = -1;
                    break;
                }
                int a10 = cVar.a();
                cVar.b(4);
                j10 = cVar.c();
                cVar.b(4);
                if (1835365473 == a10) {
                    break;
                }
                i10++;
            }
            if (j10 != -1) {
                cVar.b((int) (j10 - cVar.getPosition()));
                cVar.b(12);
                long c10 = cVar.c();
                for (int i11 = 0; ((long) i11) < c10; i11++) {
                    int a11 = cVar.a();
                    long c11 = cVar.c();
                    long c12 = cVar.c();
                    if (1164798569 == a11 || 1701669481 == a11) {
                        return new b(c11 + j10, c12);
                    }
                }
            }
            throw new IOException("Cannot read metadata.");
        }
        throw new IOException("Cannot read metadata.");
    }

    static f1.b b(ByteBuffer byteBuffer) throws IOException {
        ByteBuffer duplicate = byteBuffer.duplicate();
        duplicate.position((int) a(new a(duplicate)).a());
        return f1.b.h(duplicate);
    }

    static long c(int i10) {
        return ((long) i10) & UInt32.MAX_VALUE_LONG;
    }

    static int d(short s10) {
        return s10 & 65535;
    }
}
