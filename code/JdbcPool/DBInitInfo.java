package JdbcPool;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
/**
 * Created by john on 2016/11/2.
 * @author zzy
 */
class DBInitInfo {
    static DBbean dBbean;
    static {
        dBbean = new DBbean();
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse("database_information.xml");
            //get the all document who name is person
            NodeList nl = doc.getElementsByTagName("database");
            int size= nl.getLength();
            for (int i = 0; i < size; i++) {
                Node n = nl.item(i);
                //get the all document which is n child document¡£ take notice£¬
                // all the enter will regard the n's child document
                NodeList nl2 = n.getChildNodes();
                int size2 = nl2.getLength();
                for (int j = 0; j < size2; j++) {
                    Node n2 = nl2.item(j);
                    //all the enter will regard the n's child document£¬so hasChildNodes
                    if (n2.hasChildNodes()) {
                        if (n2.getNodeName().equals("drivername")) {
                            dBbean.setDriverName(n2.getFirstChild().getNodeValue());
                        } else if (n2.getNodeName().equals("url")) {
                            dBbean.setUrl(n2.getFirstChild().getNodeValue());
                        } else if (n2.getNodeName().equals("user")) {
                            dBbean.setUserName(n2.getFirstChild().getNodeValue());
                        } else if (n2.getNodeName().equals("poolname")) {
                            dBbean.setPoolName(n2.getFirstChild().getNodeValue());
                        } else if (n2.getNodeName().equals("minConnection")) {
                            dBbean.setMinConnections(Integer.parseInt(n2.getFirstChild().getNodeValue()));
                        } else if(n2.getNodeName().equals("maxConnection")){
                            dBbean.setMaxConnections(Integer.parseInt(n2.getFirstChild().getNodeValue()));
                        } else if(n2.getNodeName().equals("maxConnection")){
                            dBbean.setInitConnections(Integer.parseInt(n2.getFirstChild().getNodeValue()));
                        }else if(n2.getNodeName().equals("password")){
                            dBbean.setInitConnections(Integer.parseInt(n2.getFirstChild().getNodeValue()));
                        }
                    }
                }
            }
        } catch (Exception e){//be lazy!
            e.printStackTrace();
        }
    }
}
