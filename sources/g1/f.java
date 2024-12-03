package g1;

import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.SparseArray;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.util.h;
import androidx.emoji2.text.e;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    private final b f15015a;

    private static class a extends b {

        /* renamed from: a  reason: collision with root package name */
        private final TextView f15016a;

        /* renamed from: b  reason: collision with root package name */
        private final d f15017b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f15018c = true;

        a(TextView textView) {
            this.f15016a = textView;
            this.f15017b = new d(textView);
        }

        @NonNull
        private InputFilter[] f(@NonNull InputFilter[] inputFilterArr) {
            for (d dVar : inputFilterArr) {
                if (dVar == this.f15017b) {
                    return inputFilterArr;
                }
            }
            InputFilter[] inputFilterArr2 = new InputFilter[(inputFilterArr.length + 1)];
            System.arraycopy(inputFilterArr, 0, inputFilterArr2, 0, r0);
            inputFilterArr2[r0] = this.f15017b;
            return inputFilterArr2;
        }

        private SparseArray<InputFilter> g(@NonNull InputFilter[] inputFilterArr) {
            SparseArray<InputFilter> sparseArray = new SparseArray<>(1);
            for (int i10 = 0; i10 < inputFilterArr.length; i10++) {
                InputFilter inputFilter = inputFilterArr[i10];
                if (inputFilter instanceof d) {
                    sparseArray.put(i10, inputFilter);
                }
            }
            return sparseArray;
        }

        @NonNull
        private InputFilter[] h(@NonNull InputFilter[] inputFilterArr) {
            SparseArray<InputFilter> g10 = g(inputFilterArr);
            if (g10.size() == 0) {
                return inputFilterArr;
            }
            int length = inputFilterArr.length;
            InputFilter[] inputFilterArr2 = new InputFilter[(inputFilterArr.length - g10.size())];
            int i10 = 0;
            for (int i11 = 0; i11 < length; i11++) {
                if (g10.indexOfKey(i11) < 0) {
                    inputFilterArr2[i10] = inputFilterArr[i11];
                    i10++;
                }
            }
            return inputFilterArr2;
        }

        private TransformationMethod j(TransformationMethod transformationMethod) {
            if (transformationMethod instanceof h) {
                return ((h) transformationMethod).a();
            }
            return transformationMethod;
        }

        private void k() {
            this.f15016a.setFilters(a(this.f15016a.getFilters()));
        }

        @NonNull
        private TransformationMethod m(TransformationMethod transformationMethod) {
            if (!(transformationMethod instanceof h) && !(transformationMethod instanceof PasswordTransformationMethod)) {
                return new h(transformationMethod);
            }
            return transformationMethod;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public InputFilter[] a(@NonNull InputFilter[] inputFilterArr) {
            if (!this.f15018c) {
                return h(inputFilterArr);
            }
            return f(inputFilterArr);
        }

        public boolean b() {
            return this.f15018c;
        }

        /* access modifiers changed from: package-private */
        public void c(boolean z10) {
            if (z10) {
                l();
            }
        }

        /* access modifiers changed from: package-private */
        public void d(boolean z10) {
            this.f15018c = z10;
            l();
            k();
        }

        /* access modifiers changed from: package-private */
        public TransformationMethod e(TransformationMethod transformationMethod) {
            if (this.f15018c) {
                return m(transformationMethod);
            }
            return j(transformationMethod);
        }

        /* access modifiers changed from: package-private */
        public void i(boolean z10) {
            this.f15018c = z10;
        }

        /* access modifiers changed from: package-private */
        public void l() {
            this.f15016a.setTransformationMethod(e(this.f15016a.getTransformationMethod()));
        }
    }

    static class b {
        b() {
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public InputFilter[] a(@NonNull InputFilter[] inputFilterArr) {
            throw null;
        }

        public boolean b() {
            throw null;
        }

        /* access modifiers changed from: package-private */
        public void c(boolean z10) {
            throw null;
        }

        /* access modifiers changed from: package-private */
        public void d(boolean z10) {
            throw null;
        }

        /* access modifiers changed from: package-private */
        public TransformationMethod e(TransformationMethod transformationMethod) {
            throw null;
        }
    }

    private static class c extends b {

        /* renamed from: a  reason: collision with root package name */
        private final a f15019a;

        c(TextView textView) {
            this.f15019a = new a(textView);
        }

        private boolean f() {
            return !e.h();
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public InputFilter[] a(@NonNull InputFilter[] inputFilterArr) {
            if (f()) {
                return inputFilterArr;
            }
            return this.f15019a.a(inputFilterArr);
        }

        public boolean b() {
            return this.f15019a.b();
        }

        /* access modifiers changed from: package-private */
        public void c(boolean z10) {
            if (!f()) {
                this.f15019a.c(z10);
            }
        }

        /* access modifiers changed from: package-private */
        public void d(boolean z10) {
            if (f()) {
                this.f15019a.i(z10);
            } else {
                this.f15019a.d(z10);
            }
        }

        /* access modifiers changed from: package-private */
        public TransformationMethod e(TransformationMethod transformationMethod) {
            if (f()) {
                return transformationMethod;
            }
            return this.f15019a.e(transformationMethod);
        }
    }

    public f(@NonNull TextView textView, boolean z10) {
        h.h(textView, "textView cannot be null");
        if (!z10) {
            this.f15015a = new c(textView);
        } else {
            this.f15015a = new a(textView);
        }
    }

    @NonNull
    public InputFilter[] a(@NonNull InputFilter[] inputFilterArr) {
        return this.f15015a.a(inputFilterArr);
    }

    public boolean b() {
        return this.f15015a.b();
    }

    public void c(boolean z10) {
        this.f15015a.c(z10);
    }

    public void d(boolean z10) {
        this.f15015a.d(z10);
    }

    public TransformationMethod e(TransformationMethod transformationMethod) {
        return this.f15015a.e(transformationMethod);
    }
}
