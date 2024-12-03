package q1;

import android.annotation.SuppressLint;
import androidx.room.Index$Order;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import t1.i;

@Metadata(bv = {}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0005\t\u000e\u0013\u0017\u001bBC\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\r0\f\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0011¢\u0006\u0004\b\u0019\u0010\u001aJ\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016R\u0014\u0010\u000b\u001a\u00020\u00078\u0006X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR \u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00118\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0014¨\u0006\u001c"}, d2 = {"Lq1/e;", "", "other", "", "equals", "", "hashCode", "", "toString", "a", "Ljava/lang/String;", "name", "", "Lq1/e$a;", "b", "Ljava/util/Map;", "columns", "", "Lq1/e$c;", "c", "Ljava/util/Set;", "foreignKeys", "Lq1/e$e;", "d", "indices", "<init>", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Set;Ljava/util/Set;)V", "e", "room-runtime_release"}, k = 1, mv = {1, 7, 1})
public final class e {

    /* renamed from: e  reason: collision with root package name */
    public static final b f17095e = new b((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final String f17096a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, a> f17097b;

    /* renamed from: c  reason: collision with root package name */
    public final Set<c> f17098c;

    /* renamed from: d  reason: collision with root package name */
    public final Set<C0192e> f17099d;

    @Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0018\u0018\u0000 \u001e2\u00020\u0001:\u0001\u0005B9\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0004¢\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0003J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\u0002H\u0016R\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\u00078\u0006X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u000bR\u0014\u0010\u0017\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0012R\u001a\u0010\u001b\u001a\u00020\u00048\u0006X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0012\u0012\u0004\b\u0019\u0010\u001a¨\u0006\u001f"}, d2 = {"Lq1/e$a;", "", "", "type", "", "a", "other", "", "equals", "hashCode", "toString", "Ljava/lang/String;", "name", "b", "c", "Z", "notNull", "d", "I", "primaryKeyPosition", "e", "defaultValue", "f", "createdFrom", "g", "getAffinity$annotations", "()V", "affinity", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZILjava/lang/String;I)V", "h", "room-runtime_release"}, k = 1, mv = {1, 7, 1})
    public static final class a {

        /* renamed from: h  reason: collision with root package name */
        public static final C0191a f17100h = new C0191a((DefaultConstructorMarker) null);

        /* renamed from: a  reason: collision with root package name */
        public final String f17101a;

        /* renamed from: b  reason: collision with root package name */
        public final String f17102b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f17103c;

        /* renamed from: d  reason: collision with root package name */
        public final int f17104d;

        /* renamed from: e  reason: collision with root package name */
        public final String f17105e;

        /* renamed from: f  reason: collision with root package name */
        public final int f17106f;

        /* renamed from: g  reason: collision with root package name */
        public final int f17107g;

        @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0007¨\u0006\n"}, d2 = {"Lq1/e$a$a;", "", "", "current", "", "a", "other", "b", "<init>", "()V", "room-runtime_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: q1.e$a$a  reason: collision with other inner class name */
        public static final class C0191a {
            private C0191a() {
            }

