module dev.isdn.java_vector_api {
    requires jdk.incubator.vector;
    requires jmh.core;
    requires jdk.unsupported;
    exports dev.isdn.java_vector_api.jmh_generated;
}