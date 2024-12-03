package org.jivesoftware.smack.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class FileUtils {
    private static final Logger LOGGER = Logger.getLogger(FileUtils.class.getName());

    /* JADX INFO: finally extract failed */
    public static boolean addLines(String str, Set<String> set) throws MalformedURLException, IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(getStreamForUri(URI.create(str), (ClassLoader) null), StandardCharsets.UTF_8));
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    set.add(readLine);
                } else {
                    bufferedReader.close();
                    return true;
                }
            } catch (Throwable th2) {
                bufferedReader.close();
                throw th2;
            }
        }
    }

    public static List<ClassLoader> getClassLoaders() {
        ClassLoader[] classLoaderArr = {FileUtils.class.getClassLoader(), Thread.currentThread().getContextClassLoader()};
        ArrayList arrayList = new ArrayList(2);
        for (int i10 = 0; i10 < 2; i10++) {
            ClassLoader classLoader = classLoaderArr[i10];
            if (classLoader != null) {
                arrayList.add(classLoader);
            }
        }
        return arrayList;
    }

    public static InputStream getInputStreamForClasspathFile(String str) {
        return getInputStreamForClasspathFile(str, (ClassLoader) null);
    }

    public static InputStream getStreamForClasspathFile(String str, ClassLoader classLoader) throws IOException {
        List<ClassLoader> classLoaders = getClassLoaders();
        if (classLoader != null) {
            classLoaders.add(0, classLoader);
        }
        for (ClassLoader resourceAsStream : classLoaders) {
            InputStream resourceAsStream2 = resourceAsStream.getResourceAsStream(str);
            if (resourceAsStream2 != null) {
                return resourceAsStream2;
            }
        }
        throw new IOException("Unable to get '" + str + "' from classpath. Tried ClassLoaders:" + classLoaders);
    }

    public static InputStream getStreamForUri(URI uri, ClassLoader classLoader) throws IOException {
        if (uri.getScheme().equals("classpath")) {
            return getStreamForClasspathFile(uri.getSchemeSpecificPart(), classLoader);
        }
        return uri.toURL().openStream();
    }

    public static void maybeCreateFileWithParentDirectories(File file) throws IOException {
        File parentFile = file.getParentFile();
        if (!parentFile.exists() && !parentFile.mkdirs()) {
            throw new IOException("Cannot create directory " + parentFile);
        } else if (!file.isFile()) {
            if (!file.exists()) {
                if (!file.createNewFile()) {
                    throw new IOException("Cannot create file " + file);
                }
            } else if (file.isDirectory()) {
                throw new IOException("File " + file + " exists, but is a directory.");
            } else {
                throw new IOException("File " + file + " exists, but is neither a file nor a directory");
            }
        }
    }

    public static void maybeDeleteFileOrThrow(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException("Could not delete file " + file);
        }
    }

    public static FileInputStream prepareFileInputStream(File file) throws IOException {
        if (!file.exists()) {
            throw new FileNotFoundException("File " + file.getAbsolutePath() + " not found.");
        } else if (file.isFile()) {
            return new FileInputStream(file);
        } else {
            throw new IOException("File " + file.getAbsolutePath() + " is not a file!");
        }
    }

    public static FileOutputStream prepareFileOutputStream(File file) throws IOException {
        if (!file.exists()) {
            File parentFile = file.getParentFile();
            if (!parentFile.exists() && !parentFile.mkdirs()) {
                throw new IOException("Cannot create directory " + parentFile.getAbsolutePath());
            } else if (!file.createNewFile()) {
                throw new IOException("Cannot create file " + file.getAbsolutePath());
            }
        }
        if (!file.isDirectory()) {
            return new FileOutputStream(file);
        }
        throw new AssertionError("File " + file.getAbsolutePath() + " is not a file!");
    }

    public static String readFile(File file) {
        try {
            return readFileOrThrow(file);
        } catch (FileNotFoundException e10) {
            LOGGER.log(Level.FINE, "readFile", e10);
            return null;
        } catch (IOException e11) {
            LOGGER.log(Level.WARNING, "readFile", e11);
            return null;
        }
    }

    public static String readFileOrThrow(File file) throws IOException {
        FileReader fileReader = new FileReader(file);
        try {
            char[] cArr = new char[8192];
            StringBuilder sb2 = new StringBuilder();
            while (true) {
                int read = fileReader.read(cArr);
                if (read >= 0) {
                    sb2.append(cArr, 0, read);
                } else {
                    String sb3 = sb2.toString();
                    fileReader.close();
                    return sb3;
                }
            }
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }

    public static boolean writeFile(File file, CharSequence charSequence) {
        try {
            writeFileOrThrow(file, charSequence);
            return true;
        } catch (IOException e10) {
            LOGGER.log(Level.WARNING, "writeFile", e10);
            return false;
        }
    }

    public static void writeFileOrThrow(File file, CharSequence charSequence) throws IOException {
        FileWriter fileWriter = new FileWriter(file, false);
        try {
            fileWriter.write(charSequence.toString());
        } finally {
            fileWriter.close();
        }
    }

    public static InputStream getInputStreamForClasspathFile(String str, ClassLoader classLoader) {
        try {
            return getStreamForClasspathFile(str, classLoader);
        } catch (IOException e10) {
            LOGGER.log(Level.FINE, "Suppressed IOException in getInputStreamForClasspathFile", e10);
            return null;
        }
    }
}
