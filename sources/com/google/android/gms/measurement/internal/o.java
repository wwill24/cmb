package com.google.android.gms.measurement.internal;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.os.Handler;
import androidx.core.content.a;
import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import org.apache.commons.cli.HelpFormatter;

public final class o extends o5 {

    /* renamed from: c  reason: collision with root package name */
    private long f40091c;

    /* renamed from: d  reason: collision with root package name */
    private String f40092d;

    /* renamed from: e  reason: collision with root package name */
    private AccountManager f40093e;

    /* renamed from: f  reason: collision with root package name */
    private Boolean f40094f;

    /* renamed from: g  reason: collision with root package name */
    private long f40095g;

    o(u4 u4Var) {
        super(u4Var);
    }

    /* access modifiers changed from: protected */
    public final boolean j() {
        Calendar instance = Calendar.getInstance();
        this.f40091c = TimeUnit.MINUTES.convert((long) (instance.get(15) + instance.get(16)), TimeUnit.MILLISECONDS);
        Locale locale = Locale.getDefault();
        String language = locale.getLanguage();
        Locale locale2 = Locale.ENGLISH;
        String lowerCase = language.toLowerCase(locale2);
        String lowerCase2 = locale.getCountry().toLowerCase(locale2);
        this.f40092d = lowerCase + HelpFormatter.DEFAULT_OPT_PREFIX + lowerCase2;
        return false;
    }

    /* access modifiers changed from: package-private */
    public final long o() {
        h();
        return this.f40095g;
    }

    public final long p() {
        k();
        return this.f40091c;
    }

    public final String q() {
        k();
        return this.f40092d;
    }

    /* access modifiers changed from: package-private */
    public final void r() {
        h();
        this.f40094f = null;
        this.f40095g = 0;
    }

    /* access modifiers changed from: package-private */
    public final boolean s() {
        h();
        long currentTimeMillis = this.f40059a.a().currentTimeMillis();
        if (currentTimeMillis - this.f40095g > 86400000) {
            this.f40094f = null;
        }
        Boolean bool = this.f40094f;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (a.checkSelfPermission(this.f40059a.c(), "android.permission.GET_ACCOUNTS") != 0) {
            this.f40059a.d().y().a("Permission error checking for dasher/unicorn accounts");
            this.f40095g = currentTimeMillis;
            this.f40094f = Boolean.FALSE;
            return false;
        }
        if (this.f40093e == null) {
            this.f40093e = AccountManager.get(this.f40059a.c());
        }
        try {
            Account[] result = this.f40093e.getAccountsByTypeAndFeatures("com.google", new String[]{"service_HOSTED"}, (AccountManagerCallback) null, (Handler) null).getResult();
            if (result == null || result.length <= 0) {
                Account[] result2 = this.f40093e.getAccountsByTypeAndFeatures("com.google", new String[]{"service_uca"}, (AccountManagerCallback) null, (Handler) null).getResult();
                if (result2 != null && result2.length > 0) {
                    this.f40094f = Boolean.TRUE;
                    this.f40095g = currentTimeMillis;
                    return true;
                }
                this.f40095g = currentTimeMillis;
                this.f40094f = Boolean.FALSE;
                return false;
            }
            this.f40094f = Boolean.TRUE;
            this.f40095g = currentTimeMillis;
            return true;
        } catch (AuthenticatorException | OperationCanceledException | IOException e10) {
            this.f40059a.d().t().b("Exception checking account types", e10);
        }
    }
}
