package k7;

import com.coffeemeetsbagel.feature.chat.features.ChatMediaType;
import com.coffeemeetsbagel.feature.chat.features.photoupload.api.models.ImageToSend;
import k7.s;

public final /* synthetic */ class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ s.b f15958a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f15959b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ImageToSend f15960c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ChatMediaType f15961d;

    public /* synthetic */ u(s.b bVar, a aVar, ImageToSend imageToSend, ChatMediaType chatMediaType) {
        this.f15958a = bVar;
        this.f15959b = aVar;
        this.f15960c = imageToSend;
        this.f15961d = chatMediaType;
    }

    public final void run() {
        this.f15958a.f(this.f15959b, this.f15960c, this.f15961d);
    }
}
