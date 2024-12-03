package tm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import zm.f;

public final class b extends a {

    /* renamed from: d  reason: collision with root package name */
    public static final d f33878d = new b();

    private b() {
        super(b.class.getSimpleName(), 999);
    }

    protected static Set<String> c(BufferedReader bufferedReader, boolean z10) throws UnknownHostException, IOException {
        InetAddress byName;
        String hostAddress;
        HashSet hashSet = new HashSet(6);
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return hashSet;
            }
            int indexOf = readLine.indexOf("]: [");
            if (indexOf != -1) {
                String substring = readLine.substring(1, indexOf);
                int i10 = indexOf + 4;
                int length = readLine.length() - 1;
                if (length >= i10) {
                    String substring2 = readLine.substring(i10, length);
                    if (!substring2.isEmpty() && !((!substring.endsWith(".dns") && !substring.endsWith(".dns1") && !substring.endsWith(".dns2") && !substring.endsWith(".dns3") && !substring.endsWith(".dns4")) || (byName = InetAddress.getByName(substring2)) == null || (hostAddress = byName.getHostAddress()) == null || hostAddress.length() == 0)) {
                        hashSet.add(hostAddress);
                    }
                } else if (z10) {
                    Logger logger = a.f33875c;
                    logger.warning("Malformed property detected: \"" + readLine + '\"');
                }
            }
        }
    }

    public List<String> L() {
        try {
            Set<String> c10 = c(new LineNumberReader(new InputStreamReader(Runtime.getRuntime().exec("getprop").getInputStream(), StandardCharsets.UTF_8)), true);
            if (c10.size() <= 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList(c10.size());
            arrayList.addAll(c10);
            return arrayList;
        } catch (IOException e10) {
            a.f33875c.log(Level.WARNING, "Exception in findDNSByExec", e10);
            return null;
        }
    }

    public boolean isAvailable() {
        return f.a();
    }
}
