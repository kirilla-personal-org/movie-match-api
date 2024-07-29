package ru.afanasyev.moviematch.app.ipr.xml.jaxb;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import ru.afanasyev.moviematch.app.ipr.xml.jaxb.domain.Box;
import ru.afanasyev.moviematch.app.ipr.xml.jaxb.domain.Container;
import ru.afanasyev.moviematch.app.ipr.xml.jaxb.domain.CuteBox;
import ru.afanasyev.moviematch.app.ipr.xml.jaxb.domain.CuteBoxType;
import ru.afanasyev.moviematch.app.ipr.xml.jaxb.domain.ImagedBox;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.UUID;

public class JaxbDeserialization {
    static String data = """
        <container id="b8e9dc01-117c-4f1e-8138-fd96c1a0cfdb">
            <box-list>
                <imagedBox s="10">
                    <imageCode>image1</imageCode>
                </imagedBox>
                <cuteBox type="Kotiki" s="5">
                    <cuteAmount>1</cuteAmount>
                </cuteBox>
            </box-list>
        </container>
        """;

    public static void main(String[] args) throws JAXBException {
        StringReader reader = new StringReader(data);

        JAXBContext context = JAXBContext.newInstance(Container.class, CuteBox.class, ImagedBox.class, Box.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        Container container = (Container) unmarshaller.unmarshal(reader);
    }
}
