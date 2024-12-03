package i0;

import android.media.MediaCodec;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.camera.core.v1;
import androidx.camera.video.internal.encoder.InvalidConfigException;
import d0.h;
import f0.e;
import f0.j;
import f0.k;
import java.io.IOException;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f15442a;

    public b() {
        boolean z10;
        if (((k) e.a(k.class)) != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f15442a = z10;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00a4 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String c(@androidx.annotation.NonNull android.media.MediaFormat r14, @androidx.annotation.NonNull android.media.MediaCodecInfo[] r15) {
        /*
            r13 = this;
            java.lang.String r0 = "bitrate"
            java.lang.String r1 = "mime"
            java.lang.String r1 = r14.getString(r1)
            java.lang.String r2 = "EncoderFinder"
            r3 = 0
            if (r1 != 0) goto L_0x0013
            java.lang.String r14 = "MediaFormat does not contain mime info."
            androidx.camera.core.v1.l(r2, r14)
            return r3
        L_0x0013:
            int r4 = r15.length
            r5 = 0
            r6 = r5
        L_0x0016:
            if (r6 >= r4) goto L_0x00a8
            r7 = r15[r6]
            boolean r8 = r7.isEncoder()
            if (r8 != 0) goto L_0x0022
            goto L_0x00a4
        L_0x0022:
            android.media.MediaCodecInfo$CodecCapabilities r8 = r7.getCapabilitiesForType(r1)     // Catch:{ IllegalArgumentException -> 0x009a, all -> 0x008f }
            r9 = 1
            if (r8 == 0) goto L_0x002b
            r10 = r9
            goto L_0x002c
        L_0x002b:
            r10 = r5
        L_0x002c:
            java.lang.String r11 = "MIME type is not supported"
            androidx.core.util.h.b(r10, r11)     // Catch:{ IllegalArgumentException -> 0x009a, all -> 0x008f }
            r10 = -1
            boolean r11 = r14.containsKey(r0)     // Catch:{ IllegalArgumentException -> 0x009a, all -> 0x008f }
            if (r11 == 0) goto L_0x0060
            android.media.MediaCodecInfo$VideoCapabilities r10 = r8.getVideoCapabilities()     // Catch:{ IllegalArgumentException -> 0x009a, all -> 0x008f }
            if (r10 == 0) goto L_0x0040
            r11 = r9
            goto L_0x0041
        L_0x0040:
            r11 = r5
        L_0x0041:
            java.lang.String r12 = "Not video codec"
            androidx.core.util.h.b(r11, r12)     // Catch:{ IllegalArgumentException -> 0x009a, all -> 0x008f }
            int r11 = r14.getInteger(r0)     // Catch:{ IllegalArgumentException -> 0x009a, all -> 0x008f }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ IllegalArgumentException -> 0x009a, all -> 0x008f }
            android.util.Range r10 = r10.getBitrateRange()     // Catch:{ IllegalArgumentException -> 0x009b, all -> 0x008c }
            java.lang.Comparable r10 = r10.clamp(r11)     // Catch:{ IllegalArgumentException -> 0x009b, all -> 0x008c }
            java.lang.Integer r10 = (java.lang.Integer) r10     // Catch:{ IllegalArgumentException -> 0x009b, all -> 0x008c }
            int r10 = r10.intValue()     // Catch:{ IllegalArgumentException -> 0x009b, all -> 0x008c }
            r14.setInteger(r0, r10)     // Catch:{ IllegalArgumentException -> 0x009b, all -> 0x008c }
            goto L_0x0061
        L_0x0060:
            r11 = r3
        L_0x0061:
            boolean r8 = r8.isFormatSupported(r14)     // Catch:{ IllegalArgumentException -> 0x009b, all -> 0x008c }
            if (r8 == 0) goto L_0x0089
            java.lang.String r8 = "No encoder found that supports requested bitrate. Adjusting bitrate to nearest supported bitrate [requested: %dbps, nearest: %dbps]"
            r12 = 2
            java.lang.Object[] r12 = new java.lang.Object[r12]     // Catch:{ IllegalArgumentException -> 0x009b, all -> 0x008c }
            r12[r5] = r11     // Catch:{ IllegalArgumentException -> 0x009b, all -> 0x008c }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ IllegalArgumentException -> 0x009b, all -> 0x008c }
            r12[r9] = r10     // Catch:{ IllegalArgumentException -> 0x009b, all -> 0x008c }
            java.lang.String r8 = java.lang.String.format(r8, r12)     // Catch:{ IllegalArgumentException -> 0x009b, all -> 0x008c }
            androidx.camera.core.v1.l(r2, r8)     // Catch:{ IllegalArgumentException -> 0x009b, all -> 0x008c }
            java.lang.String r15 = r7.getName()     // Catch:{ IllegalArgumentException -> 0x009b, all -> 0x008c }
            if (r11 == 0) goto L_0x0088
            int r1 = r11.intValue()
            r14.setInteger(r0, r1)
        L_0x0088:
            return r15
        L_0x0089:
            if (r11 == 0) goto L_0x00a4
            goto L_0x009d
        L_0x008c:
            r15 = move-exception
            r3 = r11
            goto L_0x0090
        L_0x008f:
            r15 = move-exception
        L_0x0090:
            if (r3 == 0) goto L_0x0099
            int r1 = r3.intValue()
            r14.setInteger(r0, r1)
        L_0x0099:
            throw r15
        L_0x009a:
            r11 = r3
        L_0x009b:
            if (r11 == 0) goto L_0x00a4
        L_0x009d:
            int r7 = r11.intValue()
            r14.setInteger(r0, r7)
        L_0x00a4:
            int r6 = r6 + 1
            goto L_0x0016
        L_0x00a8:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: i0.b.c(android.media.MediaFormat, android.media.MediaCodecInfo[]):java.lang.String");
    }

    private boolean d(@NonNull MediaFormat mediaFormat) {
        j jVar = (j) e.a(j.class);
        if (jVar == null) {
            return false;
        }
        return jVar.h(mediaFormat);
    }

    @NonNull
    public MediaCodec a(@NonNull MediaFormat mediaFormat) throws InvalidConfigException {
        MediaCodecList mediaCodecList = new MediaCodecList(1);
        String b10 = b(mediaFormat, mediaCodecList);
        try {
            if (!TextUtils.isEmpty(b10)) {
                return MediaCodec.createByCodecName(b10);
            }
            String string = mediaFormat.getString("mime");
            MediaCodec createEncoderByType = MediaCodec.createEncoderByType(string);
            v1.l("EncoderFinder", String.format("No encoder found that supports requested MediaFormat %s. Create encoder by MIME type. Dump codec info:\n%s", new Object[]{mediaFormat, h.b(string, createEncoderByType, mediaFormat)}));
            return createEncoderByType;
        } catch (IOException | IllegalArgumentException | NullPointerException e10) {
            boolean d10 = d(mediaFormat);
            String e11 = h.e(mediaCodecList, mediaFormat);
            throw new InvalidConfigException("Encoder cannot created: " + b10 + ", isMediaFormatInQuirk: " + d10 + "\n" + e11, e10);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0038  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String b(@androidx.annotation.NonNull android.media.MediaFormat r4, @androidx.annotation.NonNull android.media.MediaCodecList r5) {
        /*
            r3 = this;
            java.lang.String r0 = "frame-rate"
            r1 = 0
            boolean r2 = r3.f15442a     // Catch:{ all -> 0x0035 }
            if (r2 == 0) goto L_0x001d
            boolean r2 = r4.containsKey(r0)     // Catch:{ all -> 0x0035 }
            if (r2 == 0) goto L_0x001d
            int r2 = r4.getInteger(r0)     // Catch:{ all -> 0x0035 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0035 }
            r4.setString(r0, r1)     // Catch:{ all -> 0x001a }
            r1 = r2
            goto L_0x001d
        L_0x001a:
            r5 = move-exception
            r1 = r2
            goto L_0x0036
        L_0x001d:
            java.lang.String r2 = r5.findEncoderForFormat(r4)     // Catch:{ all -> 0x0035 }
            if (r2 != 0) goto L_0x002b
            android.media.MediaCodecInfo[] r5 = r5.getCodecInfos()     // Catch:{ all -> 0x0035 }
            java.lang.String r2 = r3.c(r4, r5)     // Catch:{ all -> 0x0035 }
        L_0x002b:
            if (r1 == 0) goto L_0x0034
            int r5 = r1.intValue()
            r4.setInteger(r0, r5)
        L_0x0034:
            return r2
        L_0x0035:
            r5 = move-exception
        L_0x0036:
            if (r1 == 0) goto L_0x003f
            int r1 = r1.intValue()
            r4.setInteger(r0, r1)
        L_0x003f:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: i0.b.b(android.media.MediaFormat, android.media.MediaCodecList):java.lang.String");
    }
}
