一. 生产环境服务器变慢，诊断思路和性能评估谈一下？

    整机：top 精简版 uptime
    CPU：vmstat
    内存：free     free -g     free -m     查看额外：  pidstat -p 进程号 -r 采样间隔秒数
    硬盘：df -h (human==人类看的懂的方式) 查看磁盘剩余空间数
    磁盘IO：iostat
    网络IO：ifstat

二. 假如生产环境CPU占用过高，请谈谈你的分析思路和定位？

    结合Linux和JDK命令一起分析，步骤如下：
    1 先用top命令找出CPU占比最高的。
    2 ps -ef或者jps进一步定位，得知是一个怎么样的一个后台程序惹事。
    3 定位到具体线程或代码（那个一个线程耗费了时间： ps -mp 进程 -o Thread, tid, time）
        -m显示所有的线程   -p pid 进程使用cpu的时间 -o该参数后是用户自定义格式
    4 将需要的线程ID转换为16进制格式（英文小写格式） printf "%x\n" 有问题的线程ID
    5 jstack 进程ID| grep tid(16进制线程ID小写英文) -A60

