package w3;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import f4.k;
import g3.a;
import g3.c;
import g3.d;
import g3.e;
import i3.f;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Queue;

public class a implements f<ByteBuffer, c> {

    /* renamed from: f  reason: collision with root package name */
    private static final C0215a f18188f = new C0215a();

    /* renamed from: g  reason: collision with root package name */
    private static final b f18189g = new b();

    /* renamed from: a  reason: collision with root package name */
    private final Context f18190a;

    /* renamed from: b  reason: collision with root package name */
    private final List<ImageHeaderParser> f18191b;

    /* renamed from: c  reason: collision with root package name */
    private final b f18192c;

    /* renamed from: d  reason: collision with root package name */
    private final C0215a f18193d;

    /* renamed from: e  reason: collision with root package name */
    private final b f18194e;

    /* renamed from: w3.a$a  reason: collision with other inner class name */
    static class C0215a {
        C0215a() {
        }

        /* access modifiers changed from: package-private */
        public g3.a a(a.C0161a aVar, c cVar, ByteBuffer byteBuffer, int i10) {
            return new e(aVar, cVar, byteBuffer, i10);
        }
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        private final Queue<d> f18195a = k.e(0);

        b() {
        }

        /* access modifiers changed from: package-private */
        public synchronized d a(ByteBuffer byteBuffer) {
            d poll;
            poll = this.f18195a.poll();
            if (poll == null) {
                poll = new d();
            }
            return poll.p(byteBuffer);
        }

        /* access modifiers changed from: package-private */
        public synchronized void b(d dVar) {
            dVar.a();
            this.f18195a.offer(dVar);
        }
    }

    public a(Context context, List<ImageHeaderParser> list, m3.d dVar, m3.b bVar) {
        this(context, list, dVar, bVar, f18189g, f18188f);
    }

    private e c(ByteBuffer byteBuffer, int i10, int i11, d dVar, i3.e eVar) {
        Bitmap.Config config;
        long b10 = f4.f.b();
        try {
            c c10 = dVar.c();
            if (c10.b() > 0) {
                if (c10.c() == 0) {
                    if (eVar.a(i.f18236a) == DecodeFormat.PREFER_RGB_565) {
                        config = Bitmap.Config.RGB_565;
                    } else {
                        config = Bitmap.Config.ARGB_8888;
                    }
                    g3.a a10 = this.f18193d.a(this.f18194e, c10, byteBuffer, e(c10, i10, i11));
                    a10.d(config);
                    a10.b();
                    Bitmap a11 = a10.a();
                    if (a11 == null) {
                        if (Log.isLoggable("BufferGifDecoder", 2)) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Decoded GIF from stream in ");
                            sb2.append(f4.f.a(b10));
                        }
                        return null;
                    }
                    e eVar2 = new e(new c(this.f18190a, a10, r3.c.a(), i10, i11, a11));
                    if (Log.isLoggable("BufferGifDecoder", 2)) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("Decoded GIF from stream in ");
                        sb3.append(f4.f.a(b10));
                    }
                    return eVar2;
                }
            }
            return null;
        } finally {
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("Decoded GIF from stream in ");
                sb4.append(f4.f.a(b10));
            }
        }
    }

    private static int e(c cVar, int i10, int i11) {
        int i12;
        int min = Math.min(cVar.a() / i11, cVar.d() / i10);
        if (min == 0) {
            i12 = 0;
        } else {
            i12 = Integer.highestOneBit(min);
        }
        int max = Math.max(1, i12);
        if (Log.isLoggable("BufferGifDecoder", 2) && max > 1) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Downsampling GIF, sampleSize: ");
            sb2.append(max);
            sb2.append(", target dimens: [");
            sb2.append(i10);
            sb2.append("x");
            sb2.append(i11);
            sb2.append("], actual dimens: [");
            sb2.append(cVar.d());
            sb2.append("x");
            sb2.append(cVar.a());
            sb2.append("]");
        }
        return max;
    }

    /* renamed from: d */
    public e a(@NonNull ByteBuffer byteBuffer, int i10, int i11, @NonNull i3.e eVar) {
        d a10 = this.f18192c.a(byteBuffer);
        try {
            return c(byteBuffer, i10, i11, a10, eVar);
        } finally {
            this.f18192c.b(a10);
        }
    }

    /* renamed from: f */
    public boolean b(@NonNull ByteBuffer byteBuffer, @NonNull i3.e eVar) throws IOException {
        if (((Boolean) eVar.a(i.f18237b)).booleanValue() || com.bumptech.glide.load.a.f(this.f18191b, byteBuffer) != ImageHeaderParser.ImageType.GIF) {
            return false;
        }
        return true;
    }

    a(Context context, List<ImageHeaderParser> list, m3.d dVar, m3.b bVar, b bVar2, C0215a aVar) {
        this.f18190a = context.getApplicationContext();
        this.f18191b = list;
        this.f18193d = aVar;
        this.f18194e = new b(dVar, bVar);
        this.f18192c = bVar2;
    }
}
