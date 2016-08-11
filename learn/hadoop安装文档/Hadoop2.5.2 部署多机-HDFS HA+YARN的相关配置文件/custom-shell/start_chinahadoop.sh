#!/bin/sh

base_dir=~/hadoop/ha
hadoop_install_dir=$base_dir/hadoop-2.5.2

sh $base_dir/custom-shell/start_journalnode.sh
sh $base_dir/custom-shell/start_namenode.sh
sh $base_dir/custom-shell/start_standby_namenode.sh
sh $base_dir/custom-shell/active_master.sh
sh $hadoop_install_dir/sbin/hadoop-daemons.sh start datanode
sh $hadoop_install_dir/sbin/start-yarn.sh

