package l8;

import com.coffeemeetsbagel.feature.chat.features.ChatMediaType;
import com.coffeemeetsbagel.models.Bagel;
import l8.h;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import vj.f;

public final /* synthetic */ class y implements f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ h1 f16229a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Bagel f16230b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f16231c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ChatMediaType f16232d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f16233e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ String f16234f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ h.d f16235g;

    public /* synthetic */ y(h1 h1Var, Bagel bagel, String str, ChatMediaType chatMediaType, String str2, String str3, h.d dVar) {
        this.f16229a = h1Var;
        this.f16230b = bagel;
        this.f16231c = str;
        this.f16232d = chatMediaType;
        this.f16233e = str2;
        this.f16234f = str3;
        this.f16235g = dVar;
    }

    public final void accept(Object obj) {
        this.f16229a.g1(this.f16230b, this.f16231c, this.f16232d, this.f16233e, this.f16234f, this.f16235g, (XMPPTCPConnection) obj);
    }
}
