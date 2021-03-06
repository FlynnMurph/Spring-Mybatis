package com.biz.zq.util;


public class PointUtil {
    /**
     * 地球长半径
     */
    private static double a = 6378137;

    /**
     * 地球短半径
     */
    private static double b = 6356752.3142;

    /**
     * 扁率
     */
    private static double f = 1 / 298.2572236;

    public static Point calcPoint(double lat, double lon, double brg, int distance) {
        double alpha = rad(brg);
        double sinAlpha1 = Math.sin(alpha);
        double cosAlpha1 = Math.cos(alpha);

        double tanU1 = (1 - f) * Math.tan(rad(lat));
        double cosU1 = 1 / Math.sqrt(1 + tanU1 * tanU1);
        double sinU1 = tanU1 * cosU1;
        double sigma1 = Math.atan2(tanU1, cosAlpha1);
        double sinAlpha = cosU1 * sinAlpha1;
        double cosSqAlpha = 1 - sinAlpha * sinAlpha;
        double uSq = cosSqAlpha * (a * a - b * b) / (b * b);
        double A = 1 + uSq / 16384 * (4096 + uSq * (-768 + uSq * (320 - 175 * uSq)));
        double B = uSq / 1024 * (256 + uSq * (-128 + uSq * (74 - 47 * uSq)));
        double cos2SigmaM=0;
        double sinSigma=0;
        double cosSigma=0;
        double sigma = distance / (b * A), sigmaP = 2 * Math.PI;
        while (Math.abs(sigma - sigmaP) > 1e-12) {
            cos2SigmaM = Math.cos(2 * sigma1 + sigma);
            sinSigma = Math.sin(sigma);
            cosSigma = Math.cos(sigma);
            double deltaSigma = B * sinSigma * (cos2SigmaM + B / 4 * (cosSigma * (-1 + 2 * cos2SigmaM * cos2SigmaM)
                    - B / 6 * cos2SigmaM * (-3 + 4 * sinSigma * sinSigma) * (-3 + 4 * cos2SigmaM * cos2SigmaM)));
            sigmaP = sigma;
            sigma = distance / (b * A) + deltaSigma;
        }

        double tmp = sinU1 * sinSigma - cosU1 * cosSigma * cosAlpha1;
        double lat2 = Math.atan2(sinU1 * cosSigma + cosU1 * sinSigma * cosAlpha1,
                (1 - f) * Math.sqrt(sinAlpha * sinAlpha + tmp * tmp));
        double lambda = Math.atan2(sinSigma * sinAlpha1, cosU1 * cosSigma - sinU1 * sinSigma * cosAlpha1);
        double C = f / 16 * cosSqAlpha * (4 + f * (4 - 3 * cosSqAlpha));
        double L = lambda - (1 - C) * f * sinAlpha
                * (sigma + C * sinSigma * (cos2SigmaM + C * cosSigma * (-1 + 2 * cos2SigmaM * cos2SigmaM)));
        // final bearing
        double revAz = Math.atan2(sinAlpha, -tmp);

        System.out.println(revAz);
        System.out.println(lon+deg(L)+","+deg(lat2));
        Point point = new Point();
        return point;
    }


    /**
     * 度 换成弧度
     * @param d
     * @return
     */
    private static double rad(double d) {
        return d * Math.PI / 180.0;
    }

    /**
     * 弧度换成度
     *
     * @param x
     *            弧度
     * @return 度
     */
    private static double deg(double x) {
        return x * 180 / Math.PI;
    }

    public static void main(String[] args) {
        calcPoint(32.234233, 104.06201405, 0, 500);
    }
}
