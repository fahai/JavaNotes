package org.fahai.app;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
/**   
 * @Title: FileRepeat.java 
 * @Package org.fahai.app 
 * @Description: ������Ŀ¼ȥ���ظ��ļ������ӡ����ظ��ļ��б������ļ���MD5�������ļ����ļ����Ƿ���ͬ��
 * <br>
 * ɾ���ظ����ļ������ȱ���·����̵��Ǹ��ļ���
 * <br>
 * ������һ�������������Ҫ�ظ����ڵ�������á�
 * <br>
 * <br>���ӣ�</b>
 * <br>
 * 1��Ĭ��ֻ��ӡ����ظ��ļ��б���ɾ���ظ��ļ����磺C:\\>java com.goofus.tool.FileRepeat D:\\test\\aa
 * <br>
 * ��C:\\>java com.goofus.tool.FileRepeat D:\\test\\aa -m:list
 * <br>
 * 2��ɾ���ظ��ļ����磺C:\\>java com.goofus.tool.FileRepeat D:\\test\\aa -m:clear
 * <br>
 * @author fahai  
 * @date 2014-7-22 ����03:54:42 
 * @version V1.0   
 */
public class FileRepeat {
    
    //�ļ�ʵ����ΪKEY���ļ�MD5ֵ��ΪVALUE
    private final static Map<File, String> FILE_MD5_MAP = new HashMap<File, String>();
    //�ظ��ļ��Ĵ������ļ�MD5ֵ��ΪKEY���ظ��ļ����б���ΪVALUE
    private final static Map<String, List<File>> FILE_REPEATED_MAP = new HashMap<String, List<File>>();
    //ģʽ��Ĭ������ظ��ļ��б�
    private static String HANDLE_MODE = "list";
 
    /**
     * @param args
     */
    public static void main(String[] args) {
        long s = System.currentTimeMillis();
         
        if(null == args || args.length < 1) {
            System.out.println("������ȷ�Ĳ������磺C:\\>java FileRepeat D:\\test\\aa");
            System.exit(-1);
        }
         
        String filePath = args[0];
        File dir = new File(filePath);
        if(!dir.isDirectory() || !dir.exists()) {
            System.out.println("������ȷ��Ŀ¼");
            System.exit(-1);
        }
         
        String args1 = args.length > 1 ? args[1] : null;
        if(null != args1) {
            if(args1.startsWith("-m:")) {
                String mode = args1.replaceAll("-m:", "");
                if(null == mode || ("list".equalsIgnoreCase(mode) && !"clear".equalsIgnoreCase(mode))){
                    System.out.println("-m:��ѡ�list��clear");
                    System.exit(-1);
                }
                HANDLE_MODE = mode;
            }else {
                System.out.println("������ȷ�Ĳ������磺C:\\>java com.goofus.tool.FileRepeat D:\\test\\aa -m:clear");
                System.exit(-1);
            }
        }
         
        int tally = 0;
        computeFileMd5(dir);
        handleRepeat();
        tally = deleteForRepeat();
         
        //��ӡ����ظ��ļ��б�
        if("list".equalsIgnoreCase(HANDLE_MODE)){
            Set<Entry<String, List<File>>> rSet = FILE_REPEATED_MAP.entrySet();
            for(Iterator<Entry<String, List<File>>> it = rSet.iterator(); it.hasNext();){
                Entry<String, List<File>> entry = it.next();
                String key = entry.getKey();
                List<File> files = entry.getValue();
                if(null != files && files.size() > 0){
                    StringBuffer fPath = new StringBuffer();
                    for(int a=0,al=files.size(); a<al; a++){
                        File f = files.get(a);
                        if(a > 0) fPath.append(",");
                        fPath.append(f.getAbsolutePath());
                    }
                    System.out.println("MD5ֵΪ��" + key + " ���ظ��ļ���" + fPath);
                }
            }
        }else if(tally < 1){
            System.out.println("û���ظ����ļ���");
        }
 
        System.out.println("ɾ����" + tally + "���ظ��ļ�����ʱ��" + (System.currentTimeMillis() - s) + "���롣");
 
    }
     
    private static void computeFileMd5(File dir){
        if(null == dir) return ;
        File[] files = dir.listFiles();
        if(null != files && files.length > 0){
            for(File f : files){
                if(f.isDirectory()){
                    computeFileMd5(f);
                }else{
                    FILE_MD5_MAP.put(f, getMd5ForFile(f));
                }
            }
        }
    }
     
