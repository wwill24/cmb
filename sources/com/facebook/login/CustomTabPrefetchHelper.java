package com.facebook.login;

import android.content.ComponentName;
import android.net.Uri;
import android.os.Bundle;
import androidx.browser.customtabs.b;
import androidx.browser.customtabs.c;
import androidx.browser.customtabs.e;
import androidx.browser.customtabs.f;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\r"}, d2 = {"Lcom/facebook/login/CustomTabPrefetchHelper;", "Landroidx/browser/customtabs/e;", "Landroid/content/ComponentName;", "name", "Landroidx/browser/customtabs/c;", "newClient", "", "onCustomTabsServiceConnected", "componentName", "onServiceDisconnected", "<init>", "()V", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
public final class CustomTabPrefetchHelper extends e {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static c client;
    /* access modifiers changed from: private */
    public static final ReentrantLock lock = new ReentrantLock();
    /* access modifiers changed from: private */
    public static f session;

    @Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\n\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0007R\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/facebook/login/CustomTabPrefetchHelper$Companion;", "", "", "prepareSession", "Landroid/net/Uri;", "url", "mayLaunchUrl", "Landroidx/browser/customtabs/f;", "getPreparedSessionOnce", "Landroidx/browser/customtabs/c;", "client", "Landroidx/browser/customtabs/c;", "Ljava/util/concurrent/locks/ReentrantLock;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "session", "Landroidx/browser/customtabs/f;", "<init>", "()V", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final void prepareSession() {
            c access$getClient$cp;
            CustomTabPrefetchHelper.lock.lock();
            if (CustomTabPrefetchHelper.session == null && (access$getClient$cp = CustomTabPrefetchHelper.client) != null) {
                CustomTabPrefetchHelper.session = access$getClient$cp.d((b) null);
            }
            CustomTabPrefetchHelper.lock.unlock();
        }

        public final f getPreparedSessionOnce() {
            CustomTabPrefetchHelper.lock.lock();
            f access$getSession$cp = CustomTabPrefetchHelper.session;
            CustomTabPrefetchHelper.session = null;
            CustomTabPrefetchHelper.lock.unlock();
            return access$getSession$cp;
        }

        public final void mayLaunchUrl(Uri uri) {
            j.g(uri, "url");
            prepareSession();
            CustomTabPrefetchHelper.lock.lock();
            f access$getSession$cp = CustomTabPrefetchHelper.session;
            if (access$getSession$cp != null) {
                access$getSession$cp.f(uri, (Bundle) null, (List<Bundle>) null);
            }
            CustomTabPrefetchHelper.lock.unlock();
        }
    }

    public static final f getPreparedSessionOnce() {
        return Companion.getPreparedSessionOnce();
    }

    public static final void mayLaunchUrl(Uri uri) {
        Companion.mayLaunchUrl(uri);
    }

    public void onCustomTabsServiceConnected(ComponentName componentName, c cVar) {
        j.g(componentName, "name");
        j.g(cVar, "newClient");
        cVar.f(0);
        client = cVar;
        Companion.prepareSession();
    }

    public void onServiceDisconnected(ComponentName componentName) {
        j.g(componentName, "componentName");
    }
}
