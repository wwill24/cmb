package k9;

import com.coffeemeetsbagel.models.Price;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public abstract class c {

    /* renamed from: c  reason: collision with root package name */
    public static final a f15974c = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final int f15975a;

    /* renamed from: b  reason: collision with root package name */
    private final String f15976b;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final class b extends c {

        /* renamed from: d  reason: collision with root package name */
        private final String f15977d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(String str) {
            super(1, str, (DefaultConstructorMarker) null);
            j.g(str, "message");
            this.f15977d = str;
        }

        public String a() {
            return this.f15977d;
        }
    }

    /* renamed from: k9.c$c  reason: collision with other inner class name */
    public static final class C0166c extends c {

        /* renamed from: d  reason: collision with root package name */
        private final String f15978d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0166c(String str) {
            super(2, str, (DefaultConstructorMarker) null);
            j.g(str, "message");
            this.f15978d = str;
        }

        public String a() {
            return this.f15978d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof C0166c) && j.b(a(), ((C0166c) obj).a());
        }

        public int hashCode() {
            return a().hashCode();
        }

        public String toString() {
            String a10 = a();
            return "Header(message=" + a10 + ")";
        }
    }

    public static final class d extends c {

        /* renamed from: d  reason: collision with root package name */
        private final Price f15979d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(Price price) {
            super(0, "", (DefaultConstructorMarker) null);
            j.g(price, FirebaseAnalytics.Param.PRICE);
            this.f15979d = price;
        }

        public final Price c() {
            return this.f15979d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof d) && j.b(this.f15979d, ((d) obj).f15979d);
        }

        public int hashCode() {
            return this.f15979d.hashCode();
        }

        public String toString() {
            Price price = this.f15979d;
            return "InventoryItem(price=" + price + ")";
        }
    }

    public static final class e extends c {

        /* renamed from: d  reason: collision with root package name */
        private final Price f15980d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(Price price) {
            super(0, "", (DefaultConstructorMarker) null);
            j.g(price, FirebaseAnalytics.Param.PRICE);
            this.f15980d = price;
        }

        public final Price c() {
            return this.f15980d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof e) && j.b(this.f15980d, ((e) obj).f15980d);
        }

        public int hashCode() {
            return this.f15980d.hashCode();
        }

        public String toString() {
            Price price = this.f15980d;
            return "OtherItem(price=" + price + ")";
        }
    }

    private c(int i10, String str) {
        this.f15975a = i10;
        this.f15976b = str;
    }

    public /* synthetic */ c(int i10, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(i10, str);
    }

    public String a() {
        return this.f15976b;
    }

    public final int b() {
        return this.f15975a;
    }
}
