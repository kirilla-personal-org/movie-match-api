package ru.afanasyev.moviematch.app.ipr.xml;

import lombok.Getter;
import lombok.SneakyThrows;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Sax {
    /**
     * SAX (Simple API for XML) — ТЕОРИЯ
     *
     * SAX-обработчик устроен так, что он просто считывает последовательно XML файлы и реагирует на разные события,
     * после чего передает информацию специальному обработчику событий.
     *
     * У него есть немало событий, однако самые частые и полезные следующие:
     * startDocument — начало документа
     * endDocument — конец документа
     * startElement — открытие элемента
     * endElement — закрытие элемента
     * characters — текстовая информация внутри элементов.
     *
     * Все события обрабатываются в обработчике событий, который нужно создать и переопределить методы.
     *
     * <b>Преимущества</b>: высокая производительность благодаря "прямому" способу считывания данных, низкие затраты памяти.
     * <b>Недостатки</b>: ограниченная функциональность, а, значит, в нелинейных задачах дорабатывать её надо будет уже нам.
     */
    @SneakyThrows
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        File f = new File("src/main/resources/xml/employees.xml");
        XMLHandler xmlHandler = new XMLHandler();
        parser.parse(f, xmlHandler);
        xmlHandler.getJobs().forEach(System.out::println);
        System.out.println(xmlHandler.stringBuilder.toString());
    }

    // ===================================================================================================================
    // = Implementation
    // ===================================================================================================================

    private static class XMLHandler extends DefaultHandler {
        @Getter
        private List<String> jobs = new ArrayList<>();
        @Getter
        private StringBuilder stringBuilder = new StringBuilder();

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("employee")) {
                String job = attributes.getValue("job");
                jobs.add(job);
            }
        }
    }
}
