package com.careerit.iplstats.pdf;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.SneakyThrows;
import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.xmlgraphics.util.MimeConstants;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.stereotype.Component;

import javax.xml.transform.*;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

@Component
public class PdfService {


    @SneakyThrows
    public File generatePdf(Map<String,Object> data, String xslFilePath, String rootElement, String fileName) {
        String xmlString = getXmlString(data,rootElement);
        File xsltFile = new File(this.getClass().getClassLoader().getResource(xslFilePath).getFile());

        File pdfFile = File.createTempFile(fileName+"_"+System.currentTimeMillis(), ".pdf");
        FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());
        FOUserAgent foUserAgent = fopFactory.newFOUserAgent();

        try (OutputStream out = new FileOutputStream(pdfFile)) {
            Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, out);

            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(new StreamSource(xsltFile));

            Source src = new StreamSource(new ByteArrayInputStream(xmlString.getBytes()));
            Result res = new SAXResult(fop.getDefaultHandler());

            transformer.transform(src, res);
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }
        return pdfFile;
    }
    
    public String getXmlString(Map<String, Object> data, String rootElement) {
        JSONObject jsonObject = new JSONObject(data);
        XmlMapper xmlMapper = new XmlMapper();
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<"+rootElement+">"
                + XML.toString(jsonObject)+"</"+rootElement+">";
       
    }
}
