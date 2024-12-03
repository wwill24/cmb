package com.appsflyer.internal;

import com.appsflyer.AppsFlyerLib;
import gk.h;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.jivesoftware.smackx.bytestreams.ibb.packet.Close;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\u0018\u0000 \u00012\u00020\r:\u0001\u0001BE\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Lcom/appsflyer/internal/AFc1qSDK;", "AFa1vSDK", "", "p0", "", "p1", "", "p2", "p3", "", "p4", "<init>", "(Ljava/lang/String;Ljava/util/Map;[BLjava/lang/String;Z)V", "Lcom/appsflyer/internal/AFc1gSDK;"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AFc1qSDK extends AFc1sSDK {
    public static final AFa1vSDK AFa1vSDK = new AFa1vSDK((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0000\b\u0003\u0018\u00002\u00020\rB\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ=\u0010\u0007\u001a\u0006*\u00020\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\t\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lcom/appsflyer/internal/AFc1qSDK$AFa1vSDK;", "", "p0", "p1", "p2", "p3", "p4", "AFInAppEventParameterName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "valueOf", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "<init>", "()V", ""}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class AFa1vSDK {
        private AFa1vSDK() {
        }

        public /* synthetic */ AFa1vSDK(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static String AFInAppEventParameterName(String str, String str2, String str3, String str4, String str5) {
            j.g(str, "");
            j.g(str2, "");
            j.g(str4, "");
            j.g(str5, "");
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(str2);
            return AFa1aSDK.values(AFa1aSDK.values(str5, str3, sb2.toString()), str4);
        }

        static String valueOf(String str, String str2, String str3) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(String.format(AFc1pSDK.valueOf, new Object[]{AppsFlyerLib.getInstance().getHostPrefix(), AFb1zSDK.AFInAppEventType().getHostName()}));
            sb2.append(str);
            sb2.append(str3);
            sb2.append("?device_id=");
            sb2.append(str2);
            return sb2.toString();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    /* synthetic */ AFc1qSDK(String str, Map map, byte[] bArr, String str2, boolean z10, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, map, (i10 & 4) != 0 ? null : bArr, (i10 & 8) != 0 ? "GET" : str2, (i10 & 16) != 0 ? false : z10);
    }

    public static final AFc1qSDK AFKeystoreWrapper(String str, String str2, String str3, String str4) {
        j.g(str, "");
        j.g(str3, "");
        j.g(str4, "");
        String valueOf = AFa1vSDK.valueOf(str, str2, str3);
        String valueOf2 = String.valueOf(System.currentTimeMillis());
        AFc1qSDK aFc1qSDK = new AFc1qSDK(valueOf, h0.l(h.a("Connection", Close.ELEMENT), h.a("af_request_epoch_ms", valueOf2), h.a("af_sig", AFa1vSDK.AFInAppEventParameterName(str, str3, str2, str4, valueOf2))), (byte[]) null, (String) null, false, 28, (DefaultConstructorMarker) null);
        aFc1qSDK.AFInAppEventParameterName(10000);
        return aFc1qSDK;
    }

    private AFc1qSDK(String str, Map<String, String> map, byte[] bArr, String str2, boolean z10) {
        super(str, bArr, str2, map, z10);
    }
}
