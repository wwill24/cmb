package vc;

import com.facebook.appevents.suggestedevents.ViewOnClickListener;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f42076a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f42077b;

    public /* synthetic */ d(String str, String str2) {
        this.f42076a = str;
        this.f42077b = str2;
    }

    public final void run() {
        ViewOnClickListener.Companion.m86queryHistoryAndProcess$lambda0(this.f42076a, this.f42077b);
    }
}
