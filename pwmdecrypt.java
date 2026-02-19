import password.pwm.error.PwmUnrecoverableException;
import password.pwm.util.secure.PwmBlockAlgorithm;
import password.pwm.util.secure.PwmSecurityKey;
import password.pwm.util.secure.SecureEngine;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class pwmdecrypt {
	public static void main(String[] args) {
		try{
			//expect just a filename
			if (args.length != 1) {
				System.out.println("usage: pwmdecrypt <pwmConfiguration.xml file>");
			}
			else {
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				DocumentBuilder builder = factory.newDocumentBuilder();
				Document doc = builder.parse(new File(args[0]));
				doc.getDocumentElement().normalize();
				Node node = doc.getElementsByTagName("PwmConfiguration").item(0);
				Element element = (Element) node;
				String createTime = element.getAttribute("createTime");
				String key = createTime + "StoredConfiguration";
				NodeList settings = doc.getElementsByTagName("setting");
				for (int i = 0; i < settings.getLength(); i++) {
					Element setting = (Element) settings.item(i);
					if (setting.getAttribute("syntax").toString().equals("PASSWORD")) {
						String settingName = setting.getAttribute("key");
						NodeList values = setting.getElementsByTagName("value");
						if (values.getLength() > 0) {
							String encValue = values.item(0).getTextContent();
							if (encValue.startsWith("ENC-PW:")) {
								String encString = encValue.substring(7);
								String clearText = SecureEngine.decryptStringValue(encString, new PwmSecurityKey(key), PwmBlockAlgorithm.CONFIG);
								System.out.println(settingName + ":" + clearText);
							}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
