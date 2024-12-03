package net.bytebuddy.agent;

import com.coffeemeetsbagel.models.util.FacebookParse;
import com.sun.jna.LastErrorException;
import com.sun.jna.Library;
import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.Platform;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.platform.win32.Advapi32;
import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.platform.win32.Win32Exception;
import com.sun.jna.platform.win32.WinBase;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.win32.StdCallLibrary;
import com.sun.jna.win32.W32APIOptions;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.security.PrivilegedAction;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import net.bytebuddy.agent.utility.nullability.MaybeNull;
import net.bytebuddy.agent.utility.nullability.UnknownNull;
import net.bytebuddy.jar.asm.Opcodes;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import org.apache.commons.beanutils.PropertyUtils;
import org.jivesoftware.smackx.jingle_filetransfer.element.Range;
import org.jivesoftware.smackx.jiveproperties.packet.JivePropertiesExtension;

public interface VirtualMachine {

    public static abstract class AbstractBase implements VirtualMachine {
        public void loadAgent(String str) throws IOException {
            loadAgent(str, (String) null);
        }

        public void loadAgentLibrary(String str) throws IOException {
            loadAgentLibrary(str, (String) null);
        }

        public void loadAgentPath(String str) throws IOException {
            loadAgentPath(str, (String) null);
        }
    }

    public static class ForOpenJ9 extends AbstractBase {
        private static final String IBM_TEMPORARY_FOLDER = "com.ibm.tools.attach.directory";
        private static final SecureRandom SECURE_RANDOM = new SecureRandom();
        private final Socket socket;

        public interface Dispatcher {

            public static class ForJnaPosixEnvironment implements Dispatcher {
                private final int attempts;
                private final PosixLibrary library = ((PosixLibrary) Native.loadLibrary("c", PosixLibrary.class));
                private final long pause;
                private final TimeUnit timeUnit;

                protected interface PosixLibrary extends Library {
                    public static final int EAGAIN = 11;
                    public static final int EDEADLK = 35;
                    public static final int ESRCH = 3;
                    public static final short IPC_NOWAIT = 2048;
                    public static final int NULL_SIGNAL = 0;
                    public static final short SEM_UNDO = 4096;

                    public static class SemaphoreOperation extends Structure {
                        public short flags;
                        public short number;
                        public short operation;

                        /* access modifiers changed from: protected */
                        public List<String> getFieldOrder() {
                            return Arrays.asList(new String[]{"number", "operation", "flags"});
                        }
                    }

                    int chmod(String str, int i10) throws LastErrorException;

                    int ftok(String str, int i10) throws LastErrorException;

                    int getpid() throws LastErrorException;

                    int getuid() throws LastErrorException;

                    int kill(int i10, int i11) throws LastErrorException;

                    int semget(int i10, int i11, int i12) throws LastErrorException;

                    int semop(int i10, SemaphoreOperation semaphoreOperation, int i11) throws LastErrorException;
                }

                public ForJnaPosixEnvironment(int i10, long j10, TimeUnit timeUnit2) {
                    this.attempts = i10;
                    this.pause = j10;
                    this.timeUnit = timeUnit2;
                }

                @SuppressFBWarnings(justification = "Modifier is required by JNA.", value = {"URF_UNREAD_PUBLIC_OR_PROTECTED_FIELD", "UUF_UNUSED_PUBLIC_OR_PROTECTED_FIELD"})
                private void notifySemaphore(File file, String str, int i10, short s10, short s11, boolean z10) {
                    PosixLibrary posixLibrary = this.library;
                    int semget = posixLibrary.semget(posixLibrary.ftok(new File(file, str).getAbsolutePath(), Opcodes.IF_ICMPLT), 2, 438);
                    PosixLibrary.SemaphoreOperation semaphoreOperation = new PosixLibrary.SemaphoreOperation();
                    semaphoreOperation.operation = s10;
                    semaphoreOperation.flags = s11;
                    while (true) {
                        int i11 = i10 - 1;
                        if (i10 > 0) {
                            try {
                                this.library.semop(semget, semaphoreOperation, 1);
                                i10 = i11;
                            } catch (LastErrorException e10) {
                                if (z10) {
                                    if (Native.getLastError() == 11) {
                                        return;
                                    }
                                    if (Native.getLastError() == 35) {
                                        return;
                                    }
                                }
                                throw e10;
                            }
                        } else {
                            return;
                        }
                    }
                }

                public void decrementSemaphore(File file, String str, boolean z10, int i10) {
                    notifySemaphore(file, str, i10, -1, 6144, true);
                }

                /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
                    java.lang.Thread.sleep(r7.timeUnit.toMillis(r7.pause));
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:14:0x005b, code lost:
                    r0 = r0 - 1;
                 */
                /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
                /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0050 */
                @edu.umd.cs.findbugs.annotations.SuppressFBWarnings(justification = "The stream life-cycle is bound to its process.", value = {"OS_OPEN_STREAM"})
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public int getOwnerIdOf(java.io.File r8) {
                    /*
                        r7 = this;
                        java.lang.Runtime r0 = java.lang.Runtime.getRuntime()     // Catch:{ IOException -> 0x007f }
                        r1 = 4
                        java.lang.String[] r1 = new java.lang.String[r1]     // Catch:{ IOException -> 0x007f }
                        java.lang.String r2 = "stat"
                        r3 = 0
                        r1[r3] = r2     // Catch:{ IOException -> 0x007f }
                        boolean r2 = com.sun.jna.Platform.isMac()     // Catch:{ IOException -> 0x007f }
                        if (r2 == 0) goto L_0x0015
                        java.lang.String r2 = "-f"
                        goto L_0x0017
                    L_0x0015:
                        java.lang.String r2 = "-c"
                    L_0x0017:
                        r4 = 1
                        r1[r4] = r2     // Catch:{ IOException -> 0x007f }
                        r2 = 2
                        java.lang.String r5 = "%u"
                        r1[r2] = r5     // Catch:{ IOException -> 0x007f }
                        r2 = 3
                        java.lang.String r8 = r8.getAbsolutePath()     // Catch:{ IOException -> 0x007f }
                        r1[r2] = r8     // Catch:{ IOException -> 0x007f }
                        java.lang.Process r8 = r0.exec(r1)     // Catch:{ IOException -> 0x007f }
                        int r0 = r7.attempts     // Catch:{ IOException -> 0x007f }
                        java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ IOException -> 0x007f }
                        java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x007f }
                        java.io.InputStream r5 = r8.getInputStream()     // Catch:{ IOException -> 0x007f }
                        java.lang.String r6 = "UTF-8"
                        r2.<init>(r5, r6)     // Catch:{ IOException -> 0x007f }
                        r1.<init>(r2)     // Catch:{ IOException -> 0x007f }
                        java.lang.String r1 = r1.readLine()     // Catch:{ IOException -> 0x007f }
                    L_0x0040:
                        int r2 = r8.exitValue()     // Catch:{ IllegalThreadStateException -> 0x0050 }
                        if (r2 != 0) goto L_0x0048
                        r3 = r4
                        goto L_0x005f
                    L_0x0048:
                        java.lang.IllegalStateException r2 = new java.lang.IllegalStateException     // Catch:{ IllegalThreadStateException -> 0x0050 }
                        java.lang.String r5 = "Error while executing stat"
                        r2.<init>(r5)     // Catch:{ IllegalThreadStateException -> 0x0050 }
                        throw r2     // Catch:{ IllegalThreadStateException -> 0x0050 }
                    L_0x0050:
                        java.util.concurrent.TimeUnit r2 = r7.timeUnit     // Catch:{ InterruptedException -> 0x0071 }
                        long r5 = r7.pause     // Catch:{ InterruptedException -> 0x0071 }
                        long r5 = r2.toMillis(r5)     // Catch:{ InterruptedException -> 0x0071 }
                        java.lang.Thread.sleep(r5)     // Catch:{ InterruptedException -> 0x0071 }
                        int r0 = r0 + -1
                        if (r0 > 0) goto L_0x0040
                    L_0x005f:
                        if (r3 == 0) goto L_0x0066
                        int r8 = java.lang.Integer.parseInt(r1)     // Catch:{ IOException -> 0x007f }
                        return r8
                    L_0x0066:
                        r8.destroy()     // Catch:{ IOException -> 0x007f }
                        java.lang.IllegalStateException r8 = new java.lang.IllegalStateException     // Catch:{ IOException -> 0x007f }
                        java.lang.String r0 = "Command for stat did not exit in time"
                        r8.<init>(r0)     // Catch:{ IOException -> 0x007f }
                        throw r8     // Catch:{ IOException -> 0x007f }
                    L_0x0071:
                        r8 = move-exception
                        java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch:{ IOException -> 0x007f }
                        r0.interrupt()     // Catch:{ IOException -> 0x007f }
                        java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ IOException -> 0x007f }
                        r0.<init>(r8)     // Catch:{ IOException -> 0x007f }
                        throw r0     // Catch:{ IOException -> 0x007f }
                    L_0x007f:
                        r8 = move-exception
                        java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                        java.lang.String r1 = "Unable to execute stat command"
                        r0.<init>(r1, r8)
                        throw r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.agent.VirtualMachine.ForOpenJ9.Dispatcher.ForJnaPosixEnvironment.getOwnerIdOf(java.io.File):int");
                }

                public String getTemporaryFolder(String str) {
                    if (Platform.isLinux()) {
                        File file = new File("/proc/" + str + "/root/tmp");
                        if (file.isDirectory() && file.canRead()) {
                            return file.getAbsolutePath();
                        }
                    }
                    String str2 = System.getenv("TMPDIR");
                    if (str2 == null) {
                        return "/tmp";
                    }
                    return str2;
                }

                public void incrementSemaphore(File file, String str, boolean z10, int i10) {
                    notifySemaphore(file, str, i10, 1, 0, false);
                }

                public boolean isExistingProcess(int i10) {
                    return this.library.kill(i10, 0) != 3;
                }

                public int pid() {
                    return this.library.getpid();
                }

                public void setPermissions(File file, int i10) {
                    this.library.chmod(file.getAbsolutePath(), i10);
                }

                public int userId() {
                    return this.library.getuid();
                }
            }

            public static class ForJnaWindowsEnvironment implements Dispatcher {
                private static final String CREATION_MUTEX_NAME = "j9shsemcreationMutex";
                private static final int NO_USER_ID = 0;
                private final WindowsLibrary library = ((WindowsLibrary) Native.loadLibrary("kernel32", WindowsLibrary.class, W32APIOptions.DEFAULT_OPTIONS));

                protected static class AttachmentHandle implements Closeable {
                    private final WinNT.HANDLE child;
                    private final WinNT.HANDLE parent;

                    protected AttachmentHandle(WinNT.HANDLE handle, WinNT.HANDLE handle2) {
                        this.parent = handle;
                        this.child = handle2;
                    }

                    public void close() {
                        Kernel32 kernel32;
                        WinNT.HANDLE handle;
                        try {
                            if (!Kernel32.INSTANCE.CloseHandle(this.child)) {
                                throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
                            } else if (!kernel32.CloseHandle(handle)) {
                                throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
                            }
                        } finally {
                            Kernel32.INSTANCE.CloseHandle(this.parent);
                        }
                    }

                    /* access modifiers changed from: protected */
                    public WinNT.HANDLE getHandle() {
                        return this.child;
                    }
                }

