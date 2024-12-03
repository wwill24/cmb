package com.github.mikephil.charting.utils;

import android.os.Environment;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    private static final String LOG = "MPChart-FileUtils";

    /* JADX WARNING: Removed duplicated region for block: B:18:0x004f A[SYNTHETIC, Splitter:B:18:0x004f] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x005a A[SYNTHETIC, Splitter:B:24:0x005a] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<com.github.mikephil.charting.data.BarEntry> loadBarEntriesFromAssets(android.content.res.AssetManager r4, java.lang.String r5) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0049 }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0049 }
            java.io.InputStream r4 = r4.open(r5)     // Catch:{ IOException -> 0x0049 }
            java.lang.String r5 = "UTF-8"
            r3.<init>(r4, r5)     // Catch:{ IOException -> 0x0049 }
            r2.<init>(r3)     // Catch:{ IOException -> 0x0049 }
            java.lang.String r4 = r2.readLine()     // Catch:{ IOException -> 0x0044, all -> 0x0041 }
        L_0x001a:
            if (r4 == 0) goto L_0x003d
            java.lang.String r5 = "#"
            java.lang.String[] r4 = r4.split(r5)     // Catch:{ IOException -> 0x0044, all -> 0x0041 }
            com.github.mikephil.charting.data.BarEntry r5 = new com.github.mikephil.charting.data.BarEntry     // Catch:{ IOException -> 0x0044, all -> 0x0041 }
            r1 = 0
            r1 = r4[r1]     // Catch:{ IOException -> 0x0044, all -> 0x0041 }
            float r1 = java.lang.Float.parseFloat(r1)     // Catch:{ IOException -> 0x0044, all -> 0x0041 }
            r3 = 1
            r4 = r4[r3]     // Catch:{ IOException -> 0x0044, all -> 0x0041 }
            int r4 = java.lang.Integer.parseInt(r4)     // Catch:{ IOException -> 0x0044, all -> 0x0041 }
            r5.<init>((float) r1, (int) r4)     // Catch:{ IOException -> 0x0044, all -> 0x0041 }
            r0.add(r5)     // Catch:{ IOException -> 0x0044, all -> 0x0041 }
            java.lang.String r4 = r2.readLine()     // Catch:{ IOException -> 0x0044, all -> 0x0041 }
            goto L_0x001a
        L_0x003d:
            r2.close()     // Catch:{ IOException -> 0x0053 }
            goto L_0x0057
        L_0x0041:
            r4 = move-exception
            r1 = r2
            goto L_0x0058
        L_0x0044:
            r4 = move-exception
            r1 = r2
            goto L_0x004a
        L_0x0047:
            r4 = move-exception
            goto L_0x0058
        L_0x0049:
            r4 = move-exception
        L_0x004a:
            r4.toString()     // Catch:{ all -> 0x0047 }
            if (r1 == 0) goto L_0x0057
            r1.close()     // Catch:{ IOException -> 0x0053 }
            goto L_0x0057
        L_0x0053:
            r4 = move-exception
            r4.toString()
        L_0x0057:
            return r0
        L_0x0058:
            if (r1 == 0) goto L_0x0062
            r1.close()     // Catch:{ IOException -> 0x005e }
            goto L_0x0062
        L_0x005e:
            r5 = move-exception
            r5.toString()
        L_0x0062:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.utils.FileUtils.loadBarEntriesFromAssets(android.content.res.AssetManager, java.lang.String):java.util.List");
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0075 A[SYNTHETIC, Splitter:B:25:0x0075] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0080 A[SYNTHETIC, Splitter:B:31:0x0080] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<com.github.mikephil.charting.data.Entry> loadEntriesFromAssets(android.content.res.AssetManager r6, java.lang.String r7) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ IOException -> 0x006f }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x006f }
            java.io.InputStream r6 = r6.open(r7)     // Catch:{ IOException -> 0x006f }
            java.lang.String r7 = "UTF-8"
            r3.<init>(r6, r7)     // Catch:{ IOException -> 0x006f }
            r2.<init>(r3)     // Catch:{ IOException -> 0x006f }
            java.lang.String r6 = r2.readLine()     // Catch:{ IOException -> 0x006a, all -> 0x0067 }
        L_0x001a:
            if (r6 == 0) goto L_0x0063
            java.lang.String r7 = "#"
            java.lang.String[] r6 = r6.split(r7)     // Catch:{ IOException -> 0x006a, all -> 0x0067 }
            int r7 = r6.length     // Catch:{ IOException -> 0x006a, all -> 0x0067 }
            r1 = 2
            r3 = 0
            r4 = 1
            if (r7 > r1) goto L_0x003d
            com.github.mikephil.charting.data.Entry r7 = new com.github.mikephil.charting.data.Entry     // Catch:{ IOException -> 0x006a, all -> 0x0067 }
            r1 = r6[r3]     // Catch:{ IOException -> 0x006a, all -> 0x0067 }
            float r1 = java.lang.Float.parseFloat(r1)     // Catch:{ IOException -> 0x006a, all -> 0x0067 }
            r6 = r6[r4]     // Catch:{ IOException -> 0x006a, all -> 0x0067 }
            int r6 = java.lang.Integer.parseInt(r6)     // Catch:{ IOException -> 0x006a, all -> 0x0067 }
            r7.<init>(r1, r6)     // Catch:{ IOException -> 0x006a, all -> 0x0067 }
            r0.add(r7)     // Catch:{ IOException -> 0x006a, all -> 0x0067 }
            goto L_0x005e
        L_0x003d:
            int r7 = r6.length     // Catch:{ IOException -> 0x006a, all -> 0x0067 }
            int r7 = r7 - r4
            float[] r1 = new float[r7]     // Catch:{ IOException -> 0x006a, all -> 0x0067 }
        L_0x0041:
            if (r3 >= r7) goto L_0x004e
            r5 = r6[r3]     // Catch:{ IOException -> 0x006a, all -> 0x0067 }
            float r5 = java.lang.Float.parseFloat(r5)     // Catch:{ IOException -> 0x006a, all -> 0x0067 }
            r1[r3] = r5     // Catch:{ IOException -> 0x006a, all -> 0x0067 }
            int r3 = r3 + 1
            goto L_0x0041
        L_0x004e:
            com.github.mikephil.charting.data.BarEntry r7 = new com.github.mikephil.charting.data.BarEntry     // Catch:{ IOException -> 0x006a, all -> 0x0067 }
            int r3 = r6.length     // Catch:{ IOException -> 0x006a, all -> 0x0067 }
            int r3 = r3 - r4
            r6 = r6[r3]     // Catch:{ IOException -> 0x006a, all -> 0x0067 }
            int r6 = java.lang.Integer.parseInt(r6)     // Catch:{ IOException -> 0x006a, all -> 0x0067 }
            r7.<init>((float[]) r1, (int) r6)     // Catch:{ IOException -> 0x006a, all -> 0x0067 }
            r0.add(r7)     // Catch:{ IOException -> 0x006a, all -> 0x0067 }
        L_0x005e:
            java.lang.String r6 = r2.readLine()     // Catch:{ IOException -> 0x006a, all -> 0x0067 }
            goto L_0x001a
        L_0x0063:
            r2.close()     // Catch:{ IOException -> 0x0079 }
            goto L_0x007d
        L_0x0067:
            r6 = move-exception
            r1 = r2
            goto L_0x007e
        L_0x006a:
            r6 = move-exception
            r1 = r2
            goto L_0x0070
        L_0x006d:
            r6 = move-exception
            goto L_0x007e
        L_0x006f:
            r6 = move-exception
        L_0x0070:
            r6.toString()     // Catch:{ all -> 0x006d }
            if (r1 == 0) goto L_0x007d
            r1.close()     // Catch:{ IOException -> 0x0079 }
            goto L_0x007d
        L_0x0079:
            r6 = move-exception
            r6.toString()
        L_0x007d:
            return r0
        L_0x007e:
            if (r1 == 0) goto L_0x0088
            r1.close()     // Catch:{ IOException -> 0x0084 }
            goto L_0x0088
        L_0x0084:
            r7 = move-exception
            r7.toString()
        L_0x0088:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.utils.FileUtils.loadEntriesFromAssets(android.content.res.AssetManager, java.lang.String):java.util.List");
    }

    public static List<Entry> loadEntriesFromFile(String str) {
        File file = new File(Environment.getExternalStorageDirectory(), str);
        ArrayList arrayList = new ArrayList();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                String[] split = readLine.split("#");
                if (split.length <= 2) {
                    arrayList.add(new Entry(Float.parseFloat(split[0]), Integer.parseInt(split[1])));
                } else {
                    int length = split.length - 1;
                    float[] fArr = new float[length];
                    for (int i10 = 0; i10 < length; i10++) {
                        fArr[i10] = Float.parseFloat(split[i10]);
                    }
                    arrayList.add(new BarEntry(fArr, Integer.parseInt(split[split.length - 1])));
                }
            }
        } catch (IOException e10) {
            e10.toString();
        }
        return arrayList;
    }

    public static void saveToSdCard(List<Entry> list, String str) {
        File file = new File(Environment.getExternalStorageDirectory(), str);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e10) {
                e10.toString();
            }
        }
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
            for (Entry next : list) {
                bufferedWriter.append(next.getVal() + "#" + next.getXIndex());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e11) {
            e11.toString();
        }
    }
}
