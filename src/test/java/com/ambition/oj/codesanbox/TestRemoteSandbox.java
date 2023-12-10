package com.ambition.oj.codesanbox;

import com.ambition.oj.judge.codesanbox.CodeSandBoxFactory;
import com.ambition.oj.judge.codesanbox.CodeSandBoxProxy;
import com.ambition.oj.judge.codesanbox.CodeSandbox;
import com.ambition.oj.judge.codesanbox.Impl.RemoteCodeSandbox;
import com.ambition.oj.judge.codesanbox.model.ExecuteCodeRequest;
import com.ambition.oj.judge.codesanbox.model.ExecuteCodeResponse;
import com.ambition.oj.judge.codesanbox.model.JudgeInfo;
import com.ambition.oj.model.enums.QuestionSubmitLanguageEnum;
import com.ambition.oj.utils.GsonUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ambition
 * @date 2023/12/10 19:25
 */

@SpringBootTest
public class TestRemoteSandbox {


    @Resource
    private RemoteCodeSandbox remoteCodeSandbox;


    @Test
    public void testRemoteSandbox() {
        CodeSandbox codeSandbox = CodeSandBoxFactory.createThirdPartyCodeSandbox("remote");
        codeSandbox = new CodeSandBoxProxy(codeSandbox);
        String code = "public class Main {\n" +
                "    public static void main(String[] args) {\n" +
                "        int a = Integer.parseInt(args[0]);\n" +
                "        int b = Integer.parseInt(args[1]);\n" +
                "        System.out.println(\"结果:\" + (a + b));\n" +
                "    }\n" +
                "}";
        String language = QuestionSubmitLanguageEnum.JAVA.getValue();
        List<String> inputList = Arrays.asList("1 2", "3 4");
        ExecuteCodeRequest executeCodeRequest = ExecuteCodeRequest.builder()
                .code(code)
                .language(language)
                .inputList(inputList)
                .build();
        ExecuteCodeResponse executeCodeResponse = codeSandbox.executeCode(executeCodeRequest);
//        将executeCodeResponse 转成json字符串
        String json = GsonUtils.getGson().toJson(executeCodeResponse);
        System.out.println("json = " + json);
        System.out.println("executeCodeResponse = " + executeCodeResponse.toString());
        Assertions.assertNotNull(executeCodeResponse);

    }

}
