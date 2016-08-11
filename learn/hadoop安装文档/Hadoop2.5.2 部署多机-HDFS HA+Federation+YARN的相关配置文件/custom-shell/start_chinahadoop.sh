#!/bin/sh

base_dir=~/hadoop/federation
hadoop_install_dir=$base_dir/hadoop-2.5.2
chinahadoop_shell_dir=$base_dir/custom-shell

#sh $chinahadoop_shell_dir/start_journalnode.sh
#sh $chinahadoop_shell_dir/start_namenode.sh
#sh $chinahadoop_shell_dir/start_standby_namenode.sh
#sh $chinahadoop_shell_dir/active_master.sh

#sh $hadoop_install_dir/sbin/hadoop-daemons.sh start datanode

sh $hadoop_install_dir/sbin/start-dfs.sh
sh $chinahadoop_shell_dir/active_cluster1_master.sh
sh $chinahadoop_shell_dir/active_cluster2_master.sh
sh $hadoop_install_dir/sbin/start-yarn.sh

