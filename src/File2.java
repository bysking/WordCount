import java.io.*;
import java.util.ArrayList;
import java.util.regex.Pattern;

//方法类
public class File2 {
	private String fileName;
	private  String outfileName;
	private  String stopfileName;
	
	static  ArrayList<String>sl=new ArrayList<String>();
	static  ArrayList<String>sl2=new ArrayList<String>();
	
	
	
	
	
	
	
	// 构造方法，传入两个数组，s1:读取的文件名，s2：存储的文件名
	public File2(String ss1, String ss2) {
     //System.out.println(ss1);
		this.fileName = ss1;
		this.outfileName = ss2;

	}

	public File2(String s1, String s2, String s3) {

		this.fileName = s1;
		this.outfileName = s2;
		this.stopfileName = s3;

	}

	// 计算字符数
	public int zCount() throws IOException {
		int z = 0, z2 = 0;
		StringBuilder sb = new StringBuilder();
//		
//		File f2 = new File(fileName); // 读取文件
//		InputStreamReader reader = new InputStreamReader(new FileInputStream(f2)); // 建立一个输入流对象reader
//		BufferedReader br = new BufferedReader(reader); //
//		System.out.println(fileName);
		
		BufferedReader br = new BufferedReader(new FileReader(fileName));

		String s = "";
		while ((s = br.readLine()) != null) {
			sb.append(s + "\n");
			z2++;
			z += s.length();
			s = "";
		}

		br.close();

		// System.out.println(z+z2);
		return z + z2 - 1;

	}

	// 计算单词数
	public int ciCount() throws IOException {
		StringBuilder sb = new StringBuilder();
		String s = "";
		BufferedReader br = new BufferedReader(new FileReader(fileName));

		while ((s = br.readLine()) != null) {
			sb.append(s + "\n");
		}
		br.close();
		String str = sb.toString();
		char c[] = str.toCharArray();

		// Pattern pat = Pattern.compile("[`~!@#$^&*()=|{}':;',\\[\\].
		// <>/?~！@#￥……&*（）——|{}【】‘；：”“'。，、？]$");
		int count = 0;		
		boolean prevIsDelim = true;
		boolean currIsDelim;//分割符
		for (int i = 0; i < c.length; i++)
		{
				if ((c[i] != ' ') && (c[i] != '\n')&& (c[i] != ',') &&(c[i] != '=')&&(c[i] != '.')&&(c[i] != '(')&&(c[i] != ')')&&(c[i] != ' ')&&(c[i] != '{')&&(c[i] != '}')&&(c[i] != '\t')&&(c[i] != '\n')&&(c[i] != '/')&&(c[i] != '*')&&(c[i] != ';')&&(c[i] != '"')&&(c[i] != ' '))			
					currIsDelim = false;
				else
					currIsDelim = true;
				
				if (currIsDelim) {
					if (prevIsDelim)
						prevIsDelim=true;	//两个逗号					
					else {					
							count++;        //5，
							prevIsDelim=true;
					}					
				}
				else if(!currIsDelim){
					
					if (prevIsDelim)        //，5
						prevIsDelim=false;
					else {                   //55
					
							prevIsDelim=false;
					}
					
				}
		}
		return count;

	}

	// 计算行数
	public int hCount() throws IOException {
		int h = 0;// line count flag
		File f2 = new File(fileName); // 读取文件
		InputStreamReader reader = new InputStreamReader(new FileInputStream(f2)); // 建立一个输入流对象reader
		BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
		String line = "";
		line = br.readLine();
		h = h + 1;
		while (line != null) {
			line = br.readLine(); // 一次读入一行数据
			h++;
		}br.close();
		return h - 1;// 校正

	}

	// 结果存为文件
	public boolean save(String name,int c,int w,int l,int a,int s,int e) throws IOException {
		this.fileName=name;
		int efunnum=0;
		//System.out.println(outfileName);
		//File2 f3 = new File2(name,outfileName,"=");
		
		File writename = new File(outfileName);
		 
	       if (!writename.exists())
	       {	       
	    	   writename.createNewFile();
	       }
		//File writename = new File(outfileName); // 相对路径，如果没有则要建立一个新的output。txt文件
		writename.createNewFile(); // 创建新文件
		BufferedWriter out = new BufferedWriter(new FileWriter(writename,true));	
		
		if(e==1){
			//System.out.println("kaishichuli");
			if(c==1)out.write(name+",字符数:"+Integer.toString(zCount()) + "\r\n"); // \r\n即为换行
			if(w==1){
				      efunnum=efun();
				out.write(name+",停用词表单词数:"+Integer.toString(efunnum) + "\r\n");
				
			}
			if(l==1)out.write(name+",行数:"+Integer.toString(hCount()) + "\r\n");
			if(a==1)afun();
			if(s==1){
				
				out.write(name+",字符数:"+Integer.toString(zCount()) + "\r\n");
				out.write(name+",单词数:"+Integer.toString(efun()) + "\r\n");
				out.write(name+",行数:"+Integer.toString(hCount()) + "\r\n");
			}
			
		}
		else{
			//System.out.println("kaishichuli");
			if(c==1)out.write(name+",字符数:"+Integer.toString(zCount()) + "\r\n"); // \r\n即为换行
			if(w==1)out.write(name+",单词数:"+Integer.toString(ciCount()) + "\r\n");
			
			if(l==1)
				out.write(name+",行数:"+Integer.toString(hCount()) + "\r\n");
			
		
			if(a==1) afun();
			
			if(s==1){
				out.write(name+",字符数:"+Integer.toString(zCount()) + "\r\n");
				out.write(name+",单词数:"+Integer.toString(ciCount()) + "\r\n");
				out.write(name+",行数:"+Integer.toString(hCount()) + "\r\n");
			}
			
		}
			//out.write(this.fileName+",代码行/空行/注释行:"+Integer.toString(ciCount()) + "\r\n");
		//if(e==1)out.write(this.fileName+",行数:"+Integer.toString(hCount()) + "\r\n");
		
		
		
		out.flush(); // 把缓存区内容压入文件
		out.close(); // 最后记得关闭文件
		return true;

	}

