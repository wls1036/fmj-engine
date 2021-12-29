cd /home/oracle/workspace/ogg-mgr-service
git pull origin master
cd ogg-client
mvn clean install
cd ..
cd ogg-mgr-web
mvn clean package
cd target
java -jar ogg-mgr-web-1.0.jar