                protected interface WindowsLibrary extends StdCallLibrary {
                    public static final int SEMAPHORE_ALL_ACCESS = 2031619;

                    @SuppressFBWarnings(justification = "Field required by native implementation.", value = {"URF_UNREAD_PUBLIC_OR_PROTECTED_FIELD", "UUF_UNUSED_PUBLIC_OR_PROTECTED_FIELD"})
                    public static class SecurityAttributes extends Structure {
                        public boolean inherit;
                        @MaybeNull
                        public WinDef.DWORD length;
                        @MaybeNull
                        public Pointer securityDescriptor;

                        /* access modifiers changed from: protected */
                        public List<String> getFieldOrder() {
                            return Arrays.asList(new String[]{Range.ATTR_LENGTH, "securityDescriptor", "inherit"});
                        }
                    }

                    @MaybeNull
                    WinNT.HANDLE CreateMutex(SecurityAttributes securityAttributes, boolean z10, String str);

                    @MaybeNull
                    WinNT.HANDLE CreateSemaphoreW(@MaybeNull WinBase.SECURITY_ATTRIBUTES security_attributes, long j10, long j11, String str);

                    WinNT.HANDLE OpenMutex(int i10, boolean z10, String str);

                    @MaybeNull
                    WinNT.HANDLE OpenSemaphoreW(int i10, boolean z10, String str);

                    boolean ReleaseMutex(WinNT.HANDLE handle);

                    boolean ReleaseSemaphore(WinNT.HANDLE handle, long j10, @MaybeNull Long l10);
                }

                private AttachmentHandle openSemaphore(File file, String str, boolean z10) {
                    String str2;
                    WinNT.SECURITY_DESCRIPTOR security_descriptor = new WinNT.SECURITY_DESCRIPTOR(65536);
                    if (!Advapi32.INSTANCE.InitializeSecurityDescriptor(security_descriptor, 1)) {
                        throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
                    } else if (Advapi32.INSTANCE.SetSecurityDescriptorDacl(security_descriptor, true, (WinNT.ACL) null, true)) {
                        WindowsLibrary.SecurityAttributes securityAttributes = new WindowsLibrary.SecurityAttributes();
                        securityAttributes.length = new WinDef.DWORD((long) securityAttributes.size());
                        securityAttributes.securityDescriptor = security_descriptor.getPointer();
                        WinNT.HANDLE CreateMutex = this.library.CreateMutex(securityAttributes, false, CREATION_MUTEX_NAME);
                        if (CreateMutex == null) {
                            int GetLastError = Kernel32.INSTANCE.GetLastError();
                            if (GetLastError == 183) {
                                CreateMutex = this.library.OpenMutex(2031617, false, CREATION_MUTEX_NAME);
                                if (CreateMutex == null) {
                                    throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
                                }
                            } else {
                                throw new Win32Exception(GetLastError);
                            }
                        }
                        int WaitForSingleObject = Kernel32.INSTANCE.WaitForSingleObject(CreateMutex, 2000);
                        if (WaitForSingleObject == -1 || WaitForSingleObject == 258) {
                            throw new Win32Exception(WaitForSingleObject);
                        }
                        try {
                            StringBuilder sb2 = new StringBuilder();
                            if (z10) {
                                str2 = "Global\\";
                            } else {
                                str2 = "";
                            }
                            sb2.append(str2);
                            sb2.append((file.getAbsolutePath() + '_' + str).replaceAll("[^a-zA-Z0-9_]", ""));
                            sb2.append("_semaphore");
                            String sb3 = sb2.toString();
                            WinNT.HANDLE OpenSemaphoreW = this.library.OpenSemaphoreW(WindowsLibrary.SEMAPHORE_ALL_ACCESS, false, sb3);
                            if (OpenSemaphoreW == null) {
                                WinNT.HANDLE CreateSemaphoreW = this.library.CreateSemaphoreW((WinBase.SECURITY_ATTRIBUTES) null, 0, 2147483647L, sb3);
                                if (CreateSemaphoreW != null) {
                                    WindowsLibrary windowsLibrary = this.library;
                                    WinNT.HANDLE CreateSemaphoreW2 = windowsLibrary.CreateSemaphoreW((WinBase.SECURITY_ATTRIBUTES) null, 0, 2147483647L, sb3 + "_set0");
                                    if (CreateSemaphoreW2 != null) {
                                        AttachmentHandle attachmentHandle = new AttachmentHandle(CreateSemaphoreW, CreateSemaphoreW2);
                                        if (this.library.ReleaseMutex(CreateMutex)) {
                                            return attachmentHandle;
                                        }
                                        throw new Win32Exception(Native.getLastError());
                                    }
                                    throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
                                }
                                throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
                            }
                            WindowsLibrary windowsLibrary2 = this.library;
                            WinNT.HANDLE OpenSemaphoreW2 = windowsLibrary2.OpenSemaphoreW(WindowsLibrary.SEMAPHORE_ALL_ACCESS, false, sb3 + "_set0");
                            if (OpenSemaphoreW2 != null) {
                                AttachmentHandle attachmentHandle2 = new AttachmentHandle(OpenSemaphoreW, OpenSemaphoreW2);
                                if (this.library.ReleaseMutex(CreateMutex)) {
                                    return attachmentHandle2;
                                }
                                throw new Win32Exception(Native.getLastError());
                            }
                            throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
                        } catch (Throwable th2) {
                            if (!this.library.ReleaseMutex(CreateMutex)) {
                                throw new Win32Exception(Native.getLastError());
                            }
                            throw th2;
                        }
                    } else {
                        throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
                    }
                }