    private static void handleRepeat(){
        if(FILE_MD5_MAP.size() < 2) return ;
         
        Set<Entry<File, String>> set = FILE_MD5_MAP.entrySet();
        for(Iterator<Entry<File, String>> it = set.iterator(); it.hasNext();){
            Entry<File, String> entry = it.next();
            if(FILE_REPEATED_MAP.containsKey(entry.getValue())){
                //�ļ���MD5ֵ�Ѿ���ΪKEY�������ظ��Ĵ����У�����Ϊ���ļ������ظ���ֱ�Ӽ����ظ��Ĵ���
                addToRepeatedMap(entry);
            }else{
                //���򣬵����Ƚ��Ƿ�����ظ��ļ�
                for(Iterator<Entry<File, String>> it2 = set.iterator(); it2.hasNext();){
                    Entry<File, String> entry2 = it2.next();
                    if(!entry.getKey().equals(entry2.getKey()) && entry.getValue().equals(entry2.getValue())){
                        //�����ظ����ļ����ȼ��뼯�ϣ��ȴ���һ������
                        if(FILE_REPEATED_MAP.containsKey(entry.getValue())){
                            addToRepeatedMap(entry);
                        }else{
                            List<File> value = new ArrayList<File>();
                            value.add(entry.getKey());
                            FILE_REPEATED_MAP.put(entry.getValue(), value);
                        }
                        break;
                    }
                }
            }
        }
    }
     
    private static int deleteForRepeat(){
        int c = 0;
             
        //ȥ�أ�������һ��
        if(FILE_REPEATED_MAP.size() > 0 && "clear".equalsIgnoreCase(HANDLE_MODE)){
            Set<Entry<String, List<File>>> rSet = FILE_REPEATED_MAP.entrySet();
            for(Iterator<Entry<String, List<File>>> it = rSet.iterator(); it.hasNext();){
                Entry<String, List<File>> entry = it.next();
                String key = entry.getKey();
                List<File> files = entry.getValue();
                if(null != files && files.size() > 0){
                    System.out.println("������������MD5ֵΪ��" + key + " ���ظ��ļ�֮һ��" + files.get(0).getAbsolutePath());
                    for(int a=1,al=files.size(); a<al; a++){
                        File f = files.get(a);
                        String fPath = f.getAbsolutePath();
                        boolean success = f.delete();
                        if(success) {
                            c++;
                            System.out.println("���ɹ���ɾ��MD5ֵΪ��" + key + " ���ظ��ļ�֮һ��" + fPath);
                        }else{
                            System.out.println("��ʧ�ܡ�ɾ��MD5ֵΪ��" + key + " ���ظ��ļ�֮һ��" + fPath);
                        }
                    }
                }
            }
        }
         
        return c;
    }
 
    private static void addToRepeatedMap(Entry<File, String> entry) {
        int depth = computeDepth(entry.getKey());
        if(depth < computeDepth(FILE_REPEATED_MAP.get(entry.getValue()).get(0))){
            //·����̷��ڵ�1����ȥ��ʱ��������
            FILE_REPEATED_MAP.get(entry.getValue()).add(0, entry.getKey());
        }else{
            FILE_REPEATED_MAP.get(entry.getValue()).add(entry.getKey());
        }
    }
     
    private static int computeDepth(File f){
        String path = convertPath(f.getAbsolutePath());
        String[] paths = path.split("/");
        if(null != paths) return paths.length;
        else return 999;
    }
     
    private static String convertPath(String path) {
        if(null != path)
            return path.replaceAll("\\\\", "/");
        else return "";
    }
     
    /**
     * �����ļ���MD5ֵ
     * @param f �ļ�
     * @return MD5ֵ
     */
    private static String getMd5ForFile(File f) {
        String rtn = "";
        if(null == f || f.isDirectory() || !f.exists()) return rtn;
        FileInputStream fis = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            fis = new FileInputStream(f);
            byte[] buffer = new byte[8192];
            int length;
            while ((length = fis.read(buffer)) != -1) {
                md.update(buffer, 0, length);
            }
             
            BigInteger bi = new BigInteger(1, md.digest());
            rtn = bi.toString(16);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return rtn;
    }
     
}