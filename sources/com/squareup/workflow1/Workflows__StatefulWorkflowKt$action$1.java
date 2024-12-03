package com.squareup.workflow1;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002\"\u0004\b\u0003\u0010\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"PropsT", "StateT", "OutputT", "RenderingT", "", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
final class Workflows__StatefulWorkflowKt$action$1 extends Lambda implements Function0<String> {
    final /* synthetic */ String $name;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Workflows__StatefulWorkflowKt$action$1(String str) {
        super(0);
        this.$name = str;
    }

    /* renamed from: a */
    public final String invoke() {
        return this.$name;
    }
}
