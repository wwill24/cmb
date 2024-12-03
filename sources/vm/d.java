package vm;

import org.minidns.AbstractDnsClient;
import org.minidns.MiniDnsException;
import org.minidns.record.s;
import wm.a;

public class d extends c<s> {

    /* renamed from: j  reason: collision with root package name */
    private final b f33953j;

    /* renamed from: k  reason: collision with root package name */
    private final AbstractDnsClient.IpVersionSetting f33954k;

    /* renamed from: l  reason: collision with root package name */
    private final a f33955l;

    d(c<s> cVar, a aVar, b bVar) throws MiniDnsException.NullResultException {
        super(cVar.f33944a, cVar.f33950g, cVar.f33948e);
        this.f33953j = bVar;
        this.f33954k = bVar.a().i();
        this.f33955l = aVar;
    }
}
