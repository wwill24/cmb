package com.squareup.workflow1;

import com.squareup.workflow1.internal.h;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import okio.BufferedSource;

@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "Lcom/squareup/workflow1/internal/h;", "Lcom/squareup/workflow1/TreeSnapshot;", "invoke", "()Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
final class TreeSnapshot$Companion$parse$1$1 extends Lambda implements Function0<Map<h, ? extends TreeSnapshot>> {
    final /* synthetic */ BufferedSource $source;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TreeSnapshot$Companion$parse$1$1(BufferedSource bufferedSource) {
        super(0);
        this.$source = bufferedSource;
    }

    public final Map<h, TreeSnapshot> invoke() {
        int readInt = this.$source.readInt();
        BufferedSource bufferedSource = this.$source;
        Map d10 = g0.d(readInt);
        int i10 = 0;
        while (i10 < readInt) {
            i10++;
            d10.put(h.f23135c.a(g.a(bufferedSource)), TreeSnapshot.f23059c.a(g.a(bufferedSource)));
        }
        return g0.b(d10);
    }
}
