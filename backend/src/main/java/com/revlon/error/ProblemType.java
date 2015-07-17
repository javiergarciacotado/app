package com.revlon.error;

public enum ProblemType {

    TODO("TODO");

    private String code;

    private ProblemType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return code;
    }
}
