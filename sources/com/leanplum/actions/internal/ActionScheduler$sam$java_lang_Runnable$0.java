package com.leanplum.actions.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.j;

@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
final class ActionScheduler$sam$java_lang_Runnable$0 implements Runnable {
    private final /* synthetic */ Function0 function;

    ActionScheduler$sam$java_lang_Runnable$0(Function0 function0) {
        this.function = function0;
    }

    public final /* synthetic */ void run() {
        j.f(this.function.invoke(), "invoke(...)");
    }
}
