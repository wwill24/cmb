package org.jivesoftware.smackx.bytestreams.socks5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.beanutils.PropertyUtils;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.util.CloseableUtil;

public class Socks5Proxy {
    private static int DEFAULT_LOCAL_SOCKS5_PROXY_PORT = -7777;
    /* access modifiers changed from: private */
    public static final Logger LOGGER = Logger.getLogger(Socks5Proxy.class.getName());
    private static final List<Socks5Proxy> RUNNING_PROXIES = new CopyOnWriteArrayList();
    private static boolean localSocks5ProxyEnabled = true;
    private static Socks5Proxy socks5Server;
    /* access modifiers changed from: private */
    public final boolean allowAllConnections;
    /* access modifiers changed from: private */
    public final List<String> allowedConnections;
    /* access modifiers changed from: private */
    public final Map<String, Socket> connectionMap;
    private final Set<InetAddress> localAddresses;
    private int localSocks5ProxyPort;
    private final Socks5ServerProcess serverProcess;
    /* access modifiers changed from: private */
    public ServerSocket serverSocket;
    private Thread serverThread;

    private class Socks5ServerProcess implements Runnable {
        private Socks5ServerProcess() {
        }

        private void establishConnection(Socket socket) throws SmackException, IOException {
            boolean z10;
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            int read = dataInputStream.read();
            if (read == 5) {
                int read2 = dataInputStream.read();
                byte[] bArr = new byte[read2];
                dataInputStream.readFully(bArr);
                byte[] bArr2 = new byte[2];
                bArr2[0] = 5;
                int i10 = 0;
                while (true) {
                    if (i10 >= read2) {
                        z10 = false;
                        break;
                    } else if (bArr[i10] == 0) {
                        z10 = true;
                        break;
                    } else {
                        i10++;
                    }
                }
                if (z10) {
                    bArr2[1] = 0;
                    dataOutputStream.write(bArr2);
                    dataOutputStream.flush();
                    byte[] receiveSocks5Message = Socks5Utils.receiveSocks5Message(dataInputStream);
                    String str = new String(receiveSocks5Message, 5, receiveSocks5Message[4], StandardCharsets.UTF_8);
                    if (Socks5Proxy.this.allowAllConnections || Socks5Proxy.this.allowedConnections.contains(str)) {
                        Socks5Proxy.this.connectionMap.put(str, socket);
                        receiveSocks5Message[1] = 0;
                        dataOutputStream.write(receiveSocks5Message);
                        dataOutputStream.flush();
                        return;
                    }
                    receiveSocks5Message[1] = 5;
                    dataOutputStream.write(receiveSocks5Message);
                    dataOutputStream.flush();
                    throw new SmackException.SmackMessageException("Connection with digest '" + str + "' is not allowed");
                }
                bArr2[1] = -1;
                dataOutputStream.write(bArr2);
                dataOutputStream.flush();
                throw new SmackException.SmackMessageException("Authentication method not supported");
            }
            throw new SmackException.SmackMessageException("Only SOCKS5 supported: Peer send " + read + " but we expect 5");
        }

        public void run() {
            while (true) {
                ServerSocket access$100 = Socks5Proxy.this.serverSocket;
                if (access$100 != null && !access$100.isClosed() && !Thread.currentThread().isInterrupted()) {
                    Socket socket = null;
                    try {
                        socket = access$100.accept();
                        establishConnection(socket);
                    } catch (IOException | SmackException e10) {
                        Logger access$200 = Socks5Proxy.LOGGER;
                        Level level = Level.FINE;
                        access$200.log(level, "Exception while " + Socks5Proxy.this + " was handling connection", e10);
                        CloseableUtil.maybeClose(socket, Socks5Proxy.LOGGER);
                    }
                } else {
                    return;
                }
            }
        }
    }

