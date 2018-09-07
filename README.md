# twjitm-core
### 相关业务介绍

###  Netty网络基础架构系统

采用netty信息加载实现长连接实时通讯系统，客户端可以值任何场景，支持实时http通讯，websocket通讯,tcp通讯，和udp通讯。
通过http协议，rpc协议。
采用自定义网络数据包结构，
实现自定义网络栈。

1：支持分布式zookeeper进行服务节点配置。
2：采用自定义注解形式实现netty私有消息协议栈。
3：支持远程RPC调用。
4：支持redis。
5：支持db分离。
6: 支持同步和异步消息处理
7: 支持kafka消息队列提供/消费 模式来实现分布式消息队列
8: 支持数据加密传输，保障数据安全。
9: 支持分布式事务3pc提交，异常回滚。

### 目前在更新阶段

独立数据db模块，独立事务模块，独立线程调度模块。以微服务的形式提供网络服务。


### TCP 通信模式

tcp通讯，采用netty实现tcp通讯，项目中可以利用 com\twjitm\core\start\GameService ,将启动模式改为tcp服务器启动模式
可以利用test中的\test\java\com\twjitm\ClientServiceTest 可以模拟客户端进行连接，需要将端口和地址改为tcp服务器进行连接。
tcp消息处理采用消息队列，将所有到来的消息放到队列中，通过线程池化技术来处理消息。

### UDP 通信模式
UDP自定义网络协议栈和tcp自定义网络协议栈格式差不多，不同的是udp不需要建立连接，也就是无状态的通信模式，在消息处理模块采用
tcp连接的时候保存的session来确定是哪个客户端发出的消息，似的udp协议能够正确的处理，通过两种不同的消息处理模式，进行选择处理
其中有：同步队列模式；生产者-消费者模式。

### HTTP 通信模式
HTTP协议同样采用自定义网络协议栈实现，和tcp，udp协议差不多，只不过数据包不一样，http是建立在tcp的应用层上的协议。
采用同步处理方式，当消息到来的时候及时作出处理。


### RPC 通信模式
RPC模块分为同步调用和异步调用，远程服务器调用，利用netty实现轻量级rpc服务器框架，通过自定义线程让步策略。结合动态代理等
java搞基知识，实现rpc服务器通讯模块。利用xml文档配置rpc服务器基本信息，以达到动态的水平扩展服务器。为分布式服务器做好
基础准备

### zookeeper 服务

通过整合zookeeper，动态的注册服务，发现服务，整合rpc逻辑，实现分布式服务发现和注册。

### 其他
还在优化，优化项目中的空间复杂度，时间复杂度，相应时间，压测能力等性能

### spring在本项目

本项目利用spring来统一管理一些bean，利用服务器启动的时候，统一将容器初始化提交给spring，利用spring提供的注解，轻松获得
注入到spring容器中的bean对象，提高代码的可读性。


作者：好昵称不随便起   twjitm    qq：1089718215

博客地址https://blog.csdn.net/baidu_23086307

个人网站地址;https://twjitm.com

