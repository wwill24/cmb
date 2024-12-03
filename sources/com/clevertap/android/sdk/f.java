package com.clevertap.android.sdk;

import android.annotation.SuppressLint;
import com.clevertap.android.sdk.task.Task;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J \u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¨\u0006\f"}, d2 = {"Lcom/clevertap/android/sdk/f;", "", "", "key", "Lcom/clevertap/android/sdk/CleverTapAPI;", "cleverTapApi", "", "b", "value", "a", "<init>", "()V", "AndroidSDKCore_release"}, k = 1, mv = {1, 4, 2})
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static final f f10208a = new f();

    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/clevertap/android/sdk/task/Task;", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "a", "()Lcom/clevertap/android/sdk/task/Task;"}, k = 3, mv = {1, 4, 2})
    static final class a<V> implements Callable<Task<Void>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f10209a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CleverTapAPI f10210b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f10211c;

        a(String str, CleverTapAPI cleverTapAPI, String str2) {
            this.f10209a = str;
            this.f10210b = cleverTapAPI;
            this.f10211c = str2;
        }

        /* renamed from: a */
        public final Task<Void> call() {
            f.f10208a.b(this.f10209a, this.f10210b);
            this.f10210b.f(this.f10209a, this.f10211c);
            return null;
        }
    }

    private f() {
    }

    @SuppressLint({"RestrictedApi"})
    public final void a(String str, String str2, CleverTapAPI cleverTapAPI) {
        j.g(str, SDKConstants.PARAM_KEY);
        j.g(str2, "value");
        j.g(cleverTapAPI, "cleverTapApi");
        k s10 = cleverTapAPI.s();
        j.f(s10, "cleverTapApi.coreState");
        com.clevertap.android.sdk.task.a.a(s10.e()).c().f("CTUtils", new a(str, cleverTapAPI, str2));
    }

    @SuppressLint({"RestrictedApi"})
    public final void b(String str, CleverTapAPI cleverTapAPI) {
        j.g(str, SDKConstants.PARAM_KEY);
        j.g(cleverTapAPI, "cleverTapApi");
        k s10 = cleverTapAPI.s();
        j.f(s10, "cleverTapApi.coreState");
        if (s10.i().v(str) == null) {
            k s11 = cleverTapAPI.s();
            j.f(s11, "cleverTapApi.coreState");
            s11.i().L(str, "");
        }
    }
}
