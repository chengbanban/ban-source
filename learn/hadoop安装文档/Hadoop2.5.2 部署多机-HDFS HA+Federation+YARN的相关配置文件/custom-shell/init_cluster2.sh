#!/bin/sh

base_dir=~/hadoop/federation
hadoop_install_dir=$base_dir/hadoop-2.5.2
cluster2_master_file=$base_dir/custom-shell/cluster2-master-conf
cluster2_standby_file=$base_dir/custom-shell/cluster2-standby-conf
if [ ! -f $cluster2_master_file ]; then
  echo $cluster2_master_file"文件不存在。"
  exit 0
fi
if [ ! -s $cluster2_master_file ]; then
  echo $cluster2_master_file"文件内容不能为空。"
  exit 0
fi
if [ ! -f $cluster2_standby_file ]; then
  echo $cluster2_standby_file"文件不存在。"
  exit 0
fi
if [ ! -s $cluster2_standby_file ]; then
  echo $cluster2_standby_file"文件内容不能为空。"
  exit 0
fi

master_host=`cat $cluster2_master_file`
#格式化 master namenode
ssh $master_host $hadoop_install_dir/bin/hdfs namenode -format -clusterId chinahadoop-cluster
#启动
ssh $master_host $hadoop_install_dir/sbin/hadoop-daemon.sh start namenode

standby_host=`cat $cluster2_standby_file`
#格式化 standby namenode
ssh $standby_host $hadoop_install_dir/bin/hdfs namenode -bootstrapStandby
#启动
ssh $standby_host $hadoop_install_dir/sbin/hadoop-daemon.sh start namenode

