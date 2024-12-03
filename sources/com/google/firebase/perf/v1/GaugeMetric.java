package com.google.firebase.perf.v1;

import com.google.firebase.perf.v1.AndroidMemoryReading;
import com.google.firebase.perf.v1.CpuMetricReading;
import com.google.firebase.perf.v1.GaugeMetadata;
import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.a;
import com.google.protobuf.h;
import com.google.protobuf.n;
import com.google.protobuf.t0;
import com.google.protobuf.w;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

public final class GaugeMetric extends GeneratedMessageLite<GaugeMetric, Builder> implements GaugeMetricOrBuilder {
    public static final int ANDROID_MEMORY_READINGS_FIELD_NUMBER = 4;
    public static final int CPU_METRIC_READINGS_FIELD_NUMBER = 2;
    /* access modifiers changed from: private */
    public static final GaugeMetric DEFAULT_INSTANCE;
    public static final int GAUGE_METADATA_FIELD_NUMBER = 3;
    private static volatile t0<GaugeMetric> PARSER = null;
    public static final int SESSION_ID_FIELD_NUMBER = 1;
    private w.j<AndroidMemoryReading> androidMemoryReadings_ = GeneratedMessageLite.emptyProtobufList();
    private int bitField0_;
    private w.j<CpuMetricReading> cpuMetricReadings_ = GeneratedMessageLite.emptyProtobufList();
    private GaugeMetadata gaugeMetadata_;
    private String sessionId_ = "";

