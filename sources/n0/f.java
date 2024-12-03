package n0;

import java.lang.reflect.Array;
import java.text.DecimalFormat;

public abstract class f {

    /* renamed from: a  reason: collision with root package name */
    protected a f16364a;

    /* renamed from: b  reason: collision with root package name */
    protected int f16365b = 0;

    /* renamed from: c  reason: collision with root package name */
    protected int[] f16366c = new int[10];

    /* renamed from: d  reason: collision with root package name */
    protected float[][] f16367d = ((float[][]) Array.newInstance(Float.TYPE, new int[]{10, 3}));

    /* renamed from: e  reason: collision with root package name */
    protected int f16368e;

    /* renamed from: f  reason: collision with root package name */
    protected String f16369f;

    /* renamed from: g  reason: collision with root package name */
    protected float[] f16370g = new float[3];

    /* renamed from: h  reason: collision with root package name */
    protected boolean f16371h = false;

    /* renamed from: i  reason: collision with root package name */
    protected long f16372i;

    /* renamed from: j  reason: collision with root package name */
    protected float f16373j = Float.NaN;

    public String toString() {
        String str = this.f16369f;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (int i10 = 0; i10 < this.f16368e; i10++) {
            str = str + "[" + this.f16366c[i10] + " , " + decimalFormat.format(this.f16367d[i10]) + "] ";
        }
        return str;
    }
}
