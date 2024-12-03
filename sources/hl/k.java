package hl;

import com.google.android.gms.common.api.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\n\u0018\u0000 \u00182\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u0011\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\t\u001a\u00020\u0002J\u0006\u0010\n\u001a\u00020\u0002J\u000e\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002J\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0000R\u0016\u0010\u0011\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0017\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0016R\u0011\u0010\u0019\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0016¨\u0006\u001c"}, d2 = {"Lhl/k;", "", "", "id", "value", "h", "", "f", "a", "i", "d", "defaultValue", "e", "other", "", "g", "I", "set", "", "b", "[I", "values", "()I", "headerTableSize", "c", "initialWindowSize", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class k {

    /* renamed from: c  reason: collision with root package name */
    public static final a f29943c = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private int f29944a;

    /* renamed from: b  reason: collision with root package name */
    private final int[] f29945b = new int[10];

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004¨\u0006\u000e"}, d2 = {"Lhl/k$a;", "", "", "COUNT", "I", "DEFAULT_INITIAL_WINDOW_SIZE", "ENABLE_PUSH", "HEADER_TABLE_SIZE", "INITIAL_WINDOW_SIZE", "MAX_CONCURRENT_STREAMS", "MAX_FRAME_SIZE", "MAX_HEADER_LIST_SIZE", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final int a(int i10) {
        return this.f29945b[i10];
    }

    public final int b() {
        if ((this.f29944a & 2) != 0) {
            return this.f29945b[1];
        }
        return -1;
    }

    public final int c() {
        if ((this.f29944a & 128) != 0) {
            return this.f29945b[7];
        }
        return 65535;
    }

    public final int d() {
        return (this.f29944a & 16) != 0 ? this.f29945b[4] : a.e.API_PRIORITY_OTHER;
    }

    public final int e(int i10) {
        return (this.f29944a & 32) != 0 ? this.f29945b[5] : i10;
    }

    public final boolean f(int i10) {
        return ((1 << i10) & this.f29944a) != 0;
    }

    public final void g(k kVar) {
        j.g(kVar, "other");
        int i10 = 0;
        while (i10 < 10) {
            int i11 = i10 + 1;
            if (kVar.f(i10)) {
                h(i10, kVar.a(i10));
            }
            i10 = i11;
        }
    }

    public final k h(int i10, int i11) {
        if (i10 >= 0) {
            int[] iArr = this.f29945b;
            if (i10 < iArr.length) {
                this.f29944a = (1 << i10) | this.f29944a;
                iArr[i10] = i11;
            }
        }
        return this;
    }

    public final int i() {
        return Integer.bitCount(this.f29944a);
    }
}
