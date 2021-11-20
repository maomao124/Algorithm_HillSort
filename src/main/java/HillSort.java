/**
 * Project name(项目名称)：算法_希尔排序
 * Package(包名): PACKAGE_NAME
 * Class(类名): HillSort
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/11/20
 * Time(创建时间)： 13:28
 * Version(版本): 1.0
 * Description(描述)：
 * 希尔排序算法的实现思路是：
 * 将待排序序列划分成多个子序列，使用普通的插入排序算法对每个子序列进行排序；
 * 按照不同的划分标准，重复执行第一步；
 * 使用普通的插入排序算法对整个序列进行排序。
 */

public class HillSort
{
    public static void sort(int[] arr)
    {
        int length = arr.length;
        // 初始化间隔数为 1
        int interval = 1;         //间隔
        // 计算最大间隔
        while (interval < length / 3)   //超过长度的1/3
        {
            interval = interval * 3 + 1;
        }
        // 根据间隔数，不断划分序列，并对各子序列排序
        while (interval > 0)
        {
            // 对各个子序列做直接插入排序
            for (int i = interval; i < length; i++)
            {
                int temp = arr[i];
                int j = i;
                while (j > interval - 1 && arr[j - interval] >= temp)
                {
                    arr[j] = arr[j - interval];
                    j -= interval;
                }
                if (j != i)
                {
                    arr[j] = temp;
                }
                print(arr);
            }
            // 计算新的间隔数，继续划分序列
            interval = (interval - 1) / 3;
            System.out.println("-------------");
        }
    }

    private static void print(int[] arr)
    {
        for (int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
