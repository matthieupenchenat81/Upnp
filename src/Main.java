import java.io.*;

/**
 * Created by sidya on 07/01/15.
 */
public class Main {

    public static void writeOutputInFile(String fileName, String output) {

        try {
            PrintWriter fw = new PrintWriter(fileName, "UTF-8");
            fw.println(output);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main (String[] args){

        String fileName = "description";
        String balise = "serviceId";
        String url = "http://172.31.190.168:56552/";
        Description.description(url, fileName);
        //System.out.print(new Parser().getContentTag(fileName, balise));

        //System.out.println(new Service(fileName,"ContentDirectory",url).getUrlSCPD());
        //System.out.println(new Service(fileName, "ContentDirectory", url).getActions());
        //System.out.println(new Service(fileName, "ContentDirectory", url).getUrlControle());

        Browse B = new Browse();
        String browse = B.ActionBrowse("0", "*", "", "http://172.31.190.168:56552", "_urn:schemas-upnp-org:service:ContentDirectory_control").toString();

        Search S = new Search();
        String search = S.ActionSearch("0000000000000005", "", "*", "", "http://172.31.190.168:56552", "_urn‐schemas‐upnp‐org‐service‐ContentDirectory_control").toString();
        //String ContainerID,String SearchCriteria,String Filter,String SortCriteria,String IP,String controlURL

        writeOutputInFile("soapBrowse", browse);
        writeOutputInFile("soapSearch", search);
    }
}
