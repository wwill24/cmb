package coil.util;

import android.graphics.Bitmap;
import android.os.Build;
import coil.size.Scale;
import coil.size.c;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import okio.BufferedSource;
import okio.ByteString;

@Metadata(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a$\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0000\u001a\u000e\u0010\b\u001a\u00020\u0007*\u0004\u0018\u00010\u0007H\u0000\u001a\u0014\u0010\r\u001a\u00020\f*\u00020\t2\u0006\u0010\u000b\u001a\u00020\nH\u0000\"\u0018\u0010\u0011\u001a\u00020\u000e*\u00020\u00078@X\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lokio/BufferedSource;", "Lokio/ByteString;", "bytes", "", "fromIndex", "toIndex", "a", "Landroid/graphics/Bitmap$Config;", "d", "Lcoil/size/c;", "Lcoil/size/Scale;", "scale", "", "c", "", "b", "(Landroid/graphics/Bitmap$Config;)Z", "isHardware", "coil-svg_release"}, k = 2, mv = {1, 7, 1})
public final class i {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f8426a;

        static {
            int[] iArr = new int[Scale.values().length];
            iArr[Scale.FILL.ordinal()] = 1;
            iArr[Scale.FIT.ordinal()] = 2;
            f8426a = iArr;
        }
    }

    public static final long a(BufferedSource bufferedSource, ByteString byteString, long j10, long j11) {
        boolean z10;
        if (byteString.H() > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            byte i10 = byteString.i(0);
            long H = j11 - ((long) byteString.H());
            long j12 = j10;
            while (j12 < H) {
                long T = bufferedSource.T(i10, j12, H);
                if (T == -1 || bufferedSource.j0(T, byteString)) {
                    return T;
                }
                j12 = T + 1;
            }
            return -1;
        }
        throw new IllegalArgumentException("bytes is empty".toString());
    }

    public static final boolean b(Bitmap.Config config) {
        return Build.VERSION.SDK_INT >= 26 && config == Bitmap.Config.HARDWARE;
    }

    public static final float c(c cVar, Scale scale) {
        if (cVar instanceof c.a) {
            return (float) ((c.a) cVar).f8407a;
        }
        int i10 = a.f8426a[scale.ordinal()];
        if (i10 == 1) {
            return Float.MIN_VALUE;
        }
        if (i10 == 2) {
            return Float.MAX_VALUE;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final Bitmap.Config d(Bitmap.Config config) {
        return (config == null || b(config)) ? Bitmap.Config.ARGB_8888 : config;
    }
}
