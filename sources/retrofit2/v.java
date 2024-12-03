package retrofit2;

import java.lang.annotation.Annotation;

final class v implements u {

    /* renamed from: a  reason: collision with root package name */
    private static final u f42435a = new v();

    v() {
    }

    static Annotation[] a(Annotation[] annotationArr) {
        if (w.l(annotationArr, u.class)) {
            return annotationArr;
        }
        Annotation[] annotationArr2 = new Annotation[(annotationArr.length + 1)];
        annotationArr2[0] = f42435a;
        System.arraycopy(annotationArr, 0, annotationArr2, 1, annotationArr.length);
        return annotationArr2;
    }

    public Class<? extends Annotation> annotationType() {
        return u.class;
    }

    public boolean equals(Object obj) {
        return obj instanceof u;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        return "@" + u.class.getName() + "()";
    }
}
