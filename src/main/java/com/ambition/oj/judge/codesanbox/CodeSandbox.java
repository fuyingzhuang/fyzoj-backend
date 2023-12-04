package com.ambition.oj.judge.codesanbox;

import com.ambition.oj.judge.codesanbox.model.ExecuteCodeRequest;
import com.ambition.oj.judge.codesanbox.model.ExecuteCodeResponse;

/**
 * @author Ambition
 * @date 2023/12/4 22:16
 * 代码沙箱 接口
 */
public interface CodeSandbox {

    /**
     * 执行代码
     *
     * @param executeCodeRequest
     * @return
     */
    ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest);

}
