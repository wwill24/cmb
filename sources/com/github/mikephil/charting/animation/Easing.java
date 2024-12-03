package com.github.mikephil.charting.animation;

public class Easing {

    /* renamed from: com.github.mikephil.charting.animation.Easing$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$github$mikephil$charting$animation$Easing$EasingOption;

        /* JADX WARNING: Can't wrap try/catch for region: R(56:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|(3:55|56|58)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(58:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|58) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00c0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00cc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x00d8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00e4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00f0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00fc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x0108 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x0114 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x0120 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x012c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x0138 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x0144 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.github.mikephil.charting.animation.Easing$EasingOption[] r0 = com.github.mikephil.charting.animation.Easing.EasingOption.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$github$mikephil$charting$animation$Easing$EasingOption = r0
                com.github.mikephil.charting.animation.Easing$EasingOption r1 = com.github.mikephil.charting.animation.Easing.EasingOption.Linear     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$github$mikephil$charting$animation$Easing$EasingOption     // Catch:{ NoSuchFieldError -> 0x001d }
                com.github.mikephil.charting.animation.Easing$EasingOption r1 = com.github.mikephil.charting.animation.Easing.EasingOption.EaseInQuad     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$github$mikephil$charting$animation$Easing$EasingOption     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.github.mikephil.charting.animation.Easing$EasingOption r1 = com.github.mikephil.charting.animation.Easing.EasingOption.EaseOutQuad     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$github$mikephil$charting$animation$Easing$EasingOption     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.github.mikephil.charting.animation.Easing$EasingOption r1 = com.github.mikephil.charting.animation.Easing.EasingOption.EaseInOutQuad     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$github$mikephil$charting$animation$Easing$EasingOption     // Catch:{ NoSuchFieldError -> 0x003e }
                com.github.mikephil.charting.animation.Easing$EasingOption r1 = com.github.mikephil.charting.animation.Easing.EasingOption.EaseInCubic     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$github$mikephil$charting$animation$Easing$EasingOption     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.github.mikephil.charting.animation.Easing$EasingOption r1 = com.github.mikephil.charting.animation.Easing.EasingOption.EaseOutCubic     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$github$mikephil$charting$animation$Easing$EasingOption     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.github.mikephil.charting.animation.Easing$EasingOption r1 = com.github.mikephil.charting.animation.Easing.EasingOption.EaseInOutCubic     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$com$github$mikephil$charting$animation$Easing$EasingOption     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.github.mikephil.charting.animation.Easing$EasingOption r1 = com.github.mikephil.charting.animation.Easing.EasingOption.EaseInQuart     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = $SwitchMap$com$github$mikephil$charting$animation$Easing$EasingOption     // Catch:{ NoSuchFieldError -> 0x006c }
                com.github.mikephil.charting.animation.Easing$EasingOption r1 = com.github.mikephil.charting.animation.Easing.EasingOption.EaseOutQuart     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = $SwitchMap$com$github$mikephil$charting$animation$Easing$EasingOption     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.github.mikephil.charting.animation.Easing$EasingOption r1 = com.github.mikephil.charting.animation.Easing.EasingOption.EaseInOutQuart     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = $SwitchMap$com$github$mikephil$charting$animation$Easing$EasingOption     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.github.mikephil.charting.animation.Easing$EasingOption r1 = com.github.mikephil.charting.animation.Easing.EasingOption.EaseInSine     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = $SwitchMap$com$github$mikephil$charting$animation$Easing$EasingOption     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.github.mikephil.charting.animation.Easing$EasingOption r1 = com.github.mikephil.charting.animation.Easing.EasingOption.EaseOutSine     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = $SwitchMap$com$github$mikephil$charting$animation$Easing$EasingOption     // Catch:{ NoSuchFieldError -> 0x009c }
                com.github.mikephil.charting.animation.Easing$EasingOption r1 = com.github.mikephil.charting.animation.Easing.EasingOption.EaseInOutSine     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = $SwitchMap$com$github$mikephil$charting$animation$Easing$EasingOption     // Catch:{ NoSuchFieldError -> 0x00a8 }
                com.github.mikephil.charting.animation.Easing$EasingOption r1 = com.github.mikephil.charting.animation.Easing.EasingOption.EaseInExpo     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = $SwitchMap$com$github$mikephil$charting$animation$Easing$EasingOption     // Catch:{ NoSuchFieldError -> 0x00b4 }
                com.github.mikephil.charting.animation.Easing$EasingOption r1 = com.github.mikephil.charting.animation.Easing.EasingOption.EaseOutExpo     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = $SwitchMap$com$github$mikephil$charting$animation$Easing$EasingOption     // Catch:{ NoSuchFieldError -> 0x00c0 }
                com.github.mikephil.charting.animation.Easing$EasingOption r1 = com.github.mikephil.charting.animation.Easing.EasingOption.EaseInOutExpo     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r0 = $SwitchMap$com$github$mikephil$charting$animation$Easing$EasingOption     // Catch:{ NoSuchFieldError -> 0x00cc }
                com.github.mikephil.charting.animation.Easing$EasingOption r1 = com.github.mikephil.charting.animation.Easing.EasingOption.EaseInCirc     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                int[] r0 = $SwitchMap$com$github$mikephil$charting$animation$Easing$EasingOption     // Catch:{ NoSuchFieldError -> 0x00d8 }
                com.github.mikephil.charting.animation.Easing$EasingOption r1 = com.github.mikephil.charting.animation.Easing.EasingOption.EaseOutCirc     // Catch:{ NoSuchFieldError -> 0x00d8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d8 }
                r2 = 18
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00d8 }
            L_0x00d8:
                int[] r0 = $SwitchMap$com$github$mikephil$charting$animation$Easing$EasingOption     // Catch:{ NoSuchFieldError -> 0x00e4 }
                com.github.mikephil.charting.animation.Easing$EasingOption r1 = com.github.mikephil.charting.animation.Easing.EasingOption.EaseInOutCirc     // Catch:{ NoSuchFieldError -> 0x00e4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e4 }
                r2 = 19
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00e4 }
            L_0x00e4:
                int[] r0 = $SwitchMap$com$github$mikephil$charting$animation$Easing$EasingOption     // Catch:{ NoSuchFieldError -> 0x00f0 }
                com.github.mikephil.charting.animation.Easing$EasingOption r1 = com.github.mikephil.charting.animation.Easing.EasingOption.EaseInElastic     // Catch:{ NoSuchFieldError -> 0x00f0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f0 }
                r2 = 20
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00f0 }
            L_0x00f0:
                int[] r0 = $SwitchMap$com$github$mikephil$charting$animation$Easing$EasingOption     // Catch:{ NoSuchFieldError -> 0x00fc }
                com.github.mikephil.charting.animation.Easing$EasingOption r1 = com.github.mikephil.charting.animation.Easing.EasingOption.EaseOutElastic     // Catch:{ NoSuchFieldError -> 0x00fc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00fc }
                r2 = 21
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00fc }
            L_0x00fc:
                int[] r0 = $SwitchMap$com$github$mikephil$charting$animation$Easing$EasingOption     // Catch:{ NoSuchFieldError -> 0x0108 }
                com.github.mikephil.charting.animation.Easing$EasingOption r1 = com.github.mikephil.charting.animation.Easing.EasingOption.EaseInOutElastic     // Catch:{ NoSuchFieldError -> 0x0108 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0108 }
                r2 = 22
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0108 }
            L_0x0108:
                int[] r0 = $SwitchMap$com$github$mikephil$charting$animation$Easing$EasingOption     // Catch:{ NoSuchFieldError -> 0x0114 }
                com.github.mikephil.charting.animation.Easing$EasingOption r1 = com.github.mikephil.charting.animation.Easing.EasingOption.EaseInBack     // Catch:{ NoSuchFieldError -> 0x0114 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0114 }
                r2 = 23
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0114 }
            L_0x0114:
                int[] r0 = $SwitchMap$com$github$mikephil$charting$animation$Easing$EasingOption     // Catch:{ NoSuchFieldError -> 0x0120 }
                com.github.mikephil.charting.animation.Easing$EasingOption r1 = com.github.mikephil.charting.animation.Easing.EasingOption.EaseOutBack     // Catch:{ NoSuchFieldError -> 0x0120 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0120 }
                r2 = 24
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0120 }
            L_0x0120:
                int[] r0 = $SwitchMap$com$github$mikephil$charting$animation$Easing$EasingOption     // Catch:{ NoSuchFieldError -> 0x012c }
                com.github.mikephil.charting.animation.Easing$EasingOption r1 = com.github.mikephil.charting.animation.Easing.EasingOption.EaseInOutBack     // Catch:{ NoSuchFieldError -> 0x012c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x012c }
                r2 = 25
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x012c }
            L_0x012c:
                int[] r0 = $SwitchMap$com$github$mikephil$charting$animation$Easing$EasingOption     // Catch:{ NoSuchFieldError -> 0x0138 }
                com.github.mikephil.charting.animation.Easing$EasingOption r1 = com.github.mikephil.charting.animation.Easing.EasingOption.EaseInBounce     // Catch:{ NoSuchFieldError -> 0x0138 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0138 }
                r2 = 26
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0138 }
            L_0x0138:
                int[] r0 = $SwitchMap$com$github$mikephil$charting$animation$Easing$EasingOption     // Catch:{ NoSuchFieldError -> 0x0144 }
                com.github.mikephil.charting.animation.Easing$EasingOption r1 = com.github.mikephil.charting.animation.Easing.EasingOption.EaseOutBounce     // Catch:{ NoSuchFieldError -> 0x0144 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0144 }
                r2 = 27
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0144 }
            L_0x0144:
                int[] r0 = $SwitchMap$com$github$mikephil$charting$animation$Easing$EasingOption     // Catch:{ NoSuchFieldError -> 0x0150 }
                com.github.mikephil.charting.animation.Easing$EasingOption r1 = com.github.mikephil.charting.animation.Easing.EasingOption.EaseInOutBounce     // Catch:{ NoSuchFieldError -> 0x0150 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0150 }
                r2 = 28
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0150 }
            L_0x0150:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.animation.Easing.AnonymousClass1.<clinit>():void");
        }
    }

    private static class EasingFunctions {
        public static final EasingFunction EaseInBack = new EasingFunction() {
            public float getInterpolation(float f10) {
                return f10 * f10 * ((f10 * 2.70158f) - 1.70158f);
            }
        };
        public static final EasingFunction EaseInBounce = new EasingFunction() {
            public float getInterpolation(float f10) {
                return 1.0f - EasingFunctions.EaseOutBounce.getInterpolation(1.0f - f10);
            }
        };
        public static final EasingFunction EaseInCirc = new EasingFunction() {
            public float getInterpolation(float f10) {
                return -(((float) Math.sqrt((double) (1.0f - (f10 * f10)))) - 1.0f);
            }
        };
        public static final EasingFunction EaseInCubic = new EasingFunction() {
            public float getInterpolation(float f10) {
                return f10 * f10 * f10;
            }
        };
        public static final EasingFunction EaseInElastic = new EasingFunction() {
            public float getInterpolation(float f10) {
                if (f10 == 0.0f) {
                    return 0.0f;
                }
                if (f10 == 1.0f) {
                    return 1.0f;
                }
                float f11 = f10 - 1.0f;
                return -(((float) Math.pow(2.0d, (double) (10.0f * f11))) * ((float) Math.sin((((double) (f11 - (0.047746483f * ((float) Math.asin(1.0d))))) * 6.283185307179586d) / ((double) 0.3f))));
            }
        };
        public static final EasingFunction EaseInExpo = new EasingFunction() {
            public float getInterpolation(float f10) {
                if (f10 == 0.0f) {
                    return 0.0f;
                }
                return (float) Math.pow(2.0d, (double) ((f10 - 1.0f) * 10.0f));
            }
        };
        public static final EasingFunction EaseInOutBack = new EasingFunction() {
            public float getInterpolation(float f10) {
                float f11 = f10 / 0.5f;
                if (f11 < 1.0f) {
                    return f11 * f11 * ((3.5949094f * f11) - 2.5949094f) * 0.5f;
                }
                float f12 = f11 - 2.0f;
                return ((f12 * f12 * ((3.5949094f * f12) + 2.5949094f)) + 2.0f) * 0.5f;
            }
        };
        public static final EasingFunction EaseInOutBounce = new EasingFunction() {
            public float getInterpolation(float f10) {
                if (f10 < 0.5f) {
                    return EasingFunctions.EaseInBounce.getInterpolation(f10 * 2.0f) * 0.5f;
                }
                return (EasingFunctions.EaseOutBounce.getInterpolation((f10 * 2.0f) - 1.0f) * 0.5f) + 0.5f;
            }
        };
        public static final EasingFunction EaseInOutCirc = new EasingFunction() {
            public float getInterpolation(float f10) {
                float sqrt;
                float f11 = 0.5f;
                float f12 = f10 / 0.5f;
                if (f12 < 1.0f) {
                    f11 = -0.5f;
                    sqrt = ((float) Math.sqrt((double) (1.0f - (f12 * f12)))) - 1.0f;
                } else {
                    float f13 = f12 - 2.0f;
                    sqrt = ((float) Math.sqrt((double) (1.0f - (f13 * f13)))) + 1.0f;
                }
                return sqrt * f11;
            }
        };
        public static final EasingFunction EaseInOutCubic = new EasingFunction() {
            public float getInterpolation(float f10) {
                float f11 = f10 / 0.5f;
                if (f11 < 1.0f) {
                    return 0.5f * f11 * f11 * f11;
                }
                float f12 = f11 - 2.0f;
                return ((f12 * f12 * f12) + 2.0f) * 0.5f;
            }
        };
        public static final EasingFunction EaseInOutElastic = new EasingFunction() {
            public float getInterpolation(float f10) {
                if (f10 == 0.0f) {
                    return 0.0f;
                }
                float f11 = f10 / 0.5f;
                if (f11 == 2.0f) {
                    return 1.0f;
                }
                float asin = 0.07161973f * ((float) Math.asin(1.0d));
                if (f11 < 1.0f) {
                    float f12 = f11 - 1.0f;
                    return ((float) Math.pow(2.0d, (double) (10.0f * f12))) * ((float) Math.sin((((double) ((f12 * 1.0f) - asin)) * 6.283185307179586d) / ((double) 0.45000002f))) * -0.5f;
                }
                float f13 = f11 - 1.0f;
                return (((float) Math.pow(2.0d, (double) (-10.0f * f13))) * ((float) Math.sin((((double) ((f13 * 1.0f) - asin)) * 6.283185307179586d) / ((double) 0.45000002f))) * 0.5f) + 1.0f;
            }
        };
        public static final EasingFunction EaseInOutExpo = new EasingFunction() {
            public float getInterpolation(float f10) {
                float f11;
                if (f10 == 0.0f) {
                    return 0.0f;
                }
                if (f10 == 1.0f) {
                    return 1.0f;
                }
                float f12 = f10 / 0.5f;
                if (f12 < 1.0f) {
                    f11 = (float) Math.pow(2.0d, (double) ((f12 - 1.0f) * 10.0f));
                } else {
                    f11 = (-((float) Math.pow(2.0d, (double) ((f12 - 1.0f) * -10.0f)))) + 2.0f;
                }
                return f11 * 0.5f;
            }
        };
        public static final EasingFunction EaseInOutQuad = new EasingFunction() {
            public float getInterpolation(float f10) {
                float f11 = f10 / 0.5f;
                if (f11 < 1.0f) {
                    return 0.5f * f11 * f11;
                }
                float f12 = f11 - 1.0f;
                return ((f12 * (f12 - 2.0f)) - 1.0f) * -0.5f;
            }
        };
        public static final EasingFunction EaseInOutQuart = new EasingFunction() {
            public float getInterpolation(float f10) {
                float f11 = f10 / 0.5f;
                if (f11 < 1.0f) {
                    return 0.5f * f11 * f11 * f11 * f11;
                }
                float f12 = f11 - 2.0f;
                return ((((f12 * f12) * f12) * f12) - 2.0f) * -0.5f;
            }
        };
        public static final EasingFunction EaseInOutSine = new EasingFunction() {
            public float getInterpolation(float f10) {
                return (((float) Math.cos(((double) f10) * 3.141592653589793d)) - 1.0f) * -0.5f;
            }
        };
        public static final EasingFunction EaseInQuad = new EasingFunction() {
            public float getInterpolation(float f10) {
                return f10 * f10;
            }
        };
        public static final EasingFunction EaseInQuart = new EasingFunction() {
            public float getInterpolation(float f10) {
                return f10 * f10 * f10 * f10;
            }
        };
        public static final EasingFunction EaseInSine = new EasingFunction() {
            public float getInterpolation(float f10) {
                return (-((float) Math.cos(((double) f10) * 1.5707963267948966d))) + 1.0f;
            }
        };
        public static final EasingFunction EaseOutBack = new EasingFunction() {
            public float getInterpolation(float f10) {
                float f11 = f10 - 1.0f;
                return (f11 * f11 * ((f11 * 2.70158f) + 1.70158f)) + 1.0f;
            }
        };
        public static final EasingFunction EaseOutBounce = new EasingFunction() {
            public float getInterpolation(float f10) {
                if (f10 < 0.36363637f) {
                    return 7.5625f * f10 * f10;
                }
                if (f10 < 0.72727275f) {
                    float f11 = f10 - 0.54545456f;
                    return (7.5625f * f11 * f11) + 0.75f;
                } else if (f10 < 0.90909094f) {
                    float f12 = f10 - 0.8181818f;
                    return (7.5625f * f12 * f12) + 0.9375f;
                } else {
                    float f13 = f10 - 0.95454544f;
                    return (7.5625f * f13 * f13) + 0.984375f;
                }
            }
        };
        public static final EasingFunction EaseOutCirc = new EasingFunction() {
            public float getInterpolation(float f10) {
                float f11 = f10 - 1.0f;
                return (float) Math.sqrt((double) (1.0f - (f11 * f11)));
            }
        };
        public static final EasingFunction EaseOutCubic = new EasingFunction() {
            public float getInterpolation(float f10) {
                float f11 = f10 - 1.0f;
                return (f11 * f11 * f11) + 1.0f;
            }
        };
        public static final EasingFunction EaseOutElastic = new EasingFunction() {
            public float getInterpolation(float f10) {
                if (f10 == 0.0f) {
                    return 0.0f;
                }
                if (f10 == 1.0f) {
                    return 1.0f;
                }
                return (((float) Math.pow(2.0d, (double) (-10.0f * f10))) * ((float) Math.sin((((double) (f10 - (0.047746483f * ((float) Math.asin(1.0d))))) * 6.283185307179586d) / ((double) 0.3f)))) + 1.0f;
            }
        };
        public static final EasingFunction EaseOutExpo = new EasingFunction() {
            public float getInterpolation(float f10) {
                if (f10 == 1.0f) {
                    return 1.0f;
                }
                return -((float) Math.pow(2.0d, (double) ((f10 + 1.0f) * -10.0f)));
            }
        };
        public static final EasingFunction EaseOutQuad = new EasingFunction() {
            public float getInterpolation(float f10) {
                return (-f10) * (f10 - 2.0f);
            }
        };
        public static final EasingFunction EaseOutQuart = new EasingFunction() {
            public float getInterpolation(float f10) {
                float f11 = f10 - 1.0f;
                return -((((f11 * f11) * f11) * f11) - 1.0f);
            }
        };
        public static final EasingFunction EaseOutSine = new EasingFunction() {
            public float getInterpolation(float f10) {
                return (float) Math.sin(((double) f10) * 1.5707963267948966d);
            }
        };
        public static final EasingFunction Linear = new EasingFunction() {
            public float getInterpolation(float f10) {
                return f10;
            }
        };

        private EasingFunctions() {
        }
    }

    public enum EasingOption {
        Linear,
        EaseInQuad,
        EaseOutQuad,
        EaseInOutQuad,
        EaseInCubic,
        EaseOutCubic,
        EaseInOutCubic,
        EaseInQuart,
        EaseOutQuart,
        EaseInOutQuart,
        EaseInSine,
        EaseOutSine,
        EaseInOutSine,
        EaseInExpo,
        EaseOutExpo,
        EaseInOutExpo,
        EaseInCirc,
        EaseOutCirc,
        EaseInOutCirc,
        EaseInElastic,
        EaseOutElastic,
        EaseInOutElastic,
        EaseInBack,
        EaseOutBack,
        EaseInOutBack,
        EaseInBounce,
        EaseOutBounce,
        EaseInOutBounce
    }

    public static EasingFunction getEasingFunctionFromOption(EasingOption easingOption) {
        switch (AnonymousClass1.$SwitchMap$com$github$mikephil$charting$animation$Easing$EasingOption[easingOption.ordinal()]) {
            case 2:
                return EasingFunctions.EaseInQuad;
            case 3:
                return EasingFunctions.EaseOutQuad;
            case 4:
                return EasingFunctions.EaseInOutQuad;
            case 5:
                return EasingFunctions.EaseInCubic;
            case 6:
                return EasingFunctions.EaseOutCubic;
            case 7:
                return EasingFunctions.EaseInOutCubic;
            case 8:
                return EasingFunctions.EaseInQuart;
            case 9:
                return EasingFunctions.EaseOutQuart;
            case 10:
                return EasingFunctions.EaseInOutQuart;
            case 11:
                return EasingFunctions.EaseInSine;
            case 12:
                return EasingFunctions.EaseOutSine;
            case 13:
                return EasingFunctions.EaseInOutSine;
            case 14:
                return EasingFunctions.EaseInExpo;
            case 15:
                return EasingFunctions.EaseOutExpo;
            case 16:
                return EasingFunctions.EaseInOutExpo;
            case 17:
                return EasingFunctions.EaseInCirc;
            case 18:
                return EasingFunctions.EaseOutCirc;
            case 19:
                return EasingFunctions.EaseInOutCirc;
            case 20:
                return EasingFunctions.EaseInElastic;
            case 21:
                return EasingFunctions.EaseOutElastic;
            case 22:
                return EasingFunctions.EaseInOutElastic;
            case 23:
                return EasingFunctions.EaseInBack;
            case 24:
                return EasingFunctions.EaseOutBack;
            case 25:
                return EasingFunctions.EaseInOutBack;
            case 26:
                return EasingFunctions.EaseInBounce;
            case 27:
                return EasingFunctions.EaseOutBounce;
            case 28:
                return EasingFunctions.EaseInOutBounce;
            default:
                return EasingFunctions.Linear;
        }
    }
}