                /* JADX WARNING: Code restructure failed: missing block: B:11:0x0020, code lost:
                    return;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:14:0x0026, code lost:
                    throw new com.sun.jna.platform.win32.Win32Exception(r4);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:9:0x001b, code lost:
                    if (r4 != 258) goto L_0x0021;
                 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void decrementSemaphore(java.io.File r2, java.lang.String r3, boolean r4, int r5) {
                    /*
                        r1 = this;
                        net.bytebuddy.agent.VirtualMachine$ForOpenJ9$Dispatcher$ForJnaWindowsEnvironment$AttachmentHandle r2 = r1.openSemaphore(r2, r3, r4)
                    L_0x0004:
                        int r3 = r5 + -1
                        if (r5 <= 0) goto L_0x002e
                        com.sun.jna.platform.win32.Kernel32 r4 = com.sun.jna.platform.win32.Kernel32.INSTANCE     // Catch:{ all -> 0x0029 }
                        com.sun.jna.platform.win32.WinNT$HANDLE r5 = r2.getHandle()     // Catch:{ all -> 0x0029 }
                        r0 = 0
                        int r4 = r4.WaitForSingleObject(r5, r0)     // Catch:{ all -> 0x0029 }
                        if (r4 == 0) goto L_0x0027
                        r5 = 128(0x80, float:1.794E-43)
                        if (r4 == r5) goto L_0x0027
                        r3 = 258(0x102, float:3.62E-43)
                        if (r4 != r3) goto L_0x0021
                        r2.close()
                        return
                    L_0x0021:
                        com.sun.jna.platform.win32.Win32Exception r3 = new com.sun.jna.platform.win32.Win32Exception     // Catch:{ all -> 0x0029 }
                        r3.<init>(r4)     // Catch:{ all -> 0x0029 }
                        throw r3     // Catch:{ all -> 0x0029 }
                    L_0x0027:
                        r5 = r3
                        goto L_0x0004
                    L_0x0029:
                        r3 = move-exception
                        r2.close()
                        throw r3
                    L_0x002e:
                        r2.close()
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.agent.VirtualMachine.ForOpenJ9.Dispatcher.ForJnaWindowsEnvironment.decrementSemaphore(java.io.File, java.lang.String, boolean, int):void");
                }

                public int getOwnerIdOf(File file) {
                    return 0;
                }

                public String getTemporaryFolder(String str) {
                    WinDef.DWORD dword = new WinDef.DWORD(260);
                    char[] cArr = new char[dword.intValue()];
                    if (Kernel32.INSTANCE.GetTempPath(dword, cArr).intValue() != 0) {
                        return Native.toString(cArr);
                    }
                    throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
                }

                public void incrementSemaphore(File file, String str, boolean z10, int i10) {
                    AttachmentHandle openSemaphore = openSemaphore(file, str, z10);
                    while (true) {
                        int i11 = i10 - 1;
                        if (i10 > 0) {
                            try {
                                if (this.library.ReleaseSemaphore(openSemaphore.getHandle(), 1, (Long) null)) {
                                    i10 = i11;
                                } else {
                                    throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
                                }
                            } catch (Throwable th2) {
                                openSemaphore.close();
                                throw th2;
                            }
                        } else {
                            openSemaphore.close();
                            return;
                        }
                    }
                }

                public boolean isExistingProcess(int i10) {
                    WinNT.HANDLE OpenProcess = Kernel32.INSTANCE.OpenProcess(1024, false, i10);
                    if (OpenProcess != null) {
                        IntByReference intByReference = new IntByReference();
                        if (!Kernel32.INSTANCE.GetExitCodeProcess(OpenProcess, intByReference)) {
                            throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
                        } else if (intByReference.getValue() == 259) {
                            return true;
                        } else {
                            return false;
                        }
                    } else {
                        throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
                    }
                }

                public int pid() {
                    return Kernel32.INSTANCE.GetCurrentProcessId();
                }

                public void setPermissions(File file, int i10) {
                }

                public int userId() {
                    return 0;
                }
            }

            void decrementSemaphore(File file, String str, boolean z10, int i10);

            int getOwnerIdOf(File file);

            String getTemporaryFolder(String str);

            void incrementSemaphore(File file, String str, boolean z10, int i10);

            boolean isExistingProcess(int i10);

            int pid();

            void setPermissions(File file, int i10);

            int userId();
        }

        protected ForOpenJ9(Socket socket2) {
            this.socket = socket2;
        }

        public static VirtualMachine attach(String str) throws IOException {
            return attach(str, FacebookParse.FB_NO_LIMIT, Platform.isWindows() ? new Dispatcher.ForJnaWindowsEnvironment() : new Dispatcher.ForJnaPosixEnvironment(15, 100, TimeUnit.MILLISECONDS));
        }

        private static byte[] read(Socket socket2) throws IOException {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = socket2.getInputStream().read(bArr);
                if (read == -1) {
                    break;
                }
                if (read > 0) {
                    int i10 = read - 1;
                    if (bArr[i10] == 0) {
                        byteArrayOutputStream.write(bArr, 0, i10);
                        break;
                    }
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            return byteArrayOutputStream.toByteArray();
        }

        private static void write(Socket socket2, byte[] bArr) throws IOException {
            socket2.getOutputStream().write(bArr);
            socket2.getOutputStream().write(0);
            socket2.getOutputStream().flush();
        }

        public void detach() throws IOException {
            try {
                write(this.socket, "ATTACH_DETACH".getBytes("UTF-8"));
                read(this.socket);
            } finally {
                this.socket.close();
            }
        }

        public Properties getAgentProperties() throws IOException {
            write(this.socket, "ATTACH_GETAGENTPROPERTIES".getBytes("UTF-8"));
            Properties properties = new Properties();
            properties.load(new ByteArrayInputStream(read(this.socket)));
            return properties;
        }

        public Properties getSystemProperties() throws IOException {
            write(this.socket, "ATTACH_GETSYSTEMPROPERTIES".getBytes("UTF-8"));
            Properties properties = new Properties();
            properties.load(new ByteArrayInputStream(read(this.socket)));
            return properties;
        }

        public void loadAgent(String str, @MaybeNull String str2) throws IOException {
            Socket socket2 = this.socket;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("ATTACH_LOADAGENT(instrument,");
            sb2.append(str);
            sb2.append(SignatureVisitor.INSTANCEOF);
            if (str2 == null) {
                str2 = "";
            }
            sb2.append(str2);
            sb2.append(PropertyUtils.MAPPED_DELIM2);
            write(socket2, sb2.toString().getBytes("UTF-8"));
            String str3 = new String(read(this.socket), "UTF-8");
            if (str3.startsWith("ATTACH_ERR")) {
                throw new IllegalStateException("Target VM failed loading agent: " + str3);
            } else if (!str3.startsWith("ATTACH_ACK") && !str3.startsWith("ATTACH_RESULT=")) {
                throw new IllegalStateException("Unexpected response: " + str3);
            }
        }

        public void loadAgentLibrary(String str, @MaybeNull String str2) throws IOException {
            String str3;
            Socket socket2 = this.socket;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("ATTACH_LOADAGENTLIBRARY(");
            sb2.append(str);
            if (str2 == null) {
                str3 = "";
            } else {
                str3 = ',' + str2;
            }
            sb2.append(str3);
            sb2.append(PropertyUtils.MAPPED_DELIM2);
            write(socket2, sb2.toString().getBytes("UTF-8"));
            String str4 = new String(read(this.socket), "UTF-8");
            if (str4.startsWith("ATTACH_ERR")) {
                throw new IllegalStateException("Target VM failed loading native library: " + str4);
            } else if (!str4.startsWith("ATTACH_ACK") && !str4.startsWith("ATTACH_RESULT=")) {
                throw new IllegalStateException("Unexpected response: " + str4);
            }
        }

        public void loadAgentPath(String str, @MaybeNull String str2) throws IOException {
            String str3;
            Socket socket2 = this.socket;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("ATTACH_LOADAGENTPATH(");
            sb2.append(str);
            if (str2 == null) {
                str3 = "";
            } else {
                str3 = ',' + str2;
            }
            sb2.append(str3);
            sb2.append(PropertyUtils.MAPPED_DELIM2);
            write(socket2, sb2.toString().getBytes("UTF-8"));
            String str4 = new String(read(this.socket), "UTF-8");
            if (str4.startsWith("ATTACH_ERR")) {
                throw new IllegalStateException("Target VM failed loading native agent: " + str4);
            } else if (!str4.startsWith("ATTACH_ACK") && !str4.startsWith("ATTACH_RESULT=")) {
                throw new IllegalStateException("Unexpected response: " + str4);
            }
        }

        public String startLocalManagementAgent() throws IOException {
            write(this.socket, "ATTACH_START_LOCAL_MANAGEMENT_AGENT".getBytes("UTF-8"));
            String str = new String(read(this.socket), "UTF-8");
            if (str.startsWith("ATTACH_ERR")) {
                throw new IllegalStateException("Target VM could not start management agent: " + str);
            } else if (str.startsWith("ATTACH_ACK")) {
                return str.substring(10);
            } else {
                if (str.startsWith("ATTACH_RESULT=")) {
                    return str.substring(14);
                }
                throw new IllegalStateException("Unexpected response: " + str);
            }
        }

        public void startManagementAgent(Properties properties) throws IOException {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            properties.store(byteArrayOutputStream, (String) null);
            write(this.socket, "ATTACH_START_MANAGEMENT_AGENT".getBytes("UTF-8"));
            write(this.socket, byteArrayOutputStream.toByteArray());
            String str = new String(read(this.socket), "UTF-8");
            if (str.startsWith("ATTACH_ERR")) {
                throw new IllegalStateException("Target VM could not start management agent: " + str);
            } else if (!str.startsWith("ATTACH_ACK") && !str.startsWith("ATTACH_RESULT=")) {
                throw new IllegalStateException("Unexpected response: " + str);
            }
        }

        /* JADX INFO: finally extract failed */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:97|(1:99)(1:100)|101|102|103|104|105|229) */
        /* JADX WARNING: Missing exception handler attribute for start block: B:104:0x01eb */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static net.bytebuddy.agent.VirtualMachine attach(java.lang.String r23, int r24, net.bytebuddy.agent.VirtualMachine.ForOpenJ9.Dispatcher r25) throws java.io.IOException {
            /*
                r0 = r23
                r1 = r25
                java.io.File r2 = new java.io.File
                java.lang.String r3 = "com.ibm.tools.attach.directory"
                java.lang.String r4 = r1.getTemporaryFolder(r0)
                java.lang.String r3 = java.lang.System.getProperty(r3, r4)
                java.lang.String r4 = ".com_ibm_tools_attach"
                r2.<init>(r3, r4)
                java.io.RandomAccessFile r3 = new java.io.RandomAccessFile
                java.io.File r4 = new java.io.File
                java.lang.String r5 = "_attachlock"
                r4.<init>(r2, r5)
                java.lang.String r5 = "rw"
                r3.<init>(r4, r5)
                java.nio.channels.FileChannel r4 = r3.getChannel()     // Catch:{ all -> 0x0359 }
                java.nio.channels.FileLock r4 = r4.lock()     // Catch:{ all -> 0x0359 }
                java.io.RandomAccessFile r5 = new java.io.RandomAccessFile     // Catch:{ all -> 0x0354 }
                java.io.File r6 = new java.io.File     // Catch:{ all -> 0x0354 }
                java.lang.String r7 = "_master"
                r6.<init>(r2, r7)     // Catch:{ all -> 0x0354 }
                java.lang.String r7 = "rw"
                r5.<init>(r6, r7)     // Catch:{ all -> 0x0354 }
                java.nio.channels.FileChannel r6 = r5.getChannel()     // Catch:{ all -> 0x034f }
                java.nio.channels.FileLock r6 = r6.lock()     // Catch:{ all -> 0x034f }
                java.io.File[] r7 = r2.listFiles()     // Catch:{ all -> 0x034a }
                if (r7 == 0) goto L_0x0333
                int r8 = r25.userId()     // Catch:{ all -> 0x034a }
                long r8 = (long) r8     // Catch:{ all -> 0x034a }
                java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ all -> 0x034a }
                r10.<init>()     // Catch:{ all -> 0x034a }
                int r11 = r7.length     // Catch:{ all -> 0x034a }
                r13 = 0
            L_0x0053:
                if (r13 >= r11) goto L_0x0105
                r14 = r7[r13]     // Catch:{ all -> 0x034a }
                boolean r15 = r14.isDirectory()     // Catch:{ all -> 0x034a }
                if (r15 == 0) goto L_0x00f7
                int r15 = r1.getOwnerIdOf(r14)     // Catch:{ all -> 0x034a }
                r16 = r13
                long r12 = (long) r15     // Catch:{ all -> 0x034a }
                int r12 = (r12 > r8 ? 1 : (r12 == r8 ? 0 : -1))
                if (r12 != 0) goto L_0x00f2
                java.io.File r12 = new java.io.File     // Catch:{ all -> 0x034a }
                java.lang.String r13 = "attachInfo"
                r12.<init>(r14, r13)     // Catch:{ all -> 0x034a }
                boolean r13 = r12.isFile()     // Catch:{ all -> 0x034a }
                if (r13 == 0) goto L_0x00f2
                java.util.Properties r13 = new java.util.Properties     // Catch:{ all -> 0x034a }
                r13.<init>()     // Catch:{ all -> 0x034a }
                java.io.FileInputStream r15 = new java.io.FileInputStream     // Catch:{ all -> 0x034a }
                r15.<init>(r12)     // Catch:{ all -> 0x034a }
                r13.load(r15)     // Catch:{ all -> 0x00ec }
                r15.close()     // Catch:{ all -> 0x034a }
                java.lang.String r15 = "processId"
                java.lang.String r15 = r13.getProperty(r15)     // Catch:{ all -> 0x034a }
                int r15 = java.lang.Integer.parseInt(r15)     // Catch:{ all -> 0x034a }
                r17 = 0
                r19 = r7
                java.lang.String r7 = "userUid"
                java.lang.String r7 = r13.getProperty(r7)     // Catch:{ NumberFormatException -> 0x009e }
                long r20 = java.lang.Long.parseLong(r7)     // Catch:{ NumberFormatException -> 0x009e }
                goto L_0x00a0
            L_0x009e:
                r20 = r17
            L_0x00a0:
                int r7 = (r8 > r17 ? 1 : (r8 == r17 ? 0 : -1))
                if (r7 == 0) goto L_0x00b2
                int r22 = (r20 > r17 ? 1 : (r20 == r17 ? 0 : -1))
                if (r22 != 0) goto L_0x00b2
                int r12 = r1.getOwnerIdOf(r12)     // Catch:{ all -> 0x034a }
                r22 = r11
                long r11 = (long) r12     // Catch:{ all -> 0x034a }
                r20 = r11
                goto L_0x00b4
            L_0x00b2:
                r22 = r11
            L_0x00b4:
                long r11 = (long) r15     // Catch:{ all -> 0x034a }
                int r11 = (r11 > r17 ? 1 : (r11 == r17 ? 0 : -1))
                if (r11 == 0) goto L_0x00e8
                boolean r11 = r1.isExistingProcess(r15)     // Catch:{ all -> 0x034a }
                if (r11 == 0) goto L_0x00c0
                goto L_0x00e8
            L_0x00c0:
                if (r7 == 0) goto L_0x00c6
                int r7 = (r20 > r8 ? 1 : (r20 == r8 ? 0 : -1))
                if (r7 != 0) goto L_0x00fd
            L_0x00c6:
                java.io.File[] r7 = r14.listFiles()     // Catch:{ all -> 0x034a }
                if (r7 == 0) goto L_0x00de
                int r11 = r7.length     // Catch:{ all -> 0x034a }
                r12 = 0
            L_0x00ce:
                if (r12 >= r11) goto L_0x00de
                r13 = r7[r12]     // Catch:{ all -> 0x034a }
                boolean r15 = r13.delete()     // Catch:{ all -> 0x034a }
                if (r15 != 0) goto L_0x00db
                r13.deleteOnExit()     // Catch:{ all -> 0x034a }
            L_0x00db:
                int r12 = r12 + 1
                goto L_0x00ce
            L_0x00de:
                boolean r7 = r14.delete()     // Catch:{ all -> 0x034a }
                if (r7 != 0) goto L_0x00fd
                r14.deleteOnExit()     // Catch:{ all -> 0x034a }
                goto L_0x00fd
            L_0x00e8:
                r10.add(r13)     // Catch:{ all -> 0x034a }
                goto L_0x00fd
            L_0x00ec:
                r0 = move-exception
                r1 = r0
                r15.close()     // Catch:{ all -> 0x034a }
                throw r1     // Catch:{ all -> 0x034a }
            L_0x00f2:
                r19 = r7
                r22 = r11
                goto L_0x00fd
            L_0x00f7:
                r19 = r7
                r22 = r11
                r16 = r13
            L_0x00fd:
                int r13 = r16 + 1
                r7 = r19
                r11 = r22
                goto L_0x0053
            L_0x0105:
                r6.release()     // Catch:{ all -> 0x034f }
                r5.close()     // Catch:{ all -> 0x0354 }
                r5 = 0
                java.util.Iterator r6 = r10.iterator()     // Catch:{ all -> 0x0354 }
            L_0x0110:
                boolean r7 = r6.hasNext()     // Catch:{ all -> 0x0354 }
                if (r7 == 0) goto L_0x0129
                java.lang.Object r7 = r6.next()     // Catch:{ all -> 0x0354 }
                java.util.Properties r7 = (java.util.Properties) r7     // Catch:{ all -> 0x0354 }
                java.lang.String r8 = "processId"
                java.lang.String r8 = r7.getProperty(r8)     // Catch:{ all -> 0x0354 }
                boolean r8 = r8.equalsIgnoreCase(r0)     // Catch:{ all -> 0x0354 }
                if (r8 == 0) goto L_0x0110
                r5 = r7
            L_0x0129:
                if (r5 == 0) goto L_0x031c
                java.net.ServerSocket r6 = new java.net.ServerSocket     // Catch:{ all -> 0x0354 }
                r0 = 0
                r6.<init>(r0)     // Catch:{ all -> 0x0354 }
                r7 = r24
                r6.setSoTimeout(r7)     // Catch:{ all -> 0x0317 }
                java.io.File r7 = new java.io.File     // Catch:{ all -> 0x0317 }
                java.lang.String r8 = "vmId"
                java.lang.String r8 = r5.getProperty(r8)     // Catch:{ all -> 0x0317 }
                r7.<init>(r2, r8)     // Catch:{ all -> 0x0317 }
                java.security.SecureRandom r8 = SECURE_RANDOM     // Catch:{ all -> 0x0317 }
                monitor-enter(r8)     // Catch:{ all -> 0x0317 }
                long r11 = r8.nextLong()     // Catch:{ all -> 0x0314 }
                java.lang.String r9 = java.lang.Long.toHexString(r11)     // Catch:{ all -> 0x0314 }
                monitor-exit(r8)     // Catch:{ all -> 0x0314 }
                java.io.File r8 = new java.io.File     // Catch:{ all -> 0x0317 }
                java.lang.String r11 = "replyInfo"
                r8.<init>(r7, r11)     // Catch:{ all -> 0x0317 }
                boolean r7 = r8.createNewFile()     // Catch:{ all -> 0x0309 }
                if (r7 == 0) goto L_0x015f
                r7 = 384(0x180, float:5.38E-43)
                r1.setPermissions(r8, r7)     // Catch:{ all -> 0x0309 }
            L_0x015f:
                java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch:{ all -> 0x0309 }
                r7.<init>(r8)     // Catch:{ all -> 0x0309 }
                java.lang.String r11 = "UTF-8"
                byte[] r11 = r9.getBytes(r11)     // Catch:{ all -> 0x0304 }
                r7.write(r11)     // Catch:{ all -> 0x0304 }
                java.lang.String r11 = "\n"
                java.lang.String r12 = "UTF-8"
                byte[] r11 = r11.getBytes(r12)     // Catch:{ all -> 0x0304 }
                r7.write(r11)     // Catch:{ all -> 0x0304 }
                int r11 = r6.getLocalPort()     // Catch:{ all -> 0x0304 }
                long r11 = (long) r11     // Catch:{ all -> 0x0304 }
                java.lang.String r11 = java.lang.Long.toString(r11)     // Catch:{ all -> 0x0304 }
                java.lang.String r12 = "UTF-8"
                byte[] r11 = r11.getBytes(r12)     // Catch:{ all -> 0x0304 }
                r7.write(r11)     // Catch:{ all -> 0x0304 }
                java.lang.String r11 = "\n"
                java.lang.String r12 = "UTF-8"
                byte[] r11 = r11.getBytes(r12)     // Catch:{ all -> 0x0304 }
                r7.write(r11)     // Catch:{ all -> 0x0304 }
                r7.close()     // Catch:{ all -> 0x0309 }
                java.util.HashMap r7 = new java.util.HashMap     // Catch:{ all -> 0x0309 }
                r7.<init>()     // Catch:{ all -> 0x0309 }
                int r11 = r25.pid()     // Catch:{ all -> 0x02ce }
                long r11 = (long) r11     // Catch:{ all -> 0x02ce }
                java.lang.String r11 = java.lang.Long.toString(r11)     // Catch:{ all -> 0x02ce }
                java.util.Iterator r10 = r10.iterator()     // Catch:{ all -> 0x02ce }
            L_0x01aa:
                boolean r12 = r10.hasNext()     // Catch:{ all -> 0x02ce }
                if (r12 == 0) goto L_0x01ef
                java.lang.Object r12 = r10.next()     // Catch:{ all -> 0x02ce }
                java.util.Properties r12 = (java.util.Properties) r12     // Catch:{ all -> 0x02ce }
                java.lang.String r13 = "processId"
                java.lang.String r13 = r12.getProperty(r13)     // Catch:{ all -> 0x02ce }
                boolean r13 = r13.equalsIgnoreCase(r11)     // Catch:{ all -> 0x02ce }
                if (r13 != 0) goto L_0x01aa
                java.lang.String r13 = "attachNotificationSync"
                java.lang.String r12 = r12.getProperty(r13)     // Catch:{ all -> 0x02ce }
                java.io.RandomAccessFile r13 = new java.io.RandomAccessFile     // Catch:{ all -> 0x02ce }
                if (r12 != 0) goto L_0x01d4
                java.io.File r12 = new java.io.File     // Catch:{ all -> 0x02ce }
                java.lang.String r14 = "attachNotificationSync"
                r12.<init>(r2, r14)     // Catch:{ all -> 0x02ce }
                goto L_0x01da
            L_0x01d4:
                java.io.File r14 = new java.io.File     // Catch:{ all -> 0x02ce }
                r14.<init>(r12)     // Catch:{ all -> 0x02ce }
                r12 = r14
            L_0x01da:
                java.lang.String r14 = "rw"
                r13.<init>(r12, r14)     // Catch:{ all -> 0x02ce }
                java.nio.channels.FileChannel r12 = r13.getChannel()     // Catch:{ IOException -> 0x01eb }
                java.nio.channels.FileLock r12 = r12.lock()     // Catch:{ IOException -> 0x01eb }
                r7.put(r13, r12)     // Catch:{ IOException -> 0x01eb }
                goto L_0x01aa
            L_0x01eb:
                r13.close()     // Catch:{ all -> 0x02ce }
                goto L_0x01aa
            L_0x01ef:
                java.io.File[] r10 = r2.listFiles()     // Catch:{ all -> 0x02ce }
                if (r10 == 0) goto L_0x0224
                int r11 = r10.length     // Catch:{ all -> 0x02ce }
                r12 = r0
            L_0x01f7:
                if (r12 >= r11) goto L_0x0224
                r13 = r10[r12]     // Catch:{ all -> 0x02ce }
                java.lang.String r13 = r13.getName()     // Catch:{ all -> 0x02ce }
                java.lang.String r14 = ".trash_"
                boolean r14 = r13.startsWith(r14)     // Catch:{ all -> 0x02ce }
                if (r14 != 0) goto L_0x0221
                java.lang.String r14 = "_attachlock"
                boolean r14 = r13.equalsIgnoreCase(r14)     // Catch:{ all -> 0x02ce }
                if (r14 != 0) goto L_0x0221
                java.lang.String r14 = "_master"
                boolean r14 = r13.equalsIgnoreCase(r14)     // Catch:{ all -> 0x02ce }
                if (r14 != 0) goto L_0x0221
                java.lang.String r14 = "_notifier"
                boolean r13 = r13.equalsIgnoreCase(r14)     // Catch:{ all -> 0x02ce }
                if (r13 != 0) goto L_0x0221
                int r0 = r0 + 1
            L_0x0221:
                int r12 = r12 + 1
                goto L_0x01f7
            L_0x0224:
                r12 = r0
                java.lang.String r0 = "globalSemaphore"
                java.lang.String r0 = r5.getProperty(r0)     // Catch:{ all -> 0x02ce }
                boolean r5 = java.lang.Boolean.parseBoolean(r0)     // Catch:{ all -> 0x02ce }
                java.lang.String r0 = "_notifier"
                r1.incrementSemaphore(r2, r0, r5, r12)     // Catch:{ all -> 0x02ce }
                java.net.Socket r0 = r6.accept()     // Catch:{ all -> 0x02c7 }
                java.lang.String r10 = new java.lang.String     // Catch:{ all -> 0x02c7 }
                byte[] r11 = read(r0)     // Catch:{ all -> 0x02c7 }
                java.lang.String r13 = "UTF-8"
                r10.<init>(r11, r13)     // Catch:{ all -> 0x02c7 }
                java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x02c7 }
                r11.<init>()     // Catch:{ all -> 0x02c7 }
                r13 = 32
                r11.append(r13)     // Catch:{ all -> 0x02c7 }
                r11.append(r9)     // Catch:{ all -> 0x02c7 }
                r11.append(r13)     // Catch:{ all -> 0x02c7 }
                java.lang.String r9 = r11.toString()     // Catch:{ all -> 0x02c7 }
                boolean r9 = r10.contains(r9)     // Catch:{ all -> 0x02c7 }
                if (r9 == 0) goto L_0x02ad
                net.bytebuddy.agent.VirtualMachine$ForOpenJ9 r9 = new net.bytebuddy.agent.VirtualMachine$ForOpenJ9     // Catch:{ all -> 0x02c7 }
                r9.<init>(r0)     // Catch:{ all -> 0x02c7 }
                java.lang.String r0 = "_notifier"
                r1.decrementSemaphore(r2, r0, r5, r12)     // Catch:{ all -> 0x02ce }
                java.util.Set r0 = r7.entrySet()     // Catch:{ all -> 0x0309 }
                java.util.Iterator r1 = r0.iterator()     // Catch:{ all -> 0x0309 }
            L_0x026f:
                boolean r0 = r1.hasNext()     // Catch:{ all -> 0x0309 }
                if (r0 == 0) goto L_0x029a
                java.lang.Object r0 = r1.next()     // Catch:{ all -> 0x0309 }
                r2 = r0
                java.util.Map$Entry r2 = (java.util.Map.Entry) r2     // Catch:{ all -> 0x0309 }
                java.lang.Object r0 = r2.getValue()     // Catch:{ all -> 0x028f }
                java.nio.channels.FileLock r0 = (java.nio.channels.FileLock) r0     // Catch:{ all -> 0x028f }
                r0.release()     // Catch:{ all -> 0x028f }
                java.lang.Object r0 = r2.getKey()     // Catch:{ all -> 0x026f }
                java.io.RandomAccessFile r0 = (java.io.RandomAccessFile) r0     // Catch:{ all -> 0x026f }
                r0.close()     // Catch:{ all -> 0x026f }
                goto L_0x026f
            L_0x028f:
                r0 = move-exception
                java.lang.Object r2 = r2.getKey()     // Catch:{ all -> 0x026f }
                java.io.RandomAccessFile r2 = (java.io.RandomAccessFile) r2     // Catch:{ all -> 0x026f }
                r2.close()     // Catch:{ all -> 0x026f }
                throw r0     // Catch:{ all -> 0x026f }
            L_0x029a:
                boolean r0 = r8.delete()     // Catch:{ all -> 0x0317 }
                if (r0 != 0) goto L_0x02a3
                r8.deleteOnExit()     // Catch:{ all -> 0x0317 }
            L_0x02a3:
                r6.close()     // Catch:{ all -> 0x0354 }
                r4.release()     // Catch:{ all -> 0x0359 }
                r3.close()
                return r9
            L_0x02ad:
                r0.close()     // Catch:{ all -> 0x02c7 }
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x02c7 }
                java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x02c7 }
                r9.<init>()     // Catch:{ all -> 0x02c7 }
                java.lang.String r11 = "Unexpected answered to attachment: "
                r9.append(r11)     // Catch:{ all -> 0x02c7 }
                r9.append(r10)     // Catch:{ all -> 0x02c7 }
                java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x02c7 }
                r0.<init>(r9)     // Catch:{ all -> 0x02c7 }
                throw r0     // Catch:{ all -> 0x02c7 }
            L_0x02c7:
                r0 = move-exception
                java.lang.String r9 = "_notifier"
                r1.decrementSemaphore(r2, r9, r5, r12)     // Catch:{ all -> 0x02ce }
                throw r0     // Catch:{ all -> 0x02ce }
            L_0x02ce:
                r0 = move-exception
                r1 = r0
                java.util.Set r0 = r7.entrySet()     // Catch:{ all -> 0x0309 }
                java.util.Iterator r2 = r0.iterator()     // Catch:{ all -> 0x0309 }
            L_0x02d8:
                boolean r0 = r2.hasNext()     // Catch:{ all -> 0x0309 }
                if (r0 == 0) goto L_0x0303
                java.lang.Object r0 = r2.next()     // Catch:{ all -> 0x0309 }
                r5 = r0
                java.util.Map$Entry r5 = (java.util.Map.Entry) r5     // Catch:{ all -> 0x0309 }
                java.lang.Object r0 = r5.getValue()     // Catch:{ all -> 0x02f8 }
                java.nio.channels.FileLock r0 = (java.nio.channels.FileLock) r0     // Catch:{ all -> 0x02f8 }
                r0.release()     // Catch:{ all -> 0x02f8 }
                java.lang.Object r0 = r5.getKey()     // Catch:{ all -> 0x02d8 }
                java.io.RandomAccessFile r0 = (java.io.RandomAccessFile) r0     // Catch:{ all -> 0x02d8 }
                r0.close()     // Catch:{ all -> 0x02d8 }
                goto L_0x02d8
            L_0x02f8:
                r0 = move-exception
                java.lang.Object r5 = r5.getKey()     // Catch:{ all -> 0x02d8 }
                java.io.RandomAccessFile r5 = (java.io.RandomAccessFile) r5     // Catch:{ all -> 0x02d8 }
                r5.close()     // Catch:{ all -> 0x02d8 }
                throw r0     // Catch:{ all -> 0x02d8 }
            L_0x0303:
                throw r1     // Catch:{ all -> 0x0309 }
            L_0x0304:
                r0 = move-exception
                r7.close()     // Catch:{ all -> 0x0309 }
                throw r0     // Catch:{ all -> 0x0309 }
            L_0x0309:
                r0 = move-exception
                boolean r1 = r8.delete()     // Catch:{ all -> 0x0317 }
                if (r1 != 0) goto L_0x0313
                r8.deleteOnExit()     // Catch:{ all -> 0x0317 }
            L_0x0313:
                throw r0     // Catch:{ all -> 0x0317 }
            L_0x0314:
                r0 = move-exception
                monitor-exit(r8)     // Catch:{ all -> 0x0314 }
                throw r0     // Catch:{ all -> 0x0317 }
            L_0x0317:
                r0 = move-exception
                r6.close()     // Catch:{ all -> 0x0354 }
                throw r0     // Catch:{ all -> 0x0354 }
            L_0x031c:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0354 }
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0354 }
                r1.<init>()     // Catch:{ all -> 0x0354 }
                java.lang.String r5 = "Could not locate target process info in "
                r1.append(r5)     // Catch:{ all -> 0x0354 }
                r1.append(r2)     // Catch:{ all -> 0x0354 }
                java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0354 }
                r0.<init>(r1)     // Catch:{ all -> 0x0354 }
                throw r0     // Catch:{ all -> 0x0354 }
            L_0x0333:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x034a }
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x034a }
                r1.<init>()     // Catch:{ all -> 0x034a }
                java.lang.String r7 = "No descriptor files found in "
                r1.append(r7)     // Catch:{ all -> 0x034a }
                r1.append(r2)     // Catch:{ all -> 0x034a }
                java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x034a }
                r0.<init>(r1)     // Catch:{ all -> 0x034a }
                throw r0     // Catch:{ all -> 0x034a }
            L_0x034a:
                r0 = move-exception
                r6.release()     // Catch:{ all -> 0x034f }
                throw r0     // Catch:{ all -> 0x034f }
            L_0x034f:
                r0 = move-exception
                r5.close()     // Catch:{ all -> 0x0354 }
                throw r0     // Catch:{ all -> 0x0354 }
            L_0x0354:
                r0 = move-exception
                r4.release()     // Catch:{ all -> 0x0359 }
                throw r0     // Catch:{ all -> 0x0359 }
            L_0x0359:
                r0 = move-exception
                r3.close()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.agent.VirtualMachine.ForOpenJ9.attach(java.lang.String, int, net.bytebuddy.agent.VirtualMachine$ForOpenJ9$Dispatcher):net.bytebuddy.agent.VirtualMachine");
        }
    }

    public enum Resolver implements PrivilegedAction<Class<? extends VirtualMachine>> {
        INSTANCE;

        public Class<? extends VirtualMachine> run() {
            try {
                Class.forName("com.sun.jna.Platform");
                return System.getProperty("java.vm.name", "").toUpperCase(Locale.US).contains("J9") ? ForOpenJ9.class : ForHotSpot.class;
            } catch (ClassNotFoundException e10) {
                throw new IllegalStateException("Optional JNA dependency is not available", e10);
            }
        }
    }

    void detach() throws IOException;

    Properties getAgentProperties() throws IOException;

    Properties getSystemProperties() throws IOException;

    void loadAgent(String str) throws IOException;

    void loadAgent(String str, @MaybeNull String str2) throws IOException;

    void loadAgentLibrary(String str) throws IOException;

    void loadAgentLibrary(String str, @MaybeNull String str2) throws IOException;

    void loadAgentPath(String str) throws IOException;

    void loadAgentPath(String str, @MaybeNull String str2) throws IOException;

    String startLocalManagementAgent() throws IOException;

    void startManagementAgent(Properties properties) throws IOException;

    public static class ForHotSpot extends AbstractBase {
        private static final String ARGUMENT_DELIMITER = "=";
        private static final String INSTRUMENT_COMMAND = "instrument";
        private static final String LOAD_COMMAND = "load";
        private static final String PROTOCOL_VERSION = "1";
        private final Connection connection;

        public interface Connection extends Closeable {

            public interface Factory {

                public static abstract class ForSocketFile implements Factory {
                    private static final String ATTACH_FILE_PREFIX = ".attach_pid";
                    private static final String SOCKET_FILE_PREFIX = ".java_pid";
                    private final int attempts;
                    private final long pause;
                    private final String temporaryDirectory;
                    private final TimeUnit timeUnit;

                    protected ForSocketFile(String str, int i10, long j10, TimeUnit timeUnit2) {
                        this.temporaryDirectory = str;
                        this.attempts = i10;
                        this.pause = j10;
                        this.timeUnit = timeUnit2;
                    }

                    @SuppressFBWarnings(justification = "File name convention is specified.", value = {"DMI_HARDCODED_ABSOLUTE_FILENAME"})
                    public Connection connect(String str) throws IOException {
                        File file = new File(this.temporaryDirectory, SOCKET_FILE_PREFIX + str);
                        if (!file.exists()) {
                            String str2 = ATTACH_FILE_PREFIX + str;
                            File file2 = new File("/proc/" + str + "/cwd/" + str2);
                            try {
                                if (!file2.createNewFile()) {
                                    if (!file2.isFile()) {
                                        throw new IllegalStateException("Could not create attach file: " + file2);
                                    }
                                }
                            } catch (IOException unused) {
                                file2 = new File(this.temporaryDirectory, str2);
                                if (!file2.createNewFile() && !file2.isFile()) {
                                    throw new IllegalStateException("Could not create attach file: " + file2);
                                }
                            }
                            try {
                                kill(str, 3);
                                int i10 = this.attempts;
                                while (!file.exists()) {
                                    int i11 = i10 - 1;
                                    if (i10 <= 0) {
                                        break;
                                    }
                                    this.timeUnit.sleep(this.pause);
                                    i10 = i11;
                                }
                                if (!file.exists()) {
                                    throw new IllegalStateException("Target VM did not respond: " + str);
                                } else if (!file2.delete()) {
                                    file2.deleteOnExit();
                                }
                            } catch (InterruptedException e10) {
                                Thread.currentThread().interrupt();
                                throw new IllegalStateException(e10);
                            } catch (Throwable th2) {
                                if (!file2.delete()) {
                                    file2.deleteOnExit();
                                }
                                throw th2;
                            }
                        }
                        return doConnect(file);
                    }

                    /* access modifiers changed from: protected */
                    public abstract Connection doConnect(File file) throws IOException;

                    /* access modifiers changed from: protected */
                    public abstract void kill(String str, int i10);
                }

