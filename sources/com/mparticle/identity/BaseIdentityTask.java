package com.mparticle.identity;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.mparticle.MParticleTask;
import java.util.HashSet;
import java.util.Set;

public final class BaseIdentityTask extends MParticleTask<IdentityApiResult> {
    Set<TaskFailureListener> failureListeners = new HashSet();
    boolean isCompleted;
    boolean isSuccessful;
    IdentityApiResult result;
    Set<TaskSuccessListener> successListeners = new HashSet();

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ IdentityHttpResponse f22322a;

        a(IdentityHttpResponse identityHttpResponse) {
            this.f22322a = identityHttpResponse;
        }

        public void run() {
            for (TaskFailureListener onFailure : BaseIdentityTask.this.failureListeners) {
                onFailure.onFailure(this.f22322a);
            }
        }
    }

    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ IdentityApiResult f22324a;

        b(IdentityApiResult identityApiResult) {
            this.f22324a = identityApiResult;
        }

        public void run() {
            for (TaskSuccessListener onSuccess : BaseIdentityTask.this.successListeners) {
                onSuccess.onSuccess(this.f22324a);
            }
        }
    }

    public boolean isComplete() {
        return this.isCompleted;
    }

    public boolean isSuccessful() {
        return this.isSuccessful;
    }

    public void setFailed(IdentityHttpResponse identityHttpResponse) {
        this.isCompleted = true;
        this.isSuccessful = false;
        new Handler(Looper.getMainLooper()).post(new a(identityHttpResponse));
    }

    public void setSuccessful(@NonNull IdentityApiResult identityApiResult) {
        this.isCompleted = true;
        this.isSuccessful = true;
        this.result = identityApiResult;
        new Handler(Looper.getMainLooper()).post(new b(identityApiResult));
    }

    @NonNull
    public BaseIdentityTask addFailureListener(@NonNull TaskFailureListener taskFailureListener) {
        if (taskFailureListener != null) {
            this.failureListeners.add(taskFailureListener);
        }
        return this;
    }

    @NonNull
    public BaseIdentityTask addSuccessListener(@NonNull TaskSuccessListener taskSuccessListener) {
        if (taskSuccessListener != null) {
            this.successListeners.add(taskSuccessListener);
        }
        return this;
    }

    public IdentityApiResult getResult() {
        return this.result;
    }
}