    /* renamed from: com.google.firebase.perf.v1.GaugeMetric$1  reason: invalid class name */
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.perf.v1.GaugeMetric.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class Builder extends GeneratedMessageLite.a<GaugeMetric, Builder> implements GaugeMetricOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 r12) {
            this();
        }

        public Builder addAllAndroidMemoryReadings(Iterable<? extends AndroidMemoryReading> iterable) {
            copyOnWrite();
            ((GaugeMetric) this.instance).addAllAndroidMemoryReadings(iterable);
            return this;
        }

        public Builder addAllCpuMetricReadings(Iterable<? extends CpuMetricReading> iterable) {
            copyOnWrite();
            ((GaugeMetric) this.instance).addAllCpuMetricReadings(iterable);
            return this;
        }

        public Builder addAndroidMemoryReadings(AndroidMemoryReading androidMemoryReading) {
            copyOnWrite();
            ((GaugeMetric) this.instance).addAndroidMemoryReadings(androidMemoryReading);
            return this;
        }

        public Builder addCpuMetricReadings(CpuMetricReading cpuMetricReading) {
            copyOnWrite();
            ((GaugeMetric) this.instance).addCpuMetricReadings(cpuMetricReading);
            return this;
        }

        public Builder clearAndroidMemoryReadings() {
            copyOnWrite();
            ((GaugeMetric) this.instance).clearAndroidMemoryReadings();
            return this;
        }

        public Builder clearCpuMetricReadings() {
            copyOnWrite();
            ((GaugeMetric) this.instance).clearCpuMetricReadings();
            return this;
        }

        public Builder clearGaugeMetadata() {
            copyOnWrite();
            ((GaugeMetric) this.instance).clearGaugeMetadata();
            return this;
        }

        public Builder clearSessionId() {
            copyOnWrite();
            ((GaugeMetric) this.instance).clearSessionId();
            return this;
        }

        public AndroidMemoryReading getAndroidMemoryReadings(int i10) {
            return ((GaugeMetric) this.instance).getAndroidMemoryReadings(i10);
        }

        public int getAndroidMemoryReadingsCount() {
            return ((GaugeMetric) this.instance).getAndroidMemoryReadingsCount();
        }

        public List<AndroidMemoryReading> getAndroidMemoryReadingsList() {
            return Collections.unmodifiableList(((GaugeMetric) this.instance).getAndroidMemoryReadingsList());
        }

        public CpuMetricReading getCpuMetricReadings(int i10) {
            return ((GaugeMetric) this.instance).getCpuMetricReadings(i10);
        }

        public int getCpuMetricReadingsCount() {
            return ((GaugeMetric) this.instance).getCpuMetricReadingsCount();
        }

        public List<CpuMetricReading> getCpuMetricReadingsList() {
            return Collections.unmodifiableList(((GaugeMetric) this.instance).getCpuMetricReadingsList());
        }

        public GaugeMetadata getGaugeMetadata() {
            return ((GaugeMetric) this.instance).getGaugeMetadata();
        }

        public String getSessionId() {
            return ((GaugeMetric) this.instance).getSessionId();
        }

        public ByteString getSessionIdBytes() {
            return ((GaugeMetric) this.instance).getSessionIdBytes();
        }

        public boolean hasGaugeMetadata() {
            return ((GaugeMetric) this.instance).hasGaugeMetadata();
        }

        public boolean hasSessionId() {
            return ((GaugeMetric) this.instance).hasSessionId();
        }

        public Builder mergeGaugeMetadata(GaugeMetadata gaugeMetadata) {
            copyOnWrite();
            ((GaugeMetric) this.instance).mergeGaugeMetadata(gaugeMetadata);
            return this;
        }

        public Builder removeAndroidMemoryReadings(int i10) {
            copyOnWrite();
            ((GaugeMetric) this.instance).removeAndroidMemoryReadings(i10);
            return this;
        }

        public Builder removeCpuMetricReadings(int i10) {
            copyOnWrite();
            ((GaugeMetric) this.instance).removeCpuMetricReadings(i10);
            return this;
        }

        public Builder setAndroidMemoryReadings(int i10, AndroidMemoryReading androidMemoryReading) {
            copyOnWrite();
            ((GaugeMetric) this.instance).setAndroidMemoryReadings(i10, androidMemoryReading);
            return this;
        }

        public Builder setCpuMetricReadings(int i10, CpuMetricReading cpuMetricReading) {
            copyOnWrite();
            ((GaugeMetric) this.instance).setCpuMetricReadings(i10, cpuMetricReading);
            return this;
        }

        public Builder setGaugeMetadata(GaugeMetadata gaugeMetadata) {
            copyOnWrite();
            ((GaugeMetric) this.instance).setGaugeMetadata(gaugeMetadata);
            return this;
        }

        public Builder setSessionId(String str) {
            copyOnWrite();
            ((GaugeMetric) this.instance).setSessionId(str);
            return this;
        }

        public Builder setSessionIdBytes(ByteString byteString) {
            copyOnWrite();
            ((GaugeMetric) this.instance).setSessionIdBytes(byteString);
            return this;
        }

        private Builder() {
            super(GaugeMetric.DEFAULT_INSTANCE);
        }

        public Builder addAndroidMemoryReadings(int i10, AndroidMemoryReading androidMemoryReading) {
            copyOnWrite();
            ((GaugeMetric) this.instance).addAndroidMemoryReadings(i10, androidMemoryReading);
            return this;
        }

        public Builder addCpuMetricReadings(int i10, CpuMetricReading cpuMetricReading) {
            copyOnWrite();
            ((GaugeMetric) this.instance).addCpuMetricReadings(i10, cpuMetricReading);
            return this;
        }

        public Builder setAndroidMemoryReadings(int i10, AndroidMemoryReading.Builder builder) {
            copyOnWrite();
            ((GaugeMetric) this.instance).setAndroidMemoryReadings(i10, (AndroidMemoryReading) builder.build());
            return this;
        }

        public Builder setCpuMetricReadings(int i10, CpuMetricReading.Builder builder) {
            copyOnWrite();
            ((GaugeMetric) this.instance).setCpuMetricReadings(i10, (CpuMetricReading) builder.build());
            return this;
        }

        public Builder setGaugeMetadata(GaugeMetadata.Builder builder) {
            copyOnWrite();
            ((GaugeMetric) this.instance).setGaugeMetadata((GaugeMetadata) builder.build());
            return this;
        }

        public Builder addAndroidMemoryReadings(AndroidMemoryReading.Builder builder) {
            copyOnWrite();
            ((GaugeMetric) this.instance).addAndroidMemoryReadings((AndroidMemoryReading) builder.build());
            return this;
        }

        public Builder addCpuMetricReadings(CpuMetricReading.Builder builder) {
            copyOnWrite();
            ((GaugeMetric) this.instance).addCpuMetricReadings((CpuMetricReading) builder.build());
            return this;
        }

        public Builder addAndroidMemoryReadings(int i10, AndroidMemoryReading.Builder builder) {
            copyOnWrite();
            ((GaugeMetric) this.instance).addAndroidMemoryReadings(i10, (AndroidMemoryReading) builder.build());
            return this;
        }

        public Builder addCpuMetricReadings(int i10, CpuMetricReading.Builder builder) {
            copyOnWrite();
            ((GaugeMetric) this.instance).addCpuMetricReadings(i10, (CpuMetricReading) builder.build());
            return this;
        }
    }

    static {
        GaugeMetric gaugeMetric = new GaugeMetric();
        DEFAULT_INSTANCE = gaugeMetric;
        GeneratedMessageLite.registerDefaultInstance(GaugeMetric.class, gaugeMetric);
    }

    private GaugeMetric() {
    }

    /* access modifiers changed from: private */
    public void addAllAndroidMemoryReadings(Iterable<? extends AndroidMemoryReading> iterable) {
        ensureAndroidMemoryReadingsIsMutable();
        a.addAll(iterable, this.androidMemoryReadings_);
    }

    /* access modifiers changed from: private */
    public void addAllCpuMetricReadings(Iterable<? extends CpuMetricReading> iterable) {
        ensureCpuMetricReadingsIsMutable();
        a.addAll(iterable, this.cpuMetricReadings_);
    }

    /* access modifiers changed from: private */
    public void addAndroidMemoryReadings(AndroidMemoryReading androidMemoryReading) {
        androidMemoryReading.getClass();
        ensureAndroidMemoryReadingsIsMutable();
        this.androidMemoryReadings_.add(androidMemoryReading);
    }

    /* access modifiers changed from: private */
    public void addCpuMetricReadings(CpuMetricReading cpuMetricReading) {
        cpuMetricReading.getClass();
        ensureCpuMetricReadingsIsMutable();
        this.cpuMetricReadings_.add(cpuMetricReading);
    }

    /* access modifiers changed from: private */
    public void clearAndroidMemoryReadings() {
        this.androidMemoryReadings_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void clearCpuMetricReadings() {
        this.cpuMetricReadings_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void clearGaugeMetadata() {
        this.gaugeMetadata_ = null;
        this.bitField0_ &= -3;
    }

    /* access modifiers changed from: private */
    public void clearSessionId() {
        this.bitField0_ &= -2;
        this.sessionId_ = getDefaultInstance().getSessionId();
    }

    private void ensureAndroidMemoryReadingsIsMutable() {
        w.j<AndroidMemoryReading> jVar = this.androidMemoryReadings_;
        if (!jVar.h()) {
            this.androidMemoryReadings_ = GeneratedMessageLite.mutableCopy(jVar);
        }
    }

    private void ensureCpuMetricReadingsIsMutable() {
        w.j<CpuMetricReading> jVar = this.cpuMetricReadings_;
        if (!jVar.h()) {
            this.cpuMetricReadings_ = GeneratedMessageLite.mutableCopy(jVar);
        }
    }

    public static GaugeMetric getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* access modifiers changed from: private */
    public void mergeGaugeMetadata(GaugeMetadata gaugeMetadata) {
        gaugeMetadata.getClass();
        GaugeMetadata gaugeMetadata2 = this.gaugeMetadata_;
        if (gaugeMetadata2 == null || gaugeMetadata2 == GaugeMetadata.getDefaultInstance()) {
            this.gaugeMetadata_ = gaugeMetadata;
        } else {
            this.gaugeMetadata_ = (GaugeMetadata) ((GaugeMetadata.Builder) GaugeMetadata.newBuilder(this.gaugeMetadata_).mergeFrom(gaugeMetadata)).buildPartial();
        }
        this.bitField0_ |= 2;
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.createBuilder();
    }

    public static GaugeMetric parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (GaugeMetric) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GaugeMetric parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (GaugeMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static t0<GaugeMetric> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* access modifiers changed from: private */
    public void removeAndroidMemoryReadings(int i10) {
        ensureAndroidMemoryReadingsIsMutable();
        this.androidMemoryReadings_.remove(i10);
    }

    /* access modifiers changed from: private */
    public void removeCpuMetricReadings(int i10) {
        ensureCpuMetricReadingsIsMutable();
        this.cpuMetricReadings_.remove(i10);
    }

    /* access modifiers changed from: private */
    public void setAndroidMemoryReadings(int i10, AndroidMemoryReading androidMemoryReading) {
        androidMemoryReading.getClass();
        ensureAndroidMemoryReadingsIsMutable();
        this.androidMemoryReadings_.set(i10, androidMemoryReading);
    }

    /* access modifiers changed from: private */
    public void setCpuMetricReadings(int i10, CpuMetricReading cpuMetricReading) {
        cpuMetricReading.getClass();
        ensureCpuMetricReadingsIsMutable();
        this.cpuMetricReadings_.set(i10, cpuMetricReading);
    }

    /* access modifiers changed from: private */
    public void setGaugeMetadata(GaugeMetadata gaugeMetadata) {
        gaugeMetadata.getClass();
        this.gaugeMetadata_ = gaugeMetadata;
        this.bitField0_ |= 2;
    }

    /* access modifiers changed from: private */
    public void setSessionId(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.sessionId_ = str;
    }

    /* access modifiers changed from: private */
    public void setSessionIdBytes(ByteString byteString) {
        this.sessionId_ = byteString.T();
        this.bitField0_ |= 1;
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new GaugeMetric();
            case 2:
                return new Builder((AnonymousClass1) null);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0002\u0000\u0001ဈ\u0000\u0002\u001b\u0003ဉ\u0001\u0004\u001b", new Object[]{"bitField0_", "sessionId_", "cpuMetricReadings_", CpuMetricReading.class, "gaugeMetadata_", "androidMemoryReadings_", AndroidMemoryReading.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                t0<GaugeMetric> t0Var = PARSER;
                if (t0Var == null) {
                    synchronized (GaugeMetric.class) {
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

    public AndroidMemoryReading getAndroidMemoryReadings(int i10) {
        return this.androidMemoryReadings_.get(i10);
    }

    public int getAndroidMemoryReadingsCount() {
        return this.androidMemoryReadings_.size();
    }

    public List<AndroidMemoryReading> getAndroidMemoryReadingsList() {
        return this.androidMemoryReadings_;
    }

    public AndroidMemoryReadingOrBuilder getAndroidMemoryReadingsOrBuilder(int i10) {
        return this.androidMemoryReadings_.get(i10);
    }

    public List<? extends AndroidMemoryReadingOrBuilder> getAndroidMemoryReadingsOrBuilderList() {
        return this.androidMemoryReadings_;
    }

    public CpuMetricReading getCpuMetricReadings(int i10) {
        return this.cpuMetricReadings_.get(i10);
    }

    public int getCpuMetricReadingsCount() {
        return this.cpuMetricReadings_.size();
    }

    public List<CpuMetricReading> getCpuMetricReadingsList() {
        return this.cpuMetricReadings_;
    }

    public CpuMetricReadingOrBuilder getCpuMetricReadingsOrBuilder(int i10) {
        return this.cpuMetricReadings_.get(i10);
    }

    public List<? extends CpuMetricReadingOrBuilder> getCpuMetricReadingsOrBuilderList() {
        return this.cpuMetricReadings_;
    }

    public GaugeMetadata getGaugeMetadata() {
        GaugeMetadata gaugeMetadata = this.gaugeMetadata_;
        return gaugeMetadata == null ? GaugeMetadata.getDefaultInstance() : gaugeMetadata;
    }

    public String getSessionId() {
        return this.sessionId_;
    }

    public ByteString getSessionIdBytes() {
        return ByteString.s(this.sessionId_);
    }

    public boolean hasGaugeMetadata() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasSessionId() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(GaugeMetric gaugeMetric) {
        return (Builder) DEFAULT_INSTANCE.createBuilder(gaugeMetric);
    }

    public static GaugeMetric parseDelimitedFrom(InputStream inputStream, n nVar) throws IOException {
        return (GaugeMetric) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, nVar);
    }

    public static GaugeMetric parseFrom(ByteBuffer byteBuffer, n nVar) throws InvalidProtocolBufferException {
        return (GaugeMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, nVar);
    }

    public static GaugeMetric parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (GaugeMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* access modifiers changed from: private */
    public void addAndroidMemoryReadings(int i10, AndroidMemoryReading androidMemoryReading) {
        androidMemoryReading.getClass();
        ensureAndroidMemoryReadingsIsMutable();
        this.androidMemoryReadings_.add(i10, androidMemoryReading);
    }

    /* access modifiers changed from: private */
    public void addCpuMetricReadings(int i10, CpuMetricReading cpuMetricReading) {
        cpuMetricReading.getClass();
        ensureCpuMetricReadingsIsMutable();
        this.cpuMetricReadings_.add(i10, cpuMetricReading);
    }

    public static GaugeMetric parseFrom(ByteString byteString, n nVar) throws InvalidProtocolBufferException {
        return (GaugeMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, nVar);
    }

    public static GaugeMetric parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (GaugeMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GaugeMetric parseFrom(byte[] bArr, n nVar) throws InvalidProtocolBufferException {
        return (GaugeMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, nVar);
    }

    public static GaugeMetric parseFrom(InputStream inputStream) throws IOException {
        return (GaugeMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GaugeMetric parseFrom(InputStream inputStream, n nVar) throws IOException {
        return (GaugeMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, nVar);
    }

    public static GaugeMetric parseFrom(h hVar) throws IOException {
        return (GaugeMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, hVar);
    }

    public static GaugeMetric parseFrom(h hVar, n nVar) throws IOException {
        return (GaugeMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, hVar, nVar);
    }
}
