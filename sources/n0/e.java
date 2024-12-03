package n0;

import java.text.DecimalFormat;

public abstract class e {

    /* renamed from: a  reason: collision with root package name */
    protected a f16359a;

    /* renamed from: b  reason: collision with root package name */
    protected int[] f16360b = new int[10];

    /* renamed from: c  reason: collision with root package name */
    protected float[] f16361c = new float[10];

    /* renamed from: d  reason: collision with root package name */
    private int f16362d;

    /* renamed from: e  reason: collision with root package name */
    private String f16363e;

    public float a(float f10) {
        return (float) this.f16359a.a((double) f10, 0);
    }

    public String toString() {
        String str = this.f16363e;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (int i10 = 0; i10 < this.f16362d; i10++) {
            str = str + "[" + this.f16360b[i10] + " , " + decimalFormat.format((double) this.f16361c[i10]) + "] ";
        }
        return str;
    }
}
