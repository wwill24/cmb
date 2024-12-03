package kotlinx.coroutines.channels;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.channels.b;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.internal.f0;

@Metadata(bv = {}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B)\u0012 \u0010\u001b\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\f\u0018\u00010\u0019j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J/\u0010\r\u001a\u00020\f2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\nH\u0014ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u000f8DX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u000f8DX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u000f8DX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0011R\u0014\u0010\u0018\u001a\u00020\u000f8DX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0011\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u001e"}, d2 = {"Lkotlinx/coroutines/channels/m;", "E", "Lkotlinx/coroutines/channels/AbstractChannel;", "element", "", "C", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/internal/m;", "Lkotlinx/coroutines/channels/t;", "list", "Lkotlinx/coroutines/channels/k;", "closed", "", "Y", "(Ljava/lang/Object;Lkotlinx/coroutines/channels/k;)V", "", "U", "()Z", "isBufferAlwaysEmpty", "V", "isBufferEmpty", "x", "isBufferAlwaysFull", "y", "isBufferFull", "Lkotlin/Function1;", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "onUndeliveredElement", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public class m<E> extends AbstractChannel<E> {
    public m(Function1<? super E, Unit> function1) {
        super(function1);
    }

    /* access modifiers changed from: protected */
    public Object C(E e10) {
        r<?> G;
        do {
            Object C = super.C(e10);
            f0 f0Var = a.f32312b;
            if (C == f0Var) {
                return f0Var;
            }
            if (C == a.f32313c) {
                G = G(e10);
                if (G == null) {
                    return f0Var;
                }
            } else if (C instanceof k) {
                return C;
            } else {
                throw new IllegalStateException(("Invalid offerInternal result " + C).toString());
            }
        } while (!(G instanceof k));
        return G;
    }

    /* access modifiers changed from: protected */
    public final boolean U() {
        return true;
    }

    /* access modifiers changed from: protected */
    public final boolean V() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void Y(Object obj, k<?> kVar) {
        UndeliveredElementException undeliveredElementException = null;
        if (obj != null) {
            if (!(obj instanceof ArrayList)) {
                t tVar = (t) obj;
                if (tVar instanceof b.a) {
                    Function1<E, Unit> function1 = this.f32318a;
                    if (function1 != null) {
                        undeliveredElementException = OnUndeliveredElementKt.c(function1, ((b.a) tVar).f32320d, (UndeliveredElementException) null);
                    }
                } else {
                    tVar.Z(kVar);
                }
            } else {
                ArrayList arrayList = (ArrayList) obj;
                UndeliveredElementException undeliveredElementException2 = null;
                for (int size = arrayList.size() - 1; -1 < size; size--) {
                    t tVar2 = (t) arrayList.get(size);
                    if (tVar2 instanceof b.a) {
                        Function1<E, Unit> function12 = this.f32318a;
                        if (function12 != null) {
                            undeliveredElementException2 = OnUndeliveredElementKt.c(function12, ((b.a) tVar2).f32320d, undeliveredElementException2);
                        } else {
                            undeliveredElementException2 = null;
                        }
                    } else {
                        tVar2.Z(kVar);
                    }
                }
                undeliveredElementException = undeliveredElementException2;
            }
        }
        if (undeliveredElementException != null) {
            throw undeliveredElementException;
        }
    }

    /* access modifiers changed from: protected */
    public final boolean x() {
        return false;
    }

    /* access modifiers changed from: protected */
    public final boolean y() {
        return false;
    }
}
