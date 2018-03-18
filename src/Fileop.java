import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;

public class Fileop {
//文件的递归处理
	String filename;
	String outfilename;
	String stopname;
	//设置两个构造方法
	public Fileop(String filename,String outfilename){
		
		this.filename=filename;
		this.outfilename=outfilename;
	}
	
public Fileop(String filename,String outfilename,String stopname){
		
		this.filename=filename;
		this.outfilename=outfilename;
		this.stopname=stopname;
	//	System.out.println(outfilename);
	}

//递归。定义一个fun函数
public void fun(String ff,int c,int w,int l,int a,int ss,int e) throws IOException{
	//System.out.println(ff);
    String fnm=ff;
   // System.out.println(fnm);
    File f1 = new File(fnm);
    if (f1.isDirectory()) 
    {
	      //System.out.println( "在当前目录： " + fnm);
	      String s[] = f1.list();
	      for (int i=0; i < s.length; i++) 
	      {
		        File f = new File(fnm + "/" + s[i]);
		        if (f.isDirectory())
		        {
		         //System.out.println(s[i] + " 是一个目录");
		          this.fun(s[i],c,w,l,a,ss,e);
		        
		        } 
		        else if(s[i]!=stopname)
		        {
		        	String pattern = ".*.txt";
		        
		        boolean isMatch = Pattern.matches(pattern, s[i]);
		        if(isMatch&&(s[i]!="stop.txt")){
		        	//System.out.println(isMatch);
		        	//System.out.println(s[i] + " 是一个文件");
		        	
			            File2 ftest=new File2(s[i],outfilename,stopname);
						//ftest.save(c,w,l,a,ss,e);
			        //  if(c==1)  System.out.println(s[i]+','+"字符数："+ftest.zCount());
			         
			           ftest.save(s[i],c,w,l,a,ss,e);
			          
			         // if(w==1) System.out.println(s[i]+','+"单词数："+ftest.ciCount());
			          
			          
			          
			         // if(l==1) System.out.println(s[i]+','+"行数："+ftest.hCount());
			        
		        	
		        }
		        //else System.out.println("不存在类型为："+pattern+"的文件");
		        }
	      }
    }
    else 
    {
    	//不做处理
     // System.out.println(fnm + " 不是一个目录");
    }
	
	
	
	
	
	
	
	
	
	
	
}	
	
	
	
}
