package com.google.android.datatransport.cct.internal;

import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;
import com.leanplum.internal.Constants;
import java.io.IOException;

public final class b implements Configurator {

    /* renamed from: a  reason: collision with root package name */
    public static final Configurator f38033a = new b();

    private static final class a implements ObjectEncoder<a> {

        /* renamed from: a  reason: collision with root package name */
        static final a f38034a = new a();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f38035b = FieldDescriptor.of("sdkVersion");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f38036c = FieldDescriptor.of(DeviceRequestsHelper.DEVICE_INFO_MODEL);

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f38037d = FieldDescriptor.of("hardware");

        /* renamed from: e  reason: collision with root package name */
        private static final FieldDescriptor f38038e = FieldDescriptor.of(DeviceRequestsHelper.DEVICE_INFO_DEVICE);

        /* renamed from: f  reason: collision with root package name */
        private static final FieldDescriptor f38039f = FieldDescriptor.of("product");

        /* renamed from: g  reason: collision with root package name */
        private static final FieldDescriptor f38040g = FieldDescriptor.of("osBuild");

        /* renamed from: h  reason: collision with root package name */
        private static final FieldDescriptor f38041h = FieldDescriptor.of("manufacturer");

        /* renamed from: i  reason: collision with root package name */
        private static final FieldDescriptor f38042i = FieldDescriptor.of("fingerprint");

        /* renamed from: j  reason: collision with root package name */
        private static final FieldDescriptor f38043j = FieldDescriptor.of(Constants.Keys.LOCALE);

        /* renamed from: k  reason: collision with root package name */
        private static final FieldDescriptor f38044k = FieldDescriptor.of("country");

        /* renamed from: l  reason: collision with root package name */
        private static final FieldDescriptor f38045l = FieldDescriptor.of("mccMnc");

        /* renamed from: m  reason: collision with root package name */
        private static final FieldDescriptor f38046m = FieldDescriptor.of("applicationBuild");

        private a() {
        }

        /* renamed from: a */
        public void encode(a aVar, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(f38035b, (Object) aVar.m());
            objectEncoderContext.add(f38036c, (Object) aVar.j());
            objectEncoderContext.add(f38037d, (Object) aVar.f());
            objectEncoderContext.add(f38038e, (Object) aVar.d());
            objectEncoderContext.add(f38039f, (Object) aVar.l());
            objectEncoderContext.add(f38040g, (Object) aVar.k());
            objectEncoderContext.add(f38041h, (Object) aVar.h());
            objectEncoderContext.add(f38042i, (Object) aVar.e());
            objectEncoderContext.add(f38043j, (Object) aVar.g());
            objectEncoderContext.add(f38044k, (Object) aVar.c());
            objectEncoderContext.add(f38045l, (Object) aVar.i());
            objectEncoderContext.add(f38046m, (Object) aVar.b());
        }
    }

    /* renamed from: com.google.android.datatransport.cct.internal.b$b  reason: collision with other inner class name */
    private static final class C0478b implements ObjectEncoder<i> {

        /* renamed from: a  reason: collision with root package name */
        static final C0478b f38047a = new C0478b();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f38048b = FieldDescriptor.of("logRequest");

        private C0478b() {
        }

        /* renamed from: a */
        public void encode(i iVar, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(f38048b, (Object) iVar.c());
        }
    }

    private static final class c implements ObjectEncoder<ClientInfo> {

        /* renamed from: a  reason: collision with root package name */
        static final c f38049a = new c();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f38050b = FieldDescriptor.of("clientType");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f38051c = FieldDescriptor.of("androidClientInfo");

        private c() {
        }

        /* renamed from: a */
        public void encode(ClientInfo clientInfo, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(f38050b, (Object) clientInfo.c());
            objectEncoderContext.add(f38051c, (Object) clientInfo.b());
        }
    }

    private static final class d implements ObjectEncoder<j> {

        /* renamed from: a  reason: collision with root package name */
        static final d f38052a = new d();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f38053b = FieldDescriptor.of("eventTimeMs");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f38054c = FieldDescriptor.of("eventCode");

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f38055d = FieldDescriptor.of("eventUptimeMs");

        /* renamed from: e  reason: collision with root package name */
        private static final FieldDescriptor f38056e = FieldDescriptor.of("sourceExtension");

        /* renamed from: f  reason: collision with root package name */
        private static final FieldDescriptor f38057f = FieldDescriptor.of("sourceExtensionJsonProto3");

