package coil.decode;

import coil.size.Scale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J8\u0010\t\u001a\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0007J8\u0010\u000b\u001a\u00020\n2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0007J8\u0010\r\u001a\u00020\f2\b\b\u0001\u0010\u0003\u001a\u00020\f2\b\b\u0001\u0010\u0004\u001a\u00020\f2\b\b\u0001\u0010\u0005\u001a\u00020\f2\b\b\u0001\u0010\u0006\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0007H\u0007J8\u0010\u000e\u001a\u00020\n2\b\b\u0001\u0010\u0003\u001a\u00020\n2\b\b\u0001\u0010\u0004\u001a\u00020\n2\b\b\u0001\u0010\u0005\u001a\u00020\n2\b\b\u0001\u0010\u0006\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0007H\u0007¨\u0006\u0011"}, d2 = {"Lcoil/decode/d;", "", "", "srcWidth", "srcHeight", "dstWidth", "dstHeight", "Lcoil/size/Scale;", "scale", "a", "", "c", "", "d", "b", "<init>", "()V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final d f8092a = new d();

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f8093a;

        static {
            int[] iArr = new int[Scale.values().length];
            iArr[Scale.FILL.ordinal()] = 1;
            iArr[Scale.FIT.ordinal()] = 2;
            f8093a = iArr;
        }
    }

    private d() {
    }

    public static final int a(int i10, int i11, int i12, int i13, Scale scale) {
        int i14;
        int highestOneBit = Integer.highestOneBit(i10 / i12);
        int highestOneBit2 = Integer.highestOneBit(i11 / i13);
        int i15 = a.f8093a[scale.ordinal()];
        if (i15 == 1) {
            i14 = Math.min(highestOneBit, highestOneBit2);
        } else if (i15 == 2) {
            i14 = Math.max(highestOneBit, highestOneBit2);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return j.c(i14, 1);
    }

    public static final double b(double d10, double d11, double d12, double d13, Scale scale) {
        double d14 = d12 / d10;
        double d15 = d13 / d11;
        int i10 = a.f8093a[scale.ordinal()];
        if (i10 == 1) {
            return Math.max(d14, d15);
        }
        if (i10 == 2) {
            return Math.min(d14, d15);
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final double c(int i10, int i11, int i12, int i13, Scale scale) {
        double d10 = ((double) i12) / ((double) i10);
        double d11 = ((double) i13) / ((double) i11);
        int i14 = a.f8093a[scale.ordinal()];
        if (i14 == 1) {
            return Math.max(d10, d11);
        }
        if (i14 == 2) {
            return Math.min(d10, d11);
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final float d(float f10, float f11, float f12, float f13, Scale scale) {
        float f14 = f12 / f10;
        float f15 = f13 / f11;
        int i10 = a.f8093a[scale.ordinal()];
        if (i10 == 1) {
            return Math.max(f14, f15);
        }
        if (i10 == 2) {
            return Math.min(f14, f15);
        }
        throw new NoWhenBranchMatchedException();
    }
}
