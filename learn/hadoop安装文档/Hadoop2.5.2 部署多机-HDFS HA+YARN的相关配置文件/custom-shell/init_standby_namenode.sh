#!/bin/sh

base_dir=~/hadoop/ha
hadoop_install_dir=$base_dir/hadoop-2.5.2
standby_namenode_file=$base_dir/custom-shell/standby-namenode-conf
if [ ! -f $standby_namenode_file ]; then
  echo $standby_namenode_file"文件不存在。"
  exit 0
fi
if [ ! -s $standby_namenode_file ]; then
  echo $standby_namenode_file"文件内容不能为空。"
  exit 0
fi

host=`cat $standby_namenode_file`
ssh $host $hadoop_install_dir/bin/hdfs namenode -bootstrapStandby
ssh $host $hadoop_install_dir/sbin/hadoop-daemon.sh start namenode 

