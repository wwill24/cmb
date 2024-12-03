package n0;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class d {

    /* renamed from: a  reason: collision with root package name */
    private a f16351a;

    /* renamed from: b  reason: collision with root package name */
    private String f16352b;

    /* renamed from: c  reason: collision with root package name */
    private int f16353c = 0;

    /* renamed from: d  reason: collision with root package name */
    private String f16354d = null;

    /* renamed from: e  reason: collision with root package name */
    public int f16355e = 0;

    /* renamed from: f  reason: collision with root package name */
    ArrayList<b> f16356f = new ArrayList<>();

    static class a {
        public double a(float f10) {
            throw null;
        }
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        int f16357a;

        /* renamed from: b  reason: collision with root package name */
        float f16358b;
    }

    public float a(float f10) {
        return (float) this.f16351a.a(f10);
    }

    public String toString() {
        String str = this.f16352b;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        Iterator<b> it = this.f16356f.iterator();
        while (it.hasNext()) {
            b next = it.next();
            str = str + "[" + next.f16357a + " , " + decimalFormat.format((double) next.f16358b) + "] ";
        }
        return str;
    }
}
