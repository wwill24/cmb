package com.squareup.workflow1;

import com.squareup.workflow1.j;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.flow.b;
import org.apache.commons.beanutils.PropertyUtils;
import wk.m;

@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001d\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/squareup/workflow1/i;", "OutputT", "Lcom/squareup/workflow1/j;", "Lkotlinx/coroutines/flow/b;", "run", "", "toString", "Lwk/m;", "b", "Lwk/m;", "outputType", "c", "Lkotlinx/coroutines/flow/b;", "work", "<init>", "(Lwk/m;Lkotlinx/coroutines/flow/b;)V", "wf1-workflow-core"}, k = 1, mv = {1, 6, 0})
public final class i<OutputT> implements j<OutputT> {

    /* renamed from: b  reason: collision with root package name */
    private final m f23089b;

    /* renamed from: c  reason: collision with root package name */
    private final b<OutputT> f23090c;

    public i(m mVar, b<? extends OutputT> bVar) {
        j.g(mVar, "outputType");
        j.g(bVar, "work");
        this.f23089b = mVar;
        this.f23090c = bVar;
    }

    public boolean a(j<?> jVar) {
        return j.b.a(this, jVar);
    }

    public b<OutputT> run() {
        return this.f23090c;
    }

    public String toString() {
        return "TypedWorker(" + this.f23089b + PropertyUtils.MAPPED_DELIM2;
    }
}
