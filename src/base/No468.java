package base;

public class No468 {
    public String validIPAddress(String IP) {
        if (isIPv4(IP))
            return "IPv4";
        if (isIPv6(IP))
            return "IPv6";
        return "Neither";
    }

    public boolean isIPv4(String ip) {
        if (!ip.matches("([0-9]{1,3}\\.){3}[0-9]{1,3}"))
            return false;
        String[] split = ip.split("\\.");
        for (String str : split) {
            int num = Integer.parseInt(str);
            if (num > 255)
                return false;
            if (str.startsWith("0") && str.length() > 1)
                return false;
        }
        return true;
    }

    public boolean isIPv6(String ip) {
        return ip.matches("((([A-Fa-f0-9]){1,4}):){7}(([A-Fa-f0-9]){1,4})");
    }

    public static void main(String[] args) {
//        String str = "1.1.1.01";
//        System.out.println(No468.isIPv4(str));
    }
}
