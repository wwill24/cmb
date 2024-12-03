package okhttp3;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kk.c;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0011\n\u0002\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u000eB/\b\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0014\u001a\u00020\u0005\u0012\u0006\u0010\u0016\u001a\u00020\u0005\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u0017¢\u0006\u0004\b\u001b\u0010\u001cJ\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0005J\b\u0010\b\u001a\u00020\u0005H\u0016J\u0013\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\r\u001a\u00020\fH\u0016R\u0014\u0010\u0010\u001a\u00020\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0014\u001a\u00020\u00058\u0007¢\u0006\f\n\u0004\b\u0011\u0010\u000f\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0016\u001a\u00020\u00058\u0007¢\u0006\f\n\u0004\b\u0004\u0010\u000f\u001a\u0004\b\u0015\u0010\u0013R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u00178\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001e"}, d2 = {"Lokhttp3/v;", "", "Ljava/nio/charset/Charset;", "defaultValue", "c", "", "name", "f", "toString", "other", "", "equals", "", "hashCode", "a", "Ljava/lang/String;", "mediaType", "b", "i", "()Ljava/lang/String;", "type", "h", "subtype", "", "d", "[Ljava/lang/String;", "parameterNamesAndValues", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V", "e", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class v {

    /* renamed from: e  reason: collision with root package name */
    public static final a f33190e = new a((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static final Pattern f33191f = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public static final Pattern f33192g = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    /* renamed from: a  reason: collision with root package name */
    private final String f33193a;

    /* renamed from: b  reason: collision with root package name */
    private final String f33194b;

    /* renamed from: c  reason: collision with root package name */
    private final String f33195c;

    /* renamed from: d  reason: collision with root package name */
    private final String[] f33196d;

    @Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003*\u00020\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0005R\u001c\u0010\t\u001a\n \b*\u0004\u0018\u00010\u00070\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\r\u0010\fR\u001c\u0010\u000e\u001a\n \b*\u0004\u0018\u00010\u00070\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\n¨\u0006\u0011"}, d2 = {"Lokhttp3/v$a;", "", "", "Lokhttp3/v;", "a", "(Ljava/lang/String;)Lokhttp3/v;", "b", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "PARAMETER", "Ljava/util/regex/Pattern;", "QUOTED", "Ljava/lang/String;", "TOKEN", "TYPE_SUBTYPE", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final v a(String str) {
            j.g(str, "<this>");
            Matcher matcher = v.f33191f.matcher(str);
            if (matcher.lookingAt()) {
                String group = matcher.group(1);
                j.f(group, "typeSubtype.group(1)");
                Locale locale = Locale.US;
                j.f(locale, "US");
                String lowerCase = group.toLowerCase(locale);
                j.f(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                String group2 = matcher.group(2);
                j.f(group2, "typeSubtype.group(2)");
                j.f(locale, "US");
                String lowerCase2 = group2.toLowerCase(locale);
                j.f(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
                ArrayList arrayList = new ArrayList();
                Matcher matcher2 = v.f33192g.matcher(str);
                int end = matcher.end();
                while (end < str.length()) {
                    matcher2.region(end, str.length());
                    if (matcher2.lookingAt()) {
                        String group3 = matcher2.group(1);
                        if (group3 == null) {
                            end = matcher2.end();
                        } else {
                            String group4 = matcher2.group(2);
                            if (group4 == null) {
                                group4 = matcher2.group(3);
                            } else if (r.J(group4, "'", false, 2, (Object) null) && r.s(group4, "'", false, 2, (Object) null) && group4.length() > 2) {
                                group4 = group4.substring(1, group4.length() - 1);
                                j.f(group4, "this as java.lang.String…ing(startIndex, endIndex)");
                            }
                            arrayList.add(group3);
                            arrayList.add(group4);
                            end = matcher2.end();
                        }
                    } else {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Parameter is not formatted correctly: \"");
                        String substring = str.substring(end);
                        j.f(substring, "this as java.lang.String).substring(startIndex)");
                        sb2.append(substring);
                        sb2.append("\" for: \"");
                        sb2.append(str);
                        sb2.append('\"');
                        throw new IllegalArgumentException(sb2.toString().toString());
                    }
                }
                Object[] array2 = arrayList.toArray(new String[0]);
                if (array2 != null) {
                    return new v(str, lowerCase, lowerCase2, (String[]) array2, (DefaultConstructorMarker) null);
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            }
            throw new IllegalArgumentException(("No subtype found for: \"" + str + '\"').toString());
        }

        public final v b(String str) {
            j.g(str, "<this>");
            try {
                return a(str);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
    }

    private v(String str, String str2, String str3, String[] strArr) {
        this.f33193a = str;
        this.f33194b = str2;
        this.f33195c = str3;
        this.f33196d = strArr;
    }

    public /* synthetic */ v(String str, String str2, String str3, String[] strArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, strArr);
    }

    public static /* synthetic */ Charset d(v vVar, Charset charset, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            charset = null;
        }
        return vVar.c(charset);
    }

    public static final v e(String str) {
        return f33190e.a(str);
    }

    public static final v g(String str) {
        return f33190e.b(str);
    }

    public final Charset c(Charset charset) {
        String f10 = f("charset");
        if (f10 == null) {
            return charset;
        }
        try {
            return Charset.forName(f10);
        } catch (IllegalArgumentException unused) {
            return charset;
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof v) && j.b(((v) obj).f33193a, this.f33193a);
    }

    public final String f(String str) {
        j.g(str, "name");
        int i10 = 0;
        int c10 = c.c(0, this.f33196d.length - 1, 2);
        if (c10 < 0) {
            return null;
        }
        while (true) {
            int i11 = i10 + 2;
            if (r.t(this.f33196d[i10], str, true)) {
                return this.f33196d[i10 + 1];
            }
            if (i10 == c10) {
                return null;
            }
            i10 = i11;
        }
    }

    public final String h() {
        return this.f33195c;
    }

    public int hashCode() {
        return this.f33193a.hashCode();
    }

    public final String i() {
        return this.f33194b;
    }

    public String toString() {
        return this.f33193a;
    }
}
