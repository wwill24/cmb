package com.google.android.gms.common.api.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

final class a0 implements OnCompleteListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f38541a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ b0 f38542b;

    a0(b0 b0Var, TaskCompletionSource taskCompletionSource) {
        this.f38542b = b0Var;
        this.f38541a = taskCompletionSource;
    }

    public final void onComplete(@NonNull Task task) {
        this.f38542b.f38550b.remove(this.f38541a);
    }
}