                Connection connect(String str) throws IOException;
            }

            public static class ForJnaPosixSocket extends OnPersistentByteChannel<Integer> {
                private final PosixLibrary library;
                private final File socket;

                public static class Factory extends Factory.ForSocketFile {
                    private final PosixLibrary library = ((PosixLibrary) Native.loadLibrary("c", PosixLibrary.class));

                    public interface MacLibrary extends Library {
                        public static final int CS_DARWIN_USER_TEMP_DIR = 65537;

                        long confstr(int i10, Pointer pointer, long j10);
                    }

                    public Factory(String str, int i10, long j10, TimeUnit timeUnit) {
                        super(str, i10, j10, timeUnit);
                    }

                    public static Factory withDefaultTemporaryFolder(int i10, long j10, TimeUnit timeUnit) {
                        String str = "/tmp";
                        if (Platform.isMac()) {
                            MacLibrary macLibrary = (MacLibrary) Native.loadLibrary("c", MacLibrary.class);
                            Memory memory = new Memory(4096);
                            long confstr = macLibrary.confstr(65537, memory, memory.size());
                            if (confstr != 0) {
                                if (confstr <= 4096) {
                                    str = memory.getString(0);
                                }
                            }
                        }
                        return new Factory(str, i10, j10, timeUnit);
                    }

