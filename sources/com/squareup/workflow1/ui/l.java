package com.squareup.workflow1.ui;

import kotlin.Metadata;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.flow.b;
import kotlinx.coroutines.flow.d;
import kotlinx.coroutines.flow.i;
import kotlinx.coroutines.flow.s;

@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0003¢\u0006\u0004\b\u0013\u0010\u0010R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00078\u0016X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0004\u0010\nR$\u0010\u0011\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00038V@VX\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/squareup/workflow1/ui/l;", "Lcom/squareup/workflow1/ui/k;", "Lkotlinx/coroutines/flow/i;", "", "a", "Lkotlinx/coroutines/flow/i;", "_textValue", "Lkotlinx/coroutines/flow/b;", "b", "Lkotlinx/coroutines/flow/b;", "()Lkotlinx/coroutines/flow/b;", "onTextChanged", "value", "c", "()Ljava/lang/String;", "d", "(Ljava/lang/String;)V", "textValue", "initialValue", "<init>", "wf1-core-common"}, k = 1, mv = {1, 6, 0})
final class l implements k {

    /* renamed from: a  reason: collision with root package name */
    private final i<String> f23243a;

    /* renamed from: b  reason: collision with root package name */
    private final b<String> f23244b;

    public l(String str) {
        j.g(str, "initialValue");
        i<String> a10 = s.a(str);
        this.f23243a = a10;
        this.f23244b = d.n(a10, 1);
    }

    public b<String> a() {
        return this.f23244b;
    }

    public String c() {
        return this.f23243a.getValue();
    }

    public void d(String str) {
        j.g(str, "value");
        this.f23243a.setValue(str);
    }
}
