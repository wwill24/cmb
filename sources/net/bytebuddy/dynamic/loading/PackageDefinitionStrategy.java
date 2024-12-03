package net.bytebuddy.dynamic.loading;

import com.google.firebase.sessions.settings.RemoteSettings;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.jar.Attributes;
import java.util.jar.Manifest;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.utility.nullability.AlwaysNull;
import net.bytebuddy.utility.nullability.MaybeNull;

public interface PackageDefinitionStrategy {

    public interface Definition {

        public static class Simple implements Definition {
            @MaybeNull
            private final String implementationTitle;
            @MaybeNull
            private final String implementationVendor;
            @MaybeNull
            private final String implementationVersion;
            @MaybeNull
            protected final URL sealBase;
            @MaybeNull
            private final String specificationTitle;
            @MaybeNull
            private final String specificationVendor;
            @MaybeNull
            private final String specificationVersion;

            public Simple(@MaybeNull String str, @MaybeNull String str2, @MaybeNull String str3, @MaybeNull String str4, @MaybeNull String str5, @MaybeNull String str6, @MaybeNull URL url) {
                this.specificationTitle = str;
                this.specificationVersion = str2;
                this.specificationVendor = str3;
                this.implementationTitle = str4;
                this.implementationVersion = str5;
                this.implementationVendor = str6;
                this.sealBase = url;
            }

