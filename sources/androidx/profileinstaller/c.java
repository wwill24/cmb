package androidx.profileinstaller;

import android.content.res.AssetManager;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.profileinstaller.h;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;
import org.jivesoftware.smack.compress.packet.Compressed;

public class c {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final AssetManager f6145a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final Executor f6146b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final h.c f6147c;

    /* renamed from: d  reason: collision with root package name */
    private final byte[] f6148d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private final File f6149e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private final String f6150f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    private final String f6151g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    private final String f6152h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f6153i = false;

    /* renamed from: j  reason: collision with root package name */
    private d[] f6154j;

    /* renamed from: k  reason: collision with root package name */
    private byte[] f6155k;

    public c(@NonNull AssetManager assetManager, @NonNull Executor executor, @NonNull h.c cVar, @NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull File file) {
        this.f6145a = assetManager;
        this.f6146b = executor;
        this.f6147c = cVar;
        this.f6150f = str;
        this.f6151g = str2;
        this.f6152h = str3;
        this.f6149e = file;
        this.f6148d = d();
    }

    private c b(d[] dVarArr, byte[] bArr) {
        InputStream h10;
        try {
            h10 = h(this.f6145a, this.f6152h);
            if (h10 != null) {
                this.f6154j = m.q(h10, m.o(h10, m.f6176b), bArr, dVarArr);
                h10.close();
                return this;
            }
            if (h10 != null) {
                h10.close();
            }
            return null;
        } catch (FileNotFoundException e10) {
            this.f6147c.a(9, e10);
        } catch (IOException e11) {
            this.f6147c.a(7, e11);
        } catch (IllegalStateException e12) {
            this.f6154j = null;
            this.f6147c.a(8, e12);
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }

    private void c() {
        if (!this.f6153i) {
            throw new IllegalStateException("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
        }
    }

    private static byte[] d() {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 > 33) {
            return null;
        }
        switch (i10) {
            case 25:
                return o.f6191e;
            case 26:
                return o.f6190d;
            case 27:
                return o.f6189c;
            case 28:
            case 29:
            case 30:
                return o.f6188b;
            case 31:
            case 32:
            case 33:
                return o.f6187a;
            default:
                return null;
        }
    }

    private InputStream f(AssetManager assetManager) {
        try {
            return h(assetManager, this.f6151g);
        } catch (FileNotFoundException e10) {
            this.f6147c.a(6, e10);
            return null;
        } catch (IOException e11) {
            this.f6147c.a(7, e11);
            return null;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void g(int i10, Object obj) {
        this.f6147c.a(i10, obj);
    }

    private InputStream h(AssetManager assetManager, String str) throws IOException {
        try {
            return assetManager.openFd(str).createInputStream();
        } catch (FileNotFoundException e10) {
            String message = e10.getMessage();
            if (message == null || !message.contains(Compressed.ELEMENT)) {
                return null;
            }
            this.f6147c.b(5, (Object) null);
            return null;
        }
    }

    private d[] j(InputStream inputStream) {
        try {
            d[] w10 = m.w(inputStream, m.o(inputStream, m.f6175a), this.f6150f);
            try {
                inputStream.close();
                return w10;
            } catch (IOException e10) {
                this.f6147c.a(7, e10);
                return w10;
            }
        } catch (IOException e11) {
            this.f6147c.a(7, e11);
            inputStream.close();
            return null;
        } catch (IllegalStateException e12) {
            this.f6147c.a(8, e12);
            try {
                inputStream.close();
            } catch (IOException e13) {
                this.f6147c.a(7, e13);
            }
            return null;
        } catch (Throwable th2) {
            try {
                inputStream.close();
            } catch (IOException e14) {
                this.f6147c.a(7, e14);
            }
            throw th2;
        }
    }

    private static boolean k() {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 > 33) {
            return false;
        }
        if (i10 != 25) {
            switch (i10) {
                case 31:
                case 32:
                case 33:
                    break;
                default:
                    return false;
            }
        }
        return true;
    }

    private void l(int i10, Object obj) {
        this.f6146b.execute(new b(this, i10, obj));
    }

    public boolean e() {
        if (this.f6148d == null) {
            l(3, Integer.valueOf(Build.VERSION.SDK_INT));
            return false;
        } else if (!this.f6149e.canWrite()) {
            l(4, (Object) null);
            return false;
        } else {
            this.f6153i = true;
            return true;
        }
    }

    @NonNull
    public c i() {
        c b10;
        c();
        if (this.f6148d == null) {
            return this;
        }
        InputStream f10 = f(this.f6145a);
        if (f10 != null) {
            this.f6154j = j(f10);
        }
        d[] dVarArr = this.f6154j;
        if (dVarArr == null || !k() || (b10 = b(dVarArr, this.f6148d)) == null) {
            return this;
        }
        return b10;
    }

    @NonNull
    public c m() {
        ByteArrayOutputStream byteArrayOutputStream;
        d[] dVarArr = this.f6154j;
        byte[] bArr = this.f6148d;
        if (!(dVarArr == null || bArr == null)) {
            c();
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                m.E(byteArrayOutputStream, bArr);
                if (!m.B(byteArrayOutputStream, bArr, dVarArr)) {
                    this.f6147c.a(5, (Object) null);
                    this.f6154j = null;
                    byteArrayOutputStream.close();
                    return this;
                }
                this.f6155k = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                this.f6154j = null;
            } catch (IOException e10) {
                this.f6147c.a(7, e10);
            } catch (IllegalStateException e11) {
                this.f6147c.a(8, e11);
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
        }
        return this;
        throw th;
    }

    public boolean n() {
        FileOutputStream fileOutputStream;
        byte[] bArr = this.f6155k;
        if (bArr == null) {
            return false;
        }
        c();
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                fileOutputStream = new FileOutputStream(this.f6149e);
                e.l(byteArrayInputStream, fileOutputStream);
                l(1, (Object) null);
                fileOutputStream.close();
                byteArrayInputStream.close();
                this.f6155k = null;
                this.f6154j = null;
                return true;
            } catch (Throwable th2) {
                byteArrayInputStream.close();
                throw th2;
            }
        } catch (FileNotFoundException e10) {
            l(6, e10);
            this.f6155k = null;
            this.f6154j = null;
            return false;
        } catch (IOException e11) {
            try {
                l(7, e11);
                this.f6155k = null;
                this.f6154j = null;
                return false;
            } catch (Throwable th3) {
                this.f6155k = null;
                this.f6154j = null;
                throw th3;
            }
        } catch (Throwable th4) {
            th2.addSuppressed(th4);
        }
        throw th;
    }
}
