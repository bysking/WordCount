import java.io.*;

public class WcMain 
{

	public static void main(String[] args) throws IOException 
	{	 //控制变量，用来选择解析参数完毕后的执行操作 
		int c=0,w=0,l = 0,o=0,s=0,a=0,e=0;	
		
		String inname=null;	//输入文件名	
		String outname=null;//输出文件名		
		String stopname=null;//停用词表
		
		//
		
		for(int i=0;i<args.length;i++)
		{
			//解析参数
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
							
						case "-a":
							a=1;
							break;	
							
						case "-e":
							e=1;
							break;	
							
						default:
								
				}		
				
		}	
		//程序的变量初始赋值
			
			else {
				if(i>0){
					
					if(args[i-1].equals("-o"))
						 outname=args[i];
					 
					 if(args[i-1].equals("-e")) 
						 stopname=args[i];
					 					 
					 if(args[i-1].equals("-s")||args[i-1].equals("-c")||args[i-1].equals("-w")||args[i-1].equals("-l")||args[i-1].equals("-a")) 
						 inname=args[i];
					
					
				}
				
				else inname=args[i];	 							 
				    	
		     	}
			 
			
		}
		
		
		
		if(c==1){
			        if(outname==null){
			        	
			        	File2 ftest=new File2(inname,"result.txt");
			        	System.out.println(inname+','+"字符数："+ftest.zCount());
			        	ftest.save(inname,c,w,l,a,s,e);
			        }
			        else{
			        	//System.out.println(outname);
			        	File2 ftest=new File2(inname,outname);
			        	System.out.println(inname+','+"字符数："+ftest.zCount());
			        	ftest.save(inname,c,w,l,a,s,e);
			        }
					
					c=0;
				}
				
         if(w==1){
					if(e==1){
						//System.out.println(inname+outname+stopname);
						if(outname==null){
							
							File2 ftest=new File2(inname,"result.txt",stopname);
							ftest.save(inname,c,w,l,a,s,e);
							System.out.println(inname+','+"停用词表后单词数："+ftest.efun());
						}
						else {
							File2 ftest=new File2(inname,outname,stopname);
						System.out.println(inname+','+"停用词表后单词数："+ftest.efun());
						ftest.save(inname,c,w,l,a,s,e);
						
					  	}
						
					e=0;
					     }
					else{
						
						File2 ftest=new File2(inname,"result.txt");
						
						System.out.println(inname+','+"单词数："+ftest.ciCount());
						ftest.save(inname,c,w,l,a,s,e);
					}
					w=0;	
					
				}
				
				
          if(l==1){//System.out.println(outname);
					if(outname==null){
						
						File2 ftest=new File2(inname,"result.txt");
						System.out.println(inname+','+"行数："+ftest.hCount());
						ftest.save(inname,c,w,l,a,s,e);
					}
					else{
						
						File2 ftest=new File2(inname,outname);
						System.out.println(inname+','+"行数："+ftest.hCount());
						ftest.save(inname,c,w,l,a,s,e);
						
					}
					l=0;
				}
             
           if(o==1){
					//System.out.println(outname);
        	   if(e==1){
        		   
        		   //System.out.println(inname+outname+stopname);
        		   File2 ftest=new File2(inname,outname,stopname);
			
        		   ftest.save(inname,c,w,l,a,s,e);
        		  e=0; 
        	   }
        	   else{
        		   
        		   File2 ftest=new File2(inname,outname);
        		  // System.out.println(inname);
				   ftest.save(inname,c,w,l,a,s,e);
					
        		   
        	   }
					o=0;
			}
           
           if(s==1)
           {
        	    String dirname = "./";
        	    //System.out.println(stopname);
        	    if(e==1){
        	    	
        	    	Fileop f1op = new Fileop(dirname,outname,stopname);
        	    	f1op.fun(dirname,c,w,l,a,s,e);
        	    }
        	    Fileop f1op = new Fileop(dirname,outname,"result.txt");
        	    f1op.fun(dirname,c,w,l,a,s,e);      	    	
        	    }
        	    
           if(a==1&&(outname!=null)){
				//System.out.println(inname);
				//System.out.println(outname);
				File2 ftest=new File2(inname,outname);
				ftest.afun();
				
			}    
        	  /*  
           if(e==1){
        		System.out.println(inname+outname+stopname);
				File2 ftest=new File2(inname,outname,stopname);
			
				System.out.println(inname+','+"停用词表单词数："+ftest.efun());
				
			}    
        	    */
			}
				
	  
	    
	
		 
   }	