            @SuppressFBWarnings(justification = "Package sealing relies on URL equality.", value = {"DMI_BLOCKING_METHODS_ON_URL"})
            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                Simple simple = (Simple) obj;
                String str = this.specificationTitle;
                if (str == null ? simple.specificationTitle == null : str.equals(simple.specificationTitle)) {
                    String str2 = this.specificationVersion;
                    if (str2 == null ? simple.specificationVersion == null : str2.equals(simple.specificationVersion)) {
                        String str3 = this.specificationVendor;
                        if (str3 == null ? simple.specificationVendor == null : str3.equals(simple.specificationVendor)) {
                            String str4 = this.implementationTitle;
                            if (str4 == null ? simple.implementationTitle == null : str4.equals(simple.implementationTitle)) {
                                String str5 = this.implementationVersion;
                                if (str5 == null ? simple.implementationVersion == null : str5.equals(simple.implementationVersion)) {
                                    String str6 = this.implementationVendor;
                                    if (str6 == null ? simple.implementationVendor == null : str6.equals(simple.implementationVendor)) {
                                        URL url = this.sealBase;
                                        if (url != null) {
                                            if (url.equals(simple.sealBase)) {
                                                return true;
                                            }
                                        } else if (simple.sealBase == null) {
                                            return true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                return false;
            }

            @MaybeNull
            public String getImplementationTitle() {
                return this.implementationTitle;
            }

            @MaybeNull
            public String getImplementationVendor() {
                return this.implementationVendor;
            }

            @MaybeNull
            public String getImplementationVersion() {
                return this.implementationVersion;
            }

            @MaybeNull
            public URL getSealBase() {
                return this.sealBase;
            }

            @MaybeNull
            public String getSpecificationTitle() {
                return this.specificationTitle;
            }

            @MaybeNull
            public String getSpecificationVendor() {
                return this.specificationVendor;
            }

            @MaybeNull
            public String getSpecificationVersion() {
                return this.specificationVersion;
            }

            @SuppressFBWarnings(justification = "Package sealing relies on URL equality.", value = {"DMI_BLOCKING_METHODS_ON_URL"})
            public int hashCode() {
                int i10;
                int i11;
                int i12;
                int i13;
                int i14;
                int i15;
                String str = this.specificationTitle;
                int i16 = 0;
                if (str != null) {
                    i10 = str.hashCode();
                } else {
                    i10 = 0;
                }
                int i17 = i10 * 31;
                String str2 = this.specificationVersion;
                if (str2 != null) {
                    i11 = str2.hashCode();
                } else {
                    i11 = 0;
                }
                int i18 = (i17 + i11) * 31;
                String str3 = this.specificationVendor;
                if (str3 != null) {
                    i12 = str3.hashCode();
                } else {
                    i12 = 0;
                }
                int i19 = (i18 + i12) * 31;
                String str4 = this.implementationTitle;
                if (str4 != null) {
                    i13 = str4.hashCode();
                } else {
                    i13 = 0;
                }
                int i20 = (i19 + i13) * 31;
                String str5 = this.implementationVersion;
                if (str5 != null) {
                    i14 = str5.hashCode();
                } else {
                    i14 = 0;
                }
                int i21 = (i20 + i14) * 31;
                String str6 = this.implementationVendor;
                if (str6 != null) {
                    i15 = str6.hashCode();
                } else {
                    i15 = 0;
                }
                int i22 = (i21 + i15) * 31;
                URL url = this.sealBase;
                if (url != null) {
                    i16 = url.hashCode();
                }
                return i22 + i16;
            }

            public boolean isCompatibleTo(Package packageR) {
                URL url = this.sealBase;
                if (url == null) {
                    return !packageR.isSealed();
                }
                return packageR.isSealed(url);
            }

            public boolean isDefined() {
                return true;
            }
        }

        public enum Trivial implements Definition {
            INSTANCE;
            
            @AlwaysNull
            private static final URL NOT_SEALED = null;
            @AlwaysNull
            private static final String NO_VALUE = null;

            static {
                NO_VALUE = null;
                NOT_SEALED = null;
            }

            @MaybeNull
            public String getImplementationTitle() {
                return NO_VALUE;
            }

            public String getImplementationVendor() {
                return NO_VALUE;
            }

            @MaybeNull
            public String getImplementationVersion() {
                return NO_VALUE;
            }

            @MaybeNull
            public URL getSealBase() {
                return NOT_SEALED;
            }

            @MaybeNull
            public String getSpecificationTitle() {
                return NO_VALUE;
            }

            @MaybeNull
            public String getSpecificationVendor() {
                return NO_VALUE;
            }

            @MaybeNull
            public String getSpecificationVersion() {
                return NO_VALUE;
            }

            public boolean isCompatibleTo(Package packageR) {
                return true;
            }

            public boolean isDefined() {
                return true;
            }
        }

        public enum Undefined implements Definition {
            INSTANCE;

            public String getImplementationTitle() {
                throw new IllegalStateException("Cannot read property of undefined package");
            }

            public String getImplementationVendor() {
                throw new IllegalStateException("Cannot read property of undefined package");
            }

            public String getImplementationVersion() {
                throw new IllegalStateException("Cannot read property of undefined package");
            }

            public URL getSealBase() {
                throw new IllegalStateException("Cannot read property of undefined package");
            }

            public String getSpecificationTitle() {
                throw new IllegalStateException("Cannot read property of undefined package");
            }

            public String getSpecificationVendor() {
                throw new IllegalStateException("Cannot read property of undefined package");
            }

            public String getSpecificationVersion() {
                throw new IllegalStateException("Cannot read property of undefined package");
            }

            public boolean isCompatibleTo(Package packageR) {
                throw new IllegalStateException("Cannot check compatibility to undefined package");
            }

            public boolean isDefined() {
                return false;
            }
        }

        @MaybeNull
        String getImplementationTitle();

        @MaybeNull
        String getImplementationVendor();

        @MaybeNull
        String getImplementationVersion();

        @MaybeNull
        URL getSealBase();

        @MaybeNull
        String getSpecificationTitle();

        @MaybeNull
        String getSpecificationVendor();

        @MaybeNull
        String getSpecificationVersion();

        boolean isCompatibleTo(Package packageR);

        boolean isDefined();
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class ManifestReading implements PackageDefinitionStrategy {
        private static final Attributes.Name[] ATTRIBUTE_NAMES = {Attributes.Name.SPECIFICATION_TITLE, Attributes.Name.SPECIFICATION_VERSION, Attributes.Name.SPECIFICATION_VENDOR, Attributes.Name.IMPLEMENTATION_TITLE, Attributes.Name.IMPLEMENTATION_VERSION, Attributes.Name.IMPLEMENTATION_VENDOR, Attributes.Name.SEALED};
        /* access modifiers changed from: private */
        @AlwaysNull
        public static final URL NOT_SEALED = null;
        private final SealBaseLocator sealBaseLocator;

        public interface SealBaseLocator {

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForFixedValue implements SealBaseLocator {
                @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
                @MaybeNull
                private final URL sealBase;

                public ForFixedValue(@MaybeNull URL url) {
                    this.sealBase = url;
                }

                @SuppressFBWarnings(justification = "Package sealing relies on URL equality.", value = {"DMI_BLOCKING_METHODS_ON_URL"})
                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    URL url = this.sealBase;
                    URL url2 = ((ForFixedValue) obj).sealBase;
                    if (url != null) {
                        return url.equals(url2);
                    }
                    if (url2 == null) {
                        return true;
                    }
                    return false;
                }

                @MaybeNull
                public URL findSealBase(ClassLoader classLoader, String str) {
                    return this.sealBase;
                }

                @SuppressFBWarnings(justification = "Package sealing relies on URL equality.", value = {"DMI_BLOCKING_METHODS_ON_URL"})
                public int hashCode() {
                    URL url = this.sealBase;
                    if (url == null) {
                        return 17;
                    }
                    return url.hashCode();
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForTypeResourceUrl implements SealBaseLocator {
                private static final String CLASS_FILE_EXTENSION = ".class";
                private static final int EXCLUDE_INITIAL_SLASH = 1;
                private static final String FILE_SYSTEM = "file";
                private static final String JAR_FILE = "jar";
                private static final String RUNTIME_IMAGE = "jrt";
                private final SealBaseLocator fallback;

                public ForTypeResourceUrl() {
                    this(NonSealing.INSTANCE);
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.fallback.equals(((ForTypeResourceUrl) obj).fallback);
                }

                @MaybeNull
                public URL findSealBase(ClassLoader classLoader, String str) {
                    URL resource = classLoader.getResource(str.replace('.', '/') + ".class");
                    if (resource != null) {
                        try {
                            if (resource.getProtocol().equals(JAR_FILE)) {
                                return URI.create(resource.getPath().substring(0, resource.getPath().indexOf(33))).toURL();
                            }
                            if (resource.getProtocol().equals("file")) {
                                return resource;
                            }
                            if (resource.getProtocol().equals(RUNTIME_IMAGE)) {
                                String path = resource.getPath();
                                int indexOf = path.indexOf(47, 1);
                                if (indexOf == -1) {
                                    return resource;
                                }
                                return URI.create("jrt:" + path.substring(0, indexOf)).toURL();
                            }
                        } catch (MalformedURLException e10) {
                            throw new IllegalStateException("Unexpected URL: " + resource, e10);
                        }
                    }
                    return this.fallback.findSealBase(classLoader, str);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.fallback.hashCode();
                }

                public ForTypeResourceUrl(SealBaseLocator sealBaseLocator) {
                    this.fallback = sealBaseLocator;
                }
            }

            public enum NonSealing implements SealBaseLocator {
                INSTANCE;

                @MaybeNull
                public URL findSealBase(ClassLoader classLoader, String str) {
                    return ManifestReading.NOT_SEALED;
                }
            }

            @MaybeNull
            URL findSealBase(ClassLoader classLoader, String str);
        }

        public ManifestReading() {
            this(new SealBaseLocator.ForTypeResourceUrl());
        }

        public Definition define(ClassLoader classLoader, String str, String str2) {
            URL url;
            InputStream resourceAsStream = classLoader.getResourceAsStream("META-INF/MANIFEST.MF");
            if (resourceAsStream == null) {
                return Definition.Trivial.INSTANCE;
            }
            try {
                Manifest manifest = new Manifest(resourceAsStream);
                HashMap hashMap = new HashMap();
                Attributes mainAttributes = manifest.getMainAttributes();
                if (mainAttributes != null) {
                    for (Attributes.Name name : ATTRIBUTE_NAMES) {
                        hashMap.put(name, mainAttributes.getValue(name));
                    }
                }
                Attributes attributes = manifest.getAttributes(str.replace('.', '/').concat(RemoteSettings.FORWARD_SLASH_STRING));
                if (attributes != null) {
                    for (Attributes.Name name2 : ATTRIBUTE_NAMES) {
                        String value = attributes.getValue(name2);
                        if (value != null) {
                            hashMap.put(name2, value);
                        }
                    }
                }
                String str3 = (String) hashMap.get(Attributes.Name.SPECIFICATION_TITLE);
                String str4 = (String) hashMap.get(Attributes.Name.SPECIFICATION_VERSION);
                String str5 = (String) hashMap.get(Attributes.Name.SPECIFICATION_VENDOR);
                String str6 = (String) hashMap.get(Attributes.Name.IMPLEMENTATION_TITLE);
                String str7 = (String) hashMap.get(Attributes.Name.IMPLEMENTATION_VERSION);
                String str8 = (String) hashMap.get(Attributes.Name.IMPLEMENTATION_VENDOR);
                if (Boolean.parseBoolean((String) hashMap.get(Attributes.Name.SEALED))) {
                    url = this.sealBaseLocator.findSealBase(classLoader, str2);
                } else {
                    url = NOT_SEALED;
                }
                Definition.Simple simple = new Definition.Simple(str3, str4, str5, str6, str7, str8, url);
                resourceAsStream.close();
                return simple;
            } catch (IOException e10) {
                throw new IllegalStateException("Error while reading manifest file", e10);
            } catch (Throwable th2) {
                resourceAsStream.close();
                throw th2;
            }
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.sealBaseLocator.equals(((ManifestReading) obj).sealBaseLocator);
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.sealBaseLocator.hashCode();
        }

        public ManifestReading(SealBaseLocator sealBaseLocator2) {
            this.sealBaseLocator = sealBaseLocator2;
        }
    }

    public enum NoOp implements PackageDefinitionStrategy {
        INSTANCE;

        public Definition define(ClassLoader classLoader, String str, String str2) {
            return Definition.Undefined.INSTANCE;
        }
    }

    public enum Trivial implements PackageDefinitionStrategy {
        INSTANCE;

        public Definition define(ClassLoader classLoader, String str, String str2) {
            return Definition.Trivial.INSTANCE;
        }
    }

    Definition define(ClassLoader classLoader, String str, String str2);
}
