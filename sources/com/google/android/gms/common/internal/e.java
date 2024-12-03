package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.collection.b;
import com.google.android.gms.common.api.Scope;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    private final Account f38976a;

    /* renamed from: b  reason: collision with root package name */
    private final Set f38977b;

    /* renamed from: c  reason: collision with root package name */
    private final Set f38978c;

    /* renamed from: d  reason: collision with root package name */
    private final Map f38979d;

    /* renamed from: e  reason: collision with root package name */
    private final int f38980e;

    /* renamed from: f  reason: collision with root package name */
    private final View f38981f;

    /* renamed from: g  reason: collision with root package name */
    private final String f38982g;

    /* renamed from: h  reason: collision with root package name */
    private final String f38983h;

    /* renamed from: i  reason: collision with root package name */
    private final ye.a f38984i;

    /* renamed from: j  reason: collision with root package name */
    private Integer f38985j;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private Account f38986a;

        /* renamed from: b  reason: collision with root package name */
        private b f38987b;

        /* renamed from: c  reason: collision with root package name */
        private String f38988c;

        /* renamed from: d  reason: collision with root package name */
        private String f38989d;

        /* renamed from: e  reason: collision with root package name */
        private ye.a f38990e = ye.a.f42166k;

        @NonNull
        public e a() {
            return new e(this.f38986a, this.f38987b, (Map) null, 0, (View) null, this.f38988c, this.f38989d, this.f38990e, false);
        }

        @NonNull
        public a b(@NonNull String str) {
            this.f38988c = str;
            return this;
        }

        @NonNull
        public final a c(@NonNull Collection collection) {
            if (this.f38987b == null) {
                this.f38987b = new b();
            }
            this.f38987b.addAll(collection);
            return this;
        }

        @NonNull
        public final a d(Account account) {
            this.f38986a = account;
            return this;
        }

        @NonNull
        public final a e(@NonNull String str) {
            this.f38989d = str;
            return this;
        }
    }

    public e(Account account, @NonNull Set set, @NonNull Map map, int i10, View view, @NonNull String str, @NonNull String str2, ye.a aVar, boolean z10) {
        Set set2;
        this.f38976a = account;
        if (set == null) {
            set2 = Collections.emptySet();
        } else {
            set2 = Collections.unmodifiableSet(set);
        }
        this.f38977b = set2;
        map = map == null ? Collections.emptyMap() : map;
        this.f38979d = map;
        this.f38981f = view;
        this.f38980e = i10;
        this.f38982g = str;
        this.f38983h = str2;
        this.f38984i = aVar == null ? ye.a.f42166k : aVar;
        HashSet hashSet = new HashSet(set2);
        for (z zVar : map.values()) {
            hashSet.addAll(zVar.f39071a);
        }
        this.f38978c = Collections.unmodifiableSet(hashSet);
    }

    public Account a() {
        return this.f38976a;
    }

    @Deprecated
    public String b() {
        Account account = this.f38976a;
        if (account != null) {
            return account.name;
        }
        return null;
    }

    @NonNull
    public Account c() {
        Account account = this.f38976a;
        return account != null ? account : new Account(d.DEFAULT_ACCOUNT, "com.google");
    }

    @NonNull
    public Set<Scope> d() {
        return this.f38978c;
    }

    @NonNull
    public Set<Scope> e(@NonNull com.google.android.gms.common.api.a<?> aVar) {
        z zVar = (z) this.f38979d.get(aVar);
        if (zVar == null || zVar.f39071a.isEmpty()) {
            return this.f38977b;
        }
        HashSet hashSet = new HashSet(this.f38977b);
        hashSet.addAll(zVar.f39071a);
        return hashSet;
    }

    @NonNull
    public String f() {
        return this.f38982g;
    }

    @NonNull
    public Set<Scope> g() {
        return this.f38977b;
    }

    @NonNull
    public final ye.a h() {
        return this.f38984i;
    }

    public final Integer i() {
        return this.f38985j;
    }

    public final String j() {
        return this.f38983h;
    }

    @NonNull
    public final Map k() {
        return this.f38979d;
    }

    public final void l(@NonNull Integer num) {
        this.f38985j = num;
    }
}
