import java.io.*;
//������
public class File2 {
	private String fileName;
	private String outfileName;
 
	//���췽���������������飬s1:��ȡ���ļ�����s2���洢���ļ���
	public File2(String s1,String s2){
	
		this.fileName=s1;
		this.outfileName=s2;
		
	
	}
	
	//�����ַ���
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
	
	//���㵥����
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
			
	       // Pattern pat = Pattern.compile("[`~!@#$^&*()=|{}':;',\\[\\]. <>/?~��@#������&*��������|{}��������������'��������]$"); 	  
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
	
	//��������
	public int hCount() throws IOException{
		int h=0;//line count flag
        File f2 = new File(fileName); // ��ȡ�ļ�  
        InputStreamReader reader = new InputStreamReader(  
        new FileInputStream(f2)); // ����һ������������reader  
        BufferedReader br = new BufferedReader(reader); // ����һ�����������ļ�����ת�ɼ�����ܶ���������  
        String line = "";  
        line = br.readLine();  
        h=h+1;
        while (line != null) {  
            line = br.readLine(); // һ�ζ���һ������ 
            h++;
        }
		return h-1;//У�� 
		
		
	}
	
	//�����Ϊ�ļ�
	public boolean save() throws IOException{
	
		  File writename = new File(outfileName); // ���·�������û����Ҫ����һ���µ�output��txt�ļ�  
          writename.createNewFile(); // �������ļ�  
          BufferedWriter out = new BufferedWriter(new FileWriter(writename));  
        
          out.write(Integer.toString(zCount())+"---"); // \r\n��Ϊ����
          out.write(Integer.toString(ciCount())+"---");
          out.write(Integer.toString(hCount())+"---");
       
          out.flush(); // �ѻ���������ѹ���ļ�  
          out.close(); // ���ǵùر��ļ�  
		  return true;
		
		
		
		
	}
}
