import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;

public class TungXucXac {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("36.50.135.242", 2207);

        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();

        // a. Gửi mã sinh viên (chuyển chuỗi thành mảng byte thô)
        // Lưu ý: writeUTF của DataStream tự động thêm 2 byte độ dài ở đầu, 
        // trong khi getBytes() thì không. Tùy server có thể báo lỗi đoạn này.
        String ma = "B23DCCN056;PpWEQ6F0";
        out.write(ma.getBytes());
        out.flush();

        // b. Nhận số nguyên n (Đọc 4 byte và chuyển thành int)
        byte[] intBuffer = new byte[4];
        in.read(intBuffer);
        int n = ByteBuffer.wrap(intBuffer).getInt();
        System.out.println("Số lần tung xúc xắc: " + n);

        int[] counts = new int[7];

        // c (phần 1). Nhận n giá trị xúc xắc (mỗi số đọc 4 byte)
        for (int i = 0; i < n; i++) {
            in.read(intBuffer);
            int roll = ByteBuffer.wrap(intBuffer).getInt();
            if (roll >= 1 && roll <= 6) {
                counts[roll]++;
            }
        }

        // c (phần 2). Gửi xác suất dưới dạng float (chuyển float thành 4 byte)
        for (int i = 1; i <= 6; i++) {
            float prob = (float) counts[i] / n;
            System.out.println("Mặt " + i + " - Xác suất: " + prob);

            // Ép kiểu float thành mảng 4 byte
            byte[] probBytes = ByteBuffer.allocate(4).putFloat(prob).array();
            out.write(probBytes);
        }

        out.flush();

        // d. Đóng kết nối
        in.close();
        out.close();
        socket.close();
    }
}