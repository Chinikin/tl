package dubbo.client;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import hs.dubbo.server.UserService;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;

public class YoungClient {

    public UserService buildRemoteService(String remoteUrl){
        ReferenceConfig<UserService> referenceConfig = new ReferenceConfig();
        referenceConfig.setInterface(UserService.class);
        referenceConfig.setRegistry(new RegistryConfig("multicast://224.1.2.3:11111"));
        referenceConfig.setUrl(remoteUrl);
        referenceConfig.setApplication(new ApplicationConfig("young-app"));
        return referenceConfig.get();
    }

    public static void main(String[] args) throws IOException {
        YoungClient client = new YoungClient();
        UserService service = client.buildRemoteService(null);
        String cmd;
        int count = 0;
        while (!"exist".equals(cmd = read())) {
            System.out.println(service.getUser(555));
        }
    }

    public static String read() throws IOException {
        byte[] bytes = new byte[1024];
        LineNumberReader reader = new LineNumberReader(new InputStreamReader(System.in));
        return reader.readLine();
    }

}
