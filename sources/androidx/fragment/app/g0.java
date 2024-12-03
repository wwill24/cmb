package androidx.fragment.app;

import java.io.Writer;

final class g0 extends Writer {

    /* renamed from: a  reason: collision with root package name */
    private final String f5849a;

    /* renamed from: b  reason: collision with root package name */
    private StringBuilder f5850b = new StringBuilder(128);

    g0(String str) {
        this.f5849a = str;
    }

    private void a() {
        if (this.f5850b.length() > 0) {
            this.f5850b.toString();
            StringBuilder sb2 = this.f5850b;
            sb2.delete(0, sb2.length());
        }
    }

    public void close() {
        a();
    }

    public void flush() {
        a();
    }

    public void write(char[] cArr, int i10, int i11) {
        for (int i12 = 0; i12 < i11; i12++) {
            char c10 = cArr[i10 + i12];
            if (c10 == 10) {
                a();
            } else {
                this.f5850b.append(c10);
            }
        }
    }
}
