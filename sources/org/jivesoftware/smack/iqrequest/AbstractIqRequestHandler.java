package org.jivesoftware.smack.iqrequest;

import org.jivesoftware.smack.iqrequest.IQRequestHandler;
import org.jivesoftware.smack.packet.IQ;

public abstract class AbstractIqRequestHandler implements IQRequestHandler {
    private final String element;
    private final IQRequestHandler.Mode mode;
    private final String namespace;
    private final IQ.Type type;

    /* renamed from: org.jivesoftware.smack.iqrequest.AbstractIqRequestHandler$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$packet$IQ$Type;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                org.jivesoftware.smack.packet.IQ$Type[] r0 = org.jivesoftware.smack.packet.IQ.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$jivesoftware$smack$packet$IQ$Type = r0
                org.jivesoftware.smack.packet.IQ$Type r1 = org.jivesoftware.smack.packet.IQ.Type.set     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$org$jivesoftware$smack$packet$IQ$Type     // Catch:{ NoSuchFieldError -> 0x001d }
                org.jivesoftware.smack.packet.IQ$Type r1 = org.jivesoftware.smack.packet.IQ.Type.get     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smack.iqrequest.AbstractIqRequestHandler.AnonymousClass1.<clinit>():void");
        }
    }

    protected AbstractIqRequestHandler(String str, String str2, IQ.Type type2, IQRequestHandler.Mode mode2) {
        int i10 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$packet$IQ$Type[type2.ordinal()];
        if (i10 == 1 || i10 == 2) {
            this.element = str;
            this.namespace = str2;
            this.type = type2;
            this.mode = mode2;
            return;
        }
        throw new IllegalArgumentException("Only get and set IQ type allowed");
    }

    public String getElement() {
        return this.element;
    }

    public IQRequestHandler.Mode getMode() {
        return this.mode;
    }

    public String getNamespace() {
        return this.namespace;
    }

    public IQ.Type getType() {
        return this.type;
    }

    public abstract IQ handleIQRequest(IQ iq);
}
