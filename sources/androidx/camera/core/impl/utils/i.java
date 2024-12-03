package androidx.camera.core.impl.utils;

import android.location.Location;
import androidx.annotation.NonNull;
import androidx.camera.core.o1;
import androidx.camera.core.v1;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import net.bytebuddy.jar.asm.Opcodes;

public final class i {

    /* renamed from: c  reason: collision with root package name */
    private static final String f2656c = "i";

    /* renamed from: d  reason: collision with root package name */
    private static final ThreadLocal<SimpleDateFormat> f2657d = new a();

    /* renamed from: e  reason: collision with root package name */
    private static final ThreadLocal<SimpleDateFormat> f2658e = new b();

    /* renamed from: f  reason: collision with root package name */
    private static final ThreadLocal<SimpleDateFormat> f2659f = new c();

    /* renamed from: g  reason: collision with root package name */
    private static final List<String> f2660g = n();

    /* renamed from: h  reason: collision with root package name */
    private static final List<String> f2661h = Arrays.asList(new String[]{"ImageWidth", "ImageLength", "PixelXDimension", "PixelYDimension", "Compression", "JPEGInterchangeFormat", "JPEGInterchangeFormatLength", "ThumbnailImageLength", "ThumbnailImageWidth", "ThumbnailOrientation"});

    /* renamed from: a  reason: collision with root package name */
    private final androidx.exifinterface.media.a f2662a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f2663b = false;

    class a extends ThreadLocal<SimpleDateFormat> {
        a() {
        }

