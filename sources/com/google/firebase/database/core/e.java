package com.google.firebase.database.core;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.Query;
import com.google.firebase.database.core.Repo;

public final /* synthetic */ class e implements OnCompleteListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Repo.AnonymousClass9 f21070a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f21071b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DataSnapshot f21072c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Query f21073d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Repo f21074e;

    public /* synthetic */ e(Repo.AnonymousClass9 r12, TaskCompletionSource taskCompletionSource, DataSnapshot dataSnapshot, Query query, Repo repo) {
        this.f21070a = r12;
        this.f21071b = taskCompletionSource;
        this.f21072c = dataSnapshot;
        this.f21073d = query;
        this.f21074e = repo;
    }

    public final void onComplete(Task task) {
        this.f21070a.lambda$run$1(this.f21071b, this.f21072c, this.f21073d, this.f21074e, task);
    }
}
