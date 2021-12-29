#!/bin/bash

set -e

#v_workspace=/Users/asan/workspace/xinyou/starfire-service/workspace
#v_git_url=https://github.com/chrisvfritz/vue-2.0-simple-routing-example
#v_git_branch=master
#v_build_docker_image=node
#v_build_pre_shell=
#v_build_shell=
#v_build_post_shell=
#v_project_id=29835
#v_project_name=vue-2.0-simple-routing-example
#v_build_id=21535
#v_build_person=
#v_store_path=/Users/asan/workspace/xinyou/starfire-service/workspace
#v_tag=
#v_clear=N
#v_call_back=

v_workspace=/Users/asan/workspace/xinyou/starfire-service/workspace
v_git_url=https://github.com/chrisvfritz/vue-2.0-simple-routing-example
v_git_branch=master
v_build_docker_image=node
v_build_pre_shell=
v_build_shell=
v_build_post_shell=
v_project_id=29835
v_project_name=vue-2.0-simple-routing-example
v_build_id=21535
v_build_person=
v_store_path=/Users/asan/workspace/xinyou/starfire-service/workspace
v_tag=
v_clear=N
v_call_back=

if [ "$v_build_pre_shell" != "" ]; then
  sh -c $v_build_pre_shell
fi

#1. 检测并创建目录
v_project_dir=$v_workspace/$v_project_id
if [ "$v_clear" == "Y" ]; then
  rm -rf "$v_project_dir"
fi
mkdir -p "$v_project_dir"
cd "$v_project_dir"

#2. 下载代码
if [ ! "$(ls -A $v_project_dir)" ]; then
  git clone -b $v_git_branch "$v_git_url"
fi

v_project_code=$(ls -A $v_project_dir)
echo "project====>"$v_project_code
v_project_dir=$v_project_dir/$v_project_code
cd "$v_project_dir"
git pull origin "$v_git_branch"

#3. 编译构建

docker run -v "$v_project_dir":/user/app -w /user/app -it --rm $v_build_docker_image npm install

docker run -v "$v_project_dir":/user/app -w /user/app -it --rm $v_build_docker_image npm run build

#4. 保存文件
v_name=$RANDOM$RANDOM$RANDOM
v_name=$(echo $v_name|md5sum|cut -d" " -f1)
v_name=${v_name: 1: 6}
v_name=sf_${v_build_id}_${v_name}.zip
zip -r $v_name dist
mkdir -p $v_store_path
mv $v_name $v_store_path/

if [ "$v_build_post_shell" != "" ]; then
  sh -c $v_build_post_shell
fi

if [ "$v_call_back" != "" ]; then
  sh -c $v_build_post_shell
fi