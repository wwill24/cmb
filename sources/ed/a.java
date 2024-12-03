package ed;

import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;
import com.google.firebase.encoders.proto.AtProtobuf;
import java.io.IOException;
import org.jivesoftware.smackx.jingle.element.JingleReason;

public final class a implements Configurator {

    /* renamed from: a  reason: collision with root package name */
    public static final Configurator f40681a = new a();

    /* renamed from: ed.a$a  reason: collision with other inner class name */
    private static final class C0489a implements ObjectEncoder<hd.a> {

        /* renamed from: a  reason: collision with root package name */
        static final C0489a f40682a = new C0489a();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f40683b = FieldDescriptor.builder("window").withProperty(AtProtobuf.builder().tag(1).build()).build();

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f40684c = FieldDescriptor.builder("logSourceMetrics").withProperty(AtProtobuf.builder().tag(2).build()).build();

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f40685d = FieldDescriptor.builder("globalMetrics").withProperty(AtProtobuf.builder().tag(3).build()).build();

        /* renamed from: e  reason: collision with root package name */
        private static final FieldDescriptor f40686e = FieldDescriptor.builder("appNamespace").withProperty(AtProtobuf.builder().tag(4).build()).build();

        private C0489a() {
        }

        /* renamed from: a */
        public void encode(hd.a aVar, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(f40683b, (Object) aVar.d());
            objectEncoderContext.add(f40684c, (Object) aVar.c());
            objectEncoderContext.add(f40685d, (Object) aVar.b());
            objectEncoderContext.add(f40686e, (Object) aVar.a());
        }
    }

    private static final class b implements ObjectEncoder<hd.b> {

        /* renamed from: a  reason: collision with root package name */
        static final b f40687a = new b();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f40688b = FieldDescriptor.builder("storageMetrics").withProperty(AtProtobuf.builder().tag(1).build()).build();

        private b() {
        }

        /* renamed from: a */
        public void encode(hd.b bVar, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(f40688b, (Object) bVar.a());
        }
    }

    private static final class c implements ObjectEncoder<LogEventDropped> {

        /* renamed from: a  reason: collision with root package name */
        static final c f40689a = new c();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f40690b = FieldDescriptor.builder("eventsDroppedCount").withProperty(AtProtobuf.builder().tag(1).build()).build();

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f40691c = FieldDescriptor.builder(JingleReason.ELEMENT).withProperty(AtProtobuf.builder().tag(3).build()).build();

        private c() {
        }

        /* renamed from: a */
        public void encode(LogEventDropped logEventDropped, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(f40690b, logEventDropped.a());
            objectEncoderContext.add(f40691c, (Object) logEventDropped.b());
        }
    }

    private static final class d implements ObjectEncoder<hd.c> {

        /* renamed from: a  reason: collision with root package name */
        static final d f40692a = new d();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f40693b = FieldDescriptor.builder("logSource").withProperty(AtProtobuf.builder().tag(1).build()).build();

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f40694c = FieldDescriptor.builder("logEventDropped").withProperty(AtProtobuf.builder().tag(2).build()).build();

        private d() {
        }

        /* renamed from: a */
        public void encode(hd.c cVar, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(f40693b, (Object) cVar.b());
            objectEncoderContext.add(f40694c, (Object) cVar.a());
        }
    }

    private static final class e implements ObjectEncoder<m> {

        /* renamed from: a  reason: collision with root package name */
        static final e f40695a = new e();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f40696b = FieldDescriptor.of("clientMetrics");

        private e() {
        }

        /* renamed from: a */
        public void encode(m mVar, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(f40696b, (Object) mVar.b());
        }
    }

    private static final class f implements ObjectEncoder<hd.d> {

        /* renamed from: a  reason: collision with root package name */
        static final f f40697a = new f();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f40698b = FieldDescriptor.builder("currentCacheSizeBytes").withProperty(AtProtobuf.builder().tag(1).build()).build();

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f40699c = FieldDescriptor.builder("maxCacheSizeBytes").withProperty(AtProtobuf.builder().tag(2).build()).build();

        private f() {
        }

        /* renamed from: a */
        public void encode(hd.d dVar, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(f40698b, dVar.a());
            objectEncoderContext.add(f40699c, dVar.b());
        }
    }

    private static final class g implements ObjectEncoder<hd.e> {

        /* renamed from: a  reason: collision with root package name */
        static final g f40700a = new g();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f40701b = FieldDescriptor.builder("startMs").withProperty(AtProtobuf.builder().tag(1).build()).build();

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f40702c = FieldDescriptor.builder("endMs").withProperty(AtProtobuf.builder().tag(2).build()).build();

        private g() {
        }

        /* renamed from: a */
        public void encode(hd.e eVar, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(f40701b, eVar.b());
            objectEncoderContext.add(f40702c, eVar.a());
        }
    }

    private a() {
    }

    public void configure(EncoderConfig<?> encoderConfig) {
        encoderConfig.registerEncoder((Class<U>) m.class, (ObjectEncoder<? super U>) e.f40695a);
        encoderConfig.registerEncoder((Class<U>) hd.a.class, (ObjectEncoder<? super U>) C0489a.f40682a);
        encoderConfig.registerEncoder((Class<U>) hd.e.class, (ObjectEncoder<? super U>) g.f40700a);
        encoderConfig.registerEncoder((Class<U>) hd.c.class, (ObjectEncoder<? super U>) d.f40692a);
        encoderConfig.registerEncoder((Class<U>) LogEventDropped.class, (ObjectEncoder<? super U>) c.f40689a);
        encoderConfig.registerEncoder((Class<U>) hd.b.class, (ObjectEncoder<? super U>) b.f40687a);
        encoderConfig.registerEncoder((Class<U>) hd.d.class, (ObjectEncoder<? super U>) f.f40697a);
    }
}
