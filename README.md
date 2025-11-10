# YNU-Loss-Found

<p align="center">
  <strong>云南大学校园失物招领系统 - 后端服务</strong>
</p>

## 📖 项目简介

校园内,在同学们日常生活中,遗失物品是非常常见的事情。如:在食堂,临走时忘记了放在桌上的书本、背包;在运动场,忘记了自己放在一旁的衣服,物件等。诸如此类的事,往往会给失主带来经济上的损失。

为了减少此类现象的发生,让失物更快的回到失主的手上,我们设计了"YNU-Loss-Found"这款校园失物招领网站。该项目采用前后端分离的设计,此为后端仓库。

**前端仓库**: [AlphaGogoo/YNU-LossFound-FrontEnd](https://github.com/AlphaGogoo/YNU-LossFound-FrontEnd)

## 🛠 技术栈

- **Spring Boot**: 2.6.3
- **Java**: 11
- **MySQL**: 8.0.26
- **MyBatis Plus**: 3.5.1
- **MyBatis**: 2.2.2
- **PageHelper**: 1.4.1 (分页插件)
- **Spring Boot Mail**: 2.6.6 (邮件服务)
- **Lombok**: 简化实体类代码

## 📁 项目结构

```
com.ynu.lossfound
├── bean/                # 实体类(User, Loss, Found, LoginUserInfo)
├── config/              # 配置类(MyBatisConfig)
├── controller/          # 控制器层(LoginController, UserController, LossController, FoundController)
├── mapper/              # MyBatis Mapper 接口(使用注解方式编写 SQL)
├── service/             # 服务层接口
│   ├── impl/           # 服务层实现
│   └── EmailService    # 邮件服务(异步)
└── LossFoundApplication # 主启动类
```

## 💾 数据库设计

项目使用三张核心表:
- **user**: 用户表(主键: studentID)
- **loss**: 寻物启事表(主键: lossID)
- **found**: 招领启事表(主键: foundID)

数据库初始化脚本: `loss_found.sql`

## ✨ 核心功能

### 1. 用户注册与登录
- 用户注册时密码使用 MD5 加密(salt: "ynu")
- 注册时自动检查是否有该用户的失物已被找到并发送邮件通知

![注册页面](https://ynu-lost-found.oss-cn-beijing.aliyuncs.com/20220419183825-image-20220419183825810.png)

![登录页面](https://ynu-lost-found.oss-cn-beijing.aliyuncs.com/20220419183921-image-20220419183921699.png)

### 2. 发布寻物启事

若用户丢失了物品,可在发布启事界面选择发布寻物启事,填写失物的名称、丢失时间、丢失地点、失物的图片以及失主联系方式等信息,方便拾到失物的人快速联系到失主。

![发布寻物启事](https://ynu-lost-found.oss-cn-beijing.aliyuncs.com/20220419184015-image-20220419184015040.png)

### 3. 发布招领启事

若拾取失物者发现了某人遗失的物品,可在发布启事界面选择发布招领启事,填写拾取物的名称、丢失时间、丢失地点、拾取物的图片以及拾取者联系方式等信息,方便失主与拾取失物者联系。

![发布招领启事](https://ynu-lost-found.oss-cn-beijing.aliyuncs.com/20220419184053-image-20220419184053173.png)

### 4. 智能邮箱提醒功能 ⭐

**这是本系统的核心特色功能!**

若失物上有失主的学号或者手机号信息,拾取失物者发布招领启事时可填写上失主的学号或手机号信息,那么系统就会从数据库中根据学号或者手机号检索注册用户,如果该用户注册了此系统,系统就会读取他的邮箱信息,并将"您有丢失物品被找到"消息发送到这个邮箱里。同时会附上拾取者留下的联系方式,让失主能在最短时间内找到失物。

**实现细节**:
- 使用 `@Async` 注解实现异步邮件发送,不影响主业务流程
- 发布招领启事时自动匹配失主信息并发送邮件
- 用户注册时检查是否有失物被找到并立即通知

**实现位置**:
- `UserServiceImpl.selectFoundAndSendEmail()` (src/main/java/com/ynu/lossfound/service/impl/UserServiceImpl.java:52)
- `UserServiceImpl.insertUser()` (src/main/java/com/ynu/lossfound/service/impl/UserServiceImpl.java:79)

![邮件通知](https://ynu-lost-found.oss-cn-beijing.aliyuncs.com/20220419185306-1.png)

### 5. 寻物广场与招领广场

每有一篇寻物启事/招领启事被发布,就能够在寻物广场/招领广场找到相应的寻物/招领贴。使用 PageHelper 插件实现分页,每页显示 10 条数据。

![寻物广场](https://ynu-lost-found.oss-cn-beijing.aliyuncs.com/20220419185317-2.png)

![招领广场](https://ynu-lost-found.oss-cn-beijing.aliyuncs.com/20220419185320-3.png)

### 6. 用户信息管理

**查看与修改个人信息**

![个人信息查看](https://ynu-lost-found.oss-cn-beijing.aliyuncs.com/20220419184645-1.png)

![个人信息修改](https://ynu-lost-found.oss-cn-beijing.aliyuncs.com/20220419184650-2.png)

**修改密码**

![修改密码](https://ynu-lost-found.oss-cn-beijing.aliyuncs.com/20220419184720-image-20220419184720559.png)

**查看与删除自己发布的信息**

![发布信息管理](https://ynu-lost-found.oss-cn-beijing.aliyuncs.com/20220419184837-3.png)

## 🚀 快速开始

### 环境要求

- JDK 11+
- Maven 3.6+
- MySQL 8.0+

### 1. 克隆项目

```bash
git clone https://github.com/yourusername/YNU-LossFound-BackEnd.git
cd YNU-LossFound-BackEnd
```

### 2. 创建数据库

运行 `loss_found.sql` 创建数据库和表:

```bash
mysql -u root -p < loss_found.sql
```

### 3. 配置文件

#### 修改数据库配置

编辑 `src/main/resources/application.yaml`:

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/loss_found?useSSL=false&serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8
    username: root
    password: <your-password>
```

#### 配置邮件服务

编辑 `src/main/resources/application.properties`:

```properties
spring.mail.host=smtp.qq.com
spring.mail.port=465
spring.mail.username=<your-email>
spring.mail.password=<your-auth-code>  # QQ 邮箱第三方授权码
```

**获取 QQ 邮箱授权码**: 参考 [Spring Boot 发送邮件全解析](https://segmentfault.com/a/1190000021587834)

### 4. 运行项目

#### 方式一: 使用 Maven

```bash
# 清理并构建
mvn clean install

# 运行项目
mvn spring-boot:run
```

#### 方式二: 使用 IDEA

1. 将项目导入 IDEA
2. 等待 Maven 下载依赖
3. 找到 `com.ynu.lossfound.LossFoundApplication` 主类
4. 右键运行

![IDEA运行](https://ynu-lost-found.oss-cn-beijing.aliyuncs.com/20220419192512-image-20220419192512331.png)

#### 方式三: 打包运行

```bash
# 打包
mvn clean package

# 运行 jar 包
java -jar target/loss-found-0.0.1-SNAPSHOT.jar
```

### 5. 验证运行

服务默认运行在 `http://localhost:8888`

访问测试接口: `http://localhost:8888/api/login`

## 🔧 开发指南

### API 端点规范

所有 API 路径以 `/api/` 开头,使用 `@GetMapping` 处理请求:

#### 用户相关
- `POST /api/login` - 用户登录
- `POST /api/register` - 用户注册
- `POST /api/updateUser` - 更新用户信息
- `GET /api/selectUserByStudentId` - 根据学号查询用户

#### 寻物相关
- `POST /api/postLoss` - 发布寻物启事
- `GET /api/selectLoss` - 查询寻物启事列表
- `GET /api/deleteLossByID` - 删除寻物启事

#### 招领相关
- `POST /api/postFound` - 发布招领启事
- `GET /api/selectFound` - 查询招领启事列表
- `GET /api/deleteFoundByID` - 删除招领启事

### MyBatis 注解方式

本项目使用 MyBatis 注解方式而非 XML 映射文件:
- Mapper 接口通过 `@Select`, `@Insert`, `@Update`, `@Delete` 注解直接编写 SQL
- 启动类使用 `@MapperScan("com.ynu.lossfound.mapper")` 扫描 Mapper 接口
- MyBatis 配置文件位于 `src/main/resources/mybatis/mybatis-config.xml`(仅配置驼峰命名转换)

### 日志配置

MyBatis Mapper 层日志级别设置为 debug,可在控制台查看 SQL 执行日志:

```yaml
logging:
  level:
    com.ynu.lossfound.mapper: debug
```

### 测试

```bash
# 运行所有测试
mvn test

# 运行单个测试类
mvn test -Dtest=LossFoundApplicationTests
```

## 🏗 架构设计

### 技术架构

- **表现层**: Spring MVC (控制器层处理 HTTP 请求)
- **业务层**: Service 层(包含核心业务逻辑)
- **持久层**: MyBatis (注解方式映射)
- **数据库**: MySQL 8.0

### 核心设计模式

- **异步处理**: 邮件服务使用 `@Async` 注解实现异步发送
- **分层架构**: Controller → Service → Mapper 清晰分层
- **依赖注入**: Spring IoC 容器管理 Bean

### 安全特性

- 密码加密: MD5 + Salt("ynu")
- SQL 注入防护: MyBatis 预编译语句
- 跨域支持: 配置 CORS

## 📝 待优化项

- [ ] 密码加密算法升级为 BCrypt
- [ ] 添加图片上传功能(OSS)
- [ ] 添加搜索功能
- [ ] 添加管理员后台
- [ ] API 接口文档(Swagger)
- [ ] 单元测试覆盖率提升
- [ ] Redis 缓存优化
- [ ] JWT 认证替代 Session

## 🤝 贡献

欢迎提交 Issue 和 Pull Request!

## 📄 许可证

[MIT License](LICENSE)

## 👥 团队成员

- 开发团队: YNU-Loss-Found Team
- 前端仓库: [AlphaGogoo/YNU-LossFound-FrontEnd](https://github.com/AlphaGogoo/YNU-LossFound-FrontEnd)

---

<p align="center">
  Made with ❤️ by YNU Students
</p>
