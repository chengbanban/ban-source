#!/bin/sh

base_dir=~/hadoop/federation
hadoop_install_dir=$base_dir/hadoop-2.5.2

master_file=$base_dir/custom-shell/cluster2-master-conf
if [ ! -f $master_file ]; then
  echo $master_file"文件不存在。"
  exit 0
fi
if [ ! -s $master_file ]; then
  echo $master_file"文件内容不能为空。"
  exit 0
fi

host=`cat $master_file`
ssh $host $hadoop_install_dir/bin/hdfs haadmin -ns chinahadoop-cluster2 -transitionToActive nn3
