import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;

public class Fileop {
//�ļ��ĵݹ鴦��
	String filename;
	String outfilename;
	String stopname;
	//�����������췽��
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

//�ݹ顣����һ��fun����
public void fun(String ff,int c,int w,int l,int a,int ss,int e) throws IOException{
	//System.out.println(ff);
    String fnm=ff;
   // System.out.println(fnm);
    File f1 = new File(fnm);
    if (f1.isDirectory()) 
    {
	      //System.out.println( "�ڵ�ǰĿ¼�� " + fnm);
	      String s[] = f1.list();
	      for (int i=0; i < s.length; i++) 
	      {
		        File f = new File(fnm + "/" + s[i]);
		        if (f.isDirectory())
		        {
		         //System.out.println(s[i] + " ��һ��Ŀ¼");
		          this.fun(s[i],c,w,l,a,ss,e);
		        
		        } 
		        else if(s[i]!=stopname)
		        {
		        	String pattern = ".*.txt";
		        
		        boolean isMatch = Pattern.matches(pattern, s[i]);
		        if(isMatch&&(s[i]!="stop.txt")){
		        	//System.out.println(isMatch);
		        	//System.out.println(s[i] + " ��һ���ļ�");
		        	
			            File2 ftest=new File2(s[i],outfilename,stopname);
						//ftest.save(c,w,l,a,ss,e);
			        //  if(c==1)  System.out.println(s[i]+','+"�ַ�����"+ftest.zCount());
			         
			           ftest.save(s[i],c,w,l,a,ss,e);
			          
			         // if(w==1) System.out.println(s[i]+','+"��������"+ftest.ciCount());
			          
			          
			          
			         // if(l==1) System.out.println(s[i]+','+"������"+ftest.hCount());
			        
		        	
		        }
		        //else System.out.println("����������Ϊ��"+pattern+"���ļ�");
		        }
	      }
    }
    else 
    {
    	//��������
     // System.out.println(fnm + " ����һ��Ŀ¼");
    }
	
	
	
	
	
	
	
	
	
	
	
}	
	
	
	
}
