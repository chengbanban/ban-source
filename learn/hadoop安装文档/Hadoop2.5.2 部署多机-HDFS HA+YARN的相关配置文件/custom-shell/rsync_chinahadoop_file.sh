#!/bin/sh

base_dir=~/hadoop/ha
slaves_file=$base_dir/custom-shell/slaves-conf

chinahadoop_file=$1
if [ ! -f $slaves_file ]; then
  echo $slaves_file"文件不存在。"
  exit 0
fi
if [ ! -s $slaves_file ]; then
  echo $slaves_file"文件内容不能为空。"
  exit 0
fi
if [ -z $chinahadoop_file ]; then
  echo "请指定完整路径包括文件名。"
  exit 0
fi

localhost=`hostname`
for host in `cat $slaves_file`; do
  if [ $localhost != $host ]; then
  rsync -a $chinahadoop_file $host:$chinahadoop_file
  echo "文件已拷贝到"$host"机器上。"
  fi
done  
echo "执行完毕！"
