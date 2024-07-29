package ru.afanasyev.moviematch.app.ipr.reflections;

import lombok.SneakyThrows;

import java.io.File;
import java.io.FileInputStream;

public class CustomClassLoader extends ClassLoader {
    String registryPath = "C:\\Users\\KAfanasiev\\Desktop\\Work\\ABAF2\\clients\\build\\classes\\java\\main";

    @Override
    public Class<?> findClass(String name) {
        byte[] byteCode = loadClassFromRegistry(name);
        return defineClass(name, byteCode, 0, byteCode.length);
    }

    @Override
    public String getName() {
        return "CustomClassLoader";
    }

    @SneakyThrows
    private byte[] loadClassFromRegistry(String fileName)  {
        String filePath = registryPath + File.separatorChar + fileName.replace('.', File.separatorChar) + ".class";
        File file = new File(filePath);
        try (FileInputStream inputStream = new FileInputStream(file)) {
            return inputStream.readAllBytes();
        }
    }

//    private byte[] loadClassFromFile(String fileName)  {
//        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(
//            fileName.replace('.', File.separatorChar) + ".class");
//        byte[] buffer;
//        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
//        int nextValue = 0;
//        try {
//            while ( (nextValue = inputStream.read()) != -1 ) {
//                byteStream.write(nextValue);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        buffer = byteStream.toByteArray();
//        return buffer;
//    }
}