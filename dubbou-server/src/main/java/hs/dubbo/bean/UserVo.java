package hs.dubbo.bean;


import java.io.Serializable;

public class UserVo implements Serializable {
    private Integer id;
    private String name;
    private Integer port;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return "UserVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", port=" + port +
                '}';
    }
}
