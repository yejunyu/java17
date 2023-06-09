package com.yejunyu.seq;

import java.util.Collections;

/**
 * @Author yjy
 * @Date 2023/4/12
 **/
public class StopException extends RuntimeException {
    public static final StopException INSTANCE = new StopException();

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }

}
