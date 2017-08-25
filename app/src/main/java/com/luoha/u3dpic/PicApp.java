package com.luoha.u3dpic;

import android.app.Application;
import android.os.Environment;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.UsingFreqLimitedMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;

import java.io.File;

/**
 * Created by pander on 2016/7/21.
 */
public class PicApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initImageLoader();
    }


    public static File getImgPath() {

        if (isSDcardExist()) {
            File sdCard = getSDCard();
            return new File(sdCard + "/picTets/");
        }

        return null;
    }



    public static boolean isSDcardExist() {

        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }

    public static File getSDCard() {

        return Environment.getExternalStorageDirectory();

    }


    private void initImageLoader() {




        ImageLoaderConfiguration mImageLoaderConfiguration = new ImageLoaderConfiguration.Builder(this).diskCacheExtraOptions(480, 800, null)
                .memoryCacheExtraOptions(480, 800).threadPoolSize(5).threadPriority(Thread.NORM_PRIORITY - 2).denyCacheImageMultipleSizesInMemory()
                .memoryCache(new UsingFreqLimitedMemoryCache(2 * 1024 * 1024)).memoryCacheSize(8 * 1024 * 1024).diskCacheSize(100 * 1024 * 1024)
                .diskCacheFileCount(500).diskCache(new UnlimitedDiskCache(getImgPath())).diskCacheFileNameGenerator(new Md5FileNameGenerator())
                // 将保存的时候的URI名称用MD5 加密
                .tasksProcessingOrder(QueueProcessingType.LIFO).defaultDisplayImageOptions(DisplayImageOptions.createSimple())
                .imageDownloader(new BaseImageDownloader(this, 10 * 1000, 30 * 1000)).build();

        ImageLoader.getInstance().init(mImageLoaderConfiguration);// 全局初始化此配置

    }
}
