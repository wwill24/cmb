package kotlin.text;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public final class Regex implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public static final a f32204a = new a((DefaultConstructorMarker) null);
    private Set<? extends RegexOption> _options;
    private final Pattern nativePattern;

    private static final class Serialized implements Serializable {

        /* renamed from: a  reason: collision with root package name */
        public static final a f32205a = new a((DefaultConstructorMarker) null);
        private static final long serialVersionUID = 0;
        private final int flags;
        private final String pattern;

        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Serialized(String str, int i10) {
            j.g(str, "pattern");
            this.pattern = str;
            this.flags = i10;
        }

        private final Object readResolve() {
            Pattern compile = Pattern.compile(this.pattern, this.flags);
            j.f(compile, "compile(pattern, flags)");
            return new Regex(compile);
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final int b(int i10) {
            return (i10 & 2) != 0 ? i10 | 64 : i10;
        }
    }

    public Regex(Pattern pattern) {
        j.g(pattern, "nativePattern");
        this.nativePattern = pattern;
    }

    public static /* synthetic */ MatchResult c(Regex regex, CharSequence charSequence, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        return regex.b(charSequence, i10);
    }

    private final Object writeReplace() {
        String pattern = this.nativePattern.pattern();
        j.f(pattern, "nativePattern.pattern()");
        return new Serialized(pattern, this.nativePattern.flags());
    }

    public final boolean a(CharSequence charSequence) {
        j.g(charSequence, "input");
        return this.nativePattern.matcher(charSequence).find();
    }

    public final MatchResult b(CharSequence charSequence, int i10) {
        j.g(charSequence, "input");
        Matcher matcher = this.nativePattern.matcher(charSequence);
        j.f(matcher, "nativePattern.matcher(input)");
        return h.e(matcher, i10, charSequence);
    }

    public final MatchResult d(CharSequence charSequence) {
        j.g(charSequence, "input");
        Matcher matcher = this.nativePattern.matcher(charSequence);
        j.f(matcher, "nativePattern.matcher(input)");
        return h.f(matcher, charSequence);
    }

    public final boolean e(CharSequence charSequence) {
        j.g(charSequence, "input");
        return this.nativePattern.matcher(charSequence).matches();
    }

    public final String f(CharSequence charSequence, String str) {
        j.g(charSequence, "input");
        j.g(str, "replacement");
        String replaceAll = this.nativePattern.matcher(charSequence).replaceAll(str);
        j.f(replaceAll, "nativePattern.matcher(in…).replaceAll(replacement)");
        return replaceAll;
    }

    public final String g(CharSequence charSequence, String str) {
        j.g(charSequence, "input");
        j.g(str, "replacement");
        String replaceFirst = this.nativePattern.matcher(charSequence).replaceFirst(str);
        j.f(replaceFirst, "nativePattern.matcher(in…replaceFirst(replacement)");
        return replaceFirst;
    }

    public final List<String> h(CharSequence charSequence, int i10) {
        j.g(charSequence, "input");
        StringsKt__StringsKt.x0(i10);
        Matcher matcher = this.nativePattern.matcher(charSequence);
        if (i10 == 1 || !matcher.find()) {
            return p.e(charSequence.toString());
        }
        int i11 = 10;
        if (i10 > 0) {
            i11 = j.g(i10, 10);
        }
        ArrayList arrayList = new ArrayList(i11);
        int i12 = 0;
        int i13 = i10 - 1;
        do {
            arrayList.add(charSequence.subSequence(i12, matcher.start()).toString());
            i12 = matcher.end();
            if ((i13 >= 0 && arrayList.size() == i13) || !matcher.find()) {
                arrayList.add(charSequence.subSequence(i12, charSequence.length()).toString());
            }
            arrayList.add(charSequence.subSequence(i12, matcher.start()).toString());
            i12 = matcher.end();
            break;
        } while (!matcher.find());
        arrayList.add(charSequence.subSequence(i12, charSequence.length()).toString());
        return arrayList;
    }

    public String toString() {
        String pattern = this.nativePattern.toString();
        j.f(pattern, "nativePattern.toString()");
        return pattern;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Regex(java.lang.String r2) {
        /*
            r1 = this;
            java.lang.String r0 = "pattern"
            kotlin.jvm.internal.j.g(r2, r0)
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2)
            java.lang.String r0 = "compile(pattern)"
            kotlin.jvm.internal.j.f(r2, r0)
            r1.<init>((java.util.regex.Pattern) r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.Regex.<init>(java.lang.String):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Regex(java.lang.String r2, kotlin.text.RegexOption r3) {
        /*
            r1 = this;
            java.lang.String r0 = "pattern"
            kotlin.jvm.internal.j.g(r2, r0)
            java.lang.String r0 = "option"
            kotlin.jvm.internal.j.g(r3, r0)
            kotlin.text.Regex$a r0 = f32204a
            int r3 = r3.getValue()
            int r3 = r0.b(r3)
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2, r3)
            java.lang.String r3 = "compile(pattern, ensureUnicodeCase(option.value))"
            kotlin.jvm.internal.j.f(r2, r3)
            r1.<init>((java.util.regex.Pattern) r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.Regex.<init>(java.lang.String, kotlin.text.RegexOption):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Regex(java.lang.String r2, java.util.Set<? extends kotlin.text.RegexOption> r3) {
        /*
            r1 = this;
            java.lang.String r0 = "pattern"
            kotlin.jvm.internal.j.g(r2, r0)
            java.lang.String r0 = "options"
            kotlin.jvm.internal.j.g(r3, r0)
            kotlin.text.Regex$a r0 = f32204a
            int r3 = kotlin.text.h.h(r3)
            int r3 = r0.b(r3)
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2, r3)
            java.lang.String r3 = "compile(pattern, ensureU…odeCase(options.toInt()))"
            kotlin.jvm.internal.j.f(r2, r3)
            r1.<init>((java.util.regex.Pattern) r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.Regex.<init>(java.lang.String, java.util.Set):void");
    }
}
