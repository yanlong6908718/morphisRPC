package Layer2NodeCase;

import TestCase.BaseCase;
import com.bkbkbk.utils.JsonTools;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.bkbkbk.HttpServer.HttpUtils.http_PostWithParams;

public class GethRPC extends BaseCase {
    String url="http://192.168.0.124:8545";


@ParameterizedTest
@ValueSource(strings={"{\n" + "\"jsonrpc\":\"2.0\",\n" + "\"method\":\"eth_accounts\",\n" + "\"params\":[],\n" + "\"id\":0\n" + "}"})
public void getAccountRPCTest(String str){
    String result=http_PostWithParams(url,str);
    Assert.assertNotNull(JsonTools.getValueStr(result,"result"));
}

}
