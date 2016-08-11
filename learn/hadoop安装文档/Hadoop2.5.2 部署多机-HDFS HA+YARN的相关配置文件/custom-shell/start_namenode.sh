#!/bin/sh

base_dir=~/hadoop/ha
hadoop_install_dir=$base_dir/hadoop-2.5.2
master_file=$base_dir/custom-shell/master-conf
if [ ! -f $master_file ]; then
  echo $master_file"文件不存在。"
  exit 0
fi
if [ ! -s $master_file ]; then
  echo $master_file"文件内容不能为空。"
  exit 0
fi

host=`cat $master_file`
ssh $host $hadoop_install_dir/sbin/hadoop-daemon.sh start namenode 

