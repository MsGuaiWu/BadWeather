package com.cl.badweather.receiver;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;

import androidx.core.content.FileProvider;

import com.cl.badweather.WeatherApplication;
import com.cl.badweather.utils.WeatherUtil;
import com.cl.mvplibrary.view.dialog.AlertDialog;

import java.io.File;

/**
 * 下载APK广播
 */
public class DownloadApkReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(DownloadManager.ACTION_DOWNLOAD_COMPLETE)){ //下载完成
            long downloadId = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID,-1L);
            DownloadManager manager = (DownloadManager) WeatherApplication.getContext().getSystemService(Context.DOWNLOAD_SERVICE);
            DownloadManager.Query query = new DownloadManager.Query();
            query.setFilterById(downloadId);
            Cursor cursor = manager.query(query);
            if (!cursor.moveToFirst()) {
                cursor.close();
                return;
            }
            int status = cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_STATUS));
            if (status == DownloadManager.STATUS_SUCCESSFUL){ //成功
                //安装
                installApk(context);

            }
        }
    }
    public static void installApk(Context context) {
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),"BadWeather.apk");
        Intent intent = new Intent(Intent.ACTION_VIEW);
        //由于没有在activity环境下启动Activity,设置下面的标签
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if (Build.VERSION.SDK_INT > 24) { //判断版本是否在7.0以上
           //参数1 上下文，参数2 Provide 主机地址 和配置文件中保持一致  参数3 共享的文件
            Uri apkUri = FileProvider.getUriForFile(context,context.getPackageName() + ".fileprovider",file);
            //添加这一句表示对目标应用临时授权改Uri所代表的文件
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            intent.setDataAndType(apkUri,"application/vnd.android.package-archive");
        }else {
            intent.setDataAndType(Uri.fromFile(file),"application/vnd.android.package-archive");
        }
        context.startActivity(intent);
    }
}
