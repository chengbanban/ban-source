#!/bin/sh

base_dir=~/hadoop/federation
hadoop_install_dir=$base_dir/hadoop-2.5.2
journalnode_file=$base_dir/custom-shell/journalnode-conf

if [ ! -f $journalnode_file ]; then
  echo $journalnode_file"文件不存在。"
  exit 0
fi
if [ ! -s $journalnode_file ]; then
  echo $journalnode_file"文件内容不能为空。"
  exit 0
fi

for host in `cat $journalnode_file`; do
  echo $host"正在启动JournalNode。"
  ssh $host $hadoop_install_dir/sbin/hadoop-daemon.sh start journalnode 
done
