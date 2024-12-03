package com.google.firebase.database.android;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import com.google.firebase.FirebaseApiNotAvailableException;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.database.core.TokenProvider;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import com.google.firebase.internal.api.FirebaseNoSignedInUserException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicReference;

public class AndroidAuthTokenProvider implements TokenProvider {
    private final Deferred<InternalAuthProvider> deferredAuthProvider;
    private final AtomicReference<InternalAuthProvider> internalAuth = new AtomicReference<>();

    public AndroidAuthTokenProvider(Deferred<InternalAuthProvider> deferred) {
        this.deferredAuthProvider = deferred;
        deferred.whenAvailable(new j(this));
    }

    private static boolean isUnauthenticatedUsage(Exception exc) {
        return (exc instanceof FirebaseApiNotAvailableException) || (exc instanceof FirebaseNoSignedInUserException);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$getToken$2(TokenProvider.GetTokenCompletionListener getTokenCompletionListener, Exception exc) {
        if (isUnauthenticatedUsage(exc)) {
            getTokenCompletionListener.onSuccess((String) null);
        } else {
            getTokenCompletionListener.onError(exc.getMessage());
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(Provider provider) {
        this.internalAuth.set((InternalAuthProvider) provider.get());
    }

    public void addTokenChangeListener(ExecutorService executorService, TokenProvider.TokenChangeListener tokenChangeListener) {
        this.deferredAuthProvider.whenAvailable(new i(executorService, tokenChangeListener));
    }

    @SuppressLint({"TaskMainThread"})
    public void getToken(boolean z10, @NonNull TokenProvider.GetTokenCompletionListener getTokenCompletionListener) {
        InternalAuthProvider internalAuthProvider = this.internalAuth.get();
        if (internalAuthProvider != null) {
            internalAuthProvider.getAccessToken(z10).addOnSuccessListener(new k(getTokenCompletionListener)).addOnFailureListener(new l(getTokenCompletionListener));
        } else {
            getTokenCompletionListener.onSuccess((String) null);
        }
    }

    public void removeTokenChangeListener(TokenProvider.TokenChangeListener tokenChangeListener) {
    }
}
