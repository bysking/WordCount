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
	      System.out.println( "�ڵ�ǰĿ¼�� " + fnm);
	      String s[] = f1.list();
	      for (int i=0; i < s.length; i++) 
	      {
		        File f = new File(fnm + "/" + s[i]);
		        if (f.isDirectory())
		        {
		          System.out.println(s[i] + " ��һ��Ŀ¼");
		          this.fun(s[i]);
		        
		        } 
		        else 
		        {
		        	String pattern = ".*.txt.*";
		        
		        boolean isMatch = Pattern.matches(pattern, s[i]);
		        if(isMatch){
		        	
		        	 System.out.println(s[i] + " ��һ���ļ�");
			            File2 ftest=new File2(s[i],"=");
			            System.out.println(s[i]+','+"�ַ�����"+ftest.zCount());
						System.out.println(s[i]+','+"��������"+ftest.ciCount());
						System.out.println(s[i]+','+"������"+ftest.hCount());
		        	
		        }
		        //else System.out.println("����������Ϊ��"+pattern+"���ļ�");
		        }
	      }
    }
    else 
    {
      System.out.println(fnm + " ����һ��Ŀ¼");
    }
	
	
	
	
	
	
	
	
	
	
	
}	
	
	
	
}
