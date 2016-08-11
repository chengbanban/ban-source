#!/bin/sh

base_dir=~/hadoop/ha
hadoop_install_dir=$base_dir/hadoop-2.5.2

sh $hadoop_install_dir/sbin/stop-dfs.sh
sh $hadoop_install_dir/sbin/stop-yarn.sh

