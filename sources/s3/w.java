package s3;

import android.annotation.TargetApi;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import i3.d;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

public class w<T> implements i3.f<T, Bitmap> {

    /* renamed from: d  reason: collision with root package name */
    public static final i3.d<Long> f17470d = i3.d.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, new a());

    /* renamed from: e  reason: collision with root package name */
    public static final i3.d<Integer> f17471e = i3.d.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, new b());

    /* renamed from: f  reason: collision with root package name */
    private static final e f17472f = new e();

    /* renamed from: a  reason: collision with root package name */
    private final f<T> f17473a;

    /* renamed from: b  reason: collision with root package name */
    private final m3.d f17474b;

    /* renamed from: c  reason: collision with root package name */
    private final e f17475c;

    class a implements d.b<Long> {

        /* renamed from: a  reason: collision with root package name */
        private final ByteBuffer f17476a = ByteBuffer.allocate(8);

        a() {
        }

        /* renamed from: b */
        public void a(@NonNull byte[] bArr, @NonNull Long l10, @NonNull MessageDigest messageDigest) {
            messageDigest.update(bArr);
            synchronized (this.f17476a) {
                this.f17476a.position(0);
                messageDigest.update(this.f17476a.putLong(l10.longValue()).array());
            }
        }
    }

    class b implements d.b<Integer> {

        /* renamed from: a  reason: collision with root package name */
        private final ByteBuffer f17477a = ByteBuffer.allocate(4);

        b() {
        }

        /* renamed from: b */
        public void a(@NonNull byte[] bArr, @NonNull Integer num, @NonNull MessageDigest messageDigest) {
            if (num != null) {
                messageDigest.update(bArr);
                synchronized (this.f17477a) {
                    this.f17477a.position(0);
                    messageDigest.update(this.f17477a.putInt(num.intValue()).array());
                }
            }
        }
    }

    private static final class c implements f<AssetFileDescriptor> {
        private c() {
        }

        /* synthetic */ c(a aVar) {
            this();
        }

        /* renamed from: b */
        public void a(MediaMetadataRetriever mediaMetadataRetriever, AssetFileDescriptor assetFileDescriptor) {
            mediaMetadataRetriever.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        }
    }

    static final class d implements f<ByteBuffer> {

        class a extends MediaDataSource {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ ByteBuffer f17478a;

            a(ByteBuffer byteBuffer) {
                this.f17478a = byteBuffer;
            }

            public void close() {
            }

            public long getSize() {
                return (long) this.f17478a.limit();
            }

            public int readAt(long j10, byte[] bArr, int i10, int i11) {
                if (j10 >= ((long) this.f17478a.limit())) {
                    return -1;
                }
                this.f17478a.position((int) j10);
                int min = Math.min(i11, this.f17478a.remaining());
                this.f17478a.get(bArr, i10, min);
                return min;
            }
        }

        d() {
        }

        /* renamed from: b */
        public void a(MediaMetadataRetriever mediaMetadataRetriever, ByteBuffer byteBuffer) {
            mediaMetadataRetriever.setDataSource(new a(byteBuffer));
        }
    }

    static class e {
        e() {
        }

        public MediaMetadataRetriever a() {
            return new MediaMetadataRetriever();
        }
    }

    interface f<T> {
        void a(MediaMetadataRetriever mediaMetadataRetriever, T t10);
    }

    static final class g implements f<ParcelFileDescriptor> {
        g() {
        }

        /* renamed from: b */
        public void a(MediaMetadataRetriever mediaMetadataRetriever, ParcelFileDescriptor parcelFileDescriptor) {
            mediaMetadataRetriever.setDataSource(parcelFileDescriptor.getFileDescriptor());
        }
    }

    w(m3.d dVar, f<T> fVar) {
        this(dVar, fVar, f17472f);
    }

    public static i3.f<AssetFileDescriptor, Bitmap> c(m3.d dVar) {
        return new w(dVar, new c((a) null));
    }

    public static i3.f<ByteBuffer, Bitmap> d(m3.d dVar) {
        return new w(dVar, new d());
    }

    private static Bitmap e(MediaMetadataRetriever mediaMetadataRetriever, long j10, int i10, int i11, int i12, DownsampleStrategy downsampleStrategy) {
        Bitmap bitmap;
        if (Build.VERSION.SDK_INT < 27 || i11 == Integer.MIN_VALUE || i12 == Integer.MIN_VALUE || downsampleStrategy == DownsampleStrategy.f9459f) {
            bitmap = null;
        } else {
            bitmap = g(mediaMetadataRetriever, j10, i10, i11, i12, downsampleStrategy);
        }
        if (bitmap == null) {
            return f(mediaMetadataRetriever, j10, i10);
        }
        return bitmap;
    }

    private static Bitmap f(MediaMetadataRetriever mediaMetadataRetriever, long j10, int i10) {
        return mediaMetadataRetriever.getFrameAtTime(j10, i10);
    }

    @TargetApi(27)
    private static Bitmap g(MediaMetadataRetriever mediaMetadataRetriever, long j10, int i10, int i11, int i12, DownsampleStrategy downsampleStrategy) {
        try {
            int parseInt = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
            int parseInt2 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
            int parseInt3 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
            if (parseInt3 == 90 || parseInt3 == 270) {
                int i13 = parseInt2;
                parseInt2 = parseInt;
                parseInt = i13;
            }
            float b10 = downsampleStrategy.b(parseInt, parseInt2, i11, i12);
            return mediaMetadataRetriever.getScaledFrameAtTime(j10, i10, Math.round(((float) parseInt) * b10), Math.round(b10 * ((float) parseInt2)));
        } catch (Throwable unused) {
            Log.isLoggable("VideoDecoder", 3);
            return null;
        }
    }

    public static i3.f<ParcelFileDescriptor, Bitmap> h(m3.d dVar) {
        return new w(dVar, new g());
    }

    public l3.c<Bitmap> a(@NonNull T t10, int i10, int i11, @NonNull i3.e eVar) throws IOException {
        long longValue = ((Long) eVar.a(f17470d)).longValue();
        if (longValue >= 0 || longValue == -1) {
            Integer num = (Integer) eVar.a(f17471e);
            if (num == null) {
                num = 2;
            }
            DownsampleStrategy downsampleStrategy = (DownsampleStrategy) eVar.a(DownsampleStrategy.f9461h);
            if (downsampleStrategy == null) {
                downsampleStrategy = DownsampleStrategy.f9460g;
            }
            DownsampleStrategy downsampleStrategy2 = downsampleStrategy;
            MediaMetadataRetriever a10 = this.f17475c.a();
            try {
                this.f17473a.a(a10, t10);
                Bitmap e10 = e(a10, longValue, num.intValue(), i10, i11, downsampleStrategy2);
                a10.release();
                return e.d(e10, this.f17474b);
            } catch (RuntimeException e11) {
                throw new IOException(e11);
            } catch (Throwable th2) {
                a10.release();
                throw th2;
            }
        } else {
            throw new IllegalArgumentException("Requested frame must be non-negative, or DEFAULT_FRAME, given: " + longValue);
        }
    }

    public boolean b(@NonNull T t10, @NonNull i3.e eVar) {
        return true;
    }

    w(m3.d dVar, f<T> fVar, e eVar) {
        this.f17474b = dVar;
        this.f17473a = fVar;
        this.f17475c = eVar;
    }
}
