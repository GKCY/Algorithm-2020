import java.util.ArrayList;
import java.util.List;

public class No93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        //枚举所有各部分长度
        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                for (int k = 1; k < 4; k++) {
                    for (int l = 1; l < 4; l++) {
                        if (i + j + k + l == s.length()) {
                            int a = Integer.parseInt(s.substring(0, i));
                            int b = Integer.parseInt(s.substring(i, i+j));
                            int c = Integer.parseInt(s.substring(i+j, i+j+k));
                            int d = Integer.parseInt(s.substring(i+j+k, i+j+k+l));
                            if (a <= 255 && b <= 255 && c <= 255 && d <= 255) {
                                builder.append(a).append(".").append(b).append(".")
                                        .append(c).append(".").append(d);
                                // 0开头无效
                                if (builder.length() - 3 == s.length())
                                    res.add(builder.toString());
                                builder.delete(0, builder.length());
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
}