        /* renamed from: a */
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy:MM:dd", Locale.US);
        }
    }

    class b extends ThreadLocal<SimpleDateFormat> {
        b() {
        }

        /* renamed from: a */
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat("HH:mm:ss", Locale.US);
        }
    }

    class c extends ThreadLocal<SimpleDateFormat> {
        c() {
        }

        /* renamed from: a */
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", Locale.US);
        }
    }

    private static final class d {

        static final class a {

            /* renamed from: a  reason: collision with root package name */
            final double f2664a;

            a(double d10) {
                this.f2664a = d10;
            }

            /* access modifiers changed from: package-private */
            public double a() {
                return this.f2664a / 2.23694d;
            }
        }

        static a a(double d10) {
            return new a(d10 * 0.621371d);
        }

        static a b(double d10) {
            return new a(d10 * 1.15078d);
        }

        static a c(double d10) {
            return new a(d10);
        }
    }

    private i(androidx.exifinterface.media.a aVar) {
        this.f2662a = aVar;
    }

    private void a() {
        long currentTimeMillis = System.currentTimeMillis();
        String f10 = f(currentTimeMillis);
        this.f2662a.d0("DateTime", f10);
        try {
            this.f2662a.d0("SubSecTime", Long.toString(currentTimeMillis - d(f10).getTime()));
        } catch (ParseException unused) {
        }
    }

    private static Date c(String str) throws ParseException {
        return f2657d.get().parse(str);
    }

    private static Date d(String str) throws ParseException {
        return f2659f.get().parse(str);
    }

    private static Date e(String str) throws ParseException {
        return f2658e.get().parse(str);
    }

    private static String f(long j10) {
        return f2659f.get().format(new Date(j10));
    }

    @NonNull
    public static i h(@NonNull File file) throws IOException {
        return i(file.toString());
    }

    @NonNull
    public static i i(@NonNull String str) throws IOException {
        return new i(new androidx.exifinterface.media.a(str));
    }

    @NonNull
    public static i j(@NonNull o1 o1Var) throws IOException {
        ByteBuffer d10 = o1Var.M0()[0].d();
        d10.rewind();
        byte[] bArr = new byte[d10.capacity()];
        d10.get(bArr);
        return k(new ByteArrayInputStream(bArr));
    }

    @NonNull
    public static i k(@NonNull InputStream inputStream) throws IOException {
        return new i(new androidx.exifinterface.media.a(inputStream));
    }

    @NonNull
    public static List<String> n() {
        return Arrays.asList(new String[]{"ImageWidth", "ImageLength", "BitsPerSample", "Compression", "PhotometricInterpretation", "Orientation", "SamplesPerPixel", "PlanarConfiguration", "YCbCrSubSampling", "YCbCrPositioning", "XResolution", "YResolution", "ResolutionUnit", "StripOffsets", "RowsPerStrip", "StripByteCounts", "JPEGInterchangeFormat", "JPEGInterchangeFormatLength", "TransferFunction", "WhitePoint", "PrimaryChromaticities", "YCbCrCoefficients", "ReferenceBlackWhite", "DateTime", "ImageDescription", "Make", "Model", "Software", "Artist", "Copyright", "ExifVersion", "FlashpixVersion", "ColorSpace", "Gamma", "PixelXDimension", "PixelYDimension", "ComponentsConfiguration", "CompressedBitsPerPixel", "MakerNote", "UserComment", "RelatedSoundFile", "DateTimeOriginal", "DateTimeDigitized", "OffsetTime", "OffsetTimeOriginal", "OffsetTimeDigitized", "SubSecTime", "SubSecTimeOriginal", "SubSecTimeDigitized", "ExposureTime", "FNumber", "ExposureProgram", "SpectralSensitivity", "PhotographicSensitivity", "OECF", "SensitivityType", "StandardOutputSensitivity", "RecommendedExposureIndex", "ISOSpeed", "ISOSpeedLatitudeyyy", "ISOSpeedLatitudezzz", "ShutterSpeedValue", "ApertureValue", "BrightnessValue", "ExposureBiasValue", "MaxApertureValue", "SubjectDistance", "MeteringMode", "LightSource", "Flash", "SubjectArea", "FocalLength", "FlashEnergy", "SpatialFrequencyResponse", "FocalPlaneXResolution", "FocalPlaneYResolution", "FocalPlaneResolutionUnit", "SubjectLocation", "ExposureIndex", "SensingMethod", "FileSource", "SceneType", "CFAPattern", "CustomRendered", "ExposureMode", "WhiteBalance", "DigitalZoomRatio", "FocalLengthIn35mmFilm", "SceneCaptureType", "GainControl", "Contrast", "Saturation", "Sharpness", "DeviceSettingDescription", "SubjectDistanceRange", "ImageUniqueID", "CameraOwnerName", "BodySerialNumber", "LensSpecification", "LensMake", "LensModel", "LensSerialNumber", "GPSVersionID", "GPSLatitudeRef", "GPSLatitude", "GPSLongitudeRef", "GPSLongitude", "GPSAltitudeRef", "GPSAltitude", "GPSTimeStamp", "GPSSatellites", "GPSStatus", "GPSMeasureMode", "GPSDOP", "GPSSpeedRef", "GPSSpeed", "GPSTrackRef", "GPSTrack", "GPSImgDirectionRef", "GPSImgDirection", "GPSMapDatum", "GPSDestLatitudeRef", "GPSDestLatitude", "GPSDestLongitudeRef", "GPSDestLongitude", "GPSDestBearingRef", "GPSDestBearing", "GPSDestDistanceRef", "GPSDestDistance", "GPSProcessingMethod", "GPSAreaInformation", "GPSDateStamp", "GPSDifferential", "GPSHPositioningError", "InteroperabilityIndex", "ThumbnailImageLength", "ThumbnailImageWidth", "ThumbnailOrientation", "DNGVersion", "DefaultCropSize", "ThumbnailImage", "PreviewImageStart", "PreviewImageLength", "AspectFrame", "SensorBottomBorder", "SensorLeftBorder", "SensorRightBorder", "SensorTopBorder", "ISO", "JpgFromRaw", "Xmp", "NewSubfileType", "SubfileType"});
    }

    private long x(String str) {
        if (str == null) {
            return -1;
        }
        try {
            return d(str).getTime();
        } catch (ParseException unused) {
            return -1;
        }
    }

    private long y(String str, String str2) {
        if (str == null && str2 == null) {
            return -1;
        }
        if (str2 == null) {
            try {
                return c(str).getTime();
            } catch (ParseException unused) {
                return -1;
            }
        } else if (str == null) {
            try {
                return e(str2).getTime();
            } catch (ParseException unused2) {
                return -1;
            }
        } else {
            return x(str + " " + str2);
        }
    }

    public void A() throws IOException {
        if (!this.f2663b) {
            a();
        }
        this.f2662a.Y();
    }

    public void b(@NonNull Location location) {
        this.f2662a.e0(location);
    }

    public void g(@NonNull i iVar) {
        ArrayList<String> arrayList = new ArrayList<>(f2660g);
        arrayList.removeAll(f2661h);
        for (String str : arrayList) {
            String g10 = this.f2662a.g(str);
            String g11 = iVar.f2662a.g(str);
            if (g10 != null && !g10.equals(g11)) {
                iVar.f2662a.d0(str, g10);
            }
        }
    }

    public void l() {
        int i10;
        switch (r()) {
            case 2:
                i10 = 1;
                break;
            case 3:
                i10 = 4;
                break;
            case 4:
                i10 = 3;
                break;
            case 5:
                i10 = 6;
                break;
            case 6:
                i10 = 5;
                break;
            case 7:
                i10 = 8;
                break;
            case 8:
                i10 = 7;
                break;
            default:
                i10 = 2;
                break;
        }
        this.f2662a.d0("Orientation", String.valueOf(i10));
    }

    public void m() {
        int i10;
        switch (r()) {
            case 2:
                i10 = 3;
                break;
            case 3:
                i10 = 2;
                break;
            case 4:
                i10 = 1;
                break;
            case 5:
                i10 = 8;
                break;
            case 6:
                i10 = 7;
                break;
            case 7:
                i10 = 6;
                break;
            case 8:
                i10 = 5;
                break;
            default:
                i10 = 4;
                break;
        }
        this.f2662a.d0("Orientation", String.valueOf(i10));
    }

    public String o() {
        return this.f2662a.g("ImageDescription");
    }

    public int p() {
        return this.f2662a.i("ImageLength", 0);
    }

    public Location q() {
        double d10;
        String g10 = this.f2662a.g("GPSProcessingMethod");
        double[] m10 = this.f2662a.m();
        double f10 = this.f2662a.f(0.0d);
        double h10 = this.f2662a.h("GPSSpeed", 0.0d);
        String g11 = this.f2662a.g("GPSSpeedRef");
        if (g11 == null) {
            g11 = "K";
        }
        long y10 = y(this.f2662a.g("GPSDateStamp"), this.f2662a.g("GPSTimeStamp"));
        if (m10 == null) {
            return null;
        }
        if (g10 == null) {
            g10 = f2656c;
        }
        Location location = new Location(g10);
        location.setLatitude(m10[0]);
        location.setLongitude(m10[1]);
        if (f10 != 0.0d) {
            location.setAltitude(f10);
        }
        if (h10 != 0.0d) {
            char c10 = 65535;
            int hashCode = g11.hashCode();
            if (hashCode != 75) {
                if (hashCode != 77) {
                    if (hashCode == 78 && g11.equals("N")) {
                        c10 = 1;
                    }
                } else if (g11.equals("M")) {
                    c10 = 0;
                }
            } else if (g11.equals("K")) {
                c10 = 2;
            }
            if (c10 == 0) {
                d10 = d.c(h10).a();
            } else if (c10 != 1) {
                d10 = d.a(h10).a();
            } else {
                d10 = d.b(h10).a();
            }
            location.setSpeed((float) d10);
        }
        if (y10 != -1) {
            location.setTime(y10);
        }
        return location;
    }

    public int r() {
        return this.f2662a.i("Orientation", 0);
    }

    public int s() {
        switch (r()) {
            case 3:
            case 4:
                return Opcodes.GETFIELD;
            case 5:
                return 270;
            case 6:
            case 7:
                return 90;
            case 8:
                return 270;
            default:
                return 0;
        }
    }

    public long t() {
        long x10 = x(this.f2662a.g("DateTimeOriginal"));
        if (x10 == -1) {
            return -1;
        }
        String g10 = this.f2662a.g("SubSecTimeOriginal");
        if (g10 == null) {
            return x10;
        }
        try {
            long parseLong = Long.parseLong(g10);
            while (parseLong > 1000) {
                parseLong /= 10;
            }
            return x10 + parseLong;
        } catch (NumberFormatException unused) {
            return x10;
        }
    }

    public String toString() {
        return String.format(Locale.ENGLISH, "Exif{width=%s, height=%s, rotation=%d, isFlippedVertically=%s, isFlippedHorizontally=%s, location=%s, timestamp=%s, description=%s}", new Object[]{Integer.valueOf(u()), Integer.valueOf(p()), Integer.valueOf(s()), Boolean.valueOf(w()), Boolean.valueOf(v()), q(), Long.valueOf(t()), o()});
    }

    public int u() {
        return this.f2662a.i("ImageWidth", 0);
    }

    public boolean v() {
        return r() == 2;
    }

    public boolean w() {
        int r10 = r();
        return r10 == 4 || r10 == 5 || r10 == 7;
    }

    public void z(int i10) {
        int i11;
        if (i10 % 90 != 0) {
            v1.l(f2656c, String.format(Locale.US, "Can only rotate in right angles (eg. 0, 90, 180, 270). %d is unsupported.", new Object[]{Integer.valueOf(i10)}));
            this.f2662a.d0("Orientation", String.valueOf(0));
            return;
        }
        int i12 = i10 % 360;
        int r10 = r();
        while (i12 < 0) {
            i12 += 90;
            switch (r10) {
                case 2:
                    r10 = 5;
                    break;
                case 3:
                case 8:
                    r10 = 6;
                    break;
                case 4:
                    r10 = 7;
                    break;
                case 5:
                    r10 = 4;
                    break;
                case 6:
                    r10 = 1;
                    break;
                case 7:
                    r10 = 2;
                    break;
                default:
                    r10 = 8;
                    break;
            }
        }
        while (i12 > 0) {
            i12 -= 90;
            switch (r10) {
                case 2:
                    i11 = 7;
                    break;
                case 3:
                    i11 = 8;
                    break;
                case 4:
                    i11 = 5;
                    break;
                case 5:
                    i11 = 2;
                    break;
                case 6:
                    i11 = 3;
                    break;
                case 7:
                    i11 = 4;
                    break;
                case 8:
                    i11 = 1;
                    break;
                default:
                    i11 = 6;
                    break;
            }
        }
        this.f2662a.d0("Orientation", String.valueOf(r10));
    }
}
