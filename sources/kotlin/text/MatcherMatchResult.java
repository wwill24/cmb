package kotlin.text;

import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import kotlin.collections.b;
import kotlin.jvm.internal.j;

final class MatcherMatchResult implements MatchResult {

    /* renamed from: a  reason: collision with root package name */
    private final Matcher f32198a;

    /* renamed from: b  reason: collision with root package name */
    private final CharSequence f32199b;

    /* renamed from: c  reason: collision with root package name */
    private final g f32200c = new MatcherMatchResult$groups$1(this);

    /* renamed from: d  reason: collision with root package name */
    private List<String> f32201d;

    public static final class a extends b<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ MatcherMatchResult f32202b;

        a(MatcherMatchResult matcherMatchResult) {
            this.f32202b = matcherMatchResult;
        }

        public int b() {
            return this.f32202b.d().groupCount() + 1;
        }

        public final /* bridge */ boolean contains(Object obj) {
            if (!(obj instanceof String)) {
                return false;
            }
            return d((String) obj);
        }

        public /* bridge */ boolean d(String str) {
            return super.contains(str);
        }

        public /* bridge */ int f(String str) {
            return super.indexOf(str);
        }

        public /* bridge */ int g(String str) {
            return super.lastIndexOf(str);
        }

        public final /* bridge */ int indexOf(Object obj) {
            if (!(obj instanceof String)) {
                return -1;
            }
            return f((String) obj);
        }

        public final /* bridge */ int lastIndexOf(Object obj) {
            if (!(obj instanceof String)) {
                return -1;
            }
            return g((String) obj);
        }

        public String get(int i10) {
            String group = this.f32202b.d().group(i10);
            return group == null ? "" : group;
        }
    }

    public MatcherMatchResult(Matcher matcher, CharSequence charSequence) {
        j.g(matcher, "matcher");
        j.g(charSequence, "input");
        this.f32198a = matcher;
        this.f32199b = charSequence;
    }

    /* access modifiers changed from: private */
    public final MatchResult d() {
        return this.f32198a;
    }

    public List<String> a() {
        if (this.f32201d == null) {
            this.f32201d = new a(this);
        }
        List<String> list = this.f32201d;
        j.d(list);
        return list;
    }

    public g b() {
        return this.f32200c;
    }

    public String getValue() {
        String group = d().group();
        j.f(group, "matchResult.group()");
        return group;
    }
}
