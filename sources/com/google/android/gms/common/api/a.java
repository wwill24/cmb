package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.internal.n;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.common.internal.i;
import com.google.android.gms.common.internal.p;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public final class a<O extends d> {

    /* renamed from: a  reason: collision with root package name */
    private final C0480a f38512a;

    /* renamed from: b  reason: collision with root package name */
    private final g f38513b;

    /* renamed from: c  reason: collision with root package name */
    private final String f38514c;

    /* renamed from: com.google.android.gms.common.api.a$a  reason: collision with other inner class name */
    public static abstract class C0480a<T extends f, O> extends e<T, O> {
        @NonNull
        @Deprecated
        public T buildClient(@NonNull Context context, @NonNull Looper looper, @NonNull com.google.android.gms.common.internal.e eVar, @NonNull O o10, @NonNull d.b bVar, @NonNull d.c cVar) {
            return buildClient(context, looper, eVar, o10, (com.google.android.gms.common.api.internal.f) bVar, (n) cVar);
        }

        @NonNull
        public T buildClient(@NonNull Context context, @NonNull Looper looper, @NonNull com.google.android.gms.common.internal.e eVar, @NonNull O o10, @NonNull com.google.android.gms.common.api.internal.f fVar, @NonNull n nVar) {
            throw new UnsupportedOperationException("buildClient must be implemented");
        }
    }

    public interface b {
    }

    public static class c<C extends b> {
    }

    public interface d {
        @NonNull

        /* renamed from: i  reason: collision with root package name */
        public static final c f38515i = new c((o) null);

        /* renamed from: com.google.android.gms.common.api.a$d$a  reason: collision with other inner class name */
        public interface C0481a extends d {
            @NonNull
            Account O();
        }

        public interface b extends d {
            GoogleSignInAccount F();
        }

        public static final class c implements d {
            private c() {
            }

            /* synthetic */ c(o oVar) {
            }
        }
    }

    public static abstract class e<T extends b, O> {
        public static final int API_PRIORITY_GAMES = 1;
        public static final int API_PRIORITY_OTHER = Integer.MAX_VALUE;
        public static final int API_PRIORITY_PLUS = 2;

        @NonNull
        public List<Scope> getImpliedScopes(O o10) {
            return Collections.emptyList();
        }

        public int getPriority() {
            return API_PRIORITY_OTHER;
        }
    }

    public interface f extends b {
        void connect(@NonNull d.c cVar);

        void disconnect();

        void disconnect(@NonNull String str);

        void dump(@NonNull String str, FileDescriptor fileDescriptor, @NonNull PrintWriter printWriter, String[] strArr);

        @NonNull
        Feature[] getAvailableFeatures();

        @NonNull
        String getEndpointPackageName();

        String getLastDisconnectMessage();

        int getMinApkVersion();

        void getRemoteService(i iVar, Set<Scope> set);

        @NonNull
        Set<Scope> getScopesForConnectionlessNonSignIn();

        @NonNull
        Intent getSignInIntent();

        boolean isConnected();

        boolean isConnecting();

        void onUserSignOut(@NonNull d.e eVar);

        boolean providesSignIn();

        boolean requiresGooglePlayServices();

        boolean requiresSignIn();
    }

    public static final class g<C extends f> extends c<C> {
    }

    public <C extends f> a(@NonNull String str, @NonNull C0480a<C, O> aVar, @NonNull g<C> gVar) {
        p.l(aVar, "Cannot construct an Api with a null ClientBuilder");
        p.l(gVar, "Cannot construct an Api with a null ClientKey");
        this.f38514c = str;
        this.f38512a = aVar;
        this.f38513b = gVar;
    }

    @NonNull
    public final C0480a a() {
        return this.f38512a;
    }

    @NonNull
    public final c b() {
        return this.f38513b;
    }

    @NonNull
    public final e c() {
        return this.f38512a;
    }

    @NonNull
    public final String d() {
        return this.f38514c;
    }
}
