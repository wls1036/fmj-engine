#!/usr/bin/env bash

code=$1
codeUpper=$2
name=$3

if [ "$code" == "" ]; then
echo "Usage: ./scripts/gen.sh {code} {codeUpper} {name}"
exit 0
fi

if [ "$codeUpper" == "" ]; then
echo "Usage: ./scripts/gen.sh {code} {codeUpper} {name}"
exit 0
fi

if [ "$name" == "" ]; then
echo "Usage: ./scripts/gen.sh {code} {codeUpper} {name}"
exit 0
fi

base=/Users/asan/workspace/prod/office-service/office-web/src/main/java/com/xinyou/office/web
prefix=''
#base=src/main/java/com/xinyou/post
mkdir -p $base/$code
mkdir -p $base/$code/controller
mkdir -p $base/$code/dao
mkdir -p $base/$code/eo
mkdir -p $base/$code/vo
mkdir -p $base/$code/service

sed "s/{code}/$code/g;s/{codeUpper}/$codeUpper/g;s/{name}/$name/g" ./template/controller.java >$base/$code/controller/${codeUpper}Controller.java
sed "s/{code}/$code/g;s/{codeUpper}/$codeUpper/g;s/{name}/$name/g" ./template/service.java >$base/$code/service/${codeUpper}Service.java
sed "s/{code}/$code/g;s/{codeUpper}/$codeUpper/g;s/{name}/$name/g" ./template/vo.java >$base/$code/vo/${prefix}${codeUpper}VO.java
sed "s/{code}/$code/g;s/{codeUpper}/$codeUpper/g;s/{name}/$name/g" ./template/eo.java >$base/$code/eo/${prefix}${codeUpper}EO.java
sed "s/{code}/$code/g;s/{codeUpper}/$codeUpper/g;s/{name}/$name/g" ./template/dao.java >$base/$code/dao/${codeUpper}Dao.java
