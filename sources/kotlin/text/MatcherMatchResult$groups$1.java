package kotlin.text;

import java.util.Iterator;
import kotlin.collections.AbstractCollection;
import kotlin.jvm.internal.j;
import kotlin.ranges.IntRange;

public final class MatcherMatchResult$groups$1 extends AbstractCollection<MatchGroup> implements g {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MatcherMatchResult f32203a;

    MatcherMatchResult$groups$1(MatcherMatchResult matcherMatchResult) {
        this.f32203a = matcherMatchResult;
    }

    public int b() {
        return this.f32203a.d().groupCount() + 1;
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj == null ? true : obj instanceof MatchGroup)) {
            return false;
        }
        return d((MatchGroup) obj);
    }

    public /* bridge */ boolean d(MatchGroup matchGroup) {
        return super.contains(matchGroup);
    }

    public MatchGroup get(int i10) {
        IntRange c10 = h.g(this.f32203a.d(), i10);
        if (c10.o().intValue() < 0) {
            return null;
        }
        String group = this.f32203a.d().group(i10);
        j.f(group, "matchResult.group(index)");
        return new MatchGroup(group, c10);
    }

    public boolean isEmpty() {
        return false;
    }

    public Iterator<MatchGroup> iterator() {
        return SequencesKt___SequencesKt.q(CollectionsKt___CollectionsKt.D(q.k(this)), new MatcherMatchResult$groups$1$iterator$1(this)).iterator();
    }
}
