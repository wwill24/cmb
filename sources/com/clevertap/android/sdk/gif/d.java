package com.clevertap.android.sdk.gif;

import com.clevertap.android.sdk.p;
import com.google.android.gms.common.api.a;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

class d {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f10286a = new byte[256];

    /* renamed from: b  reason: collision with root package name */
    private int f10287b = 0;

    /* renamed from: c  reason: collision with root package name */
    private c f10288c;

    /* renamed from: d  reason: collision with root package name */
    private ByteBuffer f10289d;

    d() {
    }

    private boolean a() {
        return this.f10288c.f10284l != 0;
    }

    private int c() {
        try {
            return this.f10289d.get() & 255;
        } catch (Exception unused) {
            this.f10288c.f10284l = 1;
            return 0;
        }
    }

    private void d() {
        boolean z10;
        this.f10288c.f10275c.f10266e = m();
        this.f10288c.f10275c.f10267f = m();
        this.f10288c.f10275c.f10268g = m();
        this.f10288c.f10275c.f10269h = m();
        int c10 = c();
        boolean z11 = false;
        if ((c10 & 128) != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        int pow = (int) Math.pow(2.0d, (double) ((c10 & 7) + 1));
        b bVar = this.f10288c.f10275c;
        if ((c10 & 64) != 0) {
            z11 = true;
        }
        bVar.f10265d = z11;
        if (z10) {
            bVar.f10270i = f(pow);
        } else {
            bVar.f10270i = null;
        }
        this.f10288c.f10275c.f10262a = this.f10289d.position();
        r();
        if (!a()) {
            c cVar = this.f10288c;
            cVar.f10276d++;
            cVar.f10277e.add(cVar.f10275c);
        }
    }

    private int e() {
        int c10 = c();
        this.f10287b = c10;
        int i10 = 0;
        if (c10 > 0) {
            while (true) {
                try {
                    int i11 = this.f10287b;
                    if (i10 >= i11) {
                        break;
                    }
                    int i12 = i11 - i10;
                    this.f10289d.get(this.f10286a, i10, i12);
                    i10 += i12;
                } catch (Exception unused) {
                    this.f10288c.f10284l = 1;
                }
            }
        }
        return i10;
    }

    private int[] f(int i10) {
        byte[] bArr = new byte[(i10 * 3)];
        int[] iArr = null;
        try {
            this.f10289d.get(bArr);
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
        } catch (BufferUnderflowException e10) {
            p.c("GifHeaderParser", "Format Error Reading Color Table", e10);
            this.f10288c.f10284l = 1;
        }
        return iArr;
    }

    private void g() {
        h(a.e.API_PRIORITY_OTHER);
    }

    private void h(int i10) {
        boolean z10 = false;
        while (!z10 && !a() && this.f10288c.f10276d <= i10) {
            int c10 = c();
            if (c10 == 33) {
                int c11 = c();
                if (c11 == 1) {
                    q();
                } else if (c11 == 249) {
                    this.f10288c.f10275c = new b();
                    i();
                } else if (c11 == 254) {
                    q();
                } else if (c11 != 255) {
                    q();
                } else {
                    e();
                    String str = "";
                    for (int i11 = 0; i11 < 11; i11++) {
                        str = str + ((char) this.f10286a[i11]);
                    }
                    if (str.equals("NETSCAPE2.0")) {
                        l();
                    } else {
                        q();
                    }
                }
            } else if (c10 == 44) {
                c cVar = this.f10288c;
                if (cVar.f10275c == null) {
                    cVar.f10275c = new b();
                }
                d();
            } else if (c10 != 59) {
                this.f10288c.f10284l = 1;
            } else {
                z10 = true;
            }
        }
    }

    private void i() {
        c();
        int c10 = c();
        b bVar = this.f10288c.f10275c;
        int i10 = (c10 & 28) >> 2;
        bVar.f10264c = i10;
        boolean z10 = true;
        if (i10 == 0) {
            bVar.f10264c = 1;
        }
        if ((c10 & 1) == 0) {
            z10 = false;
        }
        bVar.f10272k = z10;
        int m10 = m();
        if (m10 < 2) {
            m10 = 10;
        }
        b bVar2 = this.f10288c.f10275c;
        bVar2.f10263b = m10 * 10;
        bVar2.f10271j = c();
        c();
    }

    private void j() {
        String str = "";
        for (int i10 = 0; i10 < 6; i10++) {
            str = str + ((char) c());
        }
        if (!str.startsWith("GIF")) {
            this.f10288c.f10284l = 1;
            return;
        }
        k();
        if (this.f10288c.f10279g && !a()) {
            c cVar = this.f10288c;
            cVar.f10278f = f(cVar.f10280h);
            c cVar2 = this.f10288c;
            cVar2.f10273a = cVar2.f10278f[cVar2.f10274b];
        }
    }

    private void k() {
        boolean z10;
        this.f10288c.f10285m = m();
        this.f10288c.f10281i = m();
        int c10 = c();
        c cVar = this.f10288c;
        if ((c10 & 128) != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        cVar.f10279g = z10;
        cVar.f10280h = 2 << (c10 & 7);
        cVar.f10274b = c();
        this.f10288c.f10283k = c();
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void l() {
        /*
            r3 = this;
        L_0x0000:
            r3.e()
            byte[] r0 = r3.f10286a
            r1 = 0
            byte r1 = r0[r1]
            r2 = 1
            if (r1 != r2) goto L_0x0020
            byte r1 = r0[r2]
            r1 = r1 & 255(0xff, float:3.57E-43)
            r2 = 2
            byte r0 = r0[r2]
            r0 = r0 & 255(0xff, float:3.57E-43)
            com.clevertap.android.sdk.gif.c r2 = r3.f10288c
            int r0 = r0 << 8
            r0 = r0 | r1
            r2.f10282j = r0
            if (r0 != 0) goto L_0x0020
            r0 = -1
            r2.f10282j = r0
        L_0x0020:
            int r0 = r3.f10287b
            if (r0 <= 0) goto L_0x002a
            boolean r0 = r3.a()
            if (r0 == 0) goto L_0x0000
        L_0x002a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.gif.d.l():void");
    }

    private int m() {
        return this.f10289d.getShort();
    }

    private void n() {
        this.f10289d = null;
        Arrays.fill(this.f10286a, (byte) 0);
        this.f10288c = new c();
        this.f10287b = 0;
    }

    private void q() {
        int c10;
        do {
            try {
                c10 = c();
                ByteBuffer byteBuffer = this.f10289d;
                byteBuffer.position(byteBuffer.position() + c10);
            } catch (IllegalArgumentException unused) {
                return;
            }
        } while (c10 > 0);
    }

    private void r() {
        c();
        q();
    }

    /* access modifiers changed from: package-private */
    public c b() {
        if (this.f10289d == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        } else if (a()) {
            return this.f10288c;
        } else {
            j();
            if (!a()) {
                g();
                c cVar = this.f10288c;
                if (cVar.f10276d < 0) {
                    cVar.f10284l = 1;
                }
            }
            return this.f10288c;
        }
    }

    public d o(ByteBuffer byteBuffer) {
        n();
        ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        this.f10289d = asReadOnlyBuffer;
        asReadOnlyBuffer.position(0);
        this.f10289d.order(ByteOrder.LITTLE_ENDIAN);
        return this;
    }

    public d p(byte[] bArr) {
        if (bArr != null) {
            o(ByteBuffer.wrap(bArr));
        } else {
            this.f10289d = null;
            this.f10288c.f10284l = 2;
        }
        return this;
    }
}
