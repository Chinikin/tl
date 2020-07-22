package hs.dubbo.server;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import hs.dubbo.server.impl.UserServiceImpl;

import java.io.IOException;

public class SimpleServer {

    public void openService(int port){
        ServiceConfig serviceConfig = new ServiceConfig();
        serviceConfig.setInterface(UserService.class);
        serviceConfig.setProtocol(new ProtocolConfig("dubbo",port));
        serviceConfig.setRegistry(new RegistryConfig("multicast://224.1.2.3:11111"));
        serviceConfig.setApplication(new ApplicationConfig("simple-app"));
        UserServiceImpl ref = new UserServiceImpl();
        serviceConfig.setRef(ref);
        serviceConfig.export();
        URL u = (URL) serviceConfig.getExportedUrls().get(0);
        ref.setPort(u.getPort());
        System.out.println("服务器已开启" + u.getPort());
    }


    public static void main(String[] args) throws IOException {
        new SimpleServer().openService(-1);
        System.in.read();
    }
}
