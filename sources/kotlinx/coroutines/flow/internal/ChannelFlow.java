package kotlinx.coroutines.flow.internal;

import com.google.android.gms.common.api.a;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.o;
import kotlinx.coroutines.channels.q;
import kotlinx.coroutines.flow.b;
import kotlinx.coroutines.flow.c;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import org.apache.commons.beanutils.PropertyUtils;

@Metadata(bv = {}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001f\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b)\u0010*J\u0010\u0010\u0004\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003H\u0016J&\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J&\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH$J!\u0010\u0010\u001a\u00020\u000f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\rH¤@ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u00132\u0006\u0010\u000e\u001a\u00020\u0012H\u0016J!\u0010\u0017\u001a\u00020\u000f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H@ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\n\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0014J\b\u0010\u001b\u001a\u00020\u0019H\u0016R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u001cR\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001dR\u0014\u0010\n\u001a\u00020\t8\u0006X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR9\u0010%\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0!\u0012\u0006\u0012\u0004\u0018\u00010\"0 8@X\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0014\u0010(\u001a\u00020\u00078@X\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'\u0002\u0004\n\u0002\b\u0019¨\u0006+"}, d2 = {"Lkotlinx/coroutines/flow/internal/ChannelFlow;", "T", "Lkotlinx/coroutines/flow/internal/i;", "Lkotlinx/coroutines/flow/b;", "k", "Lkotlin/coroutines/CoroutineContext;", "context", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "d", "j", "Lkotlinx/coroutines/channels/o;", "scope", "", "i", "(Lkotlinx/coroutines/channels/o;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlinx/coroutines/k0;", "Lkotlinx/coroutines/channels/q;", "n", "Lkotlinx/coroutines/flow/c;", "collector", "a", "(Lkotlinx/coroutines/flow/c;Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "b", "toString", "Lkotlin/coroutines/CoroutineContext;", "I", "c", "Lkotlinx/coroutines/channels/BufferOverflow;", "Lkotlin/Function2;", "Lkotlin/coroutines/c;", "", "l", "()Lkotlin/jvm/functions/Function2;", "collectToFun", "m", "()I", "produceCapacity", "<init>", "(Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public abstract class ChannelFlow<T> implements i<T> {

    /* renamed from: a  reason: collision with root package name */
    public final CoroutineContext f32435a;

    /* renamed from: b  reason: collision with root package name */
    public final int f32436b;

    /* renamed from: c  reason: collision with root package name */
    public final BufferOverflow f32437c;

    public ChannelFlow(CoroutineContext coroutineContext, int i10, BufferOverflow bufferOverflow) {
        this.f32435a = coroutineContext;
        this.f32436b = i10;
        this.f32437c = bufferOverflow;
    }

    static /* synthetic */ Object g(ChannelFlow channelFlow, c cVar, kotlin.coroutines.c cVar2) {
        Object g10 = l0.g(new ChannelFlow$collect$2(cVar, channelFlow, (kotlin.coroutines.c<? super ChannelFlow$collect$2>) null), cVar2);
        return g10 == b.d() ? g10 : Unit.f32013a;
    }

    public Object a(c<? super T> cVar, kotlin.coroutines.c<? super Unit> cVar2) {
        return g(this, cVar, cVar2);
    }

    /* access modifiers changed from: protected */
    public String b() {
        return null;
    }

    public b<T> d(CoroutineContext coroutineContext, int i10, BufferOverflow bufferOverflow) {
        CoroutineContext e02 = coroutineContext.e0(this.f32435a);
        if (bufferOverflow == BufferOverflow.SUSPEND) {
            int i11 = this.f32436b;
            if (i11 != -3) {
                if (i10 != -3) {
                    if (i11 != -2) {
                        if (i10 != -2 && (i11 = i11 + i10) < 0) {
                            i10 = a.e.API_PRIORITY_OTHER;
                        }
                    }
                }
                i10 = i11;
            }
            bufferOverflow = this.f32437c;
        }
        if (j.b(e02, this.f32435a) && i10 == this.f32436b && bufferOverflow == this.f32437c) {
            return this;
        }
        return j(e02, i10, bufferOverflow);
    }

    /* access modifiers changed from: protected */
    public abstract Object i(o<? super T> oVar, kotlin.coroutines.c<? super Unit> cVar);

    /* access modifiers changed from: protected */
    public abstract ChannelFlow<T> j(CoroutineContext coroutineContext, int i10, BufferOverflow bufferOverflow);

    public b<T> k() {
        return null;
    }

    public final Function2<o<? super T>, kotlin.coroutines.c<? super Unit>, Object> l() {
        return new ChannelFlow$collectToFun$1(this, (kotlin.coroutines.c<? super ChannelFlow$collectToFun$1>) null);
    }

    public final int m() {
        int i10 = this.f32436b;
        if (i10 == -3) {
            return -2;
        }
        return i10;
    }

    public q<T> n(k0 k0Var) {
        return ProduceKt.e(k0Var, this.f32435a, m(), this.f32437c, CoroutineStart.ATOMIC, (Function1) null, l(), 16, (Object) null);
    }

    public String toString() {
        ArrayList arrayList = new ArrayList(4);
        String b10 = b();
        if (b10 != null) {
            arrayList.add(b10);
        }
        if (this.f32435a != EmptyCoroutineContext.f32070a) {
            arrayList.add("context=" + this.f32435a);
        }
        if (this.f32436b != -3) {
            arrayList.add("capacity=" + this.f32436b);
        }
        if (this.f32437c != BufferOverflow.SUSPEND) {
            arrayList.add("onBufferOverflow=" + this.f32437c);
        }
        return m0.a(this) + '[' + CollectionsKt___CollectionsKt.W(arrayList, ", ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null) + PropertyUtils.INDEXED_DELIM2;
    }
}
