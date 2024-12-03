package r3;

import android.annotation.SuppressLint;
import android.graphics.ColorSpace;
import android.graphics.ImageDecoder;
import android.os.Build;
import android.util.Log;
import android.util.Size;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.PreferredColorSpace;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.b;
import i3.d;
import i3.e;
import i3.f;
import java.io.IOException;
import l3.c;

public abstract class a<T> implements f<ImageDecoder.Source, T> {

    /* renamed from: a  reason: collision with root package name */
    final b f17261a = b.a();

    /* renamed from: r3.a$a  reason: collision with other inner class name */
    class C0199a implements ImageDecoder.OnHeaderDecodedListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f17262a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f17263b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f17264c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ DecodeFormat f17265d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ DownsampleStrategy f17266e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ PreferredColorSpace f17267f;

        /* renamed from: r3.a$a$a  reason: collision with other inner class name */
        class C0200a implements ImageDecoder.OnPartialImageListener {
            C0200a() {
            }

            public boolean onPartialImage(@NonNull ImageDecoder.DecodeException decodeException) {
                return false;
            }
        }

        C0199a(int i10, int i11, boolean z10, DecodeFormat decodeFormat, DownsampleStrategy downsampleStrategy, PreferredColorSpace preferredColorSpace) {
            this.f17262a = i10;
            this.f17263b = i11;
            this.f17264c = z10;
            this.f17265d = decodeFormat;
            this.f17266e = downsampleStrategy;
            this.f17267f = preferredColorSpace;
        }

        @SuppressLint({"Override"})
        public void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
            ColorSpace.Named named;
            boolean z10 = false;
            if (a.this.f17261a.c(this.f17262a, this.f17263b, this.f17264c, false)) {
                imageDecoder.setAllocator(3);
            } else {
                imageDecoder.setAllocator(1);
            }
            if (this.f17265d == DecodeFormat.PREFER_RGB_565) {
                imageDecoder.setMemorySizePolicy(0);
            }
            imageDecoder.setOnPartialImageListener(new C0200a());
            Size size = imageInfo.getSize();
            int i10 = this.f17262a;
            if (i10 == Integer.MIN_VALUE) {
                i10 = size.getWidth();
            }
            int i11 = this.f17263b;
            if (i11 == Integer.MIN_VALUE) {
                i11 = size.getHeight();
            }
            float b10 = this.f17266e.b(size.getWidth(), size.getHeight(), i10, i11);
            int round = Math.round(((float) size.getWidth()) * b10);
            int round2 = Math.round(((float) size.getHeight()) * b10);
            if (Log.isLoggable("ImageDecoder", 2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Resizing from [");
                sb2.append(size.getWidth());
                sb2.append("x");
                sb2.append(size.getHeight());
                sb2.append("] to [");
                sb2.append(round);
                sb2.append("x");
                sb2.append(round2);
                sb2.append("] scaleFactor: ");
                sb2.append(b10);
            }
            imageDecoder.setTargetSize(round, round2);
            int i12 = Build.VERSION.SDK_INT;
            if (i12 >= 28) {
                if (this.f17267f == PreferredColorSpace.DISPLAY_P3 && imageInfo.getColorSpace() != null && imageInfo.getColorSpace().isWideGamut()) {
                    z10 = true;
                }
                if (z10) {
                    named = ColorSpace.Named.DISPLAY_P3;
                } else {
                    named = ColorSpace.Named.SRGB;
                }
                imageDecoder.setTargetColorSpace(ColorSpace.get(named));
            } else if (i12 >= 26) {
                imageDecoder.setTargetColorSpace(ColorSpace.get(ColorSpace.Named.SRGB));
            }
        }
    }

    /* access modifiers changed from: protected */
    public abstract c<T> c(ImageDecoder.Source source, int i10, int i11, ImageDecoder.OnHeaderDecodedListener onHeaderDecodedListener) throws IOException;

    /* renamed from: d */
    public final c<T> a(@NonNull ImageDecoder.Source source, int i10, int i11, @NonNull e eVar) throws IOException {
        boolean z10;
        DecodeFormat decodeFormat = (DecodeFormat) eVar.a(com.bumptech.glide.load.resource.bitmap.a.f9472f);
        DownsampleStrategy downsampleStrategy = (DownsampleStrategy) eVar.a(DownsampleStrategy.f9461h);
        d dVar = com.bumptech.glide.load.resource.bitmap.a.f9476j;
        if (eVar.a(dVar) == null || !((Boolean) eVar.a(dVar)).booleanValue()) {
            z10 = false;
        } else {
            z10 = true;
        }
        return c(source, i10, i11, new C0199a(i10, i11, z10, decodeFormat, downsampleStrategy, (PreferredColorSpace) eVar.a(com.bumptech.glide.load.resource.bitmap.a.f9473g)));
    }

    /* renamed from: e */
    public final boolean b(@NonNull ImageDecoder.Source source, @NonNull e eVar) {
        return true;
    }
}
