package hs.dubbo.server;

import hs.dubbo.bean.UserVo;

public interface UserService {
    UserVo getUser(Integer id);
}
