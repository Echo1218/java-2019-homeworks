# 如何运用面向对象编程思想解决葫芦娃排队问题

​																		171860539 蔡恒

## 对于问题的理解

现实：七个葫芦娃是同种生物，他们具有共同的属性（①名称②颜色）和能力（①报数②报颜色③告诉别人什么颜色的葫芦娃或者什么名字的葫芦娃排行老几（这个可以作为排序的依据））。他们彼此之间的差别仅仅存在于他们的名字和颜色不同。

代码的抽象：七个葫芦娃是同种生物即他们是一个类，葫芦娃的属性即为该类的数据成员，葫芦娃的能力即为类中的方法。

排序是一个类，拥有两种排序方法，一种冒泡，一种二分插入，这两种排序方法没什么本质的区别，只是实现不同。既然要排序就要知道葫芦娃彼此间的大小关系，这时就调用葫芦娃类中告诉排行的方法即可。排序必不可少的还有交换葫芦娃的位置，为此添加交换位置方法。作为该问题的其他需求，还加入了报数，报颜色，打乱葫芦娃队列等方法。

main函数单独在一个类。

## 用面向对象的思想解决

首先创建一个葫芦娃类：

```java
class Huluwa{
    String name;
    String color;
    public String getName()；//返回name
    public String getColor()；//返回color
    Huluwa(String name,String color)；//constructor
    public int getNameOrder()；//告诉自己排老几
    public int getColorOrder()；//告诉自己排老几
}
```

然后是排序类，里面有两个排序方法和为了支撑排序以及问题的需要而实现的各种方法

```java
public class Hulusort {
    private static void baoshu(Huluwa[] arr);//队伍报数
    private static void baoyanse(Huluwa[] arr);//队伍报颜色
    private static void bubbleSort(Huluwa[] arr);//冒泡
    private static void back(Huluwa[] arr,int start,int end);//将多个葫芦娃整体往后移
    private static void dividedSort(Huluwa[] arr);//二分排序
    private static Random rand = new Random();//产生随机数的对象
    public static  void swap(Huluwa[] a, int i, int j);//交换位置
    public static void shuffle(Huluwa[] arr);//打乱队伍顺序
}
```

main函数的大体功能：创建一个hulusort对象，七个Huluwa对象，将七个葫芦娃对象放进对象数组huluwa中，用hulusort对象对其排序。

```java
class Main{
    public static void main(String[] args)
    {
        Hulusort hulusort=new Hulusort();//创建一个hulusort对象 用于给葫芦娃排序
        Huluwa laoda=new Huluwa("老大", "红色");//创建七个葫芦娃对象
        Huluwa laoer=new Huluwa("老二","橙色");
        Huluwa laosan=new Huluwa("老三","黄色");
        Huluwa laosi=new Huluwa("老四","绿色");
        Huluwa laowu=new Huluwa("老五","青色");
        Huluwa laoliu=new Huluwa("老六","蓝色");
        Huluwa laoqi=new Huluwa("老七","紫色");
        Huluwa huluwa[]=new Huluwa[7];//对象数组
  huluwa[0]=laoda;huluwa[1]=laoer;huluwa[2]=laosan;huluwa[3]=laosi;huluwa[4]=laowu;huluwa[5]=laoliu;huluwa[6]=laoqi;//把葫芦娃放进数组中
        hulusort.shuffle(huluwa);//打乱顺序
        System.out.print("这是打乱后的原始顺序：");
        hulusort.baoshu(huluwa);//报名字
        hulusort. bubbleSort(huluwa);//冒泡排序
        hulusort.baoshu(huluwa);//报名字
        hulusort.shuffle(huluwa);//打乱顺序
        System.out.print("这是打乱后的原始顺序：");
        hulusort.baoyanse(huluwa);//报颜色
        hulusort.dividedSort(huluwa);//二分排序
        hulusort.baoyanse(huluwa);//报颜色
    }
}
```

下面以冒泡排序为例说明是如何排序的：

```java
for(int i =0;i<arr.length-1;i++) {
        for(int j=0;j<arr.length-1-i;j++) {

            if(arr[j].getNameOrder()>arr[j+1].getNameOrder()) {
                swap(arr, j, j+1);//交换
                System.out.println(arr[j+1].getName()+":"+j+"->"+(j+1));//输出葫芦娃名称和位置移动信息
                System.out.println(arr[j].getName()+":"+(j+1)+"->"+j);
            }
            }
        }
```



bubbleSort方法接受一个Huluwa类型的对象数组，数组中相邻元素比较，根据葫芦娃类的getNameOrder方法获得当前对象排行，如果左边的排行小于右边的排行，就调用swap方法交换彼此的位置，如果位置移动了，输出移动前后的位置，此时要调用huluwa中的getName方法。



另外，排序之前要把顺序打乱，等同于洗牌，此处用的是Knuth Shuffle算法。调用排序方法排好序后队伍从头到尾报名字，就是对对象数组元素遍历，分别调用getName然后打印。

二分排序的过程与此过程大体相同，只是排序的依据和算法不一样，不调用getName和getNameOrder了，而是getColor和getColorOder，用来报颜色和告诉这个对象的颜色在“红橙黄绿青蓝紫”中排第几。

总的来说，解决本问题用到的面向对象的思想就在于分清不同的类，明确不同类中的数据成员和方法，以及这些对象间彼此发消息告诉彼此要做什么，共同协作。