            public /* synthetic */ C0191a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private final boolean a(String str) {
                boolean z10;
                if (str.length() == 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (z10) {
                    return false;
                }
                int i10 = 0;
                int i11 = 0;
                int i12 = 0;
                while (i10 < str.length()) {
                    char charAt = str.charAt(i10);
                    int i13 = i12 + 1;
                    if (i12 == 0 && charAt != '(') {
                        return false;
                    }
                    if (charAt == '(') {
                        i11++;
                    } else if (charAt == ')' && i11 - 1 == 0 && i12 != str.length() - 1) {
                        return false;
                    }
                    i10++;
                    i12 = i13;
                }
                if (i11 == 0) {
                    return true;
                }
                return false;
            }

            @SuppressLint({"SyntheticAccessor"})
            public final boolean b(String str, String str2) {
                j.g(str, "current");
                if (j.b(str, str2)) {
                    return true;
                }
                if (!a(str)) {
                    return false;
                }
                String substring = str.substring(1, str.length() - 1);
                j.f(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                return j.b(StringsKt__StringsKt.W0(substring).toString(), str2);
            }
        }

        public a(String str, String str2, boolean z10, int i10, String str3, int i11) {
            j.g(str, "name");
            j.g(str2, "type");
            this.f17101a = str;
            this.f17102b = str2;
            this.f17103c = z10;
            this.f17104d = i10;
            this.f17105e = str3;
            this.f17106f = i11;
            this.f17107g = a(str2);
        }

        private final int a(String str) {
            if (str == null) {
                return 5;
            }
            Locale locale = Locale.US;
            j.f(locale, "US");
            String upperCase = str.toUpperCase(locale);
            j.f(upperCase, "this as java.lang.String).toUpperCase(locale)");
            if (StringsKt__StringsKt.O(upperCase, "INT", false, 2, (Object) null)) {
                return 3;
            }
            if (StringsKt__StringsKt.O(upperCase, "CHAR", false, 2, (Object) null) || StringsKt__StringsKt.O(upperCase, "CLOB", false, 2, (Object) null) || StringsKt__StringsKt.O(upperCase, "TEXT", false, 2, (Object) null)) {
                return 2;
            }
            if (StringsKt__StringsKt.O(upperCase, "BLOB", false, 2, (Object) null)) {
                return 5;
            }
            if (StringsKt__StringsKt.O(upperCase, "REAL", false, 2, (Object) null) || StringsKt__StringsKt.O(upperCase, "FLOA", false, 2, (Object) null) || StringsKt__StringsKt.O(upperCase, "DOUB", false, 2, (Object) null)) {
                return 4;
            }
            return 1;
        }

        public boolean equals(Object obj) {
            String str;
            boolean z10;
            String str2;
            String str3;
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a) || this.f17104d != ((a) obj).f17104d) {
                return false;
            }
            a aVar = (a) obj;
            if (!j.b(this.f17101a, aVar.f17101a) || this.f17103c != aVar.f17103c) {
                return false;
            }
            if (this.f17106f == 1 && aVar.f17106f == 2 && (str3 = this.f17105e) != null && !f17100h.b(str3, aVar.f17105e)) {
                return false;
            }
            if (this.f17106f == 2 && aVar.f17106f == 1 && (str2 = aVar.f17105e) != null && !f17100h.b(str2, this.f17105e)) {
                return false;
            }
            int i10 = this.f17106f;
            if (i10 != 0 && i10 == aVar.f17106f) {
                if ((str = this.f17105e) == null ? aVar.f17105e == null : f17100h.b(str, aVar.f17105e)) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                if (z10) {
                    return false;
                }
            }
            if (this.f17107g == aVar.f17107g) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i10;
            int hashCode = ((this.f17101a.hashCode() * 31) + this.f17107g) * 31;
            if (this.f17103c) {
                i10 = 1231;
            } else {
                i10 = 1237;
            }
            return ((hashCode + i10) * 31) + this.f17104d;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Column{name='");
            sb2.append(this.f17101a);
            sb2.append("', type='");
            sb2.append(this.f17102b);
            sb2.append("', affinity='");
            sb2.append(this.f17107g);
            sb2.append("', notNull=");
            sb2.append(this.f17103c);
            sb2.append(", primaryKeyPosition=");
            sb2.append(this.f17104d);
            sb2.append(", defaultValue='");
            String str = this.f17105e;
            if (str == null) {
                str = "undefined";
            }
            sb2.append(str);
            sb2.append("'}");
            return sb2.toString();
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007R\u0014\u0010\t\u001a\u00020\b8\u0006XT¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0006XT¢\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\b8\u0006XT¢\u0006\u0006\n\u0004\b\f\u0010\n¨\u0006\u000f"}, d2 = {"Lq1/e$b;", "", "Lt1/i;", "database", "", "tableName", "Lq1/e;", "a", "", "CREATED_FROM_DATABASE", "I", "CREATED_FROM_ENTITY", "CREATED_FROM_UNKNOWN", "<init>", "()V", "room-runtime_release"}, k = 1, mv = {1, 7, 1})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final e a(i iVar, String str) {
            j.g(iVar, "database");
            j.g(str, "tableName");
            return f.f(iVar, str);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010¢\u0006\u0004\b\u0016\u0010\u0017J\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016R\u0014\u0010\u000b\u001a\u00020\u00078\u0006X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\u00078\u0006X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\u000f\u001a\u00020\u00078\u0006X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\nR\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u00108\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u00108\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012¨\u0006\u0018"}, d2 = {"Lq1/e$c;", "", "other", "", "equals", "", "hashCode", "", "toString", "a", "Ljava/lang/String;", "referenceTable", "b", "onDelete", "c", "onUpdate", "", "d", "Ljava/util/List;", "columnNames", "e", "referenceColumnNames", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "room-runtime_release"}, k = 1, mv = {1, 7, 1})
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public final String f17108a;

        /* renamed from: b  reason: collision with root package name */
        public final String f17109b;

        /* renamed from: c  reason: collision with root package name */
        public final String f17110c;

        /* renamed from: d  reason: collision with root package name */
        public final List<String> f17111d;

        /* renamed from: e  reason: collision with root package name */
        public final List<String> f17112e;

        public c(String str, String str2, String str3, List<String> list, List<String> list2) {
            j.g(str, "referenceTable");
            j.g(str2, "onDelete");
            j.g(str3, "onUpdate");
            j.g(list, "columnNames");
            j.g(list2, "referenceColumnNames");
            this.f17108a = str;
            this.f17109b = str2;
            this.f17110c = str3;
            this.f17111d = list;
            this.f17112e = list2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            if (j.b(this.f17108a, cVar.f17108a) && j.b(this.f17109b, cVar.f17109b) && j.b(this.f17110c, cVar.f17110c) && j.b(this.f17111d, cVar.f17111d)) {
                return j.b(this.f17112e, cVar.f17112e);
            }
            return false;
        }

        public int hashCode() {
            return (((((((this.f17108a.hashCode() * 31) + this.f17109b.hashCode()) * 31) + this.f17110c.hashCode()) * 31) + this.f17111d.hashCode()) * 31) + this.f17112e.hashCode();
        }

        public String toString() {
            return "ForeignKey{referenceTable='" + this.f17108a + "', onDelete='" + this.f17109b + " +', onUpdate='" + this.f17110c + "', columnNames=" + this.f17111d + ", referenceColumnNames=" + this.f17112e + '}';
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\b\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B'\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0011\u001a\u00020\f¢\u0006\u0004\b\u0012\u0010\u0013J\u0011\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000H\u0002R\u0017\u0010\b\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\u000b\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R\u0017\u0010\u000f\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\u0006\u0010\r\u001a\u0004\b\t\u0010\u000eR\u0017\u0010\u0011\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u0014"}, d2 = {"Lq1/e$d;", "", "other", "", "a", "I", "c", "()I", "id", "b", "getSequence", "sequence", "", "Ljava/lang/String;", "()Ljava/lang/String;", "from", "d", "to", "<init>", "(IILjava/lang/String;Ljava/lang/String;)V", "room-runtime_release"}, k = 1, mv = {1, 7, 1})
    public static final class d implements Comparable<d> {

        /* renamed from: a  reason: collision with root package name */
        private final int f17113a;

        /* renamed from: b  reason: collision with root package name */
        private final int f17114b;

        /* renamed from: c  reason: collision with root package name */
        private final String f17115c;

        /* renamed from: d  reason: collision with root package name */
        private final String f17116d;

        public d(int i10, int i11, String str, String str2) {
            j.g(str, "from");
            j.g(str2, "to");
            this.f17113a = i10;
            this.f17114b = i11;
            this.f17115c = str;
            this.f17116d = str2;
        }

        /* renamed from: a */
        public int compareTo(d dVar) {
            j.g(dVar, "other");
            int i10 = this.f17113a - dVar.f17113a;
            if (i10 == 0) {
                return this.f17114b - dVar.f17114b;
            }
            return i10;
        }

        public final String b() {
            return this.f17115c;
        }

        public final int c() {
            return this.f17113a;
        }

        public final String d() {
            return this.f17116d;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\t\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\tB3\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016R\u0014\u0010\u000b\u001a\u00020\u00078\u0006X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f8\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f8\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011¨\u0006\u0018"}, d2 = {"Lq1/e$e;", "", "other", "", "equals", "", "hashCode", "", "toString", "a", "Ljava/lang/String;", "name", "b", "Z", "unique", "", "c", "Ljava/util/List;", "columns", "d", "orders", "<init>", "(Ljava/lang/String;ZLjava/util/List;Ljava/util/List;)V", "e", "room-runtime_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: q1.e$e  reason: collision with other inner class name */
    public static final class C0192e {

        /* renamed from: e  reason: collision with root package name */
        public static final a f17117e = new a((DefaultConstructorMarker) null);

        /* renamed from: a  reason: collision with root package name */
        public final String f17118a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f17119b;

        /* renamed from: c  reason: collision with root package name */
        public final List<String> f17120c;

        /* renamed from: d  reason: collision with root package name */
        public List<String> f17121d;

        @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lq1/e$e$a;", "", "", "DEFAULT_PREFIX", "Ljava/lang/String;", "<init>", "()V", "room-runtime_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: q1.e$e$a */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public C0192e(String str, boolean z10, List<String> list, List<String> list2) {
            j.g(str, "name");
            j.g(list, "columns");
            j.g(list2, "orders");
            this.f17118a = str;
            this.f17119b = z10;
            this.f17120c = list;
            this.f17121d = list2;
            boolean isEmpty = list2.isEmpty();
            ArrayList arrayList = list2;
            if (isEmpty) {
                int size = list.size();
                ArrayList arrayList2 = new ArrayList(size);
                for (int i10 = 0; i10 < size; i10++) {
                    arrayList2.add(Index$Order.ASC.name());
                }
                arrayList = arrayList2;
            }
            this.f17121d = arrayList;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0192e)) {
                return false;
            }
            C0192e eVar = (C0192e) obj;
            if (this.f17119b != eVar.f17119b || !j.b(this.f17120c, eVar.f17120c) || !j.b(this.f17121d, eVar.f17121d)) {
                return false;
            }
            if (r.J(this.f17118a, "index_", false, 2, (Object) null)) {
                return r.J(eVar.f17118a, "index_", false, 2, (Object) null);
            }
            return j.b(this.f17118a, eVar.f17118a);
        }

        public int hashCode() {
            int i10;
            if (r.J(this.f17118a, "index_", false, 2, (Object) null)) {
                i10 = -1184239155;
            } else {
                i10 = this.f17118a.hashCode();
            }
            return (((((i10 * 31) + (this.f17119b ? 1 : 0)) * 31) + this.f17120c.hashCode()) * 31) + this.f17121d.hashCode();
        }

        public String toString() {
            return "Index{name='" + this.f17118a + "', unique=" + this.f17119b + ", columns=" + this.f17120c + ", orders=" + this.f17121d + "'}";
        }
    }

    public e(String str, Map<String, a> map, Set<c> set, Set<C0192e> set2) {
        j.g(str, "name");
        j.g(map, "columns");
        j.g(set, "foreignKeys");
        this.f17096a = str;
        this.f17097b = map;
        this.f17098c = set;
        this.f17099d = set2;
    }

    public static final e a(i iVar, String str) {
        return f17095e.a(iVar, str);
    }

    public boolean equals(Object obj) {
        Set<C0192e> set;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        if (!j.b(this.f17096a, eVar.f17096a) || !j.b(this.f17097b, eVar.f17097b) || !j.b(this.f17098c, eVar.f17098c)) {
            return false;
        }
        Set<C0192e> set2 = this.f17099d;
        if (set2 == null || (set = eVar.f17099d) == null) {
            return true;
        }
        return j.b(set2, set);
    }

    public int hashCode() {
        return (((this.f17096a.hashCode() * 31) + this.f17097b.hashCode()) * 31) + this.f17098c.hashCode();
    }

    public String toString() {
        return "TableInfo{name='" + this.f17096a + "', columns=" + this.f17097b + ", foreignKeys=" + this.f17098c + ", indices=" + this.f17099d + '}';
    }
}
