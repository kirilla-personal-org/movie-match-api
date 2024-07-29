package ru.afanasyev.moviematch.app.ipr.xml.jaxb;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import ru.afanasyev.moviematch.app.ipr.xml.jaxb.domain.Box;
import ru.afanasyev.moviematch.app.ipr.xml.jaxb.domain.Container;
import ru.afanasyev.moviematch.app.ipr.xml.jaxb.domain.CuteBox;
import ru.afanasyev.moviematch.app.ipr.xml.jaxb.domain.CuteBoxType;
import ru.afanasyev.moviematch.app.ipr.xml.jaxb.domain.ImagedBox;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.UUID;

public class JaxbSerialization {
    public static void main(String[] args) throws JAXBException {
        Container container = new Container();
        container.id = UUID.randomUUID().toString();
        container.addBox(createImageBox());
        container.addBox(createCuteBox());

        //писать результат сериализации будем в Writer(StringWriter)
        StringWriter writer = new StringWriter();

        //создание объекта Marshaller, который выполняет сериализацию
        JAXBContext context = JAXBContext.newInstance(Container.class, CuteBox.class, ImagedBox.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        // сама сериализация
        marshaller.marshal(container, writer);

        //преобразовываем в строку все записанное в StringWriter
        String result = writer.toString();
        System.out.println(result);
    }

    private static Box createCuteBox() {
        CuteBox cuteBox = new CuteBox(1, CuteBoxType.CATS);
        cuteBox.size = 5;
        return cuteBox;
    }

    private static ImagedBox createImageBox() {
        ImagedBox imagedBox = new ImagedBox("image1");
        imagedBox.size = 10;
        return imagedBox;
    }
}
