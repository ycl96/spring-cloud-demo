import com.ycl.app.ServiceConsumerApplication;
import com.ycl.model.InputOutputData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author : YangChunLong
 * @date : Created in 2020/2/8 19:58
 * @description:
 * @modified By:
 * @version: :
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServiceConsumerApplication.class)
public class ProtocobufTest {
    @Test
    public void testHttp() {
        InputOutputData.Input input = InputOutputData.Input.newBuilder()
                .setName("老大")
                .setAge(18)
                .build();

        InputOutputData.Output output =  httpPost(input.toByteArray(), "http://localhost:7002/consumer/test");
        if(output != null){
            System.out.println(output.getResult());
        }
    }

    private InputOutputData.Output httpPost(byte[] bytes, String url) {
        InputOutputData.Output output = null;
        OutputStream out = null;
        InputStream in = null;
        try {
            URL realUrl = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) realUrl.openConnection();
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setRequestMethod("POST");
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);
            conn.setRequestProperty("Content-Type", "application/x-protobuf");
            conn.connect();
            out = conn.getOutputStream();
            out.write(bytes);
            out.flush();
            out.close();
            // 反序列化
            in = conn.getInputStream();
            byte[] bytesRe = toByteArray(in);
            output = InputOutputData.Output.parseFrom(bytesRe);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return output;
    }

    public byte[] toByteArray(InputStream input) throws IOException {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        byte[] buffer = new byte[4096];
        int n = 0;
        while (-1 != (n = input.read(buffer))) {
            output.write(buffer, 0, n);
        }
        return output.toByteArray();
    }
}
