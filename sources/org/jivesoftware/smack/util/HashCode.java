package org.jivesoftware.smack.util;

public class HashCode {
    private static final int MULTIPLIER_VALUE = 37;

    public static class Builder {
        /* access modifiers changed from: private */
        public int hashcode = 17;

        private void applyHash() {
            applyHash(0);
        }

        public Builder append(Object obj) {
            if (obj == null) {
                applyHash();
                return this;
            }
            if (obj.getClass().isArray()) {
                if (obj instanceof int[]) {
                    append((Object) (int[]) obj);
                } else if (obj instanceof long[]) {
                    append((long[]) obj);
                } else if (obj instanceof boolean[]) {
                    append((boolean[]) obj);
                } else if (obj instanceof double[]) {
                    append((double[]) obj);
                } else if (obj instanceof float[]) {
                    append((float[]) obj);
                } else if (obj instanceof short[]) {
                    append((Object) (short[]) obj);
                } else if (obj instanceof char[]) {
                    append((char[]) obj);
                } else if (obj instanceof byte[]) {
                    append((byte[]) obj);
                } else {
                    append((Object[]) obj);
                }
            }
            applyHash(obj.hashCode());
            return this;
        }

        public int build() {
            return this.hashcode;
        }

        private void applyHash(int i10) {
            this.hashcode = (this.hashcode * 37) + i10;
        }

        public Builder append(boolean z10) {
            applyHash(z10 ^ true ? 1 : 0);
            return this;
        }

        public Builder append(boolean[] zArr) {
            if (zArr == null) {
                applyHash();
                return this;
            }
            for (boolean append : zArr) {
                append(append);
            }
            return this;
        }

        public Builder append(byte b10) {
            applyHash(b10);
            return this;
        }

        public Builder append(byte[] bArr) {
            if (bArr == null) {
                applyHash();
                return this;
            }
            for (byte append : bArr) {
                append(append);
            }
            return this;
        }

        public Builder append(char c10) {
            applyHash(c10);
            return this;
        }

        public Builder append(char[] cArr) {
            if (cArr == null) {
                applyHash();
                return this;
            }
            for (char append : cArr) {
                append(append);
            }
            return this;
        }

        public Builder append(double d10) {
            return append(Double.doubleToLongBits(d10));
        }

        public Builder append(double[] dArr) {
            if (dArr == null) {
                applyHash();
                return this;
            }
            for (double append : dArr) {
                append(append);
            }
            return this;
        }

        public Builder append(float f10) {
            return append((long) Float.floatToIntBits(f10));
        }

        public Builder append(float[] fArr) {
            if (fArr == null) {
                applyHash();
                return this;
            }
            for (float append : fArr) {
                append(append);
            }
            return this;
        }

        public Builder append(long j10) {
            applyHash((int) (j10 ^ (j10 >>> 32)));
            return this;
        }

        public Builder append(long[] jArr) {
            if (jArr == null) {
                applyHash();
                return this;
            }
            for (long append : jArr) {
                append(append);
            }
            return this;
        }

        public Builder append(Object[] objArr) {
            if (objArr == null) {
                applyHash();
                return this;
            }
            for (Object append : objArr) {
                append(append);
            }
            return this;
        }
    }

    public static class Cache {
        private boolean calculated;
        private int hashcode;

        public int getHashCode(Calculator calculator) {
            if (this.calculated) {
                return this.hashcode;
            }
            Builder builder = new Builder();
            calculator.calculateHash(builder);
            this.calculated = true;
            int access$000 = builder.hashcode;
            this.hashcode = access$000;
            return access$000;
        }
    }

    @FunctionalInterface
    public interface Calculator {
        void calculateHash(Builder builder);
    }

    public static Builder builder() {
        return new Builder();
    }
}