    Socks5Proxy() {
        this.localSocks5ProxyPort = -7777;
        this.connectionMap = new ConcurrentHashMap();
        this.allowedConnections = Collections.synchronizedList(new LinkedList());
        this.localAddresses = new LinkedHashSet(4);
        this.serverProcess = new Socks5ServerProcess();
        this.allowAllConnections = false;
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            HashSet hashSet = new HashSet();
            Iterator<T> it = Collections.list(networkInterfaces).iterator();
            while (it.hasNext()) {
                for (InterfaceAddress address : ((NetworkInterface) it.next()).getInterfaceAddresses()) {
                    hashSet.add(address.getAddress());
                }
            }
            if (!hashSet.isEmpty()) {
                replaceLocalAddresses(hashSet);
                return;
            }
            throw new IllegalStateException("Could not determine any local internet address");
        } catch (SocketException e10) {
            throw new IllegalStateException(e10);
        }
    }

    private static void checkLocalSocks5ProxyPortArgument(int i10) {
        if (Math.abs(i10) > 65535) {
            throw new IllegalArgumentException("Local SOCKS5 proxy port must be within (-65535,65535)");
        }
    }

    public static int getDefaultLocalSocks5ProxyPort() {
        return DEFAULT_LOCAL_SOCKS5_PROXY_PORT;
    }

    static List<Socks5Proxy> getRunningProxies() {
        return RUNNING_PROXIES;
    }

    public static Socket getSocketForDigest(String str) {
        for (Socks5Proxy socket : RUNNING_PROXIES) {
            Socket socket2 = socket.getSocket(str);
            if (socket2 != null) {
                return socket2;
            }
        }
        return null;
    }

    public static synchronized Socks5Proxy getSocks5Proxy() {
        Socks5Proxy socks5Proxy;
        synchronized (Socks5Proxy.class) {
            if (socks5Server == null) {
                socks5Server = new Socks5Proxy();
            }
            if (isLocalSocks5ProxyEnabled()) {
                socks5Server.start();
            }
            socks5Proxy = socks5Server;
        }
        return socks5Proxy;
    }

    public static boolean isLocalSocks5ProxyEnabled() {
        return localSocks5ProxyEnabled;
    }

    public static void setDefaultLocalSocsk5ProxyPort(int i10) {
        checkLocalSocks5ProxyPortArgument(i10);
        DEFAULT_LOCAL_SOCKS5_PROXY_PORT = i10;
    }

    public static void setLocalSocks5ProxyEnabled(boolean z10) {
        localSocks5ProxyEnabled = z10;
    }

    private synchronized void startServerThread() {
        Thread thread = new Thread(this.serverProcess);
        this.serverThread = thread;
        thread.setName("Smack Local SOCKS5 Proxy [" + this.serverSocket + PropertyUtils.INDEXED_DELIM2);
        this.serverThread.setDaemon(true);
        RUNNING_PROXIES.add(this);
        this.serverThread.start();
    }

    public void addLocalAddress(InetAddress inetAddress) {
        if (inetAddress != null) {
            synchronized (this.localAddresses) {
                this.localAddresses.add(inetAddress);
            }
        }
    }

    public void addTransfer(String str) {
        this.allowedConnections.add(str);
    }

    public List<InetAddress> getLocalAddresses() {
        LinkedList linkedList;
        synchronized (this.localAddresses) {
            linkedList = new LinkedList(this.localAddresses);
        }
        return linkedList;
    }

    public int getLocalSocks5ProxyPort() {
        return this.localSocks5ProxyPort;
    }

    public int getPort() {
        if (!isRunning()) {
            return -1;
        }
        return this.serverSocket.getLocalPort();
    }

    /* access modifiers changed from: protected */
    public Socket getSocket(String str) {
        return this.connectionMap.get(str);
    }

    public boolean isRunning() {
        return this.serverSocket != null;
    }

    public boolean removeLocalAddress(InetAddress inetAddress) {
        boolean remove;
        synchronized (this.localAddresses) {
            remove = this.localAddresses.remove(inetAddress);
        }
        return remove;
    }

    /* access modifiers changed from: protected */
    public void removeTransfer(String str) {
        this.allowedConnections.remove(str);
        this.connectionMap.remove(str);
    }

    public void replaceLocalAddresses(Collection<? extends InetAddress> collection) {
        if (collection != null) {
            synchronized (this.localAddresses) {
                this.localAddresses.clear();
                this.localAddresses.addAll(collection);
            }
            return;
        }
        throw new IllegalArgumentException("list must not be null");
    }

    public void setLocalSocks5ProxyPort(int i10) {
        checkLocalSocks5ProxyPortArgument(i10);
        this.localSocks5ProxyPort = i10;
    }

    public synchronized ServerSocket start() {
        if (isRunning()) {
            return this.serverSocket;
        }
        try {
            if (getLocalSocks5ProxyPort() < 0) {
                int abs = Math.abs(getLocalSocks5ProxyPort());
                int i10 = 0;
                while (i10 < 65535 - abs) {
                    try {
                        this.serverSocket = new ServerSocket(abs + i10);
                        break;
                    } catch (IOException unused) {
                        i10++;
                    }
                }
            } else {
                this.serverSocket = new ServerSocket(getLocalSocks5ProxyPort());
            }
            if (this.serverSocket != null) {
                startServerThread();
            }
        } catch (IOException e10) {
            Logger logger = LOGGER;
            Level level = Level.SEVERE;
            logger.log(level, "couldn't setup local SOCKS5 proxy on port " + getLocalSocks5ProxyPort(), e10);
        }
        return this.serverSocket;
    }

    public synchronized void stop() {
        if (isRunning()) {
            RUNNING_PROXIES.remove(this);
            CloseableUtil.maybeClose(this.serverSocket, LOGGER);
            Thread thread = this.serverThread;
            if (thread != null && thread.isAlive()) {
                try {
                    this.serverThread.interrupt();
                    this.serverThread.join();
                } catch (InterruptedException e10) {
                    LOGGER.log(Level.WARNING, "SOCKS5 server thread termination was interrupted", e10);
                }
            }
            this.serverThread = null;
            this.serverSocket = null;
        }
    }

    protected Socks5Proxy(ServerSocket serverSocket2) {
        this.localSocks5ProxyPort = -7777;
        this.connectionMap = new ConcurrentHashMap();
        this.allowedConnections = Collections.synchronizedList(new LinkedList());
        this.localAddresses = new LinkedHashSet(4);
        this.serverProcess = new Socks5ServerProcess();
        this.serverSocket = serverSocket2;
        this.allowAllConnections = true;
        startServerThread();
    }
}
