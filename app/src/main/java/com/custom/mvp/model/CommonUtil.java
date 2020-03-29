package com.custom.mvp.model;


import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import com.custom.core.base.app.MyApplication;
import com.custom.core.unit.MyLog;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import androidx.core.content.FileProvider;

public class CommonUtil {
    private static final String TAG = "CommonUtil";

    /**
     * 获取版本号名字
     *
     * @author Ysw created at 2017/10/9 11:48
     */
    public static String getVersion(Application context) {
        try {
            PackageManager manager = context.getPackageManager();
            PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
            String version = info.versionName;
            return version;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 是否是手机号 11位
     *
     * @author hulin.dev
     * @date 2018/4/2
     */
    public static boolean isMobileNO(String mobiles) {
        Pattern p = Pattern.compile("1[3456789]\\d{9}");
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }

    /**
     * 获取屏幕宽度 @author Ysw created at 2017/3/15 13:05
     */
    public static int getScreenWidth(Context context) {
        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = manager.getDefaultDisplay();
        return display.getWidth();
    }

    /**
     * 获得状态栏的高度
     */
    public static int getStatusHeight(Context context) {
        int statusHeight = -1;
        try {
            Class<?> clazz = Class.forName("com.android.internal.R$dimen");
            Object object = clazz.newInstance();
            int height = Integer.parseInt(clazz.getField("status_bar_height").get(object).toString());
            statusHeight = context.getResources().getDimensionPixelSize(height);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return statusHeight;
    }

    /**
     * 判断用户密码是否符合规则
     *
     * @param pwd
     * @return
     */
    public static boolean validateUserPwd(String pwd) {
        String regex = "[0-9A-Za-z]{6,16}";
        return Pattern.matches(regex, pwd);
    }

    /**
     * 判断支付密码是否符合规则
     *
     * @param pwd
     * @return
     */
    public static boolean validatePayPwd(String pwd) {
        String regex = "^[0-9]{6}$";
        return Pattern.matches(regex, pwd);
    }

    /**
     * 把手机号中间4位转成****
     * <p>
     * eg:13612345678 变成 136****5678
     *
     * @param phone 11位手机号
     * @return
     */
    public static String encryptPhone(String phone) {
        if (!TextUtils.isEmpty(phone)) {
            phone = phone.substring(0, 3) + "****" + phone.substring(phone.length() - 4);
        } else {
            phone = "";
        }
        return phone;
    }


    /**
     * 判断集合是否为空
     *
     * @param collection Collection
     * @return
     */
    public static boolean isEmptyList(Collection collection) {
        return collection == null || collection.isEmpty();
    }

    /**
     * 判断集合
     *
     * @param collection Collection
     * @return
     */
    public static boolean isNotEmptyList(Collection collection) {
        return collection != null && !collection.isEmpty();
    }

    /**
     * 获取应用版本名
     *
     * @param context
     * @return
     */
    public static String getAppVersionName(Context context) {
        try {
            PackageManager pm = context.getPackageManager();//
            PackageInfo pi = pm.getPackageInfo(context.getPackageName(), 0);
            return pi.versionName;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 获取应用版本号
     *
     * @param context context
     * @return AppVersionCode
     */
    public static int getAppVersionCode(Context context) {
        try {
            PackageManager pm = context.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(context.getPackageName(), 0);
            return pi.versionCode;
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * 判断网络是否可用 @author Ysw created at 2017/3/15 13:05
     */
    public static boolean checkNetState(Context context) {
        boolean netstate = false;
        ConnectivityManager connectivity = (ConnectivityManager) MyApplication.getInstance().getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null) {
                for (int i = 0; i < info.length; i++) {
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        netstate = true;
                        break;
                    }
                }
            }
        }
        return netstate;
    }

    /**
     * 隐藏键盘
     * 强制隐藏
     *
     * @param context
     */
    public static void hideInputSoftFromWindowMethod(Context context, View view) {
        try {
            InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 跳转至应用权限设置界面进行相关权限的设置
     *
     * @param permissionDescription 权限的描述
     * @author Ysw created at 2017/12/5 13:54
     */
    public static void openAppDetails(final Context context, final String permissionDescription) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setMessage(permissionDescription + "，请到 “应用信息 -> 权限” 中授予！");
                builder.setPositiveButton("去手动授权", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent();
                        intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                        intent.addCategory(Intent.CATEGORY_DEFAULT);
                        intent.setData(Uri.parse("package:" + context.getApplicationContext().getPackageName()));
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                        intent.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
                        context.startActivity(intent);
                    }
                });
                builder.setNegativeButton("取消", null);
                builder.show();
            }
        });

    }


    /**
     * 保留两位小数
     *
     * @author Ysw created at 2019/3/12 14:13
     */
    public static double doubleKeep2decimals(double exceptAmount) {
        BigDecimal b = new BigDecimal(exceptAmount);
        /* 保留两位小数，舍弃两位小数后数字，不进行进位 @author Steven created at 2018/4/28 */
        return b.setScale(2, BigDecimal.ROUND_DOWN).doubleValue();
    }

