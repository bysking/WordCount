import java.io.*;

public class WcMain 
{

	public static void main(String[] args) throws IOException 
	{	 //���Ʊ���������ѡ�����������Ϻ��ִ�в��� 
		int c=0,w=0,l = 0,o=0,s=0,a=0,e=0;	
		
		String inname=null;	//�����ļ���	
		String outname=null;//����ļ���		
		String stopname=null;//ͣ�ôʱ�
		
		//
		
		for(int i=0;i<args.length;i++)
		{
			//��������
			//System.out.println(args[i]);
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
		//����ı�����ʼ��ֵ
			
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
		
		//System.out.println(outname);
		
		if(c==1){
			        if(outname==null){
			        	
			        	 if(stopname!=null){
					        	//System.out.println(outname);
					        	File2 ftest=new File2(inname,"result.txt",stopname);
					        	System.out.println(inname+','+"�ַ�����"+ftest.efun());
					        	ftest.save(inname,1,0,0,0,0,1);
					        }
			        	 
			        	 else{
			        		 
			        		 File2 ftest=new File2(inname,"result.txt");
					        	System.out.println(inname+','+"�ַ�����"+ftest.zCount());
					        	ftest.save(inname,1,0,0,0,0,0);
					        	//ftest.save(inname,c,w,l,a,s,e);
			        	 }
			        	
			        	
			        	
			        }
			        else{ //outname!=null
			        //	System.out.println(inname);
			        	//System.out.println(outname);
			        	//System.out.println(stopname);
			        	 if(stopname!=null){
					        	
					        	File2 ftest=new File2(inname,outname,stopname);
					        	System.out.println(inname+','+"�ַ�����"+ftest.efun());
					        	ftest.save(inname,1,0,0,0,0,1);
					        }
			        	 
			        	 else{//stopname==null
			        		
			        		 File2 ftest=new File2(inname,outname);
					        	System.out.println(inname+','+"�ַ�����"+ftest.zCount());
					        	ftest.save(inname,1,0,0,0,0,0);
			        	 }
			        	
			        }
			        
			       
			       
					
					//c=0;
				}
				
         if(w==1){
					if(e==1){
						//System.out.println(inname+outname+stopname);
						if(outname==null){
							
							File2 ftest=new File2(inname,"result.txt",stopname);
							ftest.save(inname,0,1,0,0,0,1);
//							ftest.save(inname,c,w,l,0,0,e);
							System.out.println(inname+','+"ͣ�ôʱ�󵥴�����"+ftest.efun());
						}
						else {
							
							File2 ftest=new File2(inname,outname,stopname);
						System.out.println(inname+','+"ͣ�ôʱ�󵥴�����"+ftest.efun());
						ftest.save(inname,0,1,0,0,0,1);
						
					  	}
						
					
					     }
					else{
						if(outname==null){
							//System.out.println("66666666");
							File2 ftest=new File2(inname,"result.txt");
							
							System.out.println(inname+','+"��������"+ftest.ciCount());
							ftest.save(inname,0,w,0,a,s,e);
						}
						else{
							
							File2 ftest=new File2(inname,outname);
							
							System.out.println(inname+','+"��������"+ftest.ciCount());
							ftest.save(inname,0,w,0,a,s,e);
						}
					}
					
					//System.out.println("66666666");
					//w=0;	
					
				}
				
				
          if(l==1){
        	  
        	  //System.out.println(outname);
					if(outname==null){
						
						File2 ftest=new File2(inname,"result.txt");
						System.out.println(inname+','+"������"+ftest.hCount());
						ftest.save(inname,0,0,l,0,0,0);
					}
					else{
						//System.out.println("888888888888888");
						File2 ftest=new File2(inname,outname);
						System.out.println(inname+','+"������"+ftest.hCount());
						ftest.save(inname,0,0,l,0,0,0);
						
					}
					//l=0;
				}
                     
           if(s==1)
           {
        	  
        	    String dirname = "./";
        	    //System.out.println(stopname);
        	    if(e==1){        	    	
        	    	Fileop f1op = new Fileop(dirname,outname,stopname);
        	    	f1op.fun(dirname,c,w,l,0,1,e);
        	    }
        	    else{
        	    	 Fileop f1op = new Fileop(dirname,outname,"result.txt");
             	     f1op.fun(dirname,c,w,l,0,s,e);         	    	
        	     }  
        	    //s=0;
        	    }
        	    
           if(a==1){
        	  // System.out.println("23456789");
				//System.out.println(inname);
				//System.out.println(outname);
        	   if(outname==null){
        		   File2 ftest=new File2(inname,"result.txt");
   				   ftest.afun(); 
        		   
        	   }
        	   else{
        		   
        		   File2 ftest=new File2(inname,outname);
   				   ftest.afun(); 
        		   
        	   }
				
			}    

		}
				
	  
	    
	
		 
   }	

