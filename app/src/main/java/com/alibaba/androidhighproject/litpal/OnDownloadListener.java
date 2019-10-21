package com.alibaba.androidhighproject.litpal;

import java.io.File;

/**
 * *******************************************
 * 标题 :                                     *
 * 编辑 : 向绍谷                               *
 * 日期 : 2019/10/21                             *
 * 描述 :                                     *
 * *******************************************
 */
public interface OnDownloadListener {
    /**
     * 下载成功之后的文件
     */
    void onDownloadSuccess(File file);

    /**
     * 下载进度
     */
    void onDownloading(int progress);

    /**
     * 下载异常信息
     */

    void onDownloadFailed(Exception e);

}
