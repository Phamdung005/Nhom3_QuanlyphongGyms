package com.mycompany.nhom3_quanlyphonggyms.utils;

import java.io.File;
import java.io.InputStream; // Thêm import này
import java.io.OutputStream; // Thêm import này nếu cần cho ghi file
import java.io.FileOutputStream; // Thêm import này nếu cần cho ghi file

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

public class FileUtils {

    /**
     * Chuyển đổi đối tượng object về định dạng XML
     * Sau đó lưu vào fileName (luôn là file trên hệ thống)
     *
     * @param fileName Đường dẫn (tương đối hoặc tuyệt đối) của file trên hệ thống
     * @param object Đối tượng cần ghi
     */
    public static void writeXMLtoFile(String fileName, Object object) {
        // Phương thức này dùng để ghi file, nên nó LUÔN LUÔN ghi ra một file vật lý trên hệ thống.
        // Điều này là hợp lý, vì bạn không thể ghi ngược vào trong một JAR đã được đóng gói.
        // Khi chạy ứng dụng đóng gói, file sẽ được ghi vào thư mục nơi JAR đang chạy,
        // hoặc đường dẫn tuyệt đối mà bạn chỉ định.
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            File xmlFile = new File(fileName);

            // Đảm bảo thư mục cha tồn tại nếu đường dẫn có thư mục con
            File parentDir = xmlFile.getParentFile();
            if (parentDir != null && !parentDir.exists()) {
                parentDir.mkdirs(); // Tạo các thư mục cha nếu chúng chưa tồn tại
            }

            jaxbMarshaller.marshal(object, xmlFile);
            System.out.println("Đã ghi thành công file: " + xmlFile.getAbsolutePath());

        } catch (JAXBException e) {
            System.err.println("Lỗi khi ghi file XML: " + fileName);
            e.printStackTrace();
        }
    }

    /**
     * Đọc nội dung fileName, sau đó chuyển đổi nội dung của file
     * thành đối tượng có kiểu là clazz.
     * Phương thức này sẽ ưu tiên đọc từ classpath (bên trong JAR) trước,
     * sau đó mới thử đọc từ file hệ thống (bên ngoài JAR).
     *
     * @param fileName Tên file (nếu từ classpath) hoặc đường dẫn file (nếu từ hệ thống)
     * @param clazz Kiểu dữ liệu của đối tượng muốn đọc
     * @return Đối tượng đã được đọc, hoặc null nếu không tìm thấy/lỗi
     */
    public static Object readXMLFile(String fileName, Class<?> clazz) {
        InputStream is = null;
        Object object = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            // THỬ ĐỌC TỪ CLASSPATH TRƯỚC (khi file nằm trong src/main/resources và được đóng gói vào JAR)
            is = FileUtils.class.getClassLoader().getResourceAsStream(fileName);

            if (is != null) {
                // Đã tìm thấy file trong classpath
                System.out.println("Đã tìm thấy file " + fileName + " trên classpath. Đang đọc...");
                object = jaxbUnmarshaller.unmarshal(is);
            } else {
                // KHÔNG tìm thấy file trên classpath, thử đọc từ hệ thống file (bên ngoài JAR)
                System.out.println("Không tìm thấy file " + fileName + " trên classpath. Đang thử đọc từ hệ thống file...");
                File xmlFile = new File(fileName);
                if (xmlFile.exists()) {
                    object = jaxbUnmarshaller.unmarshal(xmlFile);
                    System.out.println("Đã đọc thành công file " + xmlFile.getAbsolutePath() + " từ hệ thống file.");
                } else {
                    System.err.println("Lỗi: File không tồn tại cả trên classpath lẫn hệ thống file: " + fileName);
                    return null; // Trả về null nếu không tìm thấy ở cả hai nơi
                }
            }
        } catch (JAXBException e) {
            System.err.println("Lỗi JAXB khi đọc file " + fileName + ": " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (java.io.IOException ex) {
                    System.err.println("Lỗi khi đóng InputStream: " + ex.getMessage());
                }
            }
        }
        return object;
    }
}