	public void afun() throws IOException {
		// TODO Auto-generated method stub
		int daima = 0, zhushi = 0, kong = 0;
		
		File f = new File(fileName);
		 
	       if (!f.exists())
	       {	       
	    	   f.createNewFile();
	       }
		// 建立一个输入流对象reader
		InputStreamReader reader = new InputStreamReader(new FileInputStream(f));
		// 建立一个对象，它把文件内容转成计算机能读懂的语言
		BufferedReader br = new BufferedReader(reader);
		String line = "";

		while ((line = br.readLine()) != null) {

			String pattern = ".*\\s*//.*";
			boolean isMatch = Pattern.matches(pattern, line);
			if (isMatch)
				zhushi++;
			String pattern2 = "\\s*\\t*";
			boolean isMatch2 = Pattern.matches(pattern2, line);
			if (isMatch2 || line.length() == 1)
				kong++;

		}br.close();
		//System.out.println(outfileName);
		
		File writename = new File(outfileName); // 相对路径，如果没有则要建立一个新的output。txt文件
		writename.createNewFile(); // 创建新文件
		BufferedWriter out = new BufferedWriter(new FileWriter(writename,true));
		out.write(this.fileName+",代码行/空行/注释行:"+Integer.toString(daima)+"/" +Integer.toString(zhushi)+"/"+Integer.toString(kong)+ "\r\n");
		System.out.println(fileName+",代码行/注释行/空行:" + (daima) + "/" + zhushi + "/" + (kong));
		out.flush(); // 把缓存区内容压入文件
		out.close();
	}
	
	public int efun() throws IOException 
	
	{
		//---------------------------
		String str2 = "";
		String tmp;
		//System.out.println(stopfileName);
		BufferedReader br2 = new BufferedReader(new FileReader(stopfileName));
		while ((tmp = br2.readLine()) != null) {
			str2+=tmp+' ';
		}
		br2.close();
		char ch;
		String word="";
		for(int i=0;i<str2.length();i++){
			ch=str2.charAt(i);
			if(ch!=' '&&ch!=',')
				word+=ch;
			else if(!word.isEmpty()){
				sl.add(word);
				word="";
			}
		}
//----------------------------
		String str21 = "";
		String tmp1;
		BufferedReader br21 = new BufferedReader(new FileReader(fileName));
		while ((tmp1 = br21.readLine()) != null) {
			str21+=tmp1+' ';
		}
		br21.close();
		char ch1;
		String word1="";
		for(int i=0;i<str21.length();i++){
			ch1=str21.charAt(i);
			if(ch1!='"'&&ch1!='"'&&ch1!=' '&&(ch1!='(')&&(ch1!=')')&&(ch1!='{')&&(ch1!='}')&&(ch1!=',')&&(ch1!=';')&&(ch1!='\t')&&(ch1!='\n')&&(ch1!='/')&&(ch1!='*')&&(ch1!='=')&&(ch1!='.'))
				word1+=ch1;
			else if(!word1.isEmpty()){
				sl2.add(word1);
				word1="";
			}
		}
		// Pattern pat = Pattern.compile("[`~!@#$^&*()=|{}':;',\\[\\].
		// <>/?~！@#￥……&*（）——|{}【】‘；：”“'。，、？]$");
		int count = 0;		
		/*
		System.out.println("被检查表sl2");
		for (int i = 0; i < sl2.size(); i++)
		{
			System.out.println(sl2.get(i));
			
		}
		
		System.out.println("停表sl1");
		for (int j = 0; j < sl.size(); j++)
		{
			System.out.println(sl.get(j));
			
		}
		*/
		System.out.println("相同字符");
		
		for (int i = 0; i < sl2.size(); i++)
		{
			for (int j = 0; j < sl.size(); j++)
			{
				
				if(sl2.get(i).matches(sl.get(j)))
				{
					System.out.println(sl2.get(i));
					count++;					
				}
					
			}
			
		}
		System.out.println("使用停表后的单词数："+(sl2.size()-count));
		return sl2.size()-count;
	}
	
	
}