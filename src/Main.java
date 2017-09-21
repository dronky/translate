import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, UnsupportedFlavorException {
        Property prop = new Property();
        String clp = Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor).toString();
        String translated = Translator.translate("ru", clp,prop.getAPI_KEY());
        FileWrite fw = new FileWrite(prop.getFILE_PATH());
        if (!clp.isEmpty() && !translated.isEmpty() && !clp.equals(translated)) {
            if (prop.isWRITE_TO_FILE())
                if (prop.isWRITE_SENTENCE() && clp.split(" ").length > 1)
                    fw.write(clp, translated);
                else if (clp.split(" ").length == 1)
                    fw.write(clp, translated);
            System.out.println(clp + "=" + translated);
        } else System.out.println("Can't translate");
    }
}
