package Data_Structure;

public class Sort {
	public static int[] insertSort(int[]a){//插入排序
		int j;
		for(int p=1;p<a.length;p++){
			int tmp=a[p];
			for(j=p;j>0&&tmp-a[j-1]<0;j--){
				a[j]=a[j-1];
			}
			a[j]=tmp;
		}
		return a;
	}
	public static int[] shellSort(int[]a){//希尔排序
		int j;
		for(int gap=a.length/2;gap>0;gap/=2)
			for(int i=gap;i<a.length;i++){
				int tmp=a[i];
				for(j=i;j>=gap&&tmp-a[j-gap]<0;j-=gap)
					a[j]=a[j-gap];
				a[j]=tmp;
			}
		return a;
	}
	public static void HeapAdjust(int array[],int i,int nLength)//堆排序的调整部分
	{
	    int nChild;
	    int nTemp;
	    for(;2*i+1<nLength;i=nChild)
	    {
	        //子结点的位置=2*（父结点位置）+1
	        nChild=2*i+1;
	        //得到子结点中较大的结点
	        if(nChild<nLength-1&&array[nChild+1]>array[nChild])
	        	++nChild;
	        //如果较大的子结点大于父结点那么把较大的子结点往上移动，替换它的父结点
	        if(array[i]<array[nChild])
	        {
	            nTemp=array[i];
	            array[i]=array[nChild];
	            array[nChild]=nTemp; 
	        }
	        else break; //否则退出循环
	    }
	}
	public static int[] HeapSort(int array[],int length)//堆排序
	{
	    int i;
		//调整序列的前半部分元素，调整完之后第一个元素是序列的最大的元素
		//length/2-1是最后一个非叶节点，此处"/"为整除
	    for(i=length/2-1;i>=0;--i)
	        HeapAdjust(array,i,length);
		//从最后一个元素开始对序列进行调整，不断的缩小调整的范围直到第一个元素
	    for(i=length-1;i>0;--i)
	    {
	        //把第一个元素和当前的最后一个元素交换，
	        //保证当前的最后一个位置的元素都是在现在的这个序列之中最大的
	    	int ittemp=array[i];
	    	array[i]=array[0];
	    	array[0]=ittemp;
	        //不断缩小调整heap的范围，每一次调整完毕保证第一个元素是当前序列的最大值
	        HeapAdjust(array,0,i);
	    }
	    return array;
	}
	public static int[] sort(int arr[],int low,int high){//快速排序
		 int l=low;
		 int h=high;
		 int povit=arr[low];
		 while(l<h)
		 {
			 while(l<h&&arr[h]>=povit)
		        h--;
		     if(l<h){
		        int temp=arr[h];
		        arr[h]=arr[l];
		        arr[l]=temp;
		        l++;
		     }
		     while(l<h&&arr[l]<=povit)
		        l++;
		     if(l<h){
		        int temp=arr[h];
		        arr[h]=arr[l];
		        arr[l]=temp;
		        h--;
		     }
		 }
		 if(l>low)sort(arr,low,l-1);
		 if(h<high)sort(arr,l+1,high);
		 return arr;
	}
	public static int[] SimpleChoiceSort(int[]a){//简单选择排序
		for(int i=0;i<a.length;i++)
	    {
	        int k=i;
	        for(int j=i+1;j<a.length;j++){
	            if(a[k]>a[j])
	                k=j;
	         }
	         if(k!=i){
	            int t=a[i];
	            a[i]=a[k];
	            a[k]=t;
	         }
	    }
		return a;
	}
	public static int[] bubble_sort(int[]a)//冒泡排序
	{
	    int i,j,temp;
	    for(j=0;j<a.length-1;j++)
	        for(i=0;i<a.length-1-j;i++)
	        {
	            if(a[i]<a[i+1])
	            {
	                temp=a[i];
	                a[i]=a[i+1];
	                a[i+1]=temp;
	            }
	        }
	    return a;
	}
	public static int[] mergeSort(int[]a){//归并排序算法
		int[]tmpArray=new int[a.length];
		mergeSortt(a,tmpArray,0,a.length-1);
		return a;
	}
	public static void mergeSortt(int[]a,int[]tmpArray,int left,int right){//递归部分
		if(left<right){
			int center=(left+right)/2;
			mergeSortt(a,tmpArray,left,center);
			mergeSortt(a,tmpArray,center+1,right);
			merge(a,tmpArray,left,center+1,right);
		}
	}
	public static void merge(int[]a,int[]tmpArray,int leftPos,int rightPos,int rightEnd){//合并部分
		int leftEnd=rightPos-1;
		int tmpPos=leftPos;int num=rightEnd-leftPos+1;
		while(leftPos<=leftEnd&&rightPos<=rightEnd){
			if(a[leftPos]-a[rightPos]<=0){
				tmpArray[tmpPos++]=a[leftPos++];
			}
			else{
				tmpArray[tmpPos++]=a[rightPos++];
			}
		}
		while(leftPos<=leftEnd){
			tmpArray[tmpPos++]=a[leftPos++];
		}
		while(rightPos<=rightEnd){
			tmpArray[tmpPos++]=a[rightPos++];
		}
		for(int i=0;i<num;i++,rightEnd--){
			a[rightEnd]=tmpArray[rightEnd];
		}
	}
	public  static void main(String[]args){//测试排序的主方法
		int[]a={6,9,7,4,5,8,3,2,1};
		int[]b= Sort.bubble_sort(a);
		for(int i=0;i<b.length;i++){
			System.out.println(b[i]);
		}
	}
}
