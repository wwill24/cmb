package com.squareup.workflow1.internal;

import com.squareup.workflow1.k;
import com.squareup.workflow1.l;
import com.squareup.workflow1.m;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import pk.o;

@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u000e\u001a\u00028\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002\"\u0004\b\u0003\u0010\u0003\"\u0004\b\u0004\u0010\u0004\"\u0004\b\u0005\u0010\u00052\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00062\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010\n\u001a\u00020\t2$\u0010\r\u001a \u0012\u0004\u0012\u00028\u0001\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\f0\u000bH\n¢\u0006\u0004\b\u000e\u0010\u000f"}, d2 = {"CP", "CO", "CR", "P", "S", "O", "Lcom/squareup/workflow1/k;", "c", "p", "", "k", "Lkotlin/Function1;", "Lcom/squareup/workflow1/l;", "h", "a", "(Lcom/squareup/workflow1/k;Ljava/lang/Object;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0})
final class ChainedWorkflowInterceptor$wrap$1$onRenderChild$1 extends Lambda implements o<k<? super CP, ? extends CO, ? extends CR>, CP, String, Function1<? super CO, ? extends l<? super P, S, ? extends O>>, CR> {
    final /* synthetic */ m.b<P, S, O> $inner;
    final /* synthetic */ o<k<? super CP, ? extends CO, ? extends CR>, CP, String, Function1<? super CO, ? extends l<? super P, S, ? extends O>>, CR> $proceed;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChainedWorkflowInterceptor$wrap$1$onRenderChild$1(m.b<P, S, O> bVar, o<? super k<? super CP, ? extends CO, ? extends CR>, ? super CP, ? super String, ? super Function1<? super CO, ? extends l<? super P, S, ? extends O>>, ? extends CR> oVar) {
        super(4);
        this.$inner = bVar;
        this.$proceed = oVar;
    }

    /* renamed from: a */
    public final CR g(k<? super CP, ? extends CO, ? extends CR> kVar, CP cp, String str, Function1<? super CO, ? extends l<? super P, S, ? extends O>> function1) {
        j.g(kVar, "c");
        j.g(str, "k");
        j.g(function1, "h");
        return this.$inner.a(kVar, cp, str, function1, this.$proceed);
    }
}
