wget -O zipkin.jar 'https://search.maven.org/remote_content?g=io.zipkin.java&a=zipkin-server&v=LATEST&c=exec'


zipkin-service  服务器下载


可能失败：java -jar zipkin.jar --zipkin.collector.rabbitmq.addressed=39.105.91.69

RABBIT_ADDRESSES=localhost
mq启动




RABBIT_ADDRESSES=localhost STORAGE_TYPE=mysql MYSQL_USER=root MYSQL_PASS=123456  MYSQL_DB=zipkin_db  MYSQL_HOST=localhost  MYSQL_TCP_PORT=3306 nohup java -jar zipkin.jar