                    public Connection doConnect(File file) {
                        return new ForJnaPosixSocket(this.library, file);
                    }

                    /* access modifiers changed from: protected */
                    public void kill(String str, int i10) {
                        this.library.kill(Integer.parseInt(str), i10);
                    }
                }

                protected interface PosixLibrary extends Library {

                    public static class SocketAddress extends Structure {
                        @SuppressFBWarnings(justification = "Field required by native implementation.", value = {"URF_UNREAD_PUBLIC_OR_PROTECTED_FIELD"})
                        public short family = 1;
                        public byte[] path = new byte[100];

                        /* access modifiers changed from: protected */
                        public List<String> getFieldOrder() {
                            return Arrays.asList(new String[]{"family", "path"});
                        }

                        /* access modifiers changed from: protected */
                        public void setPath(String str) {
                            try {
                                System.arraycopy(str.getBytes("UTF-8"), 0, this.path, 0, str.length());
                                System.arraycopy(new byte[]{0}, 0, this.path, str.length(), 1);
                            } catch (UnsupportedEncodingException e10) {
                                throw new IllegalStateException(e10);
                            }
                        }
                    }

                    int close(int i10) throws LastErrorException;

                    int connect(int i10, SocketAddress socketAddress, int i11) throws LastErrorException;

                    int kill(int i10, int i11) throws LastErrorException;

