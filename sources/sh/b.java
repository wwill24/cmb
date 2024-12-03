package sh;

import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import rh.a;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private Mode f24490a;

    /* renamed from: b  reason: collision with root package name */
    private ErrorCorrectionLevel f24491b;

    /* renamed from: c  reason: collision with root package name */
    private a f24492c;

    /* renamed from: d  reason: collision with root package name */
    private int f24493d = -1;

    /* renamed from: e  reason: collision with root package name */
    private a f24494e;

    public static boolean b(int i10) {
        return i10 >= 0 && i10 < 8;
    }

    public a a() {
        return this.f24494e;
    }

    public void c(ErrorCorrectionLevel errorCorrectionLevel) {
        this.f24491b = errorCorrectionLevel;
    }

    public void d(int i10) {
        this.f24493d = i10;
    }

    public void e(a aVar) {
        this.f24494e = aVar;
    }

    public void f(Mode mode) {
        this.f24490a = mode;
    }

    public void g(a aVar) {
        this.f24492c = aVar;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(200);
        sb2.append("<<\n");
        sb2.append(" mode: ");
        sb2.append(this.f24490a);
        sb2.append("\n ecLevel: ");
        sb2.append(this.f24491b);
        sb2.append("\n version: ");
        sb2.append(this.f24492c);
        sb2.append("\n maskPattern: ");
        sb2.append(this.f24493d);
        if (this.f24494e == null) {
            sb2.append("\n matrix: null\n");
        } else {
            sb2.append("\n matrix:\n");
            sb2.append(this.f24494e);
        }
        sb2.append(">>\n");
        return sb2.toString();
    }
}