    /**
     * APK下载完成之后直接跳转至安装界面
     *
     * @author Ysw created at 2017/11/14 11:23
     */
    public static void install(Context context, String filePath) {
        try {
            File file = new File(filePath);
            Intent intent = new Intent(Intent.ACTION_VIEW);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                Uri apkUri = FileProvider.getUriForFile(context, "com.jinr.whaleloan.provider", file);
                intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                intent.setDataAndType(apkUri, "application/vnd.android.package-archive");
            } else {
                intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            }
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 字符串转换成浮点类型,并且保存为两位小数
     *
     * @author Steven created at 2017/10/16
     */
    public static float string2float(String amount) {
        float floatAmount = 0;
        if (!TextUtils.isEmpty(amount)) {
            try {
                floatAmount = Float.parseFloat(amount);
                /* 保留两位小数 @author Steven created at 2017/10/16 */
                BigDecimal b = new BigDecimal(floatAmount);
                floatAmount = b.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
            } catch (Exception e) {
                MyLog.e(TAG, "CommonUtil.string2float：" + e.toString());
            }
        } else {
            return floatAmount;
        }
        return floatAmount;
    }

    /**
     * 字符串转换成整数
     *
     * @author Steven created at 2018/4/19
     */
    public static int string2Int(String amount) {
        int intAmount = 0;
        if (!TextUtils.isEmpty(amount)) {
            try {
                intAmount = Integer.parseInt(amount);
            } catch (Exception e) {
                MyLog.e(TAG, "CommonUtil.string2Int：" + e.toString());
            }
        } else {
            return intAmount;
        }
        return intAmount;
    }

    /**
     * 字符串转换成double类型,并且保存为两位小数
     *
     * @author Steven created at 2018/4/19
     */
    public static double string2Double(String amount) {
        double doubleAmount = 0;
        if (!TextUtils.isEmpty(amount)) {
            try {
                doubleAmount = Double.parseDouble(amount);
                /* 保留两位小数 @author Steven created at 2018/4/19 */
                BigDecimal b = new BigDecimal(doubleAmount);
                doubleAmount = b.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
            } catch (Exception e) {
                MyLog.e(TAG, "CommonUtil.string2Double：" + e.toString());
            }
        } else {
            return doubleAmount;
        }
        return doubleAmount;
    }

    /**
     * 腾讯Bugly异常上传使用
     * <p>
     * 获取进程号对应的进程名
     *
     * @param pid 进程号
     * @return 进程名
     */
    public static String getProcessName(int pid) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("/proc/" + pid + "/cmdline"));
            String processName = reader.readLine();
            if (!TextUtils.isEmpty(processName)) {
                processName = processName.trim();
            }
            return processName;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return null;
    }


    /**
     * 获取当前手机系统版本号
     *
     * @return 系统版本号
     */
    public static String getSystemVersion() {
        return Build.VERSION.RELEASE;
    }

    /**
     * 获取手机型号
     *
     * @return 手机型号
     */
    public static String getSystemModel() {
        return Build.MODEL;
    }


    /**
     * 获取手机厂商
     *
     * @return 手机厂商
     */
    public static String getDeviceBrand() {
        return Build.BRAND;
    }


    /**
     * 获取Android Id
     * add hulin.dev 20180427
     *
     * @param context 上下文
     * @return android_id
     */
    private static String getAndroidId(Context context) {
        //        return Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
        return Settings.System.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);//Settings.System.ANDROID_ID
    }

    /**
     * 获取Build的部分信息
     * add hulin.dev 20180427
     *
     * @return String
     */
    private static String getBuildInfo() {
        //这里选用了几个不会随系统更新而改变的值
        StringBuffer buildSB = new StringBuffer();
        buildSB.append(Build.BRAND).append("/");
        buildSB.append(Build.PRODUCT).append("/");
        buildSB.append(Build.DEVICE).append("/");
        buildSB.append(Build.ID).append("/");
        buildSB.append(Build.VERSION.INCREMENTAL);
        return buildSB.toString();
    }


    /**
     * 把手机号转成**
     *
     * @author hulin.dev
     * @date 2018/5/17
     */
    public static String transTel(String tel) {
        if (TextUtils.isEmpty(tel)) {
            return null;
        }
        StringBuffer sb = new StringBuffer(tel);
        if (tel.contains(" ")) {
            for (int i = 0; i < sb.length(); i++) {
                if (i > 2 && i < 9) {
                    char c = sb.charAt(i);
                    if (!String.valueOf(c).equals(" "))
                        sb.replace(i, i + 1, "*");
                }
            }
            return sb.toString();
        }
        for (int i = 0; i < sb.length(); i++) {
            if (i > 2 && i < 7) {
                sb.replace(i, i + 1, "*");
            }
        }
        String result = sb.toString();
        return result;
    }


    /**
     * 关键字高亮变色
     *
     * @param color   变化的色值
     * @param text    文字
     * @param keyword 文字中的关键字
     * @return 结果SpannableString
     */
    public static SpannableString matcherSearchTitle(int color, String text, String keyword) {
        SpannableString s = new SpannableString(text);
        keyword = escapeExprSpecialWord(keyword);
        text = escapeExprSpecialWord(text);
        if (text.contains(keyword) && !TextUtils.isEmpty(keyword)) {
            try {
                Pattern p = Pattern.compile(keyword);
                Matcher m = p.matcher(s);
                while (m.find()) {
                    int start = m.start();
                    int end = m.end();
                    s.setSpan(new ForegroundColorSpan(color), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                }
            } catch (Exception e) {
                MyLog.e("", e.toString());
            }
        }
        return s;
    }

    /**
     * 转义正则特殊字符 （$()*+.[]?\^{},|）
     *
     * @param keyword
     * @return keyword
     */
    public static String escapeExprSpecialWord(String keyword) {
        if (!TextUtils.isEmpty(keyword)) {
            String[] fbsArr = {"\\", "$", "(", ")", "*", "+", ".", "[", "]", "?", "^", "{", "}", "|"};
            for (String key : fbsArr) {
                if (keyword.contains(key)) {
                    keyword = keyword.replace(key, "\\" + key);
                }
            }
        }
        return keyword;
    }


    /**
     * 获取当前系统时间
     *
     * @author Ysw created at 2019/3/12 14:17
     */
    public static String getCurrentTime() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = format.format(new Date(System.currentTimeMillis()));
        MyLog.e(TAG, "CommonUtil.getCurrentTime：当前时间：" + time);
        return time;
    }


    /**
     * 判断APP是否在后台还是前台
     * true 表示在前台  false 表示在后台
     *
     * @author Ysw created at 2017/10/12 9:47
     */
    public static boolean isAppOnBackstage() {
        ActivityManager am = (ActivityManager) MyApplication.getInstance().getSystemService(Context.ACTIVITY_SERVICE);
        String curPackageName = MyApplication.getInstance().getPackageName();
        List<ActivityManager.RunningAppProcessInfo> app = am.getRunningAppProcesses();
        if (app == null) return false;
        for (ActivityManager.RunningAppProcessInfo a : app) {
            if (a.processName.equals(curPackageName) && a.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND)
                return true;
        }
        return false;
    }


    /**
     * 获取渠道标识
     *
     * @author Ysw created at 2019/3/30 13:20
     */
    public static String getFlavorChannel(Context context) {
        try {
            PackageManager pm = context.getPackageManager();
            ApplicationInfo appInfo = pm.getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
            return appInfo.metaData.getString("channel");
        } catch (PackageManager.NameNotFoundException ignored) {
        }
        return "";
    }


    /**
     * 将倒计时时间转换成时分秒
     *
     * @param second
     * @author Ysw created at 2018/7/24 10:52
     */
    public static String second2TimeSecond(Long second) {
        long hours = second / 3600;
        long minutes = (second % 3600) / 60;
        long seconds = second % 60;

        String hourString = "";
        String minuteString = "";
        String secondString = "";
        if (hours < 10) {
            hourString = "0";
            if (hours == 0) {
                hourString += "0";
            } else {
                hourString += String.valueOf(hours);
            }
        } else {
            hourString = String.valueOf(hours);
        }
        if (minutes < 10) {
            minuteString = "0";
            if (minutes == 0) {
                minuteString += "0";
            } else {
                minuteString += String.valueOf(minutes);
            }
        } else {
            minuteString = String.valueOf(minutes);
        }
        if (seconds < 10) {
            secondString = "0";
            if (seconds == 0) {
                secondString += "0";
            } else {
                secondString += String.valueOf(seconds);
            }
        } else {
            secondString = String.valueOf(seconds);
        }
        return hourString + ":" + minuteString + ":" + secondString;
    }


    // 获取图片资源方法二 @author Ysw created at 2016/4/12 15:35
    public static Bitmap getBitmap(Context context, int id, String str) {
        Resources rec = context.getResources();
        BitmapDrawable bitmapDrawable = (BitmapDrawable) rec.getDrawable(id);
        Bitmap bitmap = bitmapDrawable.getBitmap();
        return bitmap;
    }

    // 获取图片资源方法三 @author Ysw created at 2016/4/12 15:36
    public static Bitmap getBitmap(Context context, int id) {
        Resources rec = context.getResources();
        InputStream in = rec.openRawResource(id);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(in);
        Bitmap bitmap = bitmapDrawable.getBitmap();
        return bitmap;
    }

    // 将 Drawable 转换成 Bitmap @author Ysw created at 2016/4/12 17:49
    public static Bitmap getBitmap(Drawable drawable) {
        BitmapDrawable bd = (BitmapDrawable) drawable;
        Bitmap bitmap = bd.getBitmap();
        return bitmap;
    }

    // 将 dp 转换成为 px @author Ysw created at 2016/4/12 11:49
    public static int dp2Px(Context context, float dp) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }

    // 将 sp 转换成 px @author Ysw created at 2016/4/12 17:55
    public static int sp2Px(Context context, float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }
}
