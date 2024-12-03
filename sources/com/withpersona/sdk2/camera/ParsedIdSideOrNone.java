package com.withpersona.sdk2.camera;

import android.graphics.Bitmap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public interface ParsedIdSideOrNone {

    public enum Side {
        Front,
        Back
    }

    public static final class b implements ParsedIdSideOrNone {

        /* renamed from: a  reason: collision with root package name */
        private final Side f14173a;

        /* renamed from: b  reason: collision with root package name */
        private final Bitmap f14174b;

        /* renamed from: c  reason: collision with root package name */
        private final ImageIdMetadata f14175c;

        /* renamed from: d  reason: collision with root package name */
        private final e f14176d;

        /* renamed from: e  reason: collision with root package name */
        private final ExtractedTexts f14177e;

        /* renamed from: f  reason: collision with root package name */
        private final ImageLightCondition f14178f;

        public b(Side side, Bitmap bitmap, ImageIdMetadata imageIdMetadata, e eVar, ExtractedTexts extractedTexts, ImageLightCondition imageLightCondition) {
            j.g(side, "side");
            j.g(bitmap, "bitmap");
            this.f14173a = side;
            this.f14174b = bitmap;
            this.f14175c = imageIdMetadata;
            this.f14176d = eVar;
            this.f14177e = extractedTexts;
            this.f14178f = imageLightCondition;
        }

        public ImageLightCondition a() {
            return this.f14178f;
        }

        public final Bitmap b() {
            return this.f14174b;
        }

        public final e c() {
            return this.f14176d;
        }

        public final ExtractedTexts d() {
            return this.f14177e;
        }

        public final ImageIdMetadata e() {
            return this.f14175c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f14173a == bVar.f14173a && j.b(this.f14174b, bVar.f14174b) && j.b(this.f14175c, bVar.f14175c) && j.b(this.f14176d, bVar.f14176d) && j.b(this.f14177e, bVar.f14177e) && j.b(a(), bVar.a());
        }

        public final Side f() {
            return this.f14173a;
        }

        public int hashCode() {
            int hashCode = ((this.f14173a.hashCode() * 31) + this.f14174b.hashCode()) * 31;
            ImageIdMetadata imageIdMetadata = this.f14175c;
            int i10 = 0;
            int hashCode2 = (hashCode + (imageIdMetadata == null ? 0 : imageIdMetadata.hashCode())) * 31;
            e eVar = this.f14176d;
            int hashCode3 = (hashCode2 + (eVar == null ? 0 : eVar.hashCode())) * 31;
            ExtractedTexts extractedTexts = this.f14177e;
            int hashCode4 = (hashCode3 + (extractedTexts == null ? 0 : extractedTexts.hashCode())) * 31;
            if (a() != null) {
                i10 = a().hashCode();
            }
            return hashCode4 + i10;
        }

        public String toString() {
            return "ParsedIdSide(side=" + this.f14173a + ", bitmap=" + this.f14174b + ", metadata=" + this.f14175c + ", extractedBarcode=" + this.f14176d + ", extractedTexts=" + this.f14177e + ", imageLightCondition=" + a() + PropertyUtils.MAPPED_DELIM2;
        }
    }

    ImageLightCondition a();

    public static final class a implements ParsedIdSideOrNone {

        /* renamed from: a  reason: collision with root package name */
        private final ImageLightCondition f14172a;

        public a() {
            this((ImageLightCondition) null, 1, (DefaultConstructorMarker) null);
        }

        public a(ImageLightCondition imageLightCondition) {
            this.f14172a = imageLightCondition;
        }

        public ImageLightCondition a() {
            return this.f14172a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && j.b(a(), ((a) obj).a());
        }

        public int hashCode() {
            if (a() == null) {
                return 0;
            }
            return a().hashCode();
        }

        public String toString() {
            return "None(imageLightCondition=" + a() + PropertyUtils.MAPPED_DELIM2;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ a(ImageLightCondition imageLightCondition, int i10, DefaultConstructorMarker defaultConstructorMarker) {
            this((i10 & 1) != 0 ? null : imageLightCondition);
        }
    }
}