                    int read(int i10, ByteBuffer byteBuffer, int i11) throws LastErrorException;

                    int socket(int i10, int i11, int i12) throws LastErrorException;

                    int write(int i10, ByteBuffer byteBuffer, int i11) throws LastErrorException;
                }

                protected ForJnaPosixSocket(PosixLibrary posixLibrary, File file) {
                    this.library = posixLibrary;
                    this.socket = file;
                }

                public void close() {
                }

                /* access modifiers changed from: protected */
                public void close(Integer num) {
                    this.library.close(num.intValue());
                }

                /* access modifiers changed from: protected */
                public Integer connect() {
                    int socket2 = this.library.socket(1, 1, 0);
                    try {
                        PosixLibrary.SocketAddress socketAddress = new PosixLibrary.SocketAddress();
                        socketAddress.setPath(this.socket.getAbsolutePath());
                        this.library.connect(socket2, socketAddress, socketAddress.size());
                        return Integer.valueOf(socket2);
                    } catch (RuntimeException e10) {
                        this.library.close(socket2);
                        throw e10;
                    }
                }

                /* access modifiers changed from: protected */
                public int read(Integer num, byte[] bArr) {
                    int read = this.library.read(num.intValue(), ByteBuffer.wrap(bArr), bArr.length);
                    if (read == 0) {
                        return -1;
                    }
                    return read;
                }

                /* access modifiers changed from: protected */
                public void write(Integer num, byte[] bArr) {
                    this.library.write(num.intValue(), ByteBuffer.wrap(bArr), bArr.length);
                }
            }

            public static class ForJnaSolarisDoor implements Connection {
                private final SolarisLibrary library;
                private final File socket;

                public static class Factory extends Factory.ForSocketFile {
                    private final SolarisLibrary library = ((SolarisLibrary) Native.loadLibrary("c", SolarisLibrary.class));

                    public Factory(int i10, long j10, TimeUnit timeUnit) {
                        super("/tmp", i10, j10, timeUnit);
                    }

                    /* access modifiers changed from: protected */
                    public Connection doConnect(File file) {
                        return new ForJnaSolarisDoor(this.library, file);
                    }

