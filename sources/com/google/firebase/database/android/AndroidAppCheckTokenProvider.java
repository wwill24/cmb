package com.google.firebase.database.android;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import com.google.firebase.appcheck.interop.InteropAppCheckTokenProvider;
import com.google.firebase.database.core.TokenProvider;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicReference;

public class AndroidAppCheckTokenProvider implements TokenProvider {
    private final Deferred<InteropAppCheckTokenProvider> deferredAppCheckProvider;
    private final AtomicReference<InteropAppCheckTokenProvider> internalAppCheck = new AtomicReference<>();

    public AndroidAppCheckTokenProvider(Deferred<InteropAppCheckTokenProvider> deferred) {
        this.deferredAppCheckProvider = deferred;
        deferred.whenAvailable(new d(this));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(Provider provider) {
        this.internalAppCheck.set((InteropAppCheckTokenProvider) provider.get());
    }

    public void addTokenChangeListener(ExecutorService executorService, TokenProvider.TokenChangeListener tokenChangeListener) {
        this.deferredAppCheckProvider.whenAvailable(new e(executorService, tokenChangeListener));
    }

    @SuppressLint({"TaskMainThread"})
    public void getToken(boolean z10, @NonNull TokenProvider.GetTokenCompletionListener getTokenCompletionListener) {
        InteropAppCheckTokenProvider interopAppCheckTokenProvider = this.internalAppCheck.get();
        if (interopAppCheckTokenProvider != null) {
            interopAppCheckTokenProvider.getToken(z10).addOnSuccessListener(new a(getTokenCompletionListener)).addOnFailureListener(new b(getTokenCompletionListener));
        } else {
            getTokenCompletionListener.onSuccess((String) null);
        }
    }

    public void removeTokenChangeListener(TokenProvider.TokenChangeListener tokenChangeListener) {
    }
}
