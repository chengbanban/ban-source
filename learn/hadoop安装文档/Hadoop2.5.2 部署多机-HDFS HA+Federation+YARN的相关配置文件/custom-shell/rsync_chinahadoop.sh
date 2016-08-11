#!/bin/sh

#集群中所有节点的固定目录
base_dir=~/hadoop/federation
slaves_file=$base_dir/custom-shell/slaves-conf
if [ ! -f $slaves_file ]; then
  echo $slaves_file"文件不存在。"
  exit 0
fi
if [ ! -s $slaves_file ]; then
  echo $slaves_file"文件内容不能为空。"
  exit 0
fi
if [ -z $chinahadoop_dir ]; then
  echo "请指定一个目录。"
  exit 0
fi

localhost=`hostname`

for host in `cat $slaves_file`; do
  if [ $localhost != $host ]; then 
    #`ssh $host #!/bin/sh if [ ! -d $base_dir ]; then mkdir -p $base_dir fi`
    rsync -a $chinahadoop_dir $host:$base_dir
    echo "已拷贝到"$host"机器上。"
  fi
done
  
echo "执行完毕！"
