package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;

@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b \u0018\u00002\u00020\u00012\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u0005B\u0007¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\u0007\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H¦\u0002¨\u0006\n"}, d2 = {"Lkotlinx/coroutines/d0;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlin/Function1;", "", "", "Lkotlinx/coroutines/CompletionHandler;", "cause", "X", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public abstract class d0 extends LockFreeLinkedListNode implements Function1<Throwable, Unit> {
    public abstract void X(Throwable th2);
}
