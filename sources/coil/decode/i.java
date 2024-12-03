package coil.decode;

import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0016\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0000\"\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007\"\u0018\u0010\f\u001a\u00020\u0003*\u00020\t8@X\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\"\u0018\u0010\r\u001a\u00020\u0003*\u00020\t8@X\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcoil/decode/ExifOrientationPolicy;", "", "mimeType", "", "c", "", "a", "Ljava/util/Set;", "RESPECT_PERFORMANCE_MIME_TYPES", "Lcoil/decode/f;", "b", "(Lcoil/decode/f;)Z", "isSwapped", "isRotated", "coil-base_release"}, k = 2, mv = {1, 7, 1})
public final class i {

    /* renamed from: a  reason: collision with root package name */
    private static final Set<String> f8102a = n0.i("image/jpeg", "image/webp", "image/heic", "image/heif");

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f8103a;

        static {
            int[] iArr = new int[ExifOrientationPolicy.values().length];
            iArr[ExifOrientationPolicy.RESPECT_PERFORMANCE.ordinal()] = 1;
            iArr[ExifOrientationPolicy.IGNORE.ordinal()] = 2;
            iArr[ExifOrientationPolicy.RESPECT_ALL.ordinal()] = 3;
            f8103a = iArr;
        }
    }

    public static final boolean a(f fVar) {
        return fVar.a() > 0;
    }

    public static final boolean b(f fVar) {
        return fVar.a() == 90 || fVar.a() == 270;
    }

    public static final boolean c(ExifOrientationPolicy exifOrientationPolicy, String str) {
        int i10 = a.f8103a[exifOrientationPolicy.ordinal()];
        if (i10 != 1) {
            if (i10 == 2) {
                return false;
            }
            if (i10 != 3) {
                throw new NoWhenBranchMatchedException();
            }
        } else if (str == null || !f8102a.contains(str)) {
            return false;
        }
        return true;
    }
}
