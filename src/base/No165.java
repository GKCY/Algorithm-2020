package base;

public class No165 {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int l1 = v1.length, l2 = v2.length;

        for (int i = 0; i < Math.max(l1, l2); i++) {
            String str1 = i < l1 ? v1[i] : "0";
            String str2 = i < l2 ? v2[i] : "0";

            int n1 = Integer.parseInt(str1);
            int n2 = Integer.parseInt(str2);

            if (n1 == n2)
                continue;
            else if (n1 > n2)
                return 1;
            else if (n1 < n2)
                return -1;

        }
        return 0;
    }
}
