package com.withpersona.sdk2.camera;

import java.util.Date;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public abstract class e {

    public static final class a extends e {

        /* renamed from: a  reason: collision with root package name */
        private final String f14341a;

        /* renamed from: b  reason: collision with root package name */
        private final String f14342b;

        /* renamed from: c  reason: collision with root package name */
        private final Date f14343c;

        /* renamed from: d  reason: collision with root package name */
        private final Date f14344d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(String str, String str2, Date date, Date date2) {
            super((DefaultConstructorMarker) null);
            j.g(str, "extractionRawPayload");
            this.f14341a = str;
            this.f14342b = str2;
            this.f14343c = date;
            this.f14344d = date2;
        }

        public String a() {
            return this.f14341a;
        }

        public final Date b() {
            return this.f14343c;
        }

        public final Date c() {
            return this.f14344d;
        }

        public final String d() {
            return this.f14342b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return j.b(a(), aVar.a()) && j.b(this.f14342b, aVar.f14342b) && j.b(this.f14343c, aVar.f14343c) && j.b(this.f14344d, aVar.f14344d);
        }

        public int hashCode() {
            int hashCode = a().hashCode() * 31;
            String str = this.f14342b;
            int i10 = 0;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            Date date = this.f14343c;
            int hashCode3 = (hashCode2 + (date == null ? 0 : date.hashCode())) * 31;
            Date date2 = this.f14344d;
            if (date2 != null) {
                i10 = date2.hashCode();
            }
            return hashCode3 + i10;
        }

        public String toString() {
            return "MrzBarcodeInfo(extractionRawPayload=" + a() + ", identificationNumber=" + this.f14342b + ", birthdate=" + this.f14343c + ", expirationDate=" + this.f14344d + PropertyUtils.MAPPED_DELIM2;
        }
    }

    public static final class b extends e {

        /* renamed from: a  reason: collision with root package name */
        private final String f14345a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(String str) {
            super((DefaultConstructorMarker) null);
            j.g(str, "extractionRawPayload");
            this.f14345a = str;
        }

        public String a() {
            return this.f14345a;
        }

        public final a b() {
            return a.f14198o.d(a());
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && j.b(a(), ((b) obj).a());
        }

        public int hashCode() {
            return a().hashCode();
        }

        public String toString() {
            return "Pdf417BarcodeInfo(extractionRawPayload=" + a() + PropertyUtils.MAPPED_DELIM2;
        }
    }

    private e() {
    }

    public /* synthetic */ e(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract String a();
}
