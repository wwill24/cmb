package com.withpersona.sdk2.camera;

import org.apache.commons.beanutils.PropertyUtils;

public interface n {

    public static final class a implements n {

        /* renamed from: a  reason: collision with root package name */
        private final boolean f14367a;

        public a(boolean z10) {
            this.f14367a = z10;
        }

        public final boolean a() {
            return this.f14367a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && this.f14367a == ((a) obj).f14367a;
        }

        public int hashCode() {
            boolean z10 = this.f14367a;
            if (z10) {
                return 1;
            }
            return z10 ? 1 : 0;
        }

        public String toString() {
            return "Closed(wasRecordingInterrupted=" + this.f14367a + PropertyUtils.MAPPED_DELIM2;
        }
    }

    public static final class b implements n {

        /* renamed from: a  reason: collision with root package name */
        public static final b f14368a = new b();

        private b() {
        }
    }

    public static final class c implements n {

        /* renamed from: a  reason: collision with root package name */
        public static final c f14369a = new c();

        private c() {
        }
    }

    public static final class d implements n {

        /* renamed from: a  reason: collision with root package name */
        public static final d f14370a = new d();

        private d() {
        }
    }

    public static final class e implements n {

        /* renamed from: a  reason: collision with root package name */
        public static final e f14371a = new e();

        private e() {
        }
    }
}
