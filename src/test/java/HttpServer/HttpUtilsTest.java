package HttpServer;

import org.junit.jupiter.api.Test;

import static com.bkbkbk.HttpServer.HttpUtils.http_PostWithParams;

class HttpUtilsTest {
    String url="http://192.168.0.124:8545";

    @Test
    void http_GetWithUrltest() {
        String json="{\n" +
                "\"jsonrpc\":\"2.0\",\n" +
                "\"method\":\"eth_accounts\",\n" +
                "\"params\":[],\n" +
                "\"id\":0\n" +
                "}";
        String result=http_PostWithParams(url,json);
    }
}