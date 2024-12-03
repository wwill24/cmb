package com.google.android.gms.internal.gtm;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import com.google.android.gms.common.internal.p;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Locale;
import java.util.Map;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import rd.u;

final class zzfe extends zzbs {
    /* access modifiers changed from: private */
    public static final byte[] zza = "\n".getBytes();
    private final String zzb = String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", new Object[]{"GoogleAnalytics", zzbt.zza, Build.VERSION.RELEASE, zzfs.zzd(Locale.getDefault()), Build.MODEL, Build.ID});
    private final zzfo zzc;

    zzfe(zzbv zzbv) {
        super(zzbv);
        this.zzc = new zzfo(zzbv.zzr());
    }

    /* JADX WARNING: type inference failed for: r2v2 */
    /* JADX WARNING: type inference failed for: r2v3, types: [java.io.OutputStream] */
    /* JADX WARNING: type inference failed for: r2v4, types: [java.net.HttpURLConnection] */
    /* JADX WARNING: type inference failed for: r2v5 */
    /* JADX WARNING: type inference failed for: r2v6 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x007c A[SYNTHETIC, Splitter:B:29:0x007c] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0091 A[SYNTHETIC, Splitter:B:38:0x0091] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzg(java.net.URL r6, byte[] r7) {
        /*
            r5 = this;
            java.lang.String r0 = "Error closing http post connection output stream"
            com.google.android.gms.common.internal.p.k(r6)
            com.google.android.gms.common.internal.p.k(r7)
            int r1 = r7.length
            java.lang.Integer r2 = java.lang.Integer.valueOf(r1)
            java.lang.String r3 = "POST bytes, url"
            r5.zzH(r3, r2, r6)
            boolean r2 = com.google.android.gms.internal.gtm.zzbr.zzV()
            if (r2 == 0) goto L_0x0022
            java.lang.String r2 = new java.lang.String
            r2.<init>(r7)
            java.lang.String r3 = "Post payload\n"
            r5.zzP(r3, r2)
        L_0x0022:
            r2 = 0
            android.content.Context r3 = r5.zzo()     // Catch:{ IOException -> 0x0072, all -> 0x006e }
            r3.getPackageName()     // Catch:{ IOException -> 0x0072, all -> 0x006e }
            java.net.HttpURLConnection r6 = r5.zzb(r6)     // Catch:{ IOException -> 0x0072, all -> 0x006e }
            r3 = 1
            r6.setDoOutput(r3)     // Catch:{ IOException -> 0x0069, all -> 0x0067 }
            r6.setFixedLengthStreamingMode(r1)     // Catch:{ IOException -> 0x0069, all -> 0x0067 }
            r6.connect()     // Catch:{ IOException -> 0x0069, all -> 0x0067 }
            java.io.OutputStream r2 = r6.getOutputStream()     // Catch:{ IOException -> 0x0069, all -> 0x0067 }
            r2.write(r7)     // Catch:{ IOException -> 0x0069, all -> 0x0067 }
            r5.zzk(r6)     // Catch:{ IOException -> 0x0069, all -> 0x0067 }
            int r7 = r6.getResponseCode()     // Catch:{ IOException -> 0x0069, all -> 0x0067 }
            r1 = 200(0xc8, float:2.8E-43)
            if (r7 != r1) goto L_0x0052
            com.google.android.gms.internal.gtm.zzbq r7 = r5.zzs()     // Catch:{ IOException -> 0x0069, all -> 0x0067 }
            r7.zzi()     // Catch:{ IOException -> 0x0069, all -> 0x0067 }
            r7 = r1
        L_0x0052:
            java.lang.String r1 = "POST status"
            java.lang.Integer r3 = java.lang.Integer.valueOf(r7)     // Catch:{ IOException -> 0x0069, all -> 0x0067 }
            r5.zzG(r1, r3)     // Catch:{ IOException -> 0x0069, all -> 0x0067 }
            r2.close()     // Catch:{ IOException -> 0x005f }
            goto L_0x0063
        L_0x005f:
            r1 = move-exception
            r5.zzK(r0, r1)
        L_0x0063:
            r6.disconnect()
            return r7
        L_0x0067:
            r7 = move-exception
            goto L_0x008f
        L_0x0069:
            r7 = move-exception
            r4 = r2
            r2 = r6
            r6 = r4
            goto L_0x0075
        L_0x006e:
            r6 = move-exception
            r7 = r6
            r6 = r2
            goto L_0x008f
        L_0x0072:
            r6 = move-exception
            r7 = r6
            r6 = r2
        L_0x0075:
            java.lang.String r1 = "Network POST connection error"
            r5.zzS(r1, r7)     // Catch:{ all -> 0x008b }
            if (r6 == 0) goto L_0x0084
            r6.close()     // Catch:{ IOException -> 0x0080 }
            goto L_0x0084
        L_0x0080:
            r6 = move-exception
            r5.zzK(r0, r6)
        L_0x0084:
            if (r2 == 0) goto L_0x0089
            r2.disconnect()
        L_0x0089:
            r6 = 0
            return r6
        L_0x008b:
            r7 = move-exception
            r4 = r2
            r2 = r6
            r6 = r4
        L_0x008f:
            if (r2 == 0) goto L_0x0099
            r2.close()     // Catch:{ IOException -> 0x0095 }
            goto L_0x0099
        L_0x0095:
            r1 = move-exception
            r5.zzK(r0, r1)
        L_0x0099:
            if (r6 == 0) goto L_0x009e
            r6.disconnect()
        L_0x009e:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzfe.zzg(java.net.URL, byte[]):int");
    }

    private final URL zzh() {
        String str;
        zzw();
        String zzi = zzct.zzi();
        zzw();
        String zzb2 = zzeu.zzt.zzb();
        if (zzb2.length() != 0) {
            str = zzi.concat(zzb2);
        } else {
            str = new String(zzi);
        }
        try {
            return new URL(str);
        } catch (MalformedURLException e10) {
            zzK("Error trying to parse the hardcoded host url", e10);
            return null;
        }
    }

    private final URL zzi(zzex zzex) {
        String str;
        String str2;
        if (zzex.zzh()) {
            zzw();
            String zzi = zzct.zzi();
            zzw();
            String zzj = zzct.zzj();
            if (zzj.length() != 0) {
                str = zzi.concat(zzj);
                return new URL(str);
            }
            str2 = new String(zzi);
        } else {
            zzw();
            String zzk = zzct.zzk();
            zzw();
            String zzj2 = zzct.zzj();
            if (zzj2.length() != 0) {
                str = zzk.concat(zzj2);
                return new URL(str);
            }
            str2 = new String(zzk);
        }
        str = str2;
        try {
            return new URL(str);
        } catch (MalformedURLException e10) {
            zzK("Error trying to parse the hardcoded host url", e10);
            return null;
        }
    }

    private final URL zzj(zzex zzex, String str) {
        String str2;
        if (zzex.zzh()) {
            zzw();
            String zzi = zzct.zzi();
            zzw();
            String zzj = zzct.zzj();
            int length = zzi.length();
            StringBuilder sb2 = new StringBuilder(length + 1 + zzj.length() + str.length());
            sb2.append(zzi);
            sb2.append(zzj);
            sb2.append(TypeDescription.Generic.OfWildcardType.SYMBOL);
            sb2.append(str);
            str2 = sb2.toString();
        } else {
            zzw();
            String zzk = zzct.zzk();
            zzw();
            String zzj2 = zzct.zzj();
            int length2 = zzk.length();
            StringBuilder sb3 = new StringBuilder(length2 + 1 + zzj2.length() + str.length());
            sb3.append(zzk);
            sb3.append(zzj2);
            sb3.append(TypeDescription.Generic.OfWildcardType.SYMBOL);
            sb3.append(str);
            str2 = sb3.toString();
        }
        try {
            return new URL(str2);
        } catch (MalformedURLException e10) {
            zzK("Error trying to parse the hardcoded host url", e10);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x001f A[SYNTHETIC, Splitter:B:18:0x001f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzk(java.net.HttpURLConnection r4) throws java.io.IOException {
        /*
            r3 = this;
            java.lang.String r0 = "Error closing http connection input stream"
            java.io.InputStream r4 = r4.getInputStream()     // Catch:{ all -> 0x001b }
            r1 = 1024(0x400, float:1.435E-42)
            byte[] r1 = new byte[r1]     // Catch:{ all -> 0x0019 }
        L_0x000a:
            int r2 = r4.read(r1)     // Catch:{ all -> 0x0019 }
            if (r2 > 0) goto L_0x000a
            r4.close()     // Catch:{ IOException -> 0x0014 }
            return
        L_0x0014:
            r4 = move-exception
            r3.zzK(r0, r4)
            return
        L_0x0019:
            r1 = move-exception
            goto L_0x001d
        L_0x001b:
            r1 = move-exception
            r4 = 0
        L_0x001d:
            if (r4 == 0) goto L_0x0027
            r4.close()     // Catch:{ IOException -> 0x0023 }
            goto L_0x0027
        L_0x0023:
            r4 = move-exception
            r3.zzK(r0, r4)
        L_0x0027:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzfe.zzk(java.net.HttpURLConnection):void");
    }

    private static final void zzl(StringBuilder sb2, String str, String str2) throws UnsupportedEncodingException {
        if (sb2.length() != 0) {
            sb2.append('&');
        }
        sb2.append(URLEncoder.encode(str, "UTF-8"));
        sb2.append(SignatureVisitor.INSTANCEOF);
        sb2.append(URLEncoder.encode(str2, "UTF-8"));
    }

    /* access modifiers changed from: package-private */
    public final String zza(zzex zzex, boolean z10) {
        String str;
        p.k(zzex);
        StringBuilder sb2 = new StringBuilder();
        try {
            for (Map.Entry next : zzex.zzg().entrySet()) {
                String str2 = (String) next.getKey();
                if (!"ht".equals(str2) && !"qt".equals(str2) && !"AppUID".equals(str2) && !"z".equals(str2) && !"_gmsv".equals(str2)) {
                    zzl(sb2, str2, (String) next.getValue());
                }
            }
            zzl(sb2, "ht", String.valueOf(zzex.zzd()));
            zzl(sb2, "qt", String.valueOf(zzC().currentTimeMillis() - zzex.zzd()));
            zzw();
            if (z10) {
                long zzc2 = zzex.zzc();
                if (zzc2 != 0) {
                    str = String.valueOf(zzc2);
                } else {
                    str = String.valueOf(zzex.zzb());
                }
                zzl(sb2, "z", str);
            }
            return sb2.toString();
        } catch (UnsupportedEncodingException e10) {
            zzK("Failed to encode name or value", e10);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final HttpURLConnection zzb(URL url) throws IOException {
        URLConnection openConnection = url.openConnection();
        if (openConnection instanceof HttpURLConnection) {
            HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
            httpURLConnection.setDefaultUseCaches(false);
            zzw();
            httpURLConnection.setConnectTimeout(zzeu.zzE.zzb().intValue());
            zzw();
            httpURLConnection.setReadTimeout(zzeu.zzF.zzb().intValue());
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setRequestProperty("User-Agent", this.zzb);
            httpURLConnection.setDoInput(true);
            return httpURLConnection;
        }
        throw new IOException("Failed to obtain http connection");
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x0225  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x02bc  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x02c3  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x0322 A[EDGE_INSN: B:157:0x0322->B:153:0x0322 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x01be A[SYNTHETIC, Splitter:B:77:0x01be] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x01c9  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01d8 A[SYNTHETIC, Splitter:B:87:0x01d8] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01e3  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x01f1  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x01ff  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<java.lang.Long> zzc(java.util.List<com.google.android.gms.internal.gtm.zzex> r20) {
        /*
            r19 = this;
            r1 = r19
            java.lang.String r2 = "Error closing http compressed post connection output stream"
            rd.u.h()
            r19.zzW()
            com.google.android.gms.common.internal.p.k(r20)
            com.google.android.gms.internal.gtm.zzct r0 = r19.zzw()
            java.util.Set r0 = r0.zza()
            boolean r0 = r0.isEmpty()
            r4 = 1
            if (r0 != 0) goto L_0x0088
            com.google.android.gms.internal.gtm.zzfo r0 = r1.zzc
            r19.zzw()
            com.google.android.gms.internal.gtm.zzet<java.lang.Integer> r5 = com.google.android.gms.internal.gtm.zzeu.zzC
            java.lang.Object r5 = r5.zzb()
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            long r5 = (long) r5
            r7 = 1000(0x3e8, double:4.94E-321)
            long r5 = r5 * r7
            boolean r0 = r0.zzc(r5)
            if (r0 != 0) goto L_0x0038
            goto L_0x0088
        L_0x0038:
            r19.zzw()
            com.google.android.gms.internal.gtm.zzet<java.lang.String> r0 = com.google.android.gms.internal.gtm.zzeu.zzv
            java.lang.Object r0 = r0.zzb()
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r5 = "BATCH_BY_SESSION"
            boolean r5 = r5.equalsIgnoreCase(r0)
            if (r5 == 0) goto L_0x004d
        L_0x004b:
            r0 = r4
            goto L_0x0072
        L_0x004d:
            java.lang.String r5 = "BATCH_BY_TIME"
            boolean r5 = r5.equalsIgnoreCase(r0)
            if (r5 == 0) goto L_0x0056
            goto L_0x004b
        L_0x0056:
            java.lang.String r5 = "BATCH_BY_BRUTE_FORCE"
            boolean r5 = r5.equalsIgnoreCase(r0)
            if (r5 == 0) goto L_0x005f
            goto L_0x004b
        L_0x005f:
            java.lang.String r5 = "BATCH_BY_COUNT"
            boolean r5 = r5.equalsIgnoreCase(r0)
            if (r5 == 0) goto L_0x0068
            goto L_0x004b
        L_0x0068:
            java.lang.String r5 = "BATCH_BY_SIZE"
            boolean r0 = r5.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x0071
            goto L_0x004b
        L_0x0071:
            r0 = 0
        L_0x0072:
            r19.zzw()
            com.google.android.gms.internal.gtm.zzet<java.lang.String> r5 = com.google.android.gms.internal.gtm.zzeu.zzw
            java.lang.Object r5 = r5.zzb()
            java.lang.String r5 = (java.lang.String) r5
            java.lang.String r6 = "GZIP"
            boolean r5 = r6.equalsIgnoreCase(r5)
            if (r4 == r5) goto L_0x0086
            goto L_0x0089
        L_0x0086:
            r5 = r4
            goto L_0x008a
        L_0x0088:
            r0 = 0
        L_0x0089:
            r5 = 0
        L_0x008a:
            r6 = 200(0xc8, float:2.8E-43)
            if (r0 == 0) goto L_0x0225
            boolean r0 = r20.isEmpty()
            r0 = r0 ^ r4
            com.google.android.gms.common.internal.p.a(r0)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r5)
            int r8 = r20.size()
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            java.lang.String r9 = "Uploading batched hits. compression, count"
            r1.zzQ(r9, r0, r8)
            com.google.android.gms.internal.gtm.zzfd r8 = new com.google.android.gms.internal.gtm.zzfd
            r8.<init>(r1)
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            java.util.Iterator r0 = r20.iterator()
        L_0x00b5:
            boolean r10 = r0.hasNext()
            if (r10 == 0) goto L_0x00d4
            java.lang.Object r10 = r0.next()
            com.google.android.gms.internal.gtm.zzex r10 = (com.google.android.gms.internal.gtm.zzex) r10
            boolean r11 = r8.zzb(r10)
            if (r11 != 0) goto L_0x00c8
            goto L_0x00d4
        L_0x00c8:
            long r10 = r10.zzb()
            java.lang.Long r10 = java.lang.Long.valueOf(r10)
            r9.add(r10)
            goto L_0x00b5
        L_0x00d4:
            int r0 = r8.zza()
            if (r0 != 0) goto L_0x00dc
            goto L_0x0224
        L_0x00dc:
            java.net.URL r0 = r19.zzh()
            if (r0 != 0) goto L_0x00ed
            java.lang.String r0 = "Failed to build batching endpoint url"
            r1.zzJ(r0)
            java.util.List r9 = java.util.Collections.emptyList()
            goto L_0x0224
        L_0x00ed:
            if (r5 == 0) goto L_0x01e7
            byte[] r5 = r8.zzc()
            com.google.android.gms.common.internal.p.k(r0)
            com.google.android.gms.common.internal.p.k(r5)
            android.content.Context r10 = r19.zzo()     // Catch:{ IOException -> 0x01b3, all -> 0x01ad }
            r10.getPackageName()     // Catch:{ IOException -> 0x01b3, all -> 0x01ad }
            java.io.ByteArrayOutputStream r10 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x01b3, all -> 0x01ad }
            r10.<init>()     // Catch:{ IOException -> 0x01b3, all -> 0x01ad }
            java.util.zip.GZIPOutputStream r11 = new java.util.zip.GZIPOutputStream     // Catch:{ IOException -> 0x01b3, all -> 0x01ad }
            r11.<init>(r10)     // Catch:{ IOException -> 0x01b3, all -> 0x01ad }
            r11.write(r5)     // Catch:{ IOException -> 0x01b3, all -> 0x01ad }
            r11.close()     // Catch:{ IOException -> 0x01b3, all -> 0x01ad }
            r10.close()     // Catch:{ IOException -> 0x01b3, all -> 0x01ad }
            byte[] r10 = r10.toByteArray()     // Catch:{ IOException -> 0x01b3, all -> 0x01ad }
            java.lang.String r11 = "POST compressed size, ratio %, url"
            int r12 = r10.length     // Catch:{ IOException -> 0x01b3, all -> 0x01ad }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r12)     // Catch:{ IOException -> 0x01b3, all -> 0x01ad }
            long r14 = (long) r12     // Catch:{ IOException -> 0x01b3, all -> 0x01ad }
            r16 = 100
            long r14 = r14 * r16
            int r7 = r5.length     // Catch:{ IOException -> 0x01b3, all -> 0x01ad }
            long r3 = (long) r7     // Catch:{ IOException -> 0x01b3, all -> 0x01ad }
            long r14 = r14 / r3
            java.lang.Long r3 = java.lang.Long.valueOf(r14)     // Catch:{ IOException -> 0x01b3, all -> 0x01ad }
            r1.zzI(r11, r13, r3, r0)     // Catch:{ IOException -> 0x01b3, all -> 0x01ad }
            if (r12 <= r7) goto L_0x0138
            java.lang.String r3 = "Compressed payload is larger then uncompressed. compressed, uncompressed"
            java.lang.Integer r4 = java.lang.Integer.valueOf(r7)     // Catch:{ IOException -> 0x01b3, all -> 0x01ad }
            r1.zzT(r3, r13, r4)     // Catch:{ IOException -> 0x01b3, all -> 0x01ad }
        L_0x0138:
            boolean r3 = com.google.android.gms.internal.gtm.zzbr.zzV()     // Catch:{ IOException -> 0x01b3, all -> 0x01ad }
            if (r3 == 0) goto L_0x015b
            java.lang.String r3 = "Post payload"
            java.lang.String r4 = "\n"
            java.lang.String r7 = new java.lang.String     // Catch:{ IOException -> 0x01b3, all -> 0x01ad }
            r7.<init>(r5)     // Catch:{ IOException -> 0x01b3, all -> 0x01ad }
            int r5 = r7.length()     // Catch:{ IOException -> 0x01b3, all -> 0x01ad }
            if (r5 == 0) goto L_0x0152
            java.lang.String r4 = r4.concat(r7)     // Catch:{ IOException -> 0x01b3, all -> 0x01ad }
            goto L_0x0158
        L_0x0152:
            java.lang.String r5 = new java.lang.String     // Catch:{ IOException -> 0x01b3, all -> 0x01ad }
            r5.<init>(r4)     // Catch:{ IOException -> 0x01b3, all -> 0x01ad }
            r4 = r5
        L_0x0158:
            r1.zzP(r3, r4)     // Catch:{ IOException -> 0x01b3, all -> 0x01ad }
        L_0x015b:
            java.net.HttpURLConnection r3 = r1.zzb(r0)     // Catch:{ IOException -> 0x01b3, all -> 0x01ad }
            r0 = 1
            r3.setDoOutput(r0)     // Catch:{ IOException -> 0x01aa, all -> 0x01a4 }
            java.lang.String r0 = "Content-Encoding"
            java.lang.String r4 = "gzip"
            r3.addRequestProperty(r0, r4)     // Catch:{ IOException -> 0x01aa, all -> 0x01a4 }
            r3.setFixedLengthStreamingMode(r12)     // Catch:{ IOException -> 0x01aa, all -> 0x01a4 }
            r3.connect()     // Catch:{ IOException -> 0x01aa, all -> 0x01a4 }
            java.io.OutputStream r4 = r3.getOutputStream()     // Catch:{ IOException -> 0x01aa, all -> 0x01a4 }
            r4.write(r10)     // Catch:{ IOException -> 0x019f, all -> 0x019a }
            r4.close()     // Catch:{ IOException -> 0x019f, all -> 0x019a }
            r1.zzk(r3)     // Catch:{ IOException -> 0x01aa, all -> 0x01a4 }
            int r0 = r3.getResponseCode()     // Catch:{ IOException -> 0x01aa, all -> 0x01a4 }
            if (r0 != r6) goto L_0x018b
            com.google.android.gms.internal.gtm.zzbq r0 = r19.zzs()     // Catch:{ IOException -> 0x01aa, all -> 0x01a4 }
            r0.zzi()     // Catch:{ IOException -> 0x01aa, all -> 0x01a4 }
            r0 = r6
        L_0x018b:
            java.lang.String r4 = "POST status"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r0)     // Catch:{ IOException -> 0x01aa, all -> 0x01a4 }
            r1.zzG(r4, r5)     // Catch:{ IOException -> 0x01aa, all -> 0x01a4 }
            r3.disconnect()
            r3 = r0
            goto L_0x01ef
        L_0x019a:
            r0 = move-exception
            r16 = r3
            r7 = r4
            goto L_0x01a8
        L_0x019f:
            r0 = move-exception
            r7 = r3
            r16 = r4
            goto L_0x01b7
        L_0x01a4:
            r0 = move-exception
            r16 = r3
            r7 = 0
        L_0x01a8:
            r3 = r0
            goto L_0x01d6
        L_0x01aa:
            r0 = move-exception
            r7 = r3
            goto L_0x01b5
        L_0x01ad:
            r0 = move-exception
            r3 = r0
            r7 = 0
            r16 = 0
            goto L_0x01d6
        L_0x01b3:
            r0 = move-exception
            r7 = 0
        L_0x01b5:
            r16 = 0
        L_0x01b7:
            java.lang.String r3 = "Network compressed POST connection error"
            r1.zzS(r3, r0)     // Catch:{ all -> 0x01ce }
            if (r16 == 0) goto L_0x01c7
            r16.close()     // Catch:{ IOException -> 0x01c2 }
            goto L_0x01c7
        L_0x01c2:
            r0 = move-exception
            r3 = r0
            r1.zzK(r2, r3)
        L_0x01c7:
            if (r7 == 0) goto L_0x01cc
            r7.disconnect()
        L_0x01cc:
            r3 = 0
            goto L_0x01ef
        L_0x01ce:
            r0 = move-exception
            r3 = r0
            r18 = r16
            r16 = r7
            r7 = r18
        L_0x01d6:
            if (r7 == 0) goto L_0x01e1
            r7.close()     // Catch:{ IOException -> 0x01dc }
            goto L_0x01e1
        L_0x01dc:
            r0 = move-exception
            r4 = r0
            r1.zzK(r2, r4)
        L_0x01e1:
            if (r16 == 0) goto L_0x01e6
            r16.disconnect()
        L_0x01e6:
            throw r3
        L_0x01e7:
            byte[] r2 = r8.zzc()
            int r3 = r1.zzg(r0, r2)
        L_0x01ef:
            if (r3 != r6) goto L_0x01ff
            int r0 = r8.zza()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r2 = "Batched upload completed. Hits batched"
            r1.zzP(r2, r0)
            goto L_0x0224
        L_0x01ff:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r3)
            java.lang.String r2 = "Network error uploading hits. status code"
            r1.zzP(r2, r0)
            com.google.android.gms.internal.gtm.zzct r2 = r19.zzw()
            java.util.Set r2 = r2.zza()
            boolean r0 = r2.contains(r0)
            if (r0 == 0) goto L_0x0220
            java.lang.String r0 = "Server instructed the client to stop batching"
            r1.zzR(r0)
            com.google.android.gms.internal.gtm.zzfo r0 = r1.zzc
            r0.zzb()
        L_0x0220:
            java.util.List r9 = java.util.Collections.emptyList()
        L_0x0224:
            return r9
        L_0x0225:
            java.util.ArrayList r2 = new java.util.ArrayList
            int r0 = r20.size()
            r2.<init>(r0)
            java.util.Iterator r0 = r20.iterator()
        L_0x0232:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x0322
            java.lang.Object r3 = r0.next()
            com.google.android.gms.internal.gtm.zzex r3 = (com.google.android.gms.internal.gtm.zzex) r3
            com.google.android.gms.common.internal.p.k(r3)
            boolean r4 = r3.zzh()
            r5 = 1
            r4 = r4 ^ r5
            java.lang.String r4 = r1.zza(r3, r4)
            if (r4 != 0) goto L_0x0259
            com.google.android.gms.internal.gtm.zzfb r4 = r19.zzz()
            java.lang.String r7 = "Error formatting hit for upload"
            r4.zzb(r3, r7)
        L_0x0256:
            r4 = 0
            goto L_0x030a
        L_0x0259:
            int r7 = r4.length()
            r19.zzw()
            com.google.android.gms.internal.gtm.zzet<java.lang.Integer> r8 = com.google.android.gms.internal.gtm.zzeu.zzu
            java.lang.Object r8 = r8.zzb()
            java.lang.Integer r8 = (java.lang.Integer) r8
            int r8 = r8.intValue()
            if (r7 > r8) goto L_0x02c7
            java.net.URL r4 = r1.zzj(r3, r4)
            if (r4 != 0) goto L_0x027b
            java.lang.String r0 = "Failed to build collect GET endpoint url"
            r1.zzJ(r0)
            goto L_0x0322
        L_0x027b:
            com.google.android.gms.common.internal.p.k(r4)
            java.lang.String r7 = "GET request"
            r1.zzG(r7, r4)
            java.net.HttpURLConnection r4 = r1.zzb(r4)     // Catch:{ IOException -> 0x02b3, all -> 0x02b0 }
            r4.connect()     // Catch:{ IOException -> 0x02ad, all -> 0x02aa }
            r1.zzk(r4)     // Catch:{ IOException -> 0x02ad, all -> 0x02aa }
            int r7 = r4.getResponseCode()     // Catch:{ IOException -> 0x02ad, all -> 0x02aa }
            if (r7 != r6) goto L_0x029b
            com.google.android.gms.internal.gtm.zzbq r7 = r19.zzs()     // Catch:{ IOException -> 0x02ad, all -> 0x02aa }
            r7.zzi()     // Catch:{ IOException -> 0x02ad, all -> 0x02aa }
            r7 = r6
        L_0x029b:
            java.lang.String r8 = "GET status"
            java.lang.Integer r9 = java.lang.Integer.valueOf(r7)     // Catch:{ IOException -> 0x02ad, all -> 0x02aa }
            r1.zzG(r8, r9)     // Catch:{ IOException -> 0x02ad, all -> 0x02aa }
            r4.disconnect()
            if (r7 != r6) goto L_0x0322
            goto L_0x0256
        L_0x02aa:
            r0 = move-exception
            r7 = r4
            goto L_0x02c1
        L_0x02ad:
            r0 = move-exception
            r7 = r4
            goto L_0x02b5
        L_0x02b0:
            r0 = move-exception
            r7 = 0
            goto L_0x02c1
        L_0x02b3:
            r0 = move-exception
            r7 = 0
        L_0x02b5:
            java.lang.String r3 = "Network GET connection error"
            r1.zzS(r3, r0)     // Catch:{ all -> 0x02c0 }
            if (r7 == 0) goto L_0x0322
            r7.disconnect()
            goto L_0x0322
        L_0x02c0:
            r0 = move-exception
        L_0x02c1:
            if (r7 == 0) goto L_0x02c6
            r7.disconnect()
        L_0x02c6:
            throw r0
        L_0x02c7:
            r4 = 0
            java.lang.String r7 = r1.zza(r3, r4)
            if (r7 != 0) goto L_0x02d8
            com.google.android.gms.internal.gtm.zzfb r7 = r19.zzz()
            java.lang.String r8 = "Error formatting hit for POST upload"
            r7.zzb(r3, r8)
            goto L_0x030a
        L_0x02d8:
            byte[] r7 = r7.getBytes()
            int r8 = r7.length
            r19.zzw()
            com.google.android.gms.internal.gtm.zzet<java.lang.Integer> r9 = com.google.android.gms.internal.gtm.zzeu.zzz
            java.lang.Object r9 = r9.zzb()
            java.lang.Integer r9 = (java.lang.Integer) r9
            int r9 = r9.intValue()
            if (r8 <= r9) goto L_0x02f8
            com.google.android.gms.internal.gtm.zzfb r7 = r19.zzz()
            java.lang.String r8 = "Hit payload exceeds size limit"
            r7.zzb(r3, r8)
            goto L_0x030a
        L_0x02f8:
            java.net.URL r8 = r1.zzi(r3)
            if (r8 != 0) goto L_0x0304
            java.lang.String r0 = "Failed to build collect POST endpoint url"
            r1.zzJ(r0)
            goto L_0x0322
        L_0x0304:
            int r7 = r1.zzg(r8, r7)
            if (r7 != r6) goto L_0x0322
        L_0x030a:
            long r7 = r3.zzb()
            java.lang.Long r3 = java.lang.Long.valueOf(r7)
            r2.add(r3)
            int r3 = r2.size()
            r19.zzw()
            int r7 = com.google.android.gms.internal.gtm.zzct.zzh()
            if (r3 < r7) goto L_0x0232
        L_0x0322:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzfe.zzc(java.util.List):java.util.List");
    }

    /* access modifiers changed from: protected */
    public final void zzd() {
        zzP("Network initialized. User agent", this.zzb);
    }

    public final boolean zze() {
        NetworkInfo networkInfo;
        u.h();
        zzW();
        try {
            networkInfo = ((ConnectivityManager) zzo().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (SecurityException unused) {
            networkInfo = null;
        }
        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        }
        zzO("No network connectivity");
        return false;
    }
}
