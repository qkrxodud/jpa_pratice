package jpawebpratice.jpapratice.domain.comm;

public class commFunction {
    public static boolean isStringEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }
}
