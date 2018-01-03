package com.huawei.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class CsvImExportUtil {
	 /* ���� 
     *  
     * @param file csv�ļ�(·��+�ļ���)��csv�ļ������ڻ��Զ����� 
     * @param dataList ���� 
     * @return 
     */  
    public static boolean exportCsv(File file, List<String> dataList){  
        boolean isSucess=false;  
          
        FileOutputStream out=null;  
        OutputStreamWriter osw=null;  
        BufferedWriter bw=null;  
        try {  
//          OutputStreamWriter in_=new OutputStreamWriter(new FileOutputStream("�ļ���"), "gbk");  
            out = new FileOutputStream(file);  
            osw = new OutputStreamWriter(out, "gbk");  
            bw =new BufferedWriter(osw);  
            if(dataList!=null && !dataList.isEmpty()){  
                for(String data : dataList){  
                    bw.append(data).append("\r");  
                }  
            }  
            isSucess=true;  
        } catch (Exception e) {  
            isSucess=false;  
        }finally{  
            if(bw!=null){  
                try {  
                    bw.close();  
                    bw=null;  
                } catch (IOException e) {  
                    e.printStackTrace();  
                }   
            }  
            if(osw!=null){  
                try {  
                    osw.close();  
                    osw=null;  
                } catch (IOException e) {  
                    e.printStackTrace();  
                }   
            }  
            if(out!=null){  
                try {  
                    out.close();  
                    out=null;  
                } catch (IOException e) {  
                    e.printStackTrace();  
                }   
            }  
        }  
          
        return isSucess;  
    }  
      
    /** 
     * ���� 
     *  
     * @param file csv�ļ�(·��+�ļ�) 
     * @return 
     */  
    public static List<String> importCsv(File file){  
        List<String> dataList=new ArrayList<String>();  
          
        BufferedReader br=null;  
        try {   
            br = new BufferedReader(new FileReader(file));  
            String line = "";   
            while ((line = br.readLine()) != null) {   
                dataList.add(line);  
            }  
        }catch (Exception e) {  
        }finally{  
            if(br!=null){  
                try {  
                    br.close();  
                    br=null;  
                } catch (IOException e) {  
                    e.printStackTrace();  
                }  
            }  
        }  
   
        return dataList;  
    }  
    public static void main(String[] args) {
		File f=new File("C:\\a.csv");
		List<String>list= CsvImExportUtil.importCsv(f);
		   
		
		
	}
}  