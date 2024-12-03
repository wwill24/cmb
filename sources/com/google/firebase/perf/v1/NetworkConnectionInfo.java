package com.google.firebase.perf.v1;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.h;
import com.google.protobuf.n;
import com.google.protobuf.t0;
import com.google.protobuf.w;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class NetworkConnectionInfo extends GeneratedMessageLite<NetworkConnectionInfo, Builder> implements NetworkConnectionInfoOrBuilder {
    /* access modifiers changed from: private */
    public static final NetworkConnectionInfo DEFAULT_INSTANCE;
    public static final int MOBILE_SUBTYPE_FIELD_NUMBER = 2;
    public static final int NETWORK_TYPE_FIELD_NUMBER = 1;
    private static volatile t0<NetworkConnectionInfo> PARSER;
    private int bitField0_;
    private int mobileSubtype_;
    private int networkType_ = -1;

    /* renamed from: com.google.firebase.perf.v1.NetworkConnectionInfo$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke[] r0 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = r0
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_BUILDER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_PARSER     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.perf.v1.NetworkConnectionInfo.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class Builder extends GeneratedMessageLite.a<NetworkConnectionInfo, Builder> implements NetworkConnectionInfoOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 r12) {
            this();
        }

        public Builder clearMobileSubtype() {
            copyOnWrite();
            ((NetworkConnectionInfo) this.instance).clearMobileSubtype();
            return this;
        }

        public Builder clearNetworkType() {
            copyOnWrite();
            ((NetworkConnectionInfo) this.instance).clearNetworkType();
            return this;
        }

        public MobileSubtype getMobileSubtype() {
            return ((NetworkConnectionInfo) this.instance).getMobileSubtype();
        }

        public NetworkType getNetworkType() {
            return ((NetworkConnectionInfo) this.instance).getNetworkType();
        }

        public boolean hasMobileSubtype() {
            return ((NetworkConnectionInfo) this.instance).hasMobileSubtype();
        }

        public boolean hasNetworkType() {
            return ((NetworkConnectionInfo) this.instance).hasNetworkType();
        }

        public Builder setMobileSubtype(MobileSubtype mobileSubtype) {
            copyOnWrite();
            ((NetworkConnectionInfo) this.instance).setMobileSubtype(mobileSubtype);
            return this;
        }

        public Builder setNetworkType(NetworkType networkType) {
            copyOnWrite();
            ((NetworkConnectionInfo) this.instance).setNetworkType(networkType);
            return this;
        }

        private Builder() {
            super(NetworkConnectionInfo.DEFAULT_INSTANCE);
        }
    }

    public enum MobileSubtype implements w.c {
        UNKNOWN_MOBILE_SUBTYPE(0),
        GPRS(1),
        EDGE(2),
        UMTS(3),
        CDMA(4),
        EVDO_0(5),
        EVDO_A(6),
        RTT(7),
        HSDPA(8),
        HSUPA(9),
        HSPA(10),
        IDEN(11),
        EVDO_B(12),
        LTE(13),
        EHRPD(14),
        HSPAP(15),
        GSM(16),
        TD_SCDMA(17),
        IWLAN(18),
        LTE_CA(19),
        COMBINED(100);
        
        public static final int CDMA_VALUE = 4;
        public static final int COMBINED_VALUE = 100;
        public static final int EDGE_VALUE = 2;
        public static final int EHRPD_VALUE = 14;
        public static final int EVDO_0_VALUE = 5;
        public static final int EVDO_A_VALUE = 6;
        public static final int EVDO_B_VALUE = 12;
        public static final int GPRS_VALUE = 1;
        public static final int GSM_VALUE = 16;
        public static final int HSDPA_VALUE = 8;
        public static final int HSPAP_VALUE = 15;
        public static final int HSPA_VALUE = 10;
        public static final int HSUPA_VALUE = 9;
        public static final int IDEN_VALUE = 11;
        public static final int IWLAN_VALUE = 18;
        public static final int LTE_CA_VALUE = 19;
        public static final int LTE_VALUE = 13;
        public static final int RTT_VALUE = 7;
        public static final int TD_SCDMA_VALUE = 17;
        public static final int UMTS_VALUE = 3;
        public static final int UNKNOWN_MOBILE_SUBTYPE_VALUE = 0;
        private static final w.d<MobileSubtype> internalValueMap = null;
        private final int value;

        private static final class MobileSubtypeVerifier implements w.e {
            static final w.e INSTANCE = null;

            static {
                INSTANCE = new MobileSubtypeVerifier();
            }

            private MobileSubtypeVerifier() {
            }

            public boolean isInRange(int i10) {
                return MobileSubtype.forNumber(i10) != null;
            }
        }

        static {
            internalValueMap = new w.d<MobileSubtype>() {
                public MobileSubtype findValueByNumber(int i10) {
                    return MobileSubtype.forNumber(i10);
                }
            };
        }

        private MobileSubtype(int i10) {
            this.value = i10;
        }

        public static MobileSubtype forNumber(int i10) {
            if (i10 == 100) {
                return COMBINED;
            }
            switch (i10) {
                case 0:
                    return UNKNOWN_MOBILE_SUBTYPE;
                case 1:
                    return GPRS;
                case 2:
                    return EDGE;
                case 3:
                    return UMTS;
                case 4:
                    return CDMA;
                case 5:
                    return EVDO_0;
                case 6:
                    return EVDO_A;
                case 7:
                    return RTT;
                case 8:
                    return HSDPA;
                case 9:
                    return HSUPA;
                case 10:
                    return HSPA;
                case 11:
                    return IDEN;
                case 12:
                    return EVDO_B;
                case 13:
                    return LTE;
                case 14:
                    return EHRPD;
                case 15:
                    return HSPAP;
                case 16:
                    return GSM;
                case 17:
                    return TD_SCDMA;
                case 18:
                    return IWLAN;
                case 19:
                    return LTE_CA;
                default:
                    return null;
            }
        }

        public static w.d<MobileSubtype> internalGetValueMap() {
            return internalValueMap;
        }

        public static w.e internalGetVerifier() {
            return MobileSubtypeVerifier.INSTANCE;
        }

        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static MobileSubtype valueOf(int i10) {
            return forNumber(i10);
        }
    }

    public enum NetworkType implements w.c {
        NONE(-1),
        MOBILE(0),
        WIFI(1),
        MOBILE_MMS(2),
        MOBILE_SUPL(3),
        MOBILE_DUN(4),
        MOBILE_HIPRI(5),
        WIMAX(6),
        BLUETOOTH(7),
        DUMMY(8),
        ETHERNET(9),
        MOBILE_FOTA(10),
        MOBILE_IMS(11),
        MOBILE_CBS(12),
        WIFI_P2P(13),
        MOBILE_IA(14),
        MOBILE_EMERGENCY(15),
        PROXY(16),
        VPN(17);
        
        public static final int BLUETOOTH_VALUE = 7;
        public static final int DUMMY_VALUE = 8;
        public static final int ETHERNET_VALUE = 9;
        public static final int MOBILE_CBS_VALUE = 12;
        public static final int MOBILE_DUN_VALUE = 4;
        public static final int MOBILE_EMERGENCY_VALUE = 15;
        public static final int MOBILE_FOTA_VALUE = 10;
        public static final int MOBILE_HIPRI_VALUE = 5;
        public static final int MOBILE_IA_VALUE = 14;
        public static final int MOBILE_IMS_VALUE = 11;
        public static final int MOBILE_MMS_VALUE = 2;
        public static final int MOBILE_SUPL_VALUE = 3;
        public static final int MOBILE_VALUE = 0;
        public static final int NONE_VALUE = -1;
        public static final int PROXY_VALUE = 16;
        public static final int VPN_VALUE = 17;
        public static final int WIFI_P2P_VALUE = 13;
        public static final int WIFI_VALUE = 1;
        public static final int WIMAX_VALUE = 6;
        private static final w.d<NetworkType> internalValueMap = null;
        private final int value;

        private static final class NetworkTypeVerifier implements w.e {
            static final w.e INSTANCE = null;

            static {
                INSTANCE = new NetworkTypeVerifier();
            }

            private NetworkTypeVerifier() {
            }

            public boolean isInRange(int i10) {
                return NetworkType.forNumber(i10) != null;
            }
        }

        static {
            internalValueMap = new w.d<NetworkType>() {
                public NetworkType findValueByNumber(int i10) {
                    return NetworkType.forNumber(i10);
                }
            };
        }

        private NetworkType(int i10) {
            this.value = i10;
        }

        public static NetworkType forNumber(int i10) {
            switch (i10) {
                case -1:
                    return NONE;
                case 0:
                    return MOBILE;
                case 1:
                    return WIFI;
                case 2:
                    return MOBILE_MMS;
                case 3:
                    return MOBILE_SUPL;
                case 4:
                    return MOBILE_DUN;
                case 5:
                    return MOBILE_HIPRI;
                case 6:
                    return WIMAX;
                case 7:
                    return BLUETOOTH;
                case 8:
                    return DUMMY;
                case 9:
                    return ETHERNET;
                case 10:
                    return MOBILE_FOTA;
                case 11:
                    return MOBILE_IMS;
                case 12:
                    return MOBILE_CBS;
                case 13:
                    return WIFI_P2P;
                case 14:
                    return MOBILE_IA;
                case 15:
                    return MOBILE_EMERGENCY;
                case 16:
                    return PROXY;
                case 17:
                    return VPN;
                default:
                    return null;
            }
        }

        public static w.d<NetworkType> internalGetValueMap() {
            return internalValueMap;
        }

        public static w.e internalGetVerifier() {
            return NetworkTypeVerifier.INSTANCE;
        }

        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static NetworkType valueOf(int i10) {
            return forNumber(i10);
        }
    }

    static {
        NetworkConnectionInfo networkConnectionInfo = new NetworkConnectionInfo();
        DEFAULT_INSTANCE = networkConnectionInfo;
        GeneratedMessageLite.registerDefaultInstance(NetworkConnectionInfo.class, networkConnectionInfo);
    }

    private NetworkConnectionInfo() {
    }

    /* access modifiers changed from: private */
    public void clearMobileSubtype() {
        this.bitField0_ &= -3;
        this.mobileSubtype_ = 0;
    }

    /* access modifiers changed from: private */
    public void clearNetworkType() {
        this.bitField0_ &= -2;
        this.networkType_ = -1;
    }

    public static NetworkConnectionInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.createBuilder();
    }

    public static NetworkConnectionInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (NetworkConnectionInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static NetworkConnectionInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (NetworkConnectionInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static t0<NetworkConnectionInfo> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* access modifiers changed from: private */
    public void setMobileSubtype(MobileSubtype mobileSubtype) {
        this.mobileSubtype_ = mobileSubtype.getNumber();
        this.bitField0_ |= 2;
    }

    /* access modifiers changed from: private */
    public void setNetworkType(NetworkType networkType) {
        this.networkType_ = networkType.getNumber();
        this.bitField0_ |= 1;
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new NetworkConnectionInfo();
            case 2:
                return new Builder((AnonymousClass1) null);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဌ\u0001", new Object[]{"bitField0_", "networkType_", NetworkType.internalGetVerifier(), "mobileSubtype_", MobileSubtype.internalGetVerifier()});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                t0<NetworkConnectionInfo> t0Var = PARSER;
                if (t0Var == null) {
                    synchronized (NetworkConnectionInfo.class) {
                        t0Var = PARSER;
                        if (t0Var == null) {
                            t0Var = new GeneratedMessageLite.b<>(DEFAULT_INSTANCE);
                            PARSER = t0Var;
                        }
                    }
                }
                return t0Var;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public MobileSubtype getMobileSubtype() {
        MobileSubtype forNumber = MobileSubtype.forNumber(this.mobileSubtype_);
        if (forNumber == null) {
            return MobileSubtype.UNKNOWN_MOBILE_SUBTYPE;
        }
        return forNumber;
    }

    public NetworkType getNetworkType() {
        NetworkType forNumber = NetworkType.forNumber(this.networkType_);
        if (forNumber == null) {
            return NetworkType.NONE;
        }
        return forNumber;
    }

    public boolean hasMobileSubtype() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasNetworkType() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(NetworkConnectionInfo networkConnectionInfo) {
        return (Builder) DEFAULT_INSTANCE.createBuilder(networkConnectionInfo);
    }

    public static NetworkConnectionInfo parseDelimitedFrom(InputStream inputStream, n nVar) throws IOException {
        return (NetworkConnectionInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, nVar);
    }

    public static NetworkConnectionInfo parseFrom(ByteBuffer byteBuffer, n nVar) throws InvalidProtocolBufferException {
        return (NetworkConnectionInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, nVar);
    }

    public static NetworkConnectionInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (NetworkConnectionInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static NetworkConnectionInfo parseFrom(ByteString byteString, n nVar) throws InvalidProtocolBufferException {
        return (NetworkConnectionInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, nVar);
    }

    public static NetworkConnectionInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (NetworkConnectionInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static NetworkConnectionInfo parseFrom(byte[] bArr, n nVar) throws InvalidProtocolBufferException {
        return (NetworkConnectionInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, nVar);
    }

    public static NetworkConnectionInfo parseFrom(InputStream inputStream) throws IOException {
        return (NetworkConnectionInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static NetworkConnectionInfo parseFrom(InputStream inputStream, n nVar) throws IOException {
        return (NetworkConnectionInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, nVar);
    }

    public static NetworkConnectionInfo parseFrom(h hVar) throws IOException {
        return (NetworkConnectionInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, hVar);
    }

    public static NetworkConnectionInfo parseFrom(h hVar, n nVar) throws IOException {
        return (NetworkConnectionInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, hVar, nVar);
    }
}
