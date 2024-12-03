package vc;

import com.facebook.appevents.suggestedevents.ViewOnClickListener;
import org.json.b;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f42072a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f42073b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ViewOnClickListener f42074c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f42075d;

    public /* synthetic */ c(b bVar, String str, ViewOnClickListener viewOnClickListener, String str2) {
        this.f42072a = bVar;
        this.f42073b = str;
        this.f42074c = viewOnClickListener;
        this.f42075d = str2;
    }

    public final void run() {
        ViewOnClickListener.m85predictAndProcess$lambda0(this.f42072a, this.f42073b, this.f42074c, this.f42075d);
    }
}
