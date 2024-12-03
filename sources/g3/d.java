package g3;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.a;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f15159a = new byte[256];

    /* renamed from: b  reason: collision with root package name */
    private ByteBuffer f15160b;

    /* renamed from: c  reason: collision with root package name */
    private c f15161c;

    /* renamed from: d  reason: collision with root package name */
    private int f15162d = 0;

    private boolean b() {
        return this.f15161c.f15147b != 0;
    }

    private int d() {
        try {
            return this.f15160b.get() & 255;
        } catch (Exception unused) {
            this.f15161c.f15147b = 1;
            return 0;
        }
    }

    private void e() {
        boolean z10;
        this.f15161c.f15149d.f15135a = n();
        this.f15161c.f15149d.f15136b = n();
        this.f15161c.f15149d.f15137c = n();
        this.f15161c.f15149d.f15138d = n();
        int d10 = d();
        boolean z11 = false;
        if ((d10 & 128) != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        int pow = (int) Math.pow(2.0d, (double) ((d10 & 7) + 1));
        b bVar = this.f15161c.f15149d;
        if ((d10 & 64) != 0) {
            z11 = true;
        }
        bVar.f15139e = z11;
        if (z10) {
            bVar.f15145k = g(pow);
        } else {
            bVar.f15145k = null;
        }
        this.f15161c.f15149d.f15144j = this.f15160b.position();
        r();
        if (!b()) {
            c cVar = this.f15161c;
            cVar.f15148c++;
            cVar.f15150e.add(cVar.f15149d);
        }
    }

    private void f() {
        int d10 = d();
        this.f15162d = d10;
        if (d10 > 0) {
            int i10 = 0;
            int i11 = 0;
            while (true) {
                try {
                    int i12 = this.f15162d;
                    if (i10 < i12) {
                        i11 = i12 - i10;
                        this.f15160b.get(this.f15159a, i10, i11);
                        i10 += i11;
                    } else {
                        return;
                    }
                } catch (Exception unused) {
                    if (Log.isLoggable("GifHeaderParser", 3)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Error Reading Block n: ");
                        sb2.append(i10);
                        sb2.append(" count: ");
                        sb2.append(i11);
                        sb2.append(" blockSize: ");
                        sb2.append(this.f15162d);
                    }
                    this.f15161c.f15147b = 1;
                    return;
                }
            }
        }
    }

    private int[] g(int i10) {
        byte[] bArr = new byte[(i10 * 3)];
        int[] iArr = null;
        try {
            this.f15160b.get(bArr);
            iArr = new int[256];
            int i11 = 0;
            int i12 = 0;
            while (i11 < i10) {
                int i13 = i12 + 1;
                int i14 = i13 + 1;
                int i15 = i14 + 1;
                int i16 = i11 + 1;
                iArr[i11] = ((bArr[i12] & 255) << Tnaf.POW_2_WIDTH) | -16777216 | ((bArr[i13] & 255) << 8) | (bArr[i14] & 255);
                i12 = i15;
                i11 = i16;
            }
        } catch (BufferUnderflowException unused) {
            Log.isLoggable("GifHeaderParser", 3);
            this.f15161c.f15147b = 1;
        }
        return iArr;
    }

    private void h() {
        i(a.e.API_PRIORITY_OTHER);
    }

    private void i(int i10) {
        boolean z10 = false;
        while (!z10 && !b() && this.f15161c.f15148c <= i10) {
            int d10 = d();
            if (d10 == 33) {
                int d11 = d();
                if (d11 == 1) {
                    q();
                } else if (d11 == 249) {
                    this.f15161c.f15149d = new b();
                    j();
                } else if (d11 == 254) {
                    q();
                } else if (d11 != 255) {
                    q();
                } else {
                    f();
                    StringBuilder sb2 = new StringBuilder();
                    for (int i11 = 0; i11 < 11; i11++) {
                        sb2.append((char) this.f15159a[i11]);
                    }
                    if (sb2.toString().equals("NETSCAPE2.0")) {
                        m();
                    } else {
                        q();
                    }
                }
            } else if (d10 == 44) {
                c cVar = this.f15161c;
                if (cVar.f15149d == null) {
                    cVar.f15149d = new b();
                }
                e();
            } else if (d10 != 59) {
                this.f15161c.f15147b = 1;
            } else {
                z10 = true;
            }
        }
    }

    private void j() {
        d();
        int d10 = d();
        b bVar = this.f15161c.f15149d;
        int i10 = (d10 & 28) >> 2;
        bVar.f15141g = i10;
        boolean z10 = true;
        if (i10 == 0) {
            bVar.f15141g = 1;
        }
        if ((d10 & 1) == 0) {
            z10 = false;
        }
        bVar.f15140f = z10;
        int n10 = n();
        if (n10 < 2) {
            n10 = 10;
        }
        b bVar2 = this.f15161c.f15149d;
        bVar2.f15143i = n10 * 10;
        bVar2.f15142h = d();
        d();
    }

    private void k() {
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < 6; i10++) {
            sb2.append((char) d());
        }
        if (!sb2.toString().startsWith("GIF")) {
            this.f15161c.f15147b = 1;
            return;
        }
        l();
        if (this.f15161c.f15153h && !b()) {
            c cVar = this.f15161c;
            cVar.f15146a = g(cVar.f15154i);
            c cVar2 = this.f15161c;
            cVar2.f15157l = cVar2.f15146a[cVar2.f15155j];
        }
    }

    private void l() {
        boolean z10;
        this.f15161c.f15151f = n();
        this.f15161c.f15152g = n();
        int d10 = d();
        c cVar = this.f15161c;
        if ((d10 & 128) != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        cVar.f15153h = z10;
        cVar.f15154i = (int) Math.pow(2.0d, (double) ((d10 & 7) + 1));
        this.f15161c.f15155j = d();
        this.f15161c.f15156k = d();
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m() {
        /*
            r3 = this;
        L_0x0000:
            r3.f()
            byte[] r0 = r3.f15159a
            r1 = 0
            byte r1 = r0[r1]
            r2 = 1
            if (r1 != r2) goto L_0x001b
            byte r1 = r0[r2]
            r1 = r1 & 255(0xff, float:3.57E-43)
            r2 = 2
            byte r0 = r0[r2]
            r0 = r0 & 255(0xff, float:3.57E-43)
            g3.c r2 = r3.f15161c
            int r0 = r0 << 8
            r0 = r0 | r1
            r2.f15158m = r0
        L_0x001b:
            int r0 = r3.f15162d
            if (r0 <= 0) goto L_0x0025
            boolean r0 = r3.b()
            if (r0 == 0) goto L_0x0000
        L_0x0025:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: g3.d.m():void");
    }

    private int n() {
        return this.f15160b.getShort();
    }

    private void o() {
        this.f15160b = null;
        Arrays.fill(this.f15159a, (byte) 0);
        this.f15161c = new c();
        this.f15162d = 0;
    }

    private void q() {
        int d10;
        do {
            d10 = d();
            this.f15160b.position(Math.min(this.f15160b.position() + d10, this.f15160b.limit()));
        } while (d10 > 0);
    }

    private void r() {
        d();
        q();
    }

    public void a() {
        this.f15160b = null;
        this.f15161c = null;
    }

    @NonNull
    public c c() {
        if (this.f15160b == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        } else if (b()) {
            return this.f15161c;
        } else {
            k();
            if (!b()) {
                h();
                c cVar = this.f15161c;
                if (cVar.f15148c < 0) {
                    cVar.f15147b = 1;
                }
            }
            return this.f15161c;
        }
    }

    public d p(@NonNull ByteBuffer byteBuffer) {
        o();
        ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        this.f15160b = asReadOnlyBuffer;
        asReadOnlyBuffer.position(0);
        this.f15160b.order(ByteOrder.LITTLE_ENDIAN);
        return this;
    }
}
