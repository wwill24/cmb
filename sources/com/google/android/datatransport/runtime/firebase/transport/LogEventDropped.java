package com.google.android.datatransport.runtime.firebase.transport;

import com.google.firebase.encoders.proto.ProtoEnum;
import com.google.firebase.encoders.proto.Protobuf;

public final class LogEventDropped {

    /* renamed from: c  reason: collision with root package name */
    private static final LogEventDropped f38139c = new a().a();

    /* renamed from: a  reason: collision with root package name */
    private final long f38140a;

    /* renamed from: b  reason: collision with root package name */
    private final Reason f38141b;

    public enum Reason implements ProtoEnum {
        REASON_UNKNOWN(0),
        MESSAGE_TOO_OLD(1),
        CACHE_FULL(2),
        PAYLOAD_TOO_BIG(3),
        MAX_RETRIES_REACHED(4),
        INVALID_PAYLOD(5),
        SERVER_ERROR(6);
        
        private final int number_;

        private Reason(int i10) {
            this.number_ = i10;
        }

        public int getNumber() {
            return this.number_;
        }
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private long f38150a = 0;

        /* renamed from: b  reason: collision with root package name */
        private Reason f38151b = Reason.REASON_UNKNOWN;

        a() {
        }

        public LogEventDropped a() {
            return new LogEventDropped(this.f38150a, this.f38151b);
        }

        public a b(long j10) {
            this.f38150a = j10;
            return this;
        }

        public a c(Reason reason) {
            this.f38151b = reason;
            return this;
        }
    }

    LogEventDropped(long j10, Reason reason) {
        this.f38140a = j10;
        this.f38141b = reason;
    }

    public static a c() {
        return new a();
    }

    @Protobuf(tag = 1)
    public long a() {
        return this.f38140a;
    }

    @Protobuf(tag = 3)
    public Reason b() {
        return this.f38141b;
    }
}
