package d0;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.camera.core.v1;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import e0.e;
import e0.m;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public final class h {
    private static void a(@NonNull StringBuilder sb2, @NonNull MediaCodecInfo.AudioCapabilities audioCapabilities, @NonNull MediaFormat mediaFormat) {
        h(sb2, "[AudioCaps] getBitrateRange = " + audioCapabilities.getBitrateRange());
        h(sb2, "[AudioCaps] getMaxInputChannelCount = " + audioCapabilities.getMaxInputChannelCount());
        if (Build.VERSION.SDK_INT >= 31) {
            h(sb2, "[AudioCaps] getMinInputChannelCount = " + m.b(audioCapabilities));
            h(sb2, "[AudioCaps] getInputChannelCountRanges = " + Arrays.toString(m.a(audioCapabilities)));
        }
        h(sb2, "[AudioCaps] getSupportedSampleRateRanges = " + Arrays.toString(audioCapabilities.getSupportedSampleRateRanges()));
        h(sb2, "[AudioCaps] getSupportedSampleRates = " + Arrays.toString(audioCapabilities.getSupportedSampleRates()));
        try {
            int integer = mediaFormat.getInteger("sample-rate");
            h(sb2, "[AudioCaps] isSampleRateSupported for " + integer + " = " + audioCapabilities.isSampleRateSupported(integer));
        } catch (IllegalArgumentException | NullPointerException unused) {
            h(sb2, "[AudioCaps] mediaFormat does not contain sample rate");
        }
    }

    @NonNull
    public static String b(@NonNull String str, @NonNull MediaCodec mediaCodec, @NonNull MediaFormat mediaFormat) {
        boolean z10;
        StringBuilder sb2 = new StringBuilder();
        try {
            MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodec.getCodecInfo().getCapabilitiesForType(str);
            if (capabilitiesForType != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            androidx.core.util.h.a(z10);
            c(sb2, capabilitiesForType, mediaFormat);
        } catch (IllegalArgumentException unused) {
            h(sb2, "[" + mediaCodec.getName() + "] does not support mime " + str);
        }
        return sb2.toString();
    }

    private static void c(@NonNull StringBuilder sb2, @NonNull MediaCodecInfo.CodecCapabilities codecCapabilities, @NonNull MediaFormat mediaFormat) {
        try {
            h(sb2, "[CodecCaps] isFormatSupported = " + codecCapabilities.isFormatSupported(mediaFormat));
        } catch (ClassCastException unused) {
            h(sb2, "[CodecCaps] isFormatSupported=false");
        }
        h(sb2, "[CodecCaps] getDefaultFormat = " + codecCapabilities.getDefaultFormat());
        if (codecCapabilities.profileLevels != null) {
            StringBuilder sb3 = new StringBuilder("[");
            ArrayList arrayList = new ArrayList();
            for (MediaCodecInfo.CodecProfileLevel l10 : codecCapabilities.profileLevels) {
                arrayList.add(l(l10));
            }
            sb3.append(TextUtils.join(", ", arrayList));
            sb3.append("]");
            h(sb2, "[CodecCaps] profileLevels = " + sb3);
        }
        if (codecCapabilities.colorFormats != null) {
            h(sb2, "[CodecCaps] colorFormats = " + Arrays.toString(codecCapabilities.colorFormats));
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities != null) {
            f(sb2, videoCapabilities, mediaFormat);
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities != null) {
            a(sb2, audioCapabilities, mediaFormat);
        }
        MediaCodecInfo.EncoderCapabilities encoderCapabilities = codecCapabilities.getEncoderCapabilities();
        if (encoderCapabilities != null) {
            d(sb2, encoderCapabilities, mediaFormat);
        }
    }

    private static void d(@NonNull StringBuilder sb2, @NonNull MediaCodecInfo.EncoderCapabilities encoderCapabilities, @NonNull MediaFormat mediaFormat) {
        h(sb2, "[EncoderCaps] getComplexityRange = " + encoderCapabilities.getComplexityRange());
        if (Build.VERSION.SDK_INT >= 28) {
            h(sb2, "[EncoderCaps] getQualityRange = " + e.a(encoderCapabilities));
        }
        try {
            int integer = mediaFormat.getInteger("bitrate-mode");
            h(sb2, "[EncoderCaps] isBitrateModeSupported = " + encoderCapabilities.isBitrateModeSupported(integer));
        } catch (IllegalArgumentException | NullPointerException unused) {
            h(sb2, "[EncoderCaps] mediaFormat does not contain bitrate mode");
        }
    }

    @NonNull
    public static String e(@NonNull MediaCodecList mediaCodecList, @NonNull MediaFormat mediaFormat) {
        boolean z10;
        StringBuilder sb2 = new StringBuilder();
        h(sb2, "[Start] Dump MediaCodecList for mediaFormat " + mediaFormat);
        String string = mediaFormat.getString("mime");
        for (MediaCodecInfo mediaCodecInfo : mediaCodecList.getCodecInfos()) {
            if (mediaCodecInfo.isEncoder()) {
                boolean z11 = true;
                if (string != null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                try {
                    androidx.core.util.h.a(z10);
                    MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(string);
                    if (capabilitiesForType == null) {
                        z11 = false;
                    }
                    androidx.core.util.h.a(z11);
                    h(sb2, "[Start] [" + mediaCodecInfo.getName() + "]");
                    c(sb2, capabilitiesForType, mediaFormat);
                    h(sb2, "[End] [" + mediaCodecInfo.getName() + "]");
                } catch (IllegalArgumentException unused) {
                    h(sb2, "[" + mediaCodecInfo.getName() + "] does not support mime " + string);
                }
            }
        }
        h(sb2, "[End] Dump MediaCodecList");
        String sb3 = sb2.toString();
        k(sb3);
        return sb3;
    }

    private static void f(@NonNull StringBuilder sb2, @NonNull MediaCodecInfo.VideoCapabilities videoCapabilities, @NonNull MediaFormat mediaFormat) {
        boolean z10;
        int i10;
        int i11;
        boolean z11;
        h(sb2, "[VideoCaps] getBitrateRange = " + videoCapabilities.getBitrateRange());
        h(sb2, "[VideoCaps] getSupportedWidths = " + videoCapabilities.getSupportedWidths() + ", getWidthAlignment = " + videoCapabilities.getWidthAlignment());
        h(sb2, "[VideoCaps] getSupportedHeights = " + videoCapabilities.getSupportedHeights() + ", getHeightAlignment = " + videoCapabilities.getHeightAlignment());
        boolean z12 = true;
        int i12 = 0;
        try {
            i11 = mediaFormat.getInteger(ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
            i10 = mediaFormat.getInteger(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
            if (i11 <= 0 || i10 <= 0) {
                z11 = false;
            } else {
                z11 = true;
            }
            androidx.core.util.h.a(z11);
            z10 = true;
        } catch (IllegalArgumentException | NullPointerException unused) {
            h(sb2, "[VideoCaps] mediaFormat does not contain valid width and height");
            i11 = 0;
            i10 = 0;
            z10 = false;
        }
        if (z10) {
            try {
                h(sb2, "[VideoCaps] getSupportedHeightsFor " + i11 + " = " + videoCapabilities.getSupportedHeightsFor(i11));
            } catch (IllegalArgumentException unused2) {
                h(sb2, "[VideoCaps] could not getSupportedHeightsFor " + i11);
            }
            try {
                h(sb2, "[VideoCaps] getSupportedWidthsFor " + i10 + " = " + videoCapabilities.getSupportedWidthsFor(i10));
            } catch (IllegalArgumentException unused3) {
                h(sb2, "[VideoCaps] could not getSupportedWidthsFor " + i10);
            }
            h(sb2, "[VideoCaps] isSizeSupported for " + i11 + "x" + i10 + " = " + videoCapabilities.isSizeSupported(i11, i10));
        }
        h(sb2, "[VideoCaps] getSupportedFrameRates = " + videoCapabilities.getSupportedFrameRates());
        try {
            int integer = mediaFormat.getInteger("frame-rate");
            if (integer <= 0) {
                z12 = false;
            }
            androidx.core.util.h.a(z12);
            i12 = integer;
        } catch (IllegalArgumentException | NullPointerException unused4) {
            h(sb2, "[VideoCaps] mediaFormat does not contain frame rate");
        }
        if (z10) {
            h(sb2, "[VideoCaps] getSupportedFrameRatesFor " + i11 + "x" + i10 + " = " + videoCapabilities.getSupportedFrameRatesFor(i11, i10));
        }
        if (z10 && i12 > 0) {
            h(sb2, "[VideoCaps] areSizeAndRateSupported for " + i11 + "x" + i10 + ", " + i12 + " = " + videoCapabilities.areSizeAndRateSupported(i11, i10, (double) i12));
        }
    }

    private static String g(long j10) {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        long hours = timeUnit.toHours(j10);
        TimeUnit timeUnit2 = TimeUnit.HOURS;
        long minutes = timeUnit.toMinutes(j10 - timeUnit2.toMillis(hours));
        TimeUnit timeUnit3 = TimeUnit.MINUTES;
        long seconds = timeUnit.toSeconds((j10 - timeUnit2.toMillis(hours)) - timeUnit3.toMillis(minutes));
        return String.format(Locale.US, "%02d:%02d:%02d.%03d", new Object[]{Long.valueOf(hours), Long.valueOf(minutes), Long.valueOf(seconds), Long.valueOf(((j10 - timeUnit2.toMillis(hours)) - timeUnit3.toMillis(minutes)) - TimeUnit.SECONDS.toMillis(seconds))});
    }

    private static void h(@NonNull StringBuilder sb2, @NonNull String str) {
        sb2.append(str);
        sb2.append("\n");
    }

    @NonNull
    public static String i(long j10) {
        return g(j10);
    }

    @NonNull
    public static String j(long j10) {
        return i(TimeUnit.MICROSECONDS.toMillis(j10));
    }

    private static void k(@NonNull String str) {
        if (v1.g("DebugUtils")) {
            Scanner scanner = new Scanner(str);
            while (scanner.hasNextLine()) {
                v1.e("DebugUtils", scanner.nextLine());
            }
        }
    }

    @NonNull
    private static String l(MediaCodecInfo.CodecProfileLevel codecProfileLevel) {
        if (codecProfileLevel == null) {
            return "null";
        }
        return String.format("{level=%d, profile=%d}", new Object[]{Integer.valueOf(codecProfileLevel.level), Integer.valueOf(codecProfileLevel.profile)});
    }
}
