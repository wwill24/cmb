package com.withpersona.sdk2.camera.analyzers;

import com.withpersona.sdk2.camera.ExtractedTexts;
import com.withpersona.sdk2.camera.ImageIdMetadata;
import com.withpersona.sdk2.camera.ImageLightCondition;
import com.withpersona.sdk2.camera.ParsedIdSideOrNone;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public abstract class a {

    /* renamed from: com.withpersona.sdk2.camera.analyzers.a$a  reason: collision with other inner class name */
    public static final class C0150a extends a {

        /* renamed from: a  reason: collision with root package name */
        private final com.withpersona.sdk2.camera.e f14240a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0150a(com.withpersona.sdk2.camera.e eVar) {
            super((DefaultConstructorMarker) null);
            j.g(eVar, "extractedBarcode");
            this.f14240a = eVar;
        }

        public final com.withpersona.sdk2.camera.e a() {
            return this.f14240a;
        }
    }

    public static final class b extends a {

        /* renamed from: a  reason: collision with root package name */
        public static final b f14241a = new b();

        private b() {
            super((DefaultConstructorMarker) null);
        }
    }

    public static final class c extends a {

        /* renamed from: a  reason: collision with root package name */
        private final ParsedIdSideOrNone.Side f14242a;

        /* renamed from: b  reason: collision with root package name */
        private final a f14243b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(ParsedIdSideOrNone.Side side, a aVar) {
            super((DefaultConstructorMarker) null);
            j.g(side, "side");
            j.g(aVar, "frontOrBackData");
            this.f14242a = side;
            this.f14243b = aVar;
        }

        public final a a() {
            return this.f14243b;
        }

        public final ParsedIdSideOrNone.Side b() {
            return this.f14242a;
        }
    }

    public static final class d extends a {

        /* renamed from: a  reason: collision with root package name */
        private final ImageIdMetadata f14244a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(ImageIdMetadata imageIdMetadata) {
            super((DefaultConstructorMarker) null);
            j.g(imageIdMetadata, "metadata");
            this.f14244a = imageIdMetadata;
        }

        public final ImageIdMetadata a() {
            return this.f14244a;
        }
    }

    public static final class e extends a {

        /* renamed from: a  reason: collision with root package name */
        private final ImageLightCondition f14245a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(ImageLightCondition imageLightCondition) {
            super((DefaultConstructorMarker) null);
            j.g(imageLightCondition, "imageLightCondition");
            this.f14245a = imageLightCondition;
        }

        public final ImageLightCondition a() {
            return this.f14245a;
        }
    }

    public static final class f extends a {

        /* renamed from: a  reason: collision with root package name */
        private final ExtractedTexts f14246a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(ExtractedTexts extractedTexts) {
            super((DefaultConstructorMarker) null);
            j.g(extractedTexts, "extractedTexts");
            this.f14246a = extractedTexts;
        }

        public final ExtractedTexts a() {
            return this.f14246a;
        }
    }

    private a() {
    }

    public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
