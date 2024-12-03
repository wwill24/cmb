package org.jivesoftware.smackx.colors;

import em.a;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.SHA1;

public class ConsistentColor {
    private static final ConsistentColorSettings DEFAULT_SETTINGS = new ConsistentColorSettings();

    /* renamed from: org.jivesoftware.smackx.colors.ConsistentColor$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smackx$colors$ConsistentColor$Deficiency;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                org.jivesoftware.smackx.colors.ConsistentColor$Deficiency[] r0 = org.jivesoftware.smackx.colors.ConsistentColor.Deficiency.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$jivesoftware$smackx$colors$ConsistentColor$Deficiency = r0
                org.jivesoftware.smackx.colors.ConsistentColor$Deficiency r1 = org.jivesoftware.smackx.colors.ConsistentColor.Deficiency.none     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$org$jivesoftware$smackx$colors$ConsistentColor$Deficiency     // Catch:{ NoSuchFieldError -> 0x001d }
                org.jivesoftware.smackx.colors.ConsistentColor$Deficiency r1 = org.jivesoftware.smackx.colors.ConsistentColor.Deficiency.redGreenBlindness     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$org$jivesoftware$smackx$colors$ConsistentColor$Deficiency     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.jivesoftware.smackx.colors.ConsistentColor$Deficiency r1 = org.jivesoftware.smackx.colors.ConsistentColor.Deficiency.blueBlindness     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.colors.ConsistentColor.AnonymousClass1.<clinit>():void");
        }
    }

    public enum Deficiency {
        none,
        redGreenBlindness,
        blueBlindness
    }

    public static float[] RGBFrom(CharSequence charSequence) {
        return RGBFrom(charSequence, DEFAULT_SETTINGS);
    }

    private static double applyColorDeficiencyCorrection(double d10, Deficiency deficiency) {
        int i10 = AnonymousClass1.$SwitchMap$org$jivesoftware$smackx$colors$ConsistentColor$Deficiency[deficiency.ordinal()];
        return i10 != 2 ? i10 != 3 ? d10 : d10 % 180.0d : (((d10 + 90.0d) % 180.0d) + 270.0d) % 360.0d;
    }

    private static double createAngle(CharSequence charSequence) {
        byte[] bytes = SHA1.bytes(charSequence.toString());
        return (((double) (u(bytes[0]) + (u(bytes[1]) * 256))) / 65536.0d) * 360.0d;
    }

    public static int[] floatRgbToInts(float[] fArr) {
        return new int[]{(int) (fArr[0] * 255.0f), (int) (fArr[1] * 255.0f), (int) (fArr[2] * 255.0f)};
    }

    private static double[] hsluvToRgb(double d10) {
        return hsluvToRgb(d10, 100.0d, 50.0d);
    }

    private static double[] mixWithBackground(double[] dArr, float[] fArr) {
        return new double[]{(((double) (1.0f - fArr[0])) * 0.2d) + (dArr[0] * 0.8d), (((double) (1.0f - fArr[1])) * 0.2d) + (dArr[1] * 0.8d), (((double) (1.0f - fArr[2])) * 0.2d) + (dArr[2] * 0.8d)};
    }

    private static int u(byte b10) {
        return b10 & 255;
    }

    public static float[] RGBFrom(CharSequence charSequence, ConsistentColorSettings consistentColorSettings) {
        double[] hsluvToRgb = hsluvToRgb(applyColorDeficiencyCorrection(createAngle(charSequence), consistentColorSettings.getDeficiency()));
        if (consistentColorSettings.backgroundRGB != null) {
            hsluvToRgb = mixWithBackground(hsluvToRgb, consistentColorSettings.backgroundRGB);
        }
        return new float[]{(float) hsluvToRgb[0], (float) hsluvToRgb[1], (float) hsluvToRgb[2]};
    }

    private static double[] hsluvToRgb(double d10, double d11, double d12) {
        return a.e(new double[]{d10, d11, d12});
    }

    public static class ConsistentColorSettings {
        /* access modifiers changed from: private */
        public final float[] backgroundRGB;
        private final Deficiency deficiency;

        public ConsistentColorSettings() {
            this.deficiency = Deficiency.none;
            this.backgroundRGB = null;
        }

        private static void checkRange(float f10, float f11, float f12) {
            if (f11 > f10 || f12 < f10) {
                throw new IllegalArgumentException("Value out of range.");
            }
        }

        public Deficiency getDeficiency() {
            return this.deficiency;
        }

        public ConsistentColorSettings(Deficiency deficiency2) {
            this.deficiency = (Deficiency) Objects.requireNonNull(deficiency2, "Deficiency must be given");
            this.backgroundRGB = null;
        }

        public ConsistentColorSettings(Deficiency deficiency2, float[] fArr) {
            this.deficiency = (Deficiency) Objects.requireNonNull(deficiency2, "Deficiency must be given");
            if (fArr.length == 3) {
                for (float checkRange : fArr) {
                    checkRange(checkRange, 0.0f, 1.0f);
                }
                this.backgroundRGB = fArr;
                return;
            }
            throw new IllegalArgumentException("Background RGB value array must have length 3.");
        }
    }
}
