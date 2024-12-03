package gh;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.oned.Code128Writer;
import java.util.Map;
import nh.d;
import nh.f;
import nh.h;
import nh.i;
import nh.j;
import nh.m;
import nh.q;

public final class b implements c {

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f23438a;

        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|(3:25|26|28)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.google.zxing.BarcodeFormat[] r0 = com.google.zxing.BarcodeFormat.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f23438a = r0
                com.google.zxing.BarcodeFormat r1 = com.google.zxing.BarcodeFormat.EAN_8     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f23438a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.zxing.BarcodeFormat r1 = com.google.zxing.BarcodeFormat.UPC_E     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f23438a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.zxing.BarcodeFormat r1 = com.google.zxing.BarcodeFormat.EAN_13     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f23438a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.zxing.BarcodeFormat r1 = com.google.zxing.BarcodeFormat.UPC_A     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f23438a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.zxing.BarcodeFormat r1 = com.google.zxing.BarcodeFormat.QR_CODE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f23438a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.google.zxing.BarcodeFormat r1 = com.google.zxing.BarcodeFormat.CODE_39     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f23438a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.google.zxing.BarcodeFormat r1 = com.google.zxing.BarcodeFormat.CODE_93     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f23438a     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.google.zxing.BarcodeFormat r1 = com.google.zxing.BarcodeFormat.CODE_128     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f23438a     // Catch:{ NoSuchFieldError -> 0x006c }
                com.google.zxing.BarcodeFormat r1 = com.google.zxing.BarcodeFormat.ITF     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f23438a     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.google.zxing.BarcodeFormat r1 = com.google.zxing.BarcodeFormat.PDF_417     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f23438a     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.google.zxing.BarcodeFormat r1 = com.google.zxing.BarcodeFormat.CODABAR     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = f23438a     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.google.zxing.BarcodeFormat r1 = com.google.zxing.BarcodeFormat.DATA_MATRIX     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = f23438a     // Catch:{ NoSuchFieldError -> 0x009c }
                com.google.zxing.BarcodeFormat r1 = com.google.zxing.BarcodeFormat.AZTEC     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: gh.b.a.<clinit>():void");
        }
    }

    public jh.b a(String str, BarcodeFormat barcodeFormat, int i10, int i11, Map<EncodeHintType, ?> map) throws WriterException {
        c cVar;
        switch (a.f23438a[barcodeFormat.ordinal()]) {
            case 1:
                cVar = new i();
                break;
            case 2:
                cVar = new q();
                break;
            case 3:
                cVar = new h();
                break;
            case 4:
                cVar = new m();
                break;
            case 5:
                cVar = new qh.a();
                break;
            case 6:
                cVar = new d();
                break;
            case 7:
                cVar = new f();
                break;
            case 8:
                cVar = new Code128Writer();
                break;
            case 9:
                cVar = new j();
                break;
            case 10:
                cVar = new oh.a();
                break;
            case 11:
                cVar = new nh.b();
                break;
            case 12:
                cVar = new lh.a();
                break;
            case 13:
                cVar = new hh.a();
                break;
            default:
                throw new IllegalArgumentException("No encoder available for format " + barcodeFormat);
        }
        return cVar.a(str, barcodeFormat, i10, i11, map);
    }
}
