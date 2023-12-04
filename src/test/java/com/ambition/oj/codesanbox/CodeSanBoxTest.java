package com.ambition.oj.codesanbox;

import com.ambition.oj.judge.codesanbox.CodeSandBoxFactory;
import com.ambition.oj.judge.codesanbox.CodeSandBoxProxy;
import com.ambition.oj.judge.codesanbox.CodeSandbox;
import com.ambition.oj.judge.codesanbox.Impl.RemoteCodeSandbox;
import com.ambition.oj.judge.codesanbox.model.ExecuteCodeRequest;
import com.ambition.oj.judge.codesanbox.model.ExecuteCodeResponse;
import com.ambition.oj.model.enums.QuestionSubmitLanguageEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

/**
 * @author Ambition
 * @date 2023/12/4 22:32
 */
@SpringBootTest

public class CodeSanBoxTest {


    @Value("${codesandbox.type:example}")
    private String type;


    @Test
    void executeCode() {
        CodeSandbox codeSandbox = new RemoteCodeSandbox();
        String code = "int main() { }";
        String language = QuestionSubmitLanguageEnum.JAVA.getValue();
        List<String> inputList = Arrays.asList("1 2", "3 4");
        ExecuteCodeRequest executeCodeRequest = ExecuteCodeRequest.builder()
                .code(code)
                .language(language)
                .inputList(inputList)
                .build();
        ExecuteCodeResponse executeCodeResponse = codeSandbox.executeCode(executeCodeRequest);
        Assertions.assertNotNull(executeCodeResponse);
    }


    /**
     * 测试使用工厂模式生成代码沙箱
     */
    @Test
    void executeCodeFactory() {
        CodeSandbox codeSandbox = CodeSandBoxFactory.createThirdPartyCodeSandbox("remote");
        String code = "int main() { }";
        String language = QuestionSubmitLanguageEnum.JAVA.getValue();
        List<String> inputList = Arrays.asList("1 2", "3 4");
        ExecuteCodeRequest executeCodeRequest = ExecuteCodeRequest.builder()
                .code(code)
                .language(language)
                .inputList(inputList)
                .build();
        ExecuteCodeResponse executeCodeResponse = codeSandbox.executeCode(executeCodeRequest);
        Assertions.assertNotNull(executeCodeResponse);
    }


    /**
     * 测试使用配置文件生成代码沙箱
     */
    @Test
    void executeCodeFactoryByConfig() {
        CodeSandbox codeSandbox = CodeSandBoxFactory.createThirdPartyCodeSandbox(type);
        String code = "int main() { }";
        String language = QuestionSubmitLanguageEnum.JAVA.getValue();
        List<String> inputList = Arrays.asList("1 2", "3 4");
        ExecuteCodeRequest executeCodeRequest = ExecuteCodeRequest.builder()
                .code(code)
                .language(language)
                .inputList(inputList)
                .build();
        ExecuteCodeResponse executeCodeResponse = codeSandbox.executeCode(executeCodeRequest);
        Assertions.assertNotNull(executeCodeResponse);
    }

    /**
     * 通过代理模式生成代码沙箱
     */
    @Test
    void executeCodeFactoryByProxy() {
        CodeSandbox codeSandbox = CodeSandBoxFactory.createThirdPartyCodeSandbox(type);
        codeSandbox = new CodeSandBoxProxy(codeSandbox);
        String code = "int main() { }";
        String language = QuestionSubmitLanguageEnum.JAVA.getValue();
        List<String> inputList = Arrays.asList("1 2", "3 4");
        ExecuteCodeRequest executeCodeRequest = ExecuteCodeRequest.builder()
                .code(code)
                .language(language)
                .inputList(inputList)
                .build();
        ExecuteCodeResponse executeCodeResponse = codeSandbox.executeCode(executeCodeRequest);
        Assertions.assertNotNull(executeCodeResponse);
    }

}