                    /* access modifiers changed from: protected */
                    public void kill(String str, int i10) {
                        this.library.kill(Integer.parseInt(str), i10);
                    }
                }

                protected static class Response implements Response {
                    private final int handle;
                    private final SolarisLibrary library;

                    protected Response(SolarisLibrary solarisLibrary, int i10) {
                        this.library = solarisLibrary;
                        this.handle = i10;
                    }

                    public void close() {
                        this.library.close(this.handle);
                    }

                    public int read(byte[] bArr) {
                        int read = this.library.read(this.handle, ByteBuffer.wrap(bArr), bArr.length);
                        if (read == 0) {
                            return -1;
                        }
                        return read;
                    }
                }

                protected interface SolarisLibrary extends Library {

                    public static class DoorArgument extends Structure {
                        @MaybeNull
                        public Pointer dataPointer;
                        public int dataSize;
                        public int descriptorCount;
                        @MaybeNull
                        public Pointer descriptorPointer;
                        @UnknownNull
                        public Pointer resultPointer;
                        public int resultSize;

                        /* access modifiers changed from: protected */
                        public List<String> getFieldOrder() {
                            return Arrays.asList(new String[]{"dataPointer", "dataSize", "descriptorPointer", "descriptorCount", "resultPointer", "resultSize"});
                        }
                    }

                    int close(int i10) throws LastErrorException;

                    int door_call(int i10, DoorArgument doorArgument) throws LastErrorException;

                    int kill(int i10, int i11) throws LastErrorException;

                    int open(String str, int i10) throws LastErrorException;

                    int read(int i10, ByteBuffer byteBuffer, int i11) throws LastErrorException;
                }

                protected ForJnaSolarisDoor(SolarisLibrary solarisLibrary, File file) {
                    this.library = solarisLibrary;
                    this.socket = file;
                }

                public void close() {
                }

                @SuppressFBWarnings(justification = "This pattern is required for use of JNA.", value = {"UWF_UNWRITTEN_PUBLIC_OR_PROTECTED_FIELD", "URF_UNREAD_PUBLIC_OR_PROTECTED_FIELD"})
                public Response execute(String str, String... strArr) throws IOException {
                    Pointer pointer;
                    int open = this.library.open(this.socket.getAbsolutePath(), 2);
                    try {
                        SolarisLibrary.DoorArgument doorArgument = new SolarisLibrary.DoorArgument();
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        byteArrayOutputStream.write(str.getBytes("UTF-8"));
                        byteArrayOutputStream.write(0);
                        for (String str2 : strArr) {
                            if (str2 != null) {
                                byteArrayOutputStream.write(str2.getBytes("UTF-8"));
                            }
                            byteArrayOutputStream.write(0);
                        }
                        doorArgument.dataSize = byteArrayOutputStream.size();
                        Memory memory = new Memory((long) byteArrayOutputStream.size());
                        memory.write(0, byteArrayOutputStream.toByteArray(), 0, byteArrayOutputStream.size());
                        doorArgument.dataPointer = memory;
                        Memory memory2 = new Memory(128);
                        doorArgument.resultPointer = memory2;
                        doorArgument.resultSize = (int) memory2.size();
                        if (this.library.door_call(open, doorArgument) != 0) {
                            throw new IllegalStateException("Door call to target VM failed");
                        } else if (doorArgument.resultSize < 4 || doorArgument.resultPointer.getInt(0) != 0) {
                            throw new IllegalStateException("Target VM could not execute door call");
                        } else if (doorArgument.descriptorCount == 1 && (pointer = doorArgument.descriptorPointer) != null) {
                            return new Response(this.library, pointer.getInt(4));
                        } else {
                            throw new IllegalStateException("Did not receive communication descriptor from target VM");
                        }
                    } finally {
                        this.library.close(open);
                    }
                }
            }

            public static class ForJnaWindowsNamedPipe implements Connection {
                private static final int MEM_RELEASE = 32768;
                private final WindowsAttachLibrary attachLibrary;
                private final WinDef.LPVOID code;
                private final WindowsLibrary library;
                private final WinNT.HANDLE process;
                private final SecureRandom random = new SecureRandom();

                public static class Factory implements Factory {
                    public static final String LIBRARY_NAME = "net.bytebuddy.library.name";
                    private final WindowsAttachLibrary attachLibrary = ((WindowsAttachLibrary) Native.loadLibrary(System.getProperty(LIBRARY_NAME, "attach_hotspot_windows"), WindowsAttachLibrary.class));
                    private final WindowsLibrary library = ((WindowsLibrary) Native.loadLibrary("kernel32", WindowsLibrary.class, W32APIOptions.DEFAULT_OPTIONS));

                    public Connection connect(String str) {
                        WinNT.HANDLE OpenProcess = Kernel32.INSTANCE.OpenProcess(2039803, false, Integer.parseInt(str));
                        if (OpenProcess != null) {
                            try {
                                WinDef.LPVOID allocate_remote_code = this.attachLibrary.allocate_remote_code(OpenProcess);
                                if (allocate_remote_code != null) {
                                    return new ForJnaWindowsNamedPipe(this.library, this.attachLibrary, OpenProcess, allocate_remote_code);
                                }
                                throw new Win32Exception(Native.getLastError());
                            } catch (Throwable th2) {
                                if (!Kernel32.INSTANCE.CloseHandle(OpenProcess)) {
                                    throw new Win32Exception(Native.getLastError());
                                } else if (th2 instanceof RuntimeException) {
                                    throw th2;
                                } else {
                                    throw new IllegalStateException(th2);
                                }
                            }
                        } else {
                            throw new Win32Exception(Native.getLastError());
                        }
                    }
                }

                protected static class NamedPipeResponse implements Response {
                    private final WinNT.HANDLE pipe;

                    protected NamedPipeResponse(WinNT.HANDLE handle) {
                        this.pipe = handle;
                    }

                    public void close() {
                        try {
                            if (!Kernel32.INSTANCE.DisconnectNamedPipe(this.pipe)) {
                                throw new Win32Exception(Native.getLastError());
                            } else if (!Kernel32.INSTANCE.CloseHandle(this.pipe)) {
                                throw new Win32Exception(Native.getLastError());
                            }
                        } catch (Throwable th2) {
                            if (!Kernel32.INSTANCE.CloseHandle(this.pipe)) {
                                throw new Win32Exception(Native.getLastError());
                            }
                            throw th2;
                        }
                    }

                    public int read(byte[] bArr) {
                        IntByReference intByReference = new IntByReference();
                        if (Kernel32.INSTANCE.ReadFile(this.pipe, bArr, bArr.length, intByReference, (WinBase.OVERLAPPED) null)) {
                            return intByReference.getValue();
                        }
                        int lastError = Native.getLastError();
                        if (lastError == 109) {
                            return -1;
                        }
                        throw new Win32Exception(lastError);
                    }
                }

                protected interface WindowsAttachLibrary extends StdCallLibrary {
                    @MaybeNull
                    WinDef.LPVOID allocate_remote_argument(WinNT.HANDLE handle, String str, @MaybeNull String str2, @MaybeNull String str3, @MaybeNull String str4, @MaybeNull String str5);

                    @MaybeNull
                    WinDef.LPVOID allocate_remote_code(WinNT.HANDLE handle);
                }

                protected interface WindowsLibrary extends StdCallLibrary {
                    @MaybeNull
                    WinNT.HANDLE CreateRemoteThread(WinNT.HANDLE handle, @MaybeNull WinBase.SECURITY_ATTRIBUTES security_attributes, int i10, Pointer pointer, Pointer pointer2, @MaybeNull WinDef.DWORD dword, @MaybeNull Pointer pointer3);

                    boolean GetExitCodeThread(WinNT.HANDLE handle, IntByReference intByReference);

                    Pointer VirtualAllocEx(WinNT.HANDLE handle, Pointer pointer, int i10, int i11, int i12);

                    boolean VirtualFreeEx(WinNT.HANDLE handle, Pointer pointer, int i10, int i11);
                }

                protected ForJnaWindowsNamedPipe(WindowsLibrary windowsLibrary, WindowsAttachLibrary windowsAttachLibrary, WinNT.HANDLE handle, WinDef.LPVOID lpvoid) {
                    this.library = windowsLibrary;
                    this.attachLibrary = windowsAttachLibrary;
                    this.process = handle;
                    this.code = lpvoid;
                }

                public void close() {
                    try {
                        if (!this.library.VirtualFreeEx(this.process, this.code.getPointer(), 0, 32768)) {
                            throw new Win32Exception(Native.getLastError());
                        } else if (!Kernel32.INSTANCE.CloseHandle(this.process)) {
                            throw new Win32Exception(Native.getLastError());
                        }
                    } catch (Throwable th2) {
                        if (!Kernel32.INSTANCE.CloseHandle(this.process)) {
                            throw new Win32Exception(Native.getLastError());
                        }
                        throw th2;
                    }
                }

