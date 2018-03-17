import java.io.*;
//方法类
public class File2 {
	private String fileName;
	private String outfileName;
 
	//构造方法，传入两个数组，s1:读取的文件名，s2：存储的文件名
	public File2(String s1,String s2){
	
		this.fileName=s1;
		this.outfileName=s2;
		
	
	}
	
	//计算字符数
	public int zCount() throws IOException{
		   int z=0,z2=0;
	      StringBuilder sb = new StringBuilder();
		  
		  BufferedReader br = new BufferedReader(new FileReader(fileName));
		  
		  String s ="";
		  while( (s = br.readLine()) != null) {
		  sb.append(s + "\n");
		  z2++;
		  z+=s.length();
		  s ="";
		  }

		  br.close();
		 
		  //System.out.println(z+z2);
		  return z+z2-1;
		
		
	}
	
	//计算单词数
	public int ciCount() throws IOException{    
	          StringBuilder sb = new StringBuilder();
			  String s ="";
			  BufferedReader br = new BufferedReader(new FileReader(fileName));

			  while( (s = br.readLine()) != null) {
			  sb.append(s + "\n");
			  
			  
			  
			  
			  }	
			  br.close();
			String str = sb.toString();
			char c[] = str.toCharArray(); 
			
	       // Pattern pat = Pattern.compile("[`~!@#$^&*()=|{}':;',\\[\\]. <>/?~！@#￥……&*（）——|{}【】‘；：”“'。，、？]$"); 	  
	        int count = 0;   
	        
	        int flag1=0;
	        
	        for (int i = 0; i < c.length; i++) {         		        	
	        	if((c[i]!=' ')&&(c[i]!=',')&&(c[i]!='\n'))
	        	{
	        		if(flag1==0) 
	        			{
	        			
	        			count++;
		        		flag1=1;
	        			
	        			}
							        	
	        	}
	        	
			        	else {
			        		
			        		if(flag1==1){
				        		
				        		
				        		flag1=0;
				        	}	
				        	
			        		
			        	}
	        		
	        	}
		        
		return count;		
	}
	
	//计算行数
	public int hCount() throws IOException{
		int h=0;//line count flag
        File f2 = new File(fileName); // 读取文件  
        InputStreamReader reader = new InputStreamReader(  
        new FileInputStream(f2)); // 建立一个输入流对象reader  
        BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言  
        String line = "";  
        line = br.readLine();  
        h=h+1;
        while (line != null) {  
            line = br.readLine(); // 一次读入一行数据 
            h++;
        }
		return h-1;//校正 
		
		
	}
	
	//结果存为文件
	public boolean save() throws IOException{
	
		  File writename = new File(outfileName); // 相对路径，如果没有则要建立一个新的output。txt文件  
          writename.createNewFile(); // 创建新文件  
          BufferedWriter out = new BufferedWriter(new FileWriter(writename));  
        
          out.write(Integer.toString(zCount())+"---"); // \r\n即为换行
          out.write(Integer.toString(ciCount())+"---");
          out.write(Integer.toString(hCount())+"---");
       
          out.flush(); // 把缓存区内容压入文件  
          out.close(); // 最后记得关闭文件  
		  return true;
		
		
		
		
	}
}
