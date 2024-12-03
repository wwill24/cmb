package qn;

import java.util.Arrays;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private final Object f41809a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final char[] f41810b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f41811c = true;

    public c(char[] cArr) {
        this.f41810b = cArr;
    }

    public void a() {
        synchronized (this.f41809a) {
            char[] cArr = this.f41810b;
            if (cArr != null) {
                Arrays.fill(cArr, ' ');
            }
            this.f41811c = false;
        }
    }

    public char[] b() {
        synchronized (this.f41809a) {
            if (this.f41811c) {
                char[] cArr = this.f41810b;
                if (cArr == null) {
                    return null;
                }
                char[] cArr2 = new char[cArr.length];
                System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
                return cArr2;
            }
            throw new IllegalStateException("Passphrase has been cleared.");
        }
    }
}