                /* JADX INFO: finally extract failed */
                public Response execute(String str, String... strArr) {
                    String str2;
                    String str3;
                    String str4;
                    String str5;
                    WinNT.HANDLE CreateRemoteThread;
                    if (!"1".equals(str)) {
                        throw new IllegalArgumentException("Unknown protocol version: " + str);
                    } else if (strArr.length <= 4) {
                        String str6 = "\\\\.\\pipe\\javatool" + Math.abs(this.random.nextInt() + 1);
                        WinNT.HANDLE CreateNamedPipe = Kernel32.INSTANCE.CreateNamedPipe(str6, 1, 0, 1, Opcodes.ACC_SYNTHETIC, 8192, 0, (WinBase.SECURITY_ATTRIBUTES) null);
                        if (CreateNamedPipe != null) {
                            try {
                                WindowsAttachLibrary windowsAttachLibrary = this.attachLibrary;
                                WinNT.HANDLE handle = this.process;
                                if (strArr.length < 1) {
                                    str2 = null;
                                } else {
                                    str2 = strArr[0];
                                }
                                if (strArr.length < 2) {
                                    str3 = null;
                                } else {
                                    str3 = strArr[1];
                                }
                                if (strArr.length < 3) {
                                    str4 = null;
                                } else {
                                    str4 = strArr[2];
                                }
                                if (strArr.length < 4) {
                                    str5 = null;
                                } else {
                                    str5 = strArr[3];
                                }
                                WinDef.LPVOID allocate_remote_argument = windowsAttachLibrary.allocate_remote_argument(handle, str6, str2, str3, str4, str5);
                                if (allocate_remote_argument != null) {
                                    try {
                                        CreateRemoteThread = this.library.CreateRemoteThread(this.process, (WinBase.SECURITY_ATTRIBUTES) null, 0, this.code.getPointer(), allocate_remote_argument.getPointer(), (WinDef.DWORD) null, (Pointer) null);
                                        if (CreateRemoteThread != null) {
                                            int WaitForSingleObject = Kernel32.INSTANCE.WaitForSingleObject(CreateRemoteThread, -1);
                                            if (WaitForSingleObject == 0) {
                                                IntByReference intByReference = new IntByReference();
                                                if (!this.library.GetExitCodeThread(CreateRemoteThread, intByReference)) {
                                                    throw new Win32Exception(Native.getLastError());
                                                } else if (intByReference.getValue() == 0) {
                                                    if (!Kernel32.INSTANCE.ConnectNamedPipe(CreateNamedPipe, (WinBase.OVERLAPPED) null)) {
                                                        int lastError = Native.getLastError();
                                                        if (lastError != 535) {
                                                            throw new Win32Exception(lastError);
                                                        }
                                                    }
                                                    NamedPipeResponse namedPipeResponse = new NamedPipeResponse(CreateNamedPipe);
                                                    if (!Kernel32.INSTANCE.CloseHandle(CreateRemoteThread)) {
                                                        throw new Win32Exception(Native.getLastError());
                                                    } else if (this.library.VirtualFreeEx(this.process, allocate_remote_argument.getPointer(), 0, 32768)) {
                                                        return namedPipeResponse;
                                                    } else {
                                                        throw new Win32Exception(Native.getLastError());
                                                    }
                                                } else {
                                                    throw new IllegalStateException("Target VM could not dispatch command successfully: " + intByReference.getValue());
                                                }
                                            } else {
                                                throw new Win32Exception(WaitForSingleObject);
                                            }
                                        } else {
                                            throw new Win32Exception(Native.getLastError());
                                        }
                                    } catch (Throwable th2) {
                                        if (!this.library.VirtualFreeEx(this.process, allocate_remote_argument.getPointer(), 0, 32768)) {
                                            throw new Win32Exception(Native.getLastError());
                                        }
                                        throw th2;
                                    }
                                } else {
                                    throw new Win32Exception(Native.getLastError());
                                }
                            } catch (Throwable th3) {
                                if (!Kernel32.INSTANCE.CloseHandle(CreateNamedPipe)) {
                                    throw new Win32Exception(Native.getLastError());
                                } else if (th3 instanceof RuntimeException) {
                                    throw th3;
                                } else {
                                    throw new IllegalStateException(th3);
                                }
                            }
                        } else {
                            throw new Win32Exception(Native.getLastError());
                        }
                    } else {
                        throw new IllegalArgumentException("Cannot supply more then four arguments to Windows attach mechanism: " + Arrays.asList(strArr));
                    }
                }
            }

            public static abstract class OnPersistentByteChannel<T> implements Connection {
                private static final byte[] BLANK = {0};

                private class Response implements Response {
                    private final T connection;

                    public void close() throws IOException {
                        OnPersistentByteChannel.this.close(this.connection);
                    }

                    public int read(byte[] bArr) throws IOException {
                        return OnPersistentByteChannel.this.read(this.connection, bArr);
                    }

                    private Response(T t10) {
                        this.connection = t10;
                    }
                }

                /* access modifiers changed from: protected */
                public abstract void close(T t10) throws IOException;

                /* access modifiers changed from: protected */
                public abstract T connect() throws IOException;

                public Response execute(String str, String... strArr) throws IOException {
                    Object connect = connect();
                    try {
                        write(connect, str.getBytes("UTF-8"));
                        write(connect, BLANK);
                        for (String str2 : strArr) {
                            if (str2 != null) {
                                write(connect, str2.getBytes("UTF-8"));
                            }
                            write(connect, BLANK);
                        }
                        return new Response(connect);
                    } catch (Throwable th2) {
                        close(connect);
                        if (th2 instanceof RuntimeException) {
                            throw ((RuntimeException) th2);
                        } else if (th2 instanceof IOException) {
                            throw th2;
                        } else {
                            throw new IllegalStateException(th2);
                        }
                    }
                }

                /* access modifiers changed from: protected */
                public abstract int read(T t10, byte[] bArr) throws IOException;

                /* access modifiers changed from: protected */
                public abstract void write(T t10, byte[] bArr) throws IOException;
            }

            public interface Response extends Closeable {
                int read(byte[] bArr) throws IOException;
            }

            Response execute(String str, String... strArr) throws IOException;
        }

        protected ForHotSpot(Connection connection2) {
            this.connection = connection2;
        }

        public static VirtualMachine attach(String str) throws IOException {
            if (Platform.isWindows()) {
                return attach(str, new Connection.ForJnaWindowsNamedPipe.Factory());
            }
            if (Platform.isSolaris()) {
                return attach(str, new Connection.ForJnaSolarisDoor.Factory(15, 100, TimeUnit.MILLISECONDS));
            }
            return attach(str, Connection.ForJnaPosixSocket.Factory.withDefaultTemporaryFolder(15, 100, TimeUnit.MILLISECONDS));
        }

        private static void checkHeader(Connection.Response response) throws IOException {
            byte[] bArr = new byte[1];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int read = response.read(bArr);
                if (read == -1) {
                    break;
                } else if (read > 0) {
                    byte b10 = bArr[0];
                    if (b10 == 10) {
                        break;
                    }
                    byteArrayOutputStream.write(b10);
                }
            }
            int parseInt = Integer.parseInt(byteArrayOutputStream.toString("UTF-8"));
            if (parseInt == 0) {
                return;
            }
            if (parseInt != 101) {
                byte[] bArr2 = new byte[1024];
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                while (true) {
                    int read2 = response.read(bArr2);
                    if (read2 != -1) {
                        byteArrayOutputStream2.write(bArr2, 0, read2);
                    } else {
                        throw new IllegalStateException(byteArrayOutputStream2.toString("UTF-8"));
                    }
                }
            } else {
                throw new IOException("Protocol mismatch with target VM");
            }
        }

        private Properties getProperties(String str) throws IOException {
            Connection.Response execute = this.connection.execute("1", str, null, null, null);
            try {
                checkHeader(execute);
                byte[] bArr = new byte[1024];
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    int read = execute.read(bArr);
                    if (read != -1) {
                        byteArrayOutputStream.write(bArr, 0, read);
                    } else {
                        Properties properties = new Properties();
                        properties.load(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
                        return properties;
                    }
                }
            } finally {
                execute.close();
            }
        }

        public void detach() throws IOException {
            this.connection.close();
        }

        public Properties getAgentProperties() throws IOException {
            return getProperties("agentProperties");
        }

        public Properties getSystemProperties() throws IOException {
            return getProperties(JivePropertiesExtension.ELEMENT);
        }

        /* access modifiers changed from: protected */
        public void load(String str, boolean z10, @MaybeNull String str2) throws IOException {
            Connection connection2 = this.connection;
            String[] strArr = new String[4];
            strArr[0] = LOAD_COMMAND;
            strArr[1] = INSTRUMENT_COMMAND;
            strArr[2] = Boolean.toString(z10);
            if (str2 != null) {
                str = str + ARGUMENT_DELIMITER + str2;
            }
            strArr[3] = str;
            Connection.Response execute = connection2.execute("1", strArr);
            try {
                checkHeader(execute);
            } finally {
                execute.close();
            }
        }

        public void loadAgent(String str, @MaybeNull String str2) throws IOException {
            load(str, false, str2);
        }

        public void loadAgentLibrary(String str, @MaybeNull String str2) throws IOException {
            load(str, false, str2);
        }

        public void loadAgentPath(String str, @MaybeNull String str2) throws IOException {
            load(str, true, str2);
        }

        public String startLocalManagementAgent() throws IOException {
            Connection.Response execute = this.connection.execute("1", "jcmd", "ManagementAgent.start_local", null, null);
            try {
                checkHeader(execute);
                return getAgentProperties().getProperty("com.sun.management.jmxremote.localConnectorAddress");
            } finally {
                execute.close();
            }
        }

        public void startManagementAgent(Properties properties) throws IOException {
            StringBuilder sb2 = new StringBuilder("ManagementAgent.start ");
            boolean z10 = true;
            for (Map.Entry entry : properties.entrySet()) {
                if (!(entry.getKey() instanceof String) || !((String) entry.getKey()).startsWith("com.sun.management.")) {
                    throw new IllegalArgumentException("Illegal property name: " + entry.getKey());
                }
                if (z10) {
                    z10 = false;
                } else {
                    sb2.append(' ');
                }
                sb2.append(((String) entry.getKey()).substring(19));
                sb2.append(SignatureVisitor.INSTANCEOF);
                String obj = entry.getValue().toString();
                if (obj.contains(" ")) {
                    sb2.append('\'');
                    sb2.append(obj);
                    sb2.append('\'');
                } else {
                    sb2.append(obj);
                }
            }
            Connection.Response execute = this.connection.execute("1", "jcmd", sb2.toString(), null, null);
            try {
                checkHeader(execute);
            } finally {
                execute.close();
            }
        }

        public static VirtualMachine attach(String str, Connection.Factory factory) throws IOException {
            return new ForHotSpot(factory.connect(str));
        }
    }
}
