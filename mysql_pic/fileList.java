package mysql_pic;

import java.io.*;  
import java.util.*; 
 
public class fileList { 
	

/*	private static final String scfiles() throws Exception{
		Scanner sc = new Scanner (System.in);
		String filepath = sc.next();
	    return filepath;
	}
*/  //��ȡ����̨��·��
	public static ArrayList<String> Dirfiles() throws Exception{
		//String ele;
		
		File dirFile = new File("c:/mysql");
		ArrayList<String> Dirfile  = DirAll(dirFile);
		//ele = Dirfile.get(2);
        //ele = ele.replaceAll("\\\\","/");
        //return ele;
        
        return Dirfile;
	}
	
	
	
 



	// ����һ��ȫ�ֶ�̬���飬������ļ�·��  
    // ��Ҫ�����ļ��У������������ļ��С��ļ������ʱ���õ��ݹ飬����Ҫ��������  
    public static ArrayList<String> dirAllStrArr = new ArrayList<String>();  
  
    // �����ǽ�����ѯ��ǰ·���µ������ļ��С��ļ����Ҵ����·�����ļ�����  
    // ���������ļ��в���ѯ������������ļ��С��ļ������û��Ҫ�õ��ݹ�  
    public static ArrayList<String> Dir(File dirFile) throws Exception {  
        ArrayList<String> dirStrArr = new ArrayList<String>();  
  
        if (dirFile.exists()) {  
            // ֱ��ȡ������listFiles()�ѵ�ǰ·���µ������ļ��С��ļ���ŵ�һ���ļ�����  
            File files[] = dirFile.listFiles();  
            for (File file : files) {  
                // ������ݹ����Ĳ���dirFile�����ļ��ָ�����Ҳ����/����\��β������˹���  
                if (dirFile.getPath().endsWith(File.separator)) {  
                    dirStrArr.add(dirFile.getPath() + file.getName());  
                } else {  
                    // �������û���ļ��ָ���������һ���ļ��ָ������ټ����ļ���������·��  
                    dirStrArr.add(dirFile.getPath() + File.separator  
                            + file.getName());  
                }  
            }  
        }  
        return dirStrArr;  
    }  
  
    public static ArrayList<String> DirAll(File dirFile) throws Exception {  
  
        if (dirFile.exists()) {  
            File files[] = dirFile.listFiles();  
            for (File file : files) {  
                // ��������ļ�����ݹ���á�  
                if (file.isDirectory()) {  
                    // �ݹ����  
                    DirAll(file);  
                } else {  
                    // ��������ļ������������  
                    if (dirFile.getPath().endsWith(File.separator)) {  
                        dirAllStrArr.add(dirFile.getPath() + file.getName());  
                    } else {  
                        dirAllStrArr.add(dirFile.getPath() + File.separator 
                                + file.getName());  
                    }  
                }  
            }  
        }  
          return dirAllStrArr;   
    }  
  
     public static void main(String[] args) throws Exception {  
        //File dirFile = new File("f:/aa");
        //ArrayList<String> Dirfile  = Dir(dirFile);
        //System.out.println(Dirfile);  
        //String ele;
        //ele = Dirfile.get(2);
        //ele = ele.replaceAll("\\\\","/");
    	
        //System.out.println(fileList.file());
        System.out.println(fileList.Dirfiles());
        
       // System.out.println(Dirfile(String)[0]);  
       // DirAll(dirFile);  
       //System.out.println(dirAllStrArr);  //���ļ���
       
    	
    } 


}  