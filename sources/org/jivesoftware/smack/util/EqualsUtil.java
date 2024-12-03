package org.jivesoftware.smack.util;

public final class EqualsUtil {

    public static final class Builder {
        /* access modifiers changed from: private */
        public boolean isEquals;

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$append$0(boolean[] zArr, boolean[] zArr2) {
            if (zArr.length != zArr2.length) {
                this.isEquals = false;
                return;
            }
            for (int i10 = 0; i10 < zArr.length && this.isEquals; i10++) {
                append(zArr[i10], zArr2[i10]);
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$append$1(byte[] bArr, byte[] bArr2) {
            if (bArr.length != bArr2.length) {
                this.isEquals = false;
                return;
            }
            for (int i10 = 0; i10 < bArr.length && this.isEquals; i10++) {
                append(bArr[i10], bArr2[i10]);
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$append$2(char[] cArr, char[] cArr2) {
            if (cArr.length != cArr2.length) {
                this.isEquals = false;
                return;
            }
            for (int i10 = 0; i10 < cArr.length && this.isEquals; i10++) {
                append(cArr[i10], cArr2[i10]);
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$append$3(double[] dArr, double[] dArr2) {
            if (dArr.length != dArr2.length) {
                this.isEquals = false;
                return;
            }
            for (int i10 = 0; i10 < dArr.length && this.isEquals; i10++) {
                append(dArr[i10], dArr2[i10]);
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$append$4(float[] fArr, float[] fArr2) {
            if (fArr.length != fArr2.length) {
                this.isEquals = false;
                return;
            }
            for (int i10 = 0; i10 < fArr.length && this.isEquals; i10++) {
                append(fArr[i10], fArr2[i10]);
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$append$5(int[] iArr, int[] iArr2) {
            if (iArr.length != iArr2.length) {
                this.isEquals = false;
                return;
            }
            for (int i10 = 0; i10 < iArr.length && this.isEquals; i10++) {
                append(iArr[i10], iArr2[i10]);
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$append$6(long[] jArr, long[] jArr2) {
            if (jArr.length != jArr2.length) {
                this.isEquals = false;
                return;
            }
            for (int i10 = 0; i10 < jArr.length && this.isEquals; i10++) {
                append(jArr[i10], jArr2[i10]);
            }
        }

        private void nullSafeCompare(Object obj, Object obj2, Runnable runnable) {
            if (!this.isEquals || obj == obj2) {
                return;
            }
            if (obj == null || obj2 == null) {
                this.isEquals = false;
            } else {
                runnable.run();
            }
        }

        public <O> Builder append(O o10, O o11) {
            if (!this.isEquals || o10 == o11) {
                return this;
            }
            if (o10 == null || o11 == null) {
                this.isEquals = false;
                return this;
            }
            this.isEquals = o10.equals(o11);
            return this;
        }

        private Builder() {
            this.isEquals = true;
        }

        public Builder append(boolean z10, boolean z11) {
            if (!this.isEquals) {
                return this;
            }
            this.isEquals = z10 == z11;
            return this;
        }

        public Builder append(boolean[] zArr, boolean[] zArr2) {
            nullSafeCompare(zArr, zArr2, new a(this, zArr, zArr2));
            return this;
        }

        public Builder append(byte b10, byte b11) {
            if (!this.isEquals) {
                return this;
            }
            this.isEquals = b10 == b11;
            return this;
        }

        public Builder append(byte[] bArr, byte[] bArr2) {
            nullSafeCompare(bArr, bArr2, new f(this, bArr, bArr2));
            return this;
        }

        public Builder append(char c10, char c11) {
            if (!this.isEquals) {
                return this;
            }
            this.isEquals = c10 == c11;
            return this;
        }

        public Builder append(char[] cArr, char[] cArr2) {
            nullSafeCompare(cArr, cArr2, new g(this, cArr, cArr2));
            return this;
        }

        public Builder append(double d10, double d11) {
            if (!this.isEquals) {
                return this;
            }
            return append(Double.doubleToLongBits(d10), Double.doubleToLongBits(d11));
        }

        public Builder append(double[] dArr, double[] dArr2) {
            nullSafeCompare(dArr, dArr2, new e(this, dArr, dArr2));
            return this;
        }

        public Builder append(float f10, float f11) {
            if (!this.isEquals) {
                return this;
            }
            return append(Float.floatToIntBits(f10), Float.floatToIntBits(f11));
        }

        public Builder append(float[] fArr, float[] fArr2) {
            nullSafeCompare(fArr, fArr2, new c(this, fArr, fArr2));
            return this;
        }

        public Builder append(int i10, int i11) {
            if (!this.isEquals) {
                return this;
            }
            this.isEquals = i10 == i11;
            return this;
        }

        public Builder append(int[] iArr, int[] iArr2) {
            nullSafeCompare(iArr, iArr2, new b(this, iArr, iArr2));
            return this;
        }

        public Builder append(long j10, long j11) {
            if (!this.isEquals) {
                return this;
            }
            this.isEquals = j10 == j11;
            return this;
        }

        public Builder append(long[] jArr, long[] jArr2) {
            nullSafeCompare(jArr, jArr2, new d(this, jArr, jArr2));
            return this;
        }
    }

    @FunctionalInterface
    public interface EqualsComperator<T> {
        void compare(Builder builder, T t10);
    }

    private EqualsUtil() {
    }

    public static <T> boolean equals(T t10, Object obj, EqualsComperator<T> equalsComperator) {
        if (obj == null) {
            return false;
        }
        if (t10 == obj) {
            return true;
        }
        Class<?> cls = t10.getClass();
        if (cls != obj.getClass() || t10.hashCode() != obj.hashCode()) {
            return false;
        }
        Builder builder = new Builder();
        equalsComperator.compare(builder, cls.cast(obj));
        return builder.isEquals;
    }
}