        /* renamed from: g  reason: collision with root package name */
        private static final FieldDescriptor f38058g = FieldDescriptor.of(Constants.Keys.TIMEZONE_OFFSET_SECONDS);

        /* renamed from: h  reason: collision with root package name */
        private static final FieldDescriptor f38059h = FieldDescriptor.of("networkConnectionInfo");

        private d() {
        }

        /* renamed from: a */
        public void encode(j jVar, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(f38053b, jVar.c());
            objectEncoderContext.add(f38054c, (Object) jVar.b());
            objectEncoderContext.add(f38055d, jVar.d());
            objectEncoderContext.add(f38056e, (Object) jVar.f());
            objectEncoderContext.add(f38057f, (Object) jVar.g());
            objectEncoderContext.add(f38058g, jVar.h());
            objectEncoderContext.add(f38059h, (Object) jVar.e());
        }
    }

    private static final class e implements ObjectEncoder<k> {

        /* renamed from: a  reason: collision with root package name */
        static final e f38060a = new e();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f38061b = FieldDescriptor.of("requestTimeMs");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f38062c = FieldDescriptor.of("requestUptimeMs");

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f38063d = FieldDescriptor.of("clientInfo");

        /* renamed from: e  reason: collision with root package name */
        private static final FieldDescriptor f38064e = FieldDescriptor.of("logSource");

        /* renamed from: f  reason: collision with root package name */
        private static final FieldDescriptor f38065f = FieldDescriptor.of("logSourceName");

        /* renamed from: g  reason: collision with root package name */
        private static final FieldDescriptor f38066g = FieldDescriptor.of("logEvent");

        /* renamed from: h  reason: collision with root package name */
        private static final FieldDescriptor f38067h = FieldDescriptor.of("qosTier");

        private e() {
        }

        /* renamed from: a */
        public void encode(k kVar, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(f38061b, kVar.g());
            objectEncoderContext.add(f38062c, kVar.h());
            objectEncoderContext.add(f38063d, (Object) kVar.b());
            objectEncoderContext.add(f38064e, (Object) kVar.d());
            objectEncoderContext.add(f38065f, (Object) kVar.e());
            objectEncoderContext.add(f38066g, (Object) kVar.c());
            objectEncoderContext.add(f38067h, (Object) kVar.f());
        }
    }

    private static final class f implements ObjectEncoder<NetworkConnectionInfo> {

        /* renamed from: a  reason: collision with root package name */
        static final f f38068a = new f();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f38069b = FieldDescriptor.of("networkType");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f38070c = FieldDescriptor.of("mobileSubtype");

        private f() {
        }

        /* renamed from: a */
        public void encode(NetworkConnectionInfo networkConnectionInfo, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(f38069b, (Object) networkConnectionInfo.c());
            objectEncoderContext.add(f38070c, (Object) networkConnectionInfo.b());
        }
    }

    private b() {
    }

    public void configure(EncoderConfig<?> encoderConfig) {
        C0478b bVar = C0478b.f38047a;
        encoderConfig.registerEncoder((Class<U>) i.class, (ObjectEncoder<? super U>) bVar);
        encoderConfig.registerEncoder((Class<U>) d.class, (ObjectEncoder<? super U>) bVar);
        e eVar = e.f38060a;
        encoderConfig.registerEncoder((Class<U>) k.class, (ObjectEncoder<? super U>) eVar);
        encoderConfig.registerEncoder((Class<U>) g.class, (ObjectEncoder<? super U>) eVar);
        c cVar = c.f38049a;
        encoderConfig.registerEncoder((Class<U>) ClientInfo.class, (ObjectEncoder<? super U>) cVar);
        encoderConfig.registerEncoder((Class<U>) e.class, (ObjectEncoder<? super U>) cVar);
        a aVar = a.f38034a;
        encoderConfig.registerEncoder((Class<U>) a.class, (ObjectEncoder<? super U>) aVar);
        encoderConfig.registerEncoder((Class<U>) c.class, (ObjectEncoder<? super U>) aVar);
        d dVar = d.f38052a;
        encoderConfig.registerEncoder((Class<U>) j.class, (ObjectEncoder<? super U>) dVar);
        encoderConfig.registerEncoder((Class<U>) f.class, (ObjectEncoder<? super U>) dVar);
        f fVar = f.f38068a;
        encoderConfig.registerEncoder((Class<U>) NetworkConnectionInfo.class, (ObjectEncoder<? super U>) fVar);
        encoderConfig.registerEncoder((Class<U>) h.class, (ObjectEncoder<? super U>) fVar);
    }
}
