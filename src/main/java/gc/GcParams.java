package gc;

/**
 * @author: wei_g
 * @DATE: 2021/3/4 10:15
 *
 * 默认(MinHeapFreeRatio参数可以调整)空余堆内存小于40%时，JVM就会增大堆直到-Xmx的最大限制，
 * 默认(MaxHeapFreeRatio参数可以调整)空余堆内存大于70%时，JVM会减少堆直到 -Xms的最小限制。简
 * 单点来说，你不停地往堆内存里面丢数据，等它剩余大小小于40%了，JVM就会动态申请内存空间不过会小于-Xmx，如果剩余大小大于70%，又会动态缩小不过不会小于–Xms
 * 开发过程中，通常会将 -Xms 与 -Xmx两个参数配置成相同的值（—Xmn参数），其目的是为了能够在java垃圾回收机制清理完堆区后不需要重新分隔计算堆区的大小而浪费资源。
 */
public class GcParams {
    /**
     * 设置新生代和老年代的比值： -XX:NewRatio   --- 新生代（eden+2*Survivor）和老年代（不包含永久区）的比值（当设置了-Xmn参数时，该参数不需要设置好） 官方推荐新生代占java堆的3/8
     * 设置两个Survivor区和Eden区的比值： -XX:SurvivorRatio  ---官方推荐幸存代占新生代的1/10 即：1:1:8
     * 设置年轻代空间大小： -XX:NewSize  —XX:MaxNewSize
     * 设置永久代空间大小： -XX:PermSize  -XX:MaxPermSize
     *
     * 小总结：在出现OOM问题时，记得dump出堆，确保可以排查现场问题，输出.dump文件命令如下：
     * -XX:HeapDumpOutOfMemoryError  -XX:HeapDumpPath=输出路径
     * @param args
     */
    public static void main(String[] args) {
        //设置最大和最小堆内存以及打印gc详细日志  VM options: -Xmx20m -Xms5m -XX:+PrintGCDetails

        //1.给数组分配1M空间
//        byte[] b = new byte[1024 * 1024];
        //2.给数组分配10M空间
        byte[] a= new byte[12 * 1024 * 1024];
        //3.手动执行一次gc后观察gc详情
        System.gc();

        System.out.println("Xmx: " + Runtime.getRuntime().maxMemory() / 1024.0 / 1024.0 + "M");
        System.out.println("freeMemory: " + Runtime.getRuntime().freeMemory() / 1024.0 / 1024.0 + "M");
        System.out.println("totalMemory : " + Runtime.getRuntime().totalMemory() / 1024.0 / 1024.0 + "M");
    }
}
