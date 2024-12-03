package kotlin.text;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import kotlin.ranges.IntRange;

public final class h {
    /* access modifiers changed from: private */
    public static final MatchResult e(Matcher matcher, int i10, CharSequence charSequence) {
        if (!matcher.find(i10)) {
            return null;
        }
        return new MatcherMatchResult(matcher, charSequence);
    }

    /* access modifiers changed from: private */
    public static final MatchResult f(Matcher matcher, CharSequence charSequence) {
        if (!matcher.matches()) {
            return null;
        }
        return new MatcherMatchResult(matcher, charSequence);
    }

    /* access modifiers changed from: private */
    public static final IntRange g(MatchResult matchResult, int i10) {
        return j.o(matchResult.start(i10), matchResult.end(i10));
    }

    /* access modifiers changed from: private */
    public static final int h(Iterable<? extends f> iterable) {
        int i10 = 0;
        for (f value : iterable) {
            i10 |= value.getValue();
        }
        return i10;
    }
}
