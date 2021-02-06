package com.example.calc;

import java.io.Serializable;

public class MemResult implements Serializable {

    String memResult;

    public MemResult(String memResult) {
        this.memResult = memResult;
    }

    public String getMemResult() {
        return memResult;
    }

    public void setMemResult(String memResult) {
        this.memResult = memResult;
    }
}
