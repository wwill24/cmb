package operations.array.occurence;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import ol.a;
import operations.array.occurence.OccurrenceCheckOperation;

final class OccurrenceCheckOperation$checkOccurrence$1 extends Lambda implements Function2<a, f, Object> {
    final /* synthetic */ OccurrenceCheckOperation this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OccurrenceCheckOperation$checkOccurrence$1(OccurrenceCheckOperation occurrenceCheckOperation) {
        super(2);
        this.this$0 = occurrenceCheckOperation;
    }

    /* renamed from: a */
    public final Object invoke(a aVar, f fVar) {
        j.g(aVar, "input");
        j.g(fVar, "logicEvaluator");
        return OccurrenceCheckOperation.DefaultImpls.d(this.this$0, aVar, fVar, new Function2<c, f, Object>(this.this$0) {
            /* renamed from: c */
            public final Object invoke(c cVar, f fVar) {
                j.g(cVar, "p0");
                j.g(fVar, "p1");
                return ((OccurrenceCheckOperation) this.receiver).g(cVar, fVar);
            }
        });
    }
}
