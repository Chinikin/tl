package hs.dubbo.server.impl;

import hs.dubbo.bean.UserVo;
import hs.dubbo.server.UserService;

public class UserServiceImpl implements UserService {

    int port;

    @Override
    public UserVo getUser(Integer id) {
        UserVo u = new UserVo();
        u.setId(id);
        u.setPort(port);
        return u;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
