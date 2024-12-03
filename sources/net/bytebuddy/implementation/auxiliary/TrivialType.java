package net.bytebuddy.implementation.auxiliary;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.dynamic.scaffold.MethodGraph;
import net.bytebuddy.dynamic.scaffold.TypeValidation;
import net.bytebuddy.dynamic.scaffold.subclass.ConstructorStrategy;
import net.bytebuddy.implementation.MethodAccessorFactory;
import net.bytebuddy.implementation.auxiliary.AuxiliaryType;
import net.bytebuddy.utility.RandomString;

public enum TrivialType implements AuxiliaryType {
    SIGNATURE_RELEVANT(true),
    PLAIN(false);
    
    private final boolean eager;

    private TrivialType(boolean z10) {
        this.eager = z10;
    }

    public String getSuffix() {
        return RandomString.hashOf(name().hashCode());
    }

    public DynamicType make(String str, ClassFileVersion classFileVersion, MethodAccessorFactory methodAccessorFactory) {
        List list;
        DynamicType.Builder<Object> subclass = new ByteBuddy(classFileVersion).with(TypeValidation.DISABLED).with((MethodGraph.Compiler) MethodGraph.Empty.INSTANCE).subclass(Object.class, (ConstructorStrategy) ConstructorStrategy.Default.NO_CONSTRUCTORS);
        if (this.eager) {
            list = Collections.singletonList(AnnotationDescription.Builder.ofType((Class<? extends Annotation>) AuxiliaryType.SignatureRelevant.class).build(false));
        } else {
            list = Collections.emptyList();
        }
        return subclass.annotateType((Collection<? extends AnnotationDescription>) list).name(str).modifiers(AuxiliaryType.DEFAULT_TYPE_MODIFIER).make();
    }
}
