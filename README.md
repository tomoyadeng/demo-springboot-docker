# demo-springboot-docker

### 构建

```bash
mvn clean install docker:build
```

### 手动启动

__首先启动mysql的container__

```bash
docker run -d \
    --name mybatis-mysql \
    -e MYSQL_ROOT_PASSWORD=123456 \
    -e MYSQL_DATABASE=mybatis \
    -e MYSQL_USER=dbuser \
    -e MYSQL_PASSWORD=123456 \
    mysql:latest
```

启动完成后，可用`docker ps`查看，也可以通过执行下面命令连接到mysql

```bash
docker run -it --link mybatis-mysql:mysql --rm mysql sh \
    -c 'exec mysql -h"$MYSQL_PORT_3306_TCP_ADDR" -P"$MYSQL_PORT_3306_TCP_PORT" -uroot -p"$MYSQL_ENV_MYSQL_ROOT_PASSWORD"'
```

__启动应用__

```bash
docker run -d -t \
    --name demo-springboot-docker \
    --link mybatis-mysql:mysql \
    -p 8088:8080 \
    -e DATABASE_HOST=mybatis-mysql \
    -e DATABASE_PORT=3306 \
    -e DATABASE_NAME=mybatis \
    -e DATABASE_USER=root \
    -e DATABASE_PASSWORD=123456 \
    tomoyadeng/demo-springboot-docker

```

启动完成后，使用`docker ps`查看，或者直接访问url测试

```bash
curl http://localhost:8088/user?name=dave
```

### 使用docker-compose启动

```bash
docker-compose up
```


Link: [https://tomoyadeng.github.io/blog/2017/07/23/spring-boot-mybatis-docker/](https://tomoyadeng.github.io/blog/2017/07/23/spring-boot-mybatis-docker/)
