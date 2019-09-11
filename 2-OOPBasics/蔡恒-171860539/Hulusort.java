import java.util.Arrays;
import java.util.Random;
class Huluwa{
    String name;
    String color;
    public String getName()
    {
        return name;
    }
    public String getColor()
    {
        return color;
    }
    Huluwa(String name,String color)
    {
        this.name=name;
        this.color=color;
    }
    public int getNameOrder()
    {
        if(name=="老大")
            return 1;
        else if(name=="老二")
            return 2;
        else if(name=="老三")
            return 3;
        else if(name=="老四")
            return 4;
        else if(name=="老五")
            return 5;
        else if(name=="老六")
            return 6;
        else if(name=="老七")
            return 7;
        return 0;
    }
    public int getColorOrder()
    { if(color=="红色")
        return 1;
    else if(color=="橙色")
        return 2;
    else if(color=="黄色")
        return 3;
    else if(color=="绿色")
        return 4;
    else if(color=="青色")
        return 5;
    else if(color=="蓝色")
        return 6;
    else if(color=="紫色")
        return 7;
        return 0;
    }
}


public class Hulusort {
    public static void baoshu(Huluwa[] arr)
    {
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i].getName()+" ");
        System.out.println(" ");
    }
    public static void baoyanse(Huluwa[] arr)
    {
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i].getColor()+" ");
        System.out.println(" ");
    }
    public static void bubbleSort(Huluwa[] arr)
    {
        for(int i =0;i<arr.length-1;i++) {
        for(int j=0;j<arr.length-1-i;j++) {

            if(arr[j].getNameOrder()>arr[j+1].getNameOrder()) {
                swap(arr, j, j+1);
                System.out.println(arr[j+1].getName()+":"+j+"->"+(j+1));
                System.out.println(arr[j].getName()+":"+(j+1)+"->"+j);
            }
           //System.out.println("aaa"+j+" "+(j+1)+" "+changed);
            }
        }
    }
    public static void back(Huluwa[] arr,int start,int end)
    {
        for(int i=end;i>start;i--)
        {
            arr[i]=arr[i-1];
            System.out.println(arr[i-1].getName()+":"+(i-1)+"->"+i);

        }
    }
    public static void dividedSort(Huluwa[] arr)
    {

        int left=0; int right=0;int mid=0;
        for(int i=1;i<arr.length;i++)
        {   left=0;right=i-1;
            while(left<right)
            {
                mid=(left+right)/2;

                if(mid==left||mid==right)break;
                if(arr[i].getColorOrder()>arr[mid].getColorOrder())
                    left=mid;
                else right=mid;


            }
            Huluwa temp=arr[i];
            if(arr[i].getColorOrder()<arr[mid].getColorOrder())
            {back(arr,mid,i);arr[mid]=temp;
            if(i!=mid)
            System.out.println(temp.getName()+":"+i+"->"+mid);}
            else if(arr[i].getColorOrder()>arr[right].getColorOrder())
                {back(arr,right+1,i);arr[right+1]=temp;
                if(i!=right+1)
                System.out.println(temp.getName()+":"+i+"->"+(right+1));}
            else{
                back(arr,right,i);arr[right]=temp;
                if(i!=right)
                System.out.println(temp.getName()+":"+i+"->"+(right));
            }




        }
    }
    private static Random rand = new Random();
    public static  void swap(Huluwa[] a, int i, int j){
        Huluwa temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void shuffle(Huluwa[] arr) {
        int length = arr.length;
        for ( int i = arr.length; i > 0; i-- ){
            int randInd = rand.nextInt(i);
            swap(arr, randInd, i - 1);
        }
    }


}

class Main{
    public static void main(String[] args)
    {
        Hulusort hulusort=new Hulusort();
        Huluwa laoda=new Huluwa("老大", "红色");
        Huluwa laoer=new Huluwa("老二","橙色");
        Huluwa laosan=new Huluwa("老三","黄色");
        Huluwa laosi=new Huluwa("老四","绿色");
        Huluwa laowu=new Huluwa("老五","青色");
        Huluwa laoliu=new Huluwa("老六","蓝色");
        Huluwa laoqi=new Huluwa("老七","紫色");
        Huluwa huluwa[]=new Huluwa[7];
        huluwa[0]=laoda;huluwa[1]=laoer;huluwa[2]=laosan;huluwa[3]=laosi;huluwa[4]=laowu;huluwa[5]=laoliu;huluwa[6]=laoqi;
        hulusort.shuffle(huluwa);
        System.out.print("这是打乱后的原始顺序：");
        hulusort.baoshu(huluwa);
        hulusort. bubbleSort(huluwa);
        hulusort.baoshu(huluwa);
        hulusort.shuffle(huluwa);
        System.out.print("这是打乱后的原始顺序：");
        hulusort.baoyanse(huluwa);
        hulusort.dividedSort(huluwa);
        hulusort.baoyanse(huluwa);
       /*Huluwa wawa[]=new Huluwa[4];
       wawa[0]=laoda;wawa[1]=laosan;wawa[2]=laosi;wawa[3]=laoer;
       baoyanse(wawa);
       dividedSort(wawa);*/


       /* System.out.println(huluwa[0].getNameOrder());
        System.out.println(huluwa[1].getNameOrder());
        System.out.println(huluwa[2].getNameOrder());
        System.out.println(huluwa[3].getNameOrder());
        System.out.println(huluwa[4].getNameOrder());
        System.out.println(huluwa[5].getNameOrder());
        System.out.println(huluwa[6].getNameOrder());*/

    }
}