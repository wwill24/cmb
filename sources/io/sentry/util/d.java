package io.sentry.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public final class d {
    public static boolean a(File file) {
        if (file == null || !file.exists()) {
            return true;
        }
        if (file.isFile()) {
            return file.delete();
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return true;
        }
        for (File a10 : listFiles) {
            if (!a(a10)) {
                return false;
            }
        }
        return file.delete();
    }

    public static String b(File file) throws IOException {
        if (file == null || !file.exists() || !file.isFile() || !file.canRead()) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        try {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                sb2.append(readLine);
            }
            while (true) {
                String readLine2 = bufferedReader.readLine();
                if (readLine2 != null) {
                    sb2.append("\n");
                    sb2.append(readLine2);
                } else {
                    bufferedReader.close();
                    return sb2.toString();
                }
            }
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }
}
