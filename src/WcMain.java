import java.io.*;


public class WcMain 
{

	public static void main(String[] args) throws IOException 
	{
		
		
	  
		int c=0,w=0,l = 0,o=0,s=0;
		
		String inname=null;
		String outname=null;
		
		//
		
		for(int i=0;i<args.length;i++)
		{
			if(args[i].startsWith("-"))
				
			{
				
					switch(args[i])
					{
					
					case "-c":
						c=1;
						break;
						
					case "-w":
						w=1;
						break;
							
					case "-l":
						l=1;
						break;
						
					case "-o":
						o=1;
						break;	
						
					case "-s":
						s=1;
						break;	
					}
			}
			
			
			else {
				
					
					
					 if(args[i-1].equals("-o")) outname=args[i];
					 
					 
					 else{
						 
						 if(args[i-1].equals("-c")||args[i-1].equals("-w")||args[i-1].equals("-l")) inname=args[i];
						 						 
					 }
					
				
				
		     	}
			
			
		}
		
		
		
		if(c==1){
					
					File2 ftest=new File2(inname,"=");
					System.out.println(inname+','+"字符数："+ftest.zCount());
					
				}
				
         if(w==1){
					
					File2 ftest=new File2(inname,"=");
					System.out.println(inname+','+"单词数："+ftest.ciCount());
					
				}
				
				
          if(l==1){
					
					File2 ftest=new File2(inname,"=");
					System.out.println(inname+','+"行数："+ftest.hCount());
					
				}
				
 
                
           if(o==1){
					
					File2 ftest=new File2(inname,outname);
					ftest.save();
					
				}
           
           if(s==1)
           {
				
        	    String dirname = "./";
        	    Fileop f1 = new Fileop(dirname);
        	    f1.fun(dirname);
        	    	
        	    	
        	    }
        	    
        	    
        	    
        	    
        	    
			}
				
	  
	    
		
		 
   }	

