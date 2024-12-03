package t1;

import android.annotation.SuppressLint;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\t\u0018\u0000 \u00132\u00020\u0001:\u0001\u0007B#\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0012\u0010\r\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n¢\u0006\u0004\b\u0010\u0010\u0011B\u0011\b\u0016\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR \u0010\r\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\fR\u0014\u0010\u000f\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u000e¨\u0006\u0014"}, d2 = {"Lt1/a;", "Lt1/l;", "Lt1/k;", "statement", "", "b", "", "a", "Ljava/lang/String;", "query", "", "", "[Ljava/lang/Object;", "bindArgs", "()Ljava/lang/String;", "sql", "<init>", "(Ljava/lang/String;[Ljava/lang/Object;)V", "(Ljava/lang/String;)V", "c", "sqlite_release"}, k = 1, mv = {1, 7, 1})
public final class a implements l {

    /* renamed from: c  reason: collision with root package name */
    public static final C0204a f17626c = new C0204a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final String f17627a;

    /* renamed from: b  reason: collision with root package name */
    private final Object[] f17628b;

    @Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u0002J+\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\n\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0001\u0018\u00010\tH\u0007¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lt1/a$a;", "", "Lt1/k;", "statement", "", "index", "arg", "", "a", "", "bindArgs", "b", "(Lt1/k;[Ljava/lang/Object;)V", "<init>", "()V", "sqlite_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: t1.a$a  reason: collision with other inner class name */
    public static final class C0204a {
        private C0204a() {
        }

        public /* synthetic */ C0204a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final void a(k kVar, int i10, Object obj) {
            long j10;
            if (obj == null) {
                kVar.B1(i10);
            } else if (obj instanceof byte[]) {
                kVar.l1(i10, (byte[]) obj);
            } else if (obj instanceof Float) {
                kVar.K(i10, (double) ((Number) obj).floatValue());
            } else if (obj instanceof Double) {
                kVar.K(i10, ((Number) obj).doubleValue());
            } else if (obj instanceof Long) {
                kVar.f1(i10, ((Number) obj).longValue());
            } else if (obj instanceof Integer) {
                kVar.f1(i10, (long) ((Number) obj).intValue());
            } else if (obj instanceof Short) {
                kVar.f1(i10, (long) ((Number) obj).shortValue());
            } else if (obj instanceof Byte) {
                kVar.f1(i10, (long) ((Number) obj).byteValue());
            } else if (obj instanceof String) {
                kVar.P0(i10, (String) obj);
            } else if (obj instanceof Boolean) {
                if (((Boolean) obj).booleanValue()) {
                    j10 = 1;
                } else {
                    j10 = 0;
                }
                kVar.f1(i10, j10);
            } else {
                throw new IllegalArgumentException("Cannot bind " + obj + " at index " + i10 + " Supported types: Null, ByteArray, Float, Double, Long, Int, Short, Byte, String");
            }
        }

        @SuppressLint({"SyntheticAccessor"})
        public final void b(k kVar, Object[] objArr) {
            j.g(kVar, "statement");
            if (objArr != null) {
                int length = objArr.length;
                int i10 = 0;
                while (i10 < length) {
                    Object obj = objArr[i10];
                    i10++;
                    a(kVar, i10, obj);
                }
            }
        }
    }

    public a(String str, Object[] objArr) {
        j.g(str, "query");
        this.f17627a = str;
        this.f17628b = objArr;
    }

    public String a() {
        return this.f17627a;
    }

    public void b(k kVar) {
        j.g(kVar, "statement");
        f17626c.b(kVar, this.f17628b);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public a(String str) {
        this(str, (Object[]) null);
        j.g(str, "query");
    }
}
