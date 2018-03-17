import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;

public class Fileop {

	String filename;
	
	public Fileop(String filename){
		
		this.filename=filename;
	
	}
	
public void fun(String ff) throws IOException{
	
    String fnm=ff;
    File f1 = new File(fnm);
    if (f1.isDirectory()) 
    {
	      System.out.println( "在当前目录： " + fnm);
	      String s[] = f1.list();
	      for (int i=0; i < s.length; i++) 
	      {
		        File f = new File(fnm + "/" + s[i]);
		        if (f.isDirectory())
		        {
		          System.out.println(s[i] + " 是一个目录");
		          this.fun(s[i]);
		        
		        } 
		        else 
		        {
		        	String pattern = ".*.txt.*";
		        
		        boolean isMatch = Pattern.matches(pattern, s[i]);
		        if(isMatch){
		        	
		        	 System.out.println(s[i] + " 是一个文件");
			            File2 ftest=new File2(s[i],"=");
			            System.out.println(s[i]+','+"字符数："+ftest.zCount());
						System.out.println(s[i]+','+"单词数："+ftest.ciCount());
						System.out.println(s[i]+','+"行数："+ftest.hCount());
		        	
		        }
		        //else System.out.println("不存在类型为："+pattern+"的文件");
		        }
	      }
    }
    else 
    {
      System.out.println(fnm + " 不是一个目录");
    }
	
	
	
	
	
	
	
	
	
	
	
}	
	
	
	
}
