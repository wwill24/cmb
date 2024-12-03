package k7;

import com.coffeemeetsbagel.feature.chat.features.ChatMediaType;
import com.coffeemeetsbagel.feature.chat.features.photoupload.api.models.ImageToSend;
import k7.s;

public final /* synthetic */ class t implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ s.b f15953a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f15954b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ImageToSend f15955c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ChatMediaType f15956d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Throwable f15957e;

    public /* synthetic */ t(s.b bVar, a aVar, ImageToSend imageToSend, ChatMediaType chatMediaType, Throwable th2) {
        this.f15953a = bVar;
        this.f15954b = aVar;
        this.f15955c = imageToSend;
        this.f15956d = chatMediaType;
        this.f15957e = th2;
    }

    public final void run() {
        this.f15953a.e(this.f15954b, this.f15955c, this.f15956d, this.f15957e);
    }
}
