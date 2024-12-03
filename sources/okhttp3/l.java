package okhttp3;

import bl.d;
import fl.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlin.text.Regex;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import org.apache.commons.cli.HelpFormatter;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import org.jivesoftware.smackx.shim.packet.HeadersExtension;

@Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0017\u0018\u0000 \u001d2\u00020\u0001:\u0001\fBQ\b\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0014\u0012\u0006\u0010\u001c\u001a\u00020\u0007\u0012\u0006\u0010\u001e\u001a\u00020\u0007\u0012\u0006\u0010\"\u001a\u00020\u0003\u0012\u0006\u0010%\u001a\u00020\u0003\u0012\u0006\u0010'\u001a\u00020\u0003\u0012\u0006\u0010(\u001a\u00020\u0003¢\u0006\u0004\b)\u0010*J\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0017J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0010\u001a\u00020\u00078\u0007¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0013\u001a\u00020\u00078\u0007¢\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u0012\u0010\u000fR\u0017\u0010\u0019\u001a\u00020\u00148\u0007¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001c\u001a\u00020\u00078\u0007¢\u0006\f\n\u0004\b\u001a\u0010\r\u001a\u0004\b\u001b\u0010\u000fR\u0017\u0010\u001e\u001a\u00020\u00078\u0007¢\u0006\f\n\u0004\b\u001b\u0010\r\u001a\u0004\b\u001d\u0010\u000fR\u0017\u0010\"\u001a\u00020\u00038\u0007¢\u0006\f\n\u0004\b\u0017\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010%\u001a\u00020\u00038\u0007¢\u0006\f\n\u0004\b#\u0010\u001f\u001a\u0004\b$\u0010!R\u0017\u0010'\u001a\u00020\u00038\u0007¢\u0006\f\n\u0004\b$\u0010\u001f\u001a\u0004\b&\u0010!R\u0017\u0010(\u001a\u00020\u00038\u0007¢\u0006\f\n\u0004\b\u000e\u0010\u001f\u001a\u0004\b#\u0010!¨\u0006+"}, d2 = {"Lokhttp3/l;", "", "other", "", "equals", "", "hashCode", "", "toString", "forObsoleteRfc2965", "m", "(Z)Ljava/lang/String;", "a", "Ljava/lang/String;", "i", "()Ljava/lang/String;", "name", "b", "n", "value", "", "c", "J", "f", "()J", "expiresAt", "d", "e", "domain", "j", "path", "Z", "l", "()Z", "secure", "g", "h", "httpOnly", "k", "persistent", "hostOnly", "<init>", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;ZZZZ)V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class l {

    /* renamed from: j  reason: collision with root package name */
    public static final a f33129j = new a((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public static final Pattern f33130k = Pattern.compile("(\\d{2,4})[^\\d]*");
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public static final Pattern f33131l = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public static final Pattern f33132m = Pattern.compile("(\\d{1,2})[^\\d]*");
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public static final Pattern f33133n = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* renamed from: a  reason: collision with root package name */
    private final String f33134a;

    /* renamed from: b  reason: collision with root package name */
    private final String f33135b;

    /* renamed from: c  reason: collision with root package name */
    private final long f33136c;

    /* renamed from: d  reason: collision with root package name */
    private final String f33137d;

    /* renamed from: e  reason: collision with root package name */
    private final String f33138e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f33139f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f33140g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f33141h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f33142i;

    @Metadata(bv = {}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b%\u0010&J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J \u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0002J(\u0010\u000f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0005H\u0002J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0002H\u0007J)\u0010\u0018\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u001e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00150\u001c2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001aH\u0007R\u001c\u0010 \u001a\n \u001f*\u0004\u0018\u00010\u001e0\u001e8\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u001c\u0010\"\u001a\n \u001f*\u0004\u0018\u00010\u001e0\u001e8\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010!R\u001c\u0010#\u001a\n \u001f*\u0004\u0018\u00010\u001e0\u001e8\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010!R\u001c\u0010$\u001a\n \u001f*\u0004\u0018\u00010\u001e0\u001e8\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010!¨\u0006'"}, d2 = {"Lokhttp3/l$a;", "", "", "urlHost", "domain", "", "b", "s", "", "pos", "limit", "", "g", "input", "invert", "a", "h", "f", "Lokhttp3/t;", "url", "setCookie", "Lokhttp3/l;", "c", "currentTimeMillis", "d", "(JLokhttp3/t;Ljava/lang/String;)Lokhttp3/l;", "Lokhttp3/s;", "headers", "", "e", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "DAY_OF_MONTH_PATTERN", "Ljava/util/regex/Pattern;", "MONTH_PATTERN", "TIME_PATTERN", "YEAR_PATTERN", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:29:0x003f, code lost:
            if (r1 != ':') goto L_0x0042;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final int a(java.lang.String r6, int r7, int r8, boolean r9) {
            /*
                r5 = this;
            L_0x0000:
                if (r7 >= r8) goto L_0x0049
                int r0 = r7 + 1
                char r1 = r6.charAt(r7)
                r2 = 32
                r3 = 1
                r4 = 0
                if (r1 >= r2) goto L_0x0012
                r2 = 9
                if (r1 != r2) goto L_0x0041
            L_0x0012:
                r2 = 127(0x7f, float:1.78E-43)
                if (r1 >= r2) goto L_0x0041
                r2 = 57
                if (r1 > r2) goto L_0x0020
                r2 = 48
                if (r2 > r1) goto L_0x0020
                r2 = r3
                goto L_0x0021
            L_0x0020:
                r2 = r4
            L_0x0021:
                if (r2 != 0) goto L_0x0041
                r2 = 122(0x7a, float:1.71E-43)
                if (r1 > r2) goto L_0x002d
                r2 = 97
                if (r2 > r1) goto L_0x002d
                r2 = r3
                goto L_0x002e
            L_0x002d:
                r2 = r4
            L_0x002e:
                if (r2 != 0) goto L_0x0041
                r2 = 90
                if (r1 > r2) goto L_0x003a
                r2 = 65
                if (r2 > r1) goto L_0x003a
                r2 = r3
                goto L_0x003b
            L_0x003a:
                r2 = r4
            L_0x003b:
                if (r2 != 0) goto L_0x0041
                r2 = 58
                if (r1 != r2) goto L_0x0042
            L_0x0041:
                r4 = r3
            L_0x0042:
                r1 = r9 ^ 1
                if (r4 != r1) goto L_0x0047
                return r7
            L_0x0047:
                r7 = r0
                goto L_0x0000
            L_0x0049:
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.l.a.a(java.lang.String, int, int, boolean):int");
        }

        private final boolean b(String str, String str2) {
            if (j.b(str, str2)) {
                return true;
            }
            if (!r.s(str, str2, false, 2, (Object) null) || str.charAt((str.length() - str2.length()) - 1) != '.' || d.i(str)) {
                return false;
            }
            return true;
        }

        private final String f(String str) {
            if (!r.s(str, ".", false, 2, (Object) null)) {
                String e10 = bl.a.e(StringsKt__StringsKt.u0(str, "."));
                if (e10 != null) {
                    return e10;
                }
                throw new IllegalArgumentException();
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        private final long g(String str, int i10, int i11) {
            boolean z10;
            boolean z11;
            boolean z12;
            boolean z13;
            boolean z14;
            boolean z15;
            boolean z16;
            boolean z17;
            String str2 = str;
            int i12 = i11;
            int a10 = a(str2, i10, i12, false);
            Matcher matcher = l.f33133n.matcher(str2);
            int i13 = -1;
            int i14 = -1;
            int i15 = -1;
            int i16 = -1;
            int i17 = -1;
            int i18 = -1;
            while (a10 < i12) {
                int a11 = a(str2, a10 + 1, i12, true);
                matcher.region(a10, a11);
                if (i14 == -1 && matcher.usePattern(l.f33133n).matches()) {
                    String group = matcher.group(1);
                    j.f(group, "matcher.group(1)");
                    i14 = Integer.parseInt(group);
                    String group2 = matcher.group(2);
                    j.f(group2, "matcher.group(2)");
                    i17 = Integer.parseInt(group2);
                    String group3 = matcher.group(3);
                    j.f(group3, "matcher.group(3)");
                    i18 = Integer.parseInt(group3);
                } else if (i15 == -1 && matcher.usePattern(l.f33132m).matches()) {
                    String group4 = matcher.group(1);
                    j.f(group4, "matcher.group(1)");
                    i15 = Integer.parseInt(group4);
                } else if (i16 == -1 && matcher.usePattern(l.f33131l).matches()) {
                    String group5 = matcher.group(1);
                    j.f(group5, "matcher.group(1)");
                    Locale locale = Locale.US;
                    j.f(locale, "US");
                    String lowerCase = group5.toLowerCase(locale);
                    j.f(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                    String pattern = l.f33131l.pattern();
                    j.f(pattern, "MONTH_PATTERN.pattern()");
                    i16 = StringsKt__StringsKt.b0(pattern, lowerCase, 0, false, 6, (Object) null) / 4;
                } else if (i13 == -1 && matcher.usePattern(l.f33130k).matches()) {
                    String group6 = matcher.group(1);
                    j.f(group6, "matcher.group(1)");
                    i13 = Integer.parseInt(group6);
                }
                a10 = a(str2, a11 + 1, i12, false);
            }
            if (70 > i13 || i13 >= 100) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (z10) {
                i13 += 1900;
            }
            if (i13 < 0 || i13 >= 70) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (z11) {
                i13 += 2000;
            }
            if (i13 >= 1601) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (z12) {
                if (i16 != -1) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                if (z13) {
                    if (1 > i15 || i15 >= 32) {
                        z14 = false;
                    } else {
                        z14 = true;
                    }
                    if (z14) {
                        if (i14 < 0 || i14 >= 24) {
                            z15 = false;
                        } else {
                            z15 = true;
                        }
                        if (z15) {
                            if (i17 < 0 || i17 >= 60) {
                                z16 = false;
                            } else {
                                z16 = true;
                            }
                            if (z16) {
                                if (i18 < 0 || i18 >= 60) {
                                    z17 = false;
                                } else {
                                    z17 = true;
                                }
                                if (z17) {
                                    GregorianCalendar gregorianCalendar = new GregorianCalendar(d.f24933f);
                                    gregorianCalendar.setLenient(false);
                                    gregorianCalendar.set(1, i13);
                                    gregorianCalendar.set(2, i16 - 1);
                                    gregorianCalendar.set(5, i15);
                                    gregorianCalendar.set(11, i14);
                                    gregorianCalendar.set(12, i17);
                                    gregorianCalendar.set(13, i18);
                                    gregorianCalendar.set(14, 0);
                                    return gregorianCalendar.getTimeInMillis();
                                }
                                throw new IllegalArgumentException("Failed requirement.".toString());
                            }
                            throw new IllegalArgumentException("Failed requirement.".toString());
                        }
                        throw new IllegalArgumentException("Failed requirement.".toString());
                    }
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        private final long h(String str) {
            try {
                long parseLong = Long.parseLong(str);
                if (parseLong <= 0) {
                    return Long.MIN_VALUE;
                }
                return parseLong;
            } catch (NumberFormatException e10) {
                if (!new Regex("-?\\d+").e(str)) {
                    throw e10;
                } else if (r.J(str, HelpFormatter.DEFAULT_OPT_PREFIX, false, 2, (Object) null)) {
                    return Long.MIN_VALUE;
                } else {
                    return Long.MAX_VALUE;
                }
            }
        }

        public final l c(t tVar, String str) {
            j.g(tVar, "url");
            j.g(str, "setCookie");
            return d(System.currentTimeMillis(), tVar, str);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:56:0x0102, code lost:
            if (r1 > 253402300799999L) goto L_0x010a;
         */
        /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
        /* JADX WARNING: Removed duplicated region for block: B:62:0x0114  */
        /* JADX WARNING: Removed duplicated region for block: B:63:0x0117  */
        /* JADX WARNING: Removed duplicated region for block: B:71:0x0137 A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:72:0x0138  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final okhttp3.l d(long r26, okhttp3.t r28, java.lang.String r29) {
            /*
                r25 = this;
                r0 = r25
                r7 = r29
                java.lang.String r1 = "url"
                r8 = r28
                kotlin.jvm.internal.j.g(r8, r1)
                java.lang.String r1 = "setCookie"
                kotlin.jvm.internal.j.g(r7, r1)
                r2 = 59
                r3 = 0
                r4 = 0
                r5 = 6
                r6 = 0
                r1 = r29
                int r9 = bl.d.r(r1, r2, r3, r4, r5, r6)
                r2 = 61
                r5 = 2
                r4 = r9
                int r1 = bl.d.r(r1, r2, r3, r4, r5, r6)
                r2 = 0
                if (r1 != r9) goto L_0x0028
                return r2
            L_0x0028:
                r3 = 0
                r4 = 1
                java.lang.String r11 = bl.d.X(r7, r3, r1, r4, r2)
                int r5 = r11.length()
                if (r5 != 0) goto L_0x0036
                r5 = r4
                goto L_0x0037
            L_0x0036:
                r5 = r3
            L_0x0037:
                if (r5 != 0) goto L_0x016e
                int r5 = bl.d.y(r11)
                r6 = -1
                if (r5 == r6) goto L_0x0042
                goto L_0x016e
            L_0x0042:
                int r1 = r1 + r4
                java.lang.String r12 = bl.d.W(r7, r1, r9)
                int r1 = bl.d.y(r12)
                if (r1 == r6) goto L_0x004e
                return r2
            L_0x004e:
                int r9 = r9 + r4
                int r1 = r29.length()
                r5 = -1
                r10 = r2
                r22 = r10
                r17 = r3
                r18 = r17
                r19 = r18
                r20 = r4
                r15 = r5
                r23 = 253402300799999(0xe677d21fdbff, double:1.251973714024093E-309)
            L_0x0066:
                if (r9 >= r1) goto L_0x00d6
                r2 = 59
                int r2 = bl.d.p(r7, r2, r9, r1)
                r13 = 61
                int r13 = bl.d.p(r7, r13, r9, r2)
                java.lang.String r9 = bl.d.W(r7, r9, r13)
                if (r13 >= r2) goto L_0x0081
                int r13 = r13 + 1
                java.lang.String r13 = bl.d.W(r7, r13, r2)
                goto L_0x0083
            L_0x0081:
                java.lang.String r13 = ""
            L_0x0083:
                java.lang.String r14 = "expires"
                boolean r14 = kotlin.text.r.t(r9, r14, r4)
                if (r14 == 0) goto L_0x0094
                int r9 = r13.length()     // Catch:{ IllegalArgumentException -> 0x00d2 }
                long r23 = r0.g(r13, r3, r9)     // Catch:{ IllegalArgumentException -> 0x00d2 }
                goto L_0x00a0
            L_0x0094:
                java.lang.String r14 = "max-age"
                boolean r14 = kotlin.text.r.t(r9, r14, r4)
                if (r14 == 0) goto L_0x00a3
                long r15 = r0.h(r13)     // Catch:{  }
            L_0x00a0:
                r19 = r4
                goto L_0x00d2
            L_0x00a3:
                java.lang.String r14 = "domain"
                boolean r14 = kotlin.text.r.t(r9, r14, r4)
                if (r14 == 0) goto L_0x00b2
                java.lang.String r10 = r0.f(r13)     // Catch:{ IllegalArgumentException -> 0x00d2 }
                r20 = r3
                goto L_0x00d2
            L_0x00b2:
                java.lang.String r14 = "path"
                boolean r14 = kotlin.text.r.t(r9, r14, r4)
                if (r14 == 0) goto L_0x00bd
                r22 = r13
                goto L_0x00d2
            L_0x00bd:
                java.lang.String r13 = "secure"
                boolean r13 = kotlin.text.r.t(r9, r13, r4)
                if (r13 == 0) goto L_0x00c8
                r17 = r4
                goto L_0x00d2
            L_0x00c8:
                java.lang.String r13 = "httponly"
                boolean r9 = kotlin.text.r.t(r9, r13, r4)
                if (r9 == 0) goto L_0x00d2
                r18 = r4
            L_0x00d2:
                int r9 = r2 + 1
                r2 = 0
                goto L_0x0066
            L_0x00d6:
                r1 = -9223372036854775808
                int r4 = (r15 > r1 ? 1 : (r15 == r1 ? 0 : -1))
                if (r4 != 0) goto L_0x00de
            L_0x00dc:
                r13 = r1
                goto L_0x010e
            L_0x00de:
                int r1 = (r15 > r5 ? 1 : (r15 == r5 ? 0 : -1))
                if (r1 == 0) goto L_0x010c
                r1 = 9223372036854775(0x20c49ba5e353f7, double:4.663754807431093E-308)
                int r1 = (r15 > r1 ? 1 : (r15 == r1 ? 0 : -1))
                if (r1 > 0) goto L_0x00f0
                r1 = 1000(0x3e8, float:1.401E-42)
                long r1 = (long) r1
                long r15 = r15 * r1
                goto L_0x00f5
            L_0x00f0:
                r15 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            L_0x00f5:
                long r1 = r26 + r15
                int r4 = (r1 > r26 ? 1 : (r1 == r26 ? 0 : -1))
                if (r4 < 0) goto L_0x0105
                r4 = 253402300799999(0xe677d21fdbff, double:1.251973714024093E-309)
                int r6 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
                if (r6 <= 0) goto L_0x00dc
                goto L_0x010a
            L_0x0105:
                r4 = 253402300799999(0xe677d21fdbff, double:1.251973714024093E-309)
            L_0x010a:
                r13 = r4
                goto L_0x010e
            L_0x010c:
                r13 = r23
            L_0x010e:
                java.lang.String r1 = r28.i()
                if (r10 != 0) goto L_0x0117
                r15 = r1
                r2 = 0
                goto L_0x0121
            L_0x0117:
                boolean r2 = r0.b(r1, r10)
                if (r2 != 0) goto L_0x011f
                r2 = 0
                return r2
            L_0x011f:
                r2 = 0
                r15 = r10
            L_0x0121:
                int r1 = r1.length()
                int r4 = r15.length()
                if (r1 == r4) goto L_0x0138
                okhttp3.internal.publicsuffix.PublicSuffixDatabase$a r1 = okhttp3.internal.publicsuffix.PublicSuffixDatabase.f33105e
                okhttp3.internal.publicsuffix.PublicSuffixDatabase r1 = r1.c()
                java.lang.String r1 = r1.c(r15)
                if (r1 != 0) goto L_0x0138
                return r2
            L_0x0138:
                java.lang.String r1 = "/"
                r4 = r22
                if (r4 == 0) goto L_0x0149
                r5 = 2
                boolean r2 = kotlin.text.r.J(r4, r1, r3, r5, r2)
                if (r2 != 0) goto L_0x0146
                goto L_0x0149
            L_0x0146:
                r16 = r4
                goto L_0x0165
            L_0x0149:
                java.lang.String r2 = r28.d()
                r6 = 47
                r7 = 0
                r8 = 0
                r9 = 6
                r10 = 0
                r5 = r2
                int r4 = kotlin.text.StringsKt__StringsKt.f0(r5, r6, r7, r8, r9, r10)
                if (r4 == 0) goto L_0x0163
                java.lang.String r1 = r2.substring(r3, r4)
                java.lang.String r2 = "this as java.lang.String…ing(startIndex, endIndex)"
                kotlin.jvm.internal.j.f(r1, r2)
            L_0x0163:
                r16 = r1
            L_0x0165:
                okhttp3.l r1 = new okhttp3.l
                r21 = 0
                r10 = r1
                r10.<init>(r11, r12, r13, r15, r16, r17, r18, r19, r20, r21)
                return r1
            L_0x016e:
                r1 = r2
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.l.a.d(long, okhttp3.t, java.lang.String):okhttp3.l");
        }

        public final List<l> e(t tVar, s sVar) {
            j.g(tVar, "url");
            j.g(sVar, HeadersExtension.ELEMENT);
            List<String> o10 = sVar.o("Set-Cookie");
            int size = o10.size();
            ArrayList arrayList = null;
            int i10 = 0;
            while (i10 < size) {
                int i11 = i10 + 1;
                l c10 = c(tVar, o10.get(i10));
                if (c10 != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(c10);
                }
                i10 = i11;
            }
            if (arrayList == null) {
                return q.j();
            }
            List<l> unmodifiableList = Collections.unmodifiableList(arrayList);
            j.f(unmodifiableList, "{\n        Collections.un…ableList(cookies)\n      }");
            return unmodifiableList;
        }
    }

    private l(String str, String str2, long j10, String str3, String str4, boolean z10, boolean z11, boolean z12, boolean z13) {
        this.f33134a = str;
        this.f33135b = str2;
        this.f33136c = j10;
        this.f33137d = str3;
        this.f33138e = str4;
        this.f33139f = z10;
        this.f33140g = z11;
        this.f33141h = z12;
        this.f33142i = z13;
    }

    public /* synthetic */ l(String str, String str2, long j10, String str3, String str4, boolean z10, boolean z11, boolean z12, boolean z13, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, j10, str3, str4, z10, z11, z12, z13);
    }

    public final String e() {
        return this.f33137d;
    }

    public boolean equals(Object obj) {
        if (obj instanceof l) {
            l lVar = (l) obj;
            if (j.b(lVar.f33134a, this.f33134a) && j.b(lVar.f33135b, this.f33135b) && lVar.f33136c == this.f33136c && j.b(lVar.f33137d, this.f33137d) && j.b(lVar.f33138e, this.f33138e) && lVar.f33139f == this.f33139f && lVar.f33140g == this.f33140g && lVar.f33141h == this.f33141h && lVar.f33142i == this.f33142i) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final long f() {
        return this.f33136c;
    }

    public final boolean g() {
        return this.f33142i;
    }

    public final boolean h() {
        return this.f33140g;
    }

    @IgnoreJRERequirement
    public int hashCode() {
        return ((((((((((((((((527 + this.f33134a.hashCode()) * 31) + this.f33135b.hashCode()) * 31) + Long.hashCode(this.f33136c)) * 31) + this.f33137d.hashCode()) * 31) + this.f33138e.hashCode()) * 31) + Boolean.hashCode(this.f33139f)) * 31) + Boolean.hashCode(this.f33140g)) * 31) + Boolean.hashCode(this.f33141h)) * 31) + Boolean.hashCode(this.f33142i);
    }

    public final String i() {
        return this.f33134a;
    }

    public final String j() {
        return this.f33138e;
    }

    public final boolean k() {
        return this.f33141h;
    }

    public final boolean l() {
        return this.f33139f;
    }

    public final String m(boolean z10) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i());
        sb2.append(SignatureVisitor.INSTANCEOF);
        sb2.append(n());
        if (k()) {
            if (f() == Long.MIN_VALUE) {
                sb2.append("; max-age=0");
            } else {
                sb2.append("; expires=");
                sb2.append(c.b(new Date(f())));
            }
        }
        if (!g()) {
            sb2.append("; domain=");
            if (z10) {
                sb2.append(".");
            }
            sb2.append(e());
        }
        sb2.append("; path=");
        sb2.append(j());
        if (l()) {
            sb2.append("; secure");
        }
        if (h()) {
            sb2.append("; httponly");
        }
        String sb3 = sb2.toString();
        j.f(sb3, "toString()");
        return sb3;
    }

    public final String n() {
        return this.f33135b;
    }

    public String toString() {
        return m(false);
    }
}
