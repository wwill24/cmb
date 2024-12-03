package ff;

import android.animation.TypeEvaluator;
import android.graphics.drawable.Drawable;
import android.util.Property;
import androidx.annotation.NonNull;

public interface d {

    public static class b implements TypeEvaluator<e> {

        /* renamed from: b  reason: collision with root package name */
        public static final TypeEvaluator<e> f23412b = new b();

        /* renamed from: a  reason: collision with root package name */
        private final e f23413a = new e();

        @NonNull
        /* renamed from: a */
        public e evaluate(float f10, @NonNull e eVar, @NonNull e eVar2) {
            this.f23413a.a(nf.a.c(eVar.f23416a, eVar2.f23416a, f10), nf.a.c(eVar.f23417b, eVar2.f23417b, f10), nf.a.c(eVar.f23418c, eVar2.f23418c, f10));
            return this.f23413a;
        }
    }

    public static class c extends Property<d, e> {

        /* renamed from: a  reason: collision with root package name */
        public static final Property<d, e> f23414a = new c("circularReveal");

        private c(String str) {
            super(e.class, str);
        }

        /* renamed from: a */
        public e get(@NonNull d dVar) {
            return dVar.getRevealInfo();
        }

        /* renamed from: b */
        public void set(@NonNull d dVar, e eVar) {
            dVar.setRevealInfo(eVar);
        }
    }

    /* renamed from: ff.d$d  reason: collision with other inner class name */
    public static class C0275d extends Property<d, Integer> {

        /* renamed from: a  reason: collision with root package name */
        public static final Property<d, Integer> f23415a = new C0275d("circularRevealScrimColor");

        private C0275d(String str) {
            super(Integer.class, str);
        }

        @NonNull
        /* renamed from: a */
        public Integer get(@NonNull d dVar) {
            return Integer.valueOf(dVar.getCircularRevealScrimColor());
        }

        /* renamed from: b */
        public void set(@NonNull d dVar, @NonNull Integer num) {
            dVar.setCircularRevealScrimColor(num.intValue());
        }
    }

    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public float f23416a;

        /* renamed from: b  reason: collision with root package name */
        public float f23417b;

        /* renamed from: c  reason: collision with root package name */
        public float f23418c;

        private e() {
        }

        public void a(float f10, float f11, float f12) {
            this.f23416a = f10;
            this.f23417b = f11;
            this.f23418c = f12;
        }

        public e(float f10, float f11, float f12) {
            this.f23416a = f10;
            this.f23417b = f11;
            this.f23418c = f12;
        }
    }

    void a();

    void b();

    int getCircularRevealScrimColor();

    e getRevealInfo();

    void setCircularRevealOverlayDrawable(Drawable drawable);

    void setCircularRevealScrimColor(int i10);

    void setRevealInfo(e eVar);
